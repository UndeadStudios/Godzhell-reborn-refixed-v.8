import java.io.*;
import java.util.*;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerHandler {

    // Remark: the player structures are just a temporary solution for now
    // Later we will avoid looping through all the players for each player
    // by making use of a hash table maybe based on map regions (8x8 granularity should be ok)
    public static final int maxPlayers = 2000;
    public static Player[] players = new Player[maxPlayers];
    public static String kickNick = "";
    public static boolean kickAllPlayers = false;
    public static String messageToAll = "";
    public static int playerCount = 0;
    public static boolean updateAnnounced;
    public static boolean updateRunning;
    public static int updateSeconds;
    public static long updateStartTime;
    public static String[] playersCurrentlyOn = new String[maxPlayers];
    private static final Map<String, Player> playerByUsername = new HashMap<>();

    private final stream updateBlock = new stream(new byte[20000]);
    public int playerSlotSearchStart = 1;            // where we start searching at when adding a new player
    public int lastchatid = 1; //PM System

    PlayerHandler() {
        for (int i = 0; i < maxPlayers; i++) {
            players[i] = null;
        }
    }

    public static int[] toIntArray(ArrayList<Integer> integerList) {
        int[] intArray = new int[integerList.size()];

        for (int i = 0; i < integerList.size(); i++) {
            intArray[i] = integerList.get(i);
        }

        return intArray;
    }

    public static int getPlayerCount() {
        return playerCount;
    }

    public static boolean isPlayerOn(String playerName) {
        for (int i = 0; i < maxPlayers; i++) {
            if (playersCurrentlyOn[i] != null) {
                if (playersCurrentlyOn[i].equalsIgnoreCase(playerName)) {

                    return true;
                }
            }
        }
        return false;
    }
    public static List<Player> getPlayers() {
        Player[] clients = new Player[players.length];
        System.arraycopy(players, 0, clients, 0, players.length);
        return Arrays.asList(clients).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static int getPlayerID(String playerName) {
        for (int i = 0; i < maxPlayers; i++) {
            if (playersCurrentlyOn[i] != null) {
                if (playersCurrentlyOn[i].equalsIgnoreCase(playerName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static Stream<Player> nonNullStream() {
        return Arrays.stream(players).filter(Objects::nonNull);
    }
    // a new client connected
    public void newPlayerClient(java.net.Socket s, String connectedFrom) {
        // first, search for a free slot
        //int slot = -1, i = playerSlotSearchStart;
        int slot = -1, i = 1;
        do {
            if (players[i] == null) {
                slot = i;
                break;
            }
            i++;
            if (i >= maxPlayers) i = 0;        // wrap around
//		} while(i != playerSlotSearchStart);
        } while (i <= maxPlayers);

        client newClient = new client(s, slot);
        newClient.handler = this;
        (new Thread(newClient)).start();
        if (slot == -1) return;        // no free slot found - world is full
        players[slot] = newClient;
        players[slot].connectedFrom = connectedFrom;
        updatePlayerNames();

        // start at next slot when issuing the next search to speed it up
        playerSlotSearchStart = slot + 1;
        if (playerSlotSearchStart > maxPlayers) playerSlotSearchStart = 1;
        // Note that we don't use slot 0 because playerId zero does not function
        // properly with the client.
    }

    public void destruct() {
        for (int i = 0; i < maxPlayers; i++) {
            if (players[i] == null) continue;
            players[i].destruct();
            players[i] = null;
        }
    }
    public static Player getPlayer(int playerId) {
        if (playerId < 0 || playerId >= players.length || players[playerId] == null) {
            return null;
        }
        return (Player) players[playerId];
    }

    public void updatePlayerNames() {
        playerCount = 0;
        for (int i = 0; i < maxPlayers; i++) {
            if (players[i] != null) {
                playersCurrentlyOn[i] = players[i].playerName;
                playerCount++;
            } else {
                playersCurrentlyOn[i] = "";
            }
        }
    }
    /**
     * Create an int array of the specified length, containing all values between 0 and length once at random positions.
     *
     * @param length The size of the array.
     * @return The randomly shuffled array.
     */
    private int[] shuffledList(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int index = rand.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
    }
    public static Optional<Player> getOptionalPlayer(String name) {
        return getPlayers().stream().filter(Objects::nonNull).filter(Player -> Player.playerName.equalsIgnoreCase(name)).findFirst();
    }

    public void process() {
        try {
            if (messageToAll.length() > 0) {
                int msgTo = 1;
                do {
                    if (players[msgTo] != null) {
                        players[msgTo].globalMessage = messageToAll;
                    }
                    msgTo++;
                } while (msgTo < maxPlayers);
                messageToAll = "";
            }
            if (kickAllPlayers) {
                int kickID = 1;
                do {
                    if (players[kickID] != null) {
                        players[kickID].isKicked = true;
                    }
                    kickID++;
                } while (kickID < maxPlayers);
                kickAllPlayers = false;
            }

            // at first, parse all the incoming data
            // this has to be seperated from the outgoing part because we have to keep all the player data
            // static, so each client gets exactly the same and not the one clients are ahead in time
            // than the other ones.
            int[] randomOrder = shuffledList(Config.MAX_PLAYERS);
            for (int i = 0; i < maxPlayers; i++) {
                if (players[randomOrder[i]] == null || !players[randomOrder[i]].isActive)
                    continue;
                players[randomOrder[i]].actionAmount--;

                players[randomOrder[i]].preProcessing();
                players[randomOrder[i]].process();
                while (players[randomOrder[i]].packetSending()) ;
                players[randomOrder[i]].postProcessing();

                players[randomOrder[i]].getNextPlayerMovement();
                if (players[randomOrder[i]].playerName.equalsIgnoreCase(kickNick)) {
                    players[randomOrder[i]].kick();
                    kickNick = "";
                }

                if (players[randomOrder[i]].disconnected) {
                    for (int i2 = 0; i2 < NPCHandler.maxNPCs; i2++) {
                        if (NPCHandler.npcs[i2] != null && players[randomOrder[i]] != null) {
                            if (NPCHandler.npcs[i2].followPlayer == players[randomOrder[i]].playerId && NPCHandler.npcs[i2] != null)
                                NPCHandler.npcs[i2].IsDead = true;
                        }
                    }
                    if (players[randomOrder[i]].savefile == true) {
                        if (saveGame(players[randomOrder[i]])) {
                            playerCount--;
                            savechar(players[randomOrder[i]]);
                            System.out.println("Game saved for player " + players[randomOrder[i]].playerName);
                        } else {
                            System.out.println("Could not save for " + players[randomOrder[i]].playerName);
                        }
                    } else {
                        System.out.println("Did not save for " + players[randomOrder[i]].playerName);
                    }
                    playerByUsername.remove(players[randomOrder[i]].playerName.toLowerCase().replaceAll("_", " "));
                    removePlayer(players[randomOrder[i]]);
                    players[randomOrder[i]] = null;
                }
            }

            // loop through all players and do the updating stuff
            for (int i = 0; i < maxPlayers; i++) {
                if (players[randomOrder[i]] == null || !players[randomOrder[i]].isActive) continue;

                Calendar cal = new GregorianCalendar();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                int calc = ((year * 10000) + (month * 100) + day);
                players[randomOrder[i]].playerLastLogin = calc;
                if (players[randomOrder[i]].disconnected) {
                    for (int i3 = 0; i3 < NPCHandler.maxNPCs; i3++) {
                        if (NPCHandler.npcs[i3] != null && players[randomOrder[i]] != null) {
                            if (NPCHandler.npcs[i3].followPlayer == players[randomOrder[i]].playerId)
                                NPCHandler.npcs[i3].IsDead = true;
                        }
                    }
                    if (players[randomOrder[i]].savefile == true) {
                        if (saveGame(players[randomOrder[i]])) {
                            playerCount--;
                            savechar(players[randomOrder[i]]);
                            System.out.println("Game saved for player " + players[randomOrder[i]].playerName);
                        } else {
                            System.out.println("Could not save for " + players[randomOrder[i]].playerName);
                        }
                    } else {
                        System.out.println("Did not save for " + players[randomOrder[i]].playerName);
                    }
                    removePlayer(players[randomOrder[i]]);
                    players[randomOrder[i]] = null;
                } else {
                    if (!players[randomOrder[i]].initialized) {
                        players[randomOrder[i]].initialize();
                        players[randomOrder[i]].initialized = true;
                    } else {
                        players[randomOrder[i]].update();
                    }
                }
            }

            if (updateRunning && !updateAnnounced) {
                updateAnnounced = true;
            }

            if (updateRunning && System.currentTimeMillis() - updateStartTime > (updateSeconds * 1000L)) {
                kickAllPlayers = true;
                server.ShutDown = true;
            }

            // post processing
            for (int i = 0; i < maxPlayers; i++) {
                if (players[randomOrder[i]] == null || !players[randomOrder[i]].isActive) continue;

                players[randomOrder[i]].clearUpdateFlags();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateNPC(Player plr, stream str) {
        if (plr.getOutStream() == null)
            return;
        updateBlock.currentOffset = 0;

        str.createFrameVarSizeWord(65);
        str.initBitAccess();

        str.writeBits(8, plr.npcListSize);
        int size = plr.npcListSize;
        plr.npcListSize = 0;
        for(int i = 0; i < size; i++) {
            if(plr.RebuildNPCList == false && plr.withinDistance(plr.npcList[i]) == true) {
                plr.npcList[i].updateNPCMovement(str);
                plr.npcList[i].appendNPCUpdateBlock(updateBlock);
                plr.npcList[plr.npcListSize++] = plr.npcList[i];
            } else {
                int id = plr.npcList[i].npcId;
                plr.npcInListBitmap[id>>3] &= ~(1 << (id&7));		// clear the flag
                str.writeBits(1, 1);
                str.writeBits(2, 3);		// tells client to remove this npc from list
            }
        }
        // Clear npcs list of everything past the declared size
        for (int i = plr.npcListSize; i < plr.npcList.length; i++) {
            plr.npcList[i] = null;
        }
        int newNpcs = 0;
        // iterate through all npcs to check whether there's new npcs to add
        for(int i = 0; i < NPCHandler.maxNPCs; i++) {
            if(server.npcHandler.npcs[i] != null) {
                int id = server.npcHandler.npcs[i].npcId;
                if (plr.RebuildNPCList == false && (plr.npcInListBitmap[id>>3]&(1 << (id&7))) != 0) {
                    // npc already in npcList
                } else if (plr.withinDistance(server.npcHandler.npcs[i]) == false) {
                    // out of sight
                } else {
                    plr.addNewNPC(server.npcHandler.npcs[i], str, updateBlock);

// Don't add too many npcs in one tick
                    if (newNpcs++ >= 20) {
                        break;
                    }
                }
            }
        }

        plr.RebuildNPCList = false;

        if(updateBlock.currentOffset > 0) {
            str.writeBits(14, 16383);	// magic EOF - needed only when npc updateblock follows
            str.finishBitAccess();

            // append update block
            str.writeBytes(updateBlock.buffer, updateBlock.currentOffset, 0);
        } else {
            str.finishBitAccess();
        }
        str.endFrameVarSizeWord();
    }

    // should actually be moved to client.java because it's very client specific
    public void updatePlayer(Player plr, stream str) {
        if (plr.getOutStream() == null)
            return;
        updateBlock.currentOffset = 0;

        if (updateRunning && !updateAnnounced) {
            str.createFrame(114);
            str.writeWordBigEndian(updateSeconds * 50 / 30);
        }

        // update thisPlayer
        plr.updateThisPlayerMovement(str);        // handles walking/running and teleporting
        // do NOT send chat text back to thisPlayer!
        boolean saveChatTextUpdate = plr.chatTextUpdateRequired;
        plr.chatTextUpdateRequired = false;
        plr.appendPlayerUpdateBlock(updateBlock);
        plr.chatTextUpdateRequired = saveChatTextUpdate;

        str.writeBits(8, plr.playerListSize);
        int size = plr.playerListSize;
        if (size >= 250)
            size = 250;
        // update/remove players that are already in the playerList
        plr.playerListSize = 0;        // we're going to rebuild the list right away
        for (int i = 0; i < size; i++) {
            // this update packet does not support teleporting of other players directly
            // instead we're going to remove this player here and readd it right away below
            if (!plr.didTeleport  && !plr.playerList[i].didTeleport && plr.withinDistance(plr.playerList[i])) {
                plr.playerList[i].updatePlayerMovement(str);
                plr.playerList[i].appendPlayerUpdateBlock(updateBlock);
                plr.playerList[plr.playerListSize++] = plr.playerList[i];
            } else {
                int id = plr.playerList[i].playerId;
                plr.playerInListBitmap[id >> 3] &= ~(1 << (id & 7));        // clear the flag
                str.writeBits(1, 1);
                str.writeBits(2, 3);        // tells client to remove this char from list
            }
        }

        for (int i = 0; i < Config.MAX_PLAYERS; i++) {

            if (players[i] == null || !players[i].isActive || players[i] == plr)
                continue;
            int id = players[i].playerId;
            if ((plr.playerInListBitmap[id >> 3] & (1 << (id & 7))) != 0)
                continue;
            if (!plr.withinDistance(players[i]))
                continue;
            plr.addNewPlayer(players[id], str, updateBlock);
        }


        if (updateBlock.currentOffset > 0) {
            str.writeBits(11, 2047);    // magic EOF - needed only when player updateblock follows
            str.finishBitAccess();

            // append update block
            str.writeBytes(updateBlock.buffer, updateBlock.currentOffset, 0);
        } else {
            str.finishBitAccess();
        }
        str.endFrameVarSizeWord();
    }

    private void removePlayer(Player plr) {
        if (plr.Privatechat != 2) { // PM System
            for (int i = 1; i < maxPlayers; i++) {
                if (players[i] == null || !players[i].isActive) {
                    continue;
                }
                players[i].pmupdate(plr.playerId, 0);
            }
        }
        // anything can be done here like unlinking this player structure from
        // any of the other existing structures
        plr.destruct();
    }

    public boolean savechar(Player plr) {
        // Create a new PlayerData object and populate it with data from the Player instance
        PlayerData playerData = new PlayerData();
        playerData.setUsername(plr.playerName);
        playerData.setPassword(plr.playerPass);
        playerData.setDisplayName(plr.displayName);
        playerData.setHeightLevel(plr.heightLevel);
        playerData.setAbsX(plr.absX);
        playerData.setAbsY(plr.absY);
        playerData.setRights(plr.getRights().getValue());
        playerData.setRunEnergy(plr.runEnergy);
        playerData.setRunningToggled(plr.runningToggled);
        playerData.setDaysPlayed(plr.daysPlayed);
        playerData.setHoursPlayed(plr.hoursPlayed);
        playerData.setMinutesPlayed(plr.minutesPlayed);
        playerData.setSecondsPlayed(plr.secondsPlayed);
        playerData.setAmDonated(plr.amDonated);
        playerData.setHasFirstFloorDone(plr.hasfirstfloorDone);
        playerData.setHasSecondFloorDone(plr.hassecoundfloorDone);
        playerData.setHasThirdFloorDone(plr.hasthirdfloorDone);
        playerData.setHasFourthFloorDone(plr.hasfourthfloorDone);
        playerData.setSkullTimer(plr.skullTimer);

        // Assuming you have a way to access Slayer data
        client target = (client) PlayerHandler.players[plr.playerId];
        playerData.setSlayerTask(target.getSlayer().getTask());
        playerData.setSlayerTaskAmount(target.getSlayer().getTaskAmount());
        playerData.setSlayerMaster(target.getSlayer().getMaster());
        playerData.setConsecutiveTasks(target.getSlayer().getConsecutiveTasks());

        playerData.setPlayerIsMember(plr.playerIsMember);
        playerData.setPlayerHasDonated(plr.playerHasDonated);
        playerData.setJailed(plr.jailed);
        playerData.setPlayerMessages(plr.playerMessages);
        playerData.setPlayerLastConnect(plr.playerLastConnect);
        playerData.setPlayerUID(plr.playerUID);
        playerData.setMacAddress(plr.macAddress);
        playerData.setUuid(plr.uuid);
        playerData.setCountryCode(plr.countryCode);
        playerData.setPlayerLastLogin(plr.playerLastLogin);
        playerData.setPlayerEnergy(plr.playerEnergy);
        playerData.setPlayerGameTime(plr.playerGameTime);
        playerData.setPlayerGameCount(plr.playerGameCount);
        playerData.setLoyaltyRank(plr.loyaltyRank);
        playerData.setPrestigeLevel(plr.prestigeLevel);

        // Copy arrays
        playerData.setPlayerEquipment(plr.playerEquipment);
        playerData.setPlayerEquipmentN(plr.playerEquipmentN);
        playerData.setPlayerAppearance(plr.playerAppearance);
        playerData.setPlayerColor(plr.playerColor);
        playerData.setPlayerLevel(plr.playerLevel);
        playerData.setPlayerXP(plr.playerXP);
        playerData.setPlayerItems(plr.playerItems);
        playerData.setPlayerItemsN(plr.playerItemsN);
        playerData.setBankItems(plr.bankItems);
        playerData.setBankItemsN(plr.bankItemsN);
        playerData.setBankItems2(plr.bankItems2);
        playerData.setBankItemsN2(plr.bankItemsN2);
        playerData.setBankItems3(plr.bankItems3);
        playerData.setBankItemsN3(plr.bankItemsN3);
        playerData.setFriends(plr.friends);
        playerData.setIgnores(plr.ignores);

        // Convert the PlayerData object to JSON and save it to a file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("./Data/characters/" + plr.playerName + ".json")) {
            gson.toJson(playerData, writer);
        } catch (IOException e) {
            System.out.println(plr.playerName + ": error writing file.");
            return false;
        }
        return true;
    }

    public boolean saveGame(Player plr) {
        PlayerSave tempSave = new PlayerSave(plr);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Data/savedGames/" + tempSave.playerName + ".dat"));
            out.writeObject(tempSave);
            out.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void println_debug(String str, int ID, String Name) {
        System.out.println("[client-" + ID + "-" + Name + "]: " + str);
    }
}
