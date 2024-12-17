import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 * This class stores all information about the clan. This includes
 * active members, banned members, ranked members and their ranks,
 * clan title, and clan founder. All clan joining, leaving, and
 * moderation/setup is also handled in this class.
 * @author Galkon
 *
 */
public class Clan {

    public Clan[] clans = new Clan[100];

    /**
     * Adds a member to the clan.
     * @param player
     */
    public void addMember(client player) {
        player.sendMessage("Attempting to join channel...");
        if (isBanned(player.playerName)) {
            player.sendMessage("You are currently banned from this clan chat.</col>");
            return;
        }
        if (whoCanJoin > Rank.ANYONE && !isFounder(player.playerName)) {
            if (getRank(player.playerName) < whoCanJoin) {
                player.sendMessage("Only " + getRankTitle(whoCanJoin)
                        + "s+ may join this chat.");
                return;
            }
        }
        player.clan = this;
        player.lastClanChat = getFounder();
        activeMembers.add(player.playerName);
        player.sendFrame126("Leave Chat", 18135);
        player.sendFrame126(
                "Talking in: <col=FFFF75>" + getTitle() + "</col>", 18139);
        player.sendFrame126(
                "Owner: <col=FFFFFF>" + misc.capitalize(getFounder())
                        + "</col>", 18140);
        player.sendMessage("Now talking in clan channel <col=255>" + getTitle()
                + "<col=0>");
        player.sendMessage("To talk, start each line of chat with the / symbol.");
        updateMembers();
    }

    /**
     * Adds the player to previous clan chat upon login.
     * @param player
     */

    public void LoginStageClan(client player) {
        player.sendMessage("Attempting to join channel...");
        if (isBanned(player.playerName)) {
            player.sendMessage("You are currently banned from this clan chat.</col>");
            return;
        }
        if (whoCanJoin > Rank.ANYONE && !isFounder(player.playerName)) {
            if (getRank(player.playerName) < whoCanJoin) {
                player.sendMessage("Only " + getRankTitle(whoCanJoin)
                        + "s+ may join this chat.");
                return;
            }
        }
        player.clan = this;
        player.lastClanChat = getFounder();
        activeMembers.add(player.playerName);
        player.sendFrame126("Leave Chat", 18135);
        player.sendFrame126(
                "Talking in: <col=FFFF75>" + getTitle() + "</col>", 18139);
        player.sendFrame126(
                "Owner: <col=FFFFFF>" + misc.capitalize(getFounder())
                        + "</col>", 18140);
        player.sendMessage("Now talking in clan channel <col=255>" + getTitle()
                + "<col=0>");
        player.sendMessage("To talk, start each line of chat with the / symbol.");
        updateMembers();
    }

    /**
     * Removes the player from the clan.
     * @param player
     */
    public void removeMember(client player) {
        List<String> remove = new ArrayList<>(1);
        for (String member : activeMembers) {
            if (Objects.isNull(member)) {
                continue;
            }
            if (member.equalsIgnoreCase(player.playerName)) {
                player.clan = null;
                resetInterface(player);
                remove.add(member);
            }
        }
        activeMembers.removeAll(remove);
        player.refreshSkill(21);
        player.refreshSkill(22);
        player.refreshSkill(23);
        updateMembers();
    }

    /**
     * Removes the player from the clan.
     * @param player
     */
    public void removeMember(int playerid_) {
        List<String> remove = new ArrayList<>(1);
        for (String member : activeMembers) {
            if (Objects.isNull(member)) {
                continue;
            }
                client player = (client) PlayerHandler.getPlayer(playerid_);
                player.clan = null;
                resetInterface((client) player);
                remove.add(member);
        }
        activeMembers.removeAll(remove);
        updateMembers();
    }

    /**
     * Updates the members on the interface for the player.
     * @param player
     */
    public void updateInterface(client player) {
        player.sendFrame126(
                "Talking in: <col=FFFF75>" + getTitle() + "</col>", 18139);
        player.sendFrame126(
                "Owner: <col=FFFFFF>" + misc.capitalize(getFounder())
                        + "</col>", 18140);
        Collections.sort(activeMembers);
        for (int index = 0; index < 100; index++) {
            if (index < activeMembers.size()) {
                player.sendFrame126(
                        "<clan="
                                + getRank(activeMembers.get(index))
                                + ">"
                                + misc.capitalize(activeMembers
                                .get(index)), 18144 + index);
            } else {
                player.sendFrame126("", 18144 + index);
            }
        }
    }

    /**
     * Updates the interface for all members.
     */
/*	public void updateMembers() {
		// gonna try something
		
		for (String s : activeMembers) {
			client p = PlayerHandler.getPlayer(s);
			//if (p != null) {
				updateInterface(p);
				updateNewInterface(p);
			//}
		}	
	}*/
    public void updateMembers() {
        for (Player player : PlayerHandler.getPlayers()) {
            if (Objects.nonNull(activeMembers) && Objects.nonNull(player)) {
                if (activeMembers.contains(player.playerName)) {
                    updateInterface((client) player);
                    updateNewInterface((client) player);
                }
            }
        }
    }

    public void updateNewInterface(client player) {
        if(getTeleport()){
            player.sendFrame126("<col=65280>Yes", 18530);
        } else if(!getTeleport()){
            player.sendFrame126("<col=ff0000>No", 18530);
        }
        if(getCanCopy()){
            player.sendFrame126("<col=65280>Yes", 18533);
        } else if(!getCanCopy()){
            player.sendFrame126("<col=ff0000>No", 18533);
        }
    }

    /**
     * Resets the clan interface.
     * @param player
     */
    public void resetInterface(client player) {
        player.sendFrame126("Join chat", 18135);
        player.sendFrame126("Talking in: Not in chat", 18139);
        player.sendFrame126("Owner: None", 18140);
        for (int index = 0; index < 100; index++) {
            player.sendFrame126("", 18144 + index);
        }
    }

    /**
     * Sends a message to the clan.
     * @param player
     * @param message
     */

    public void sendChat(client paramClient, String paramString) {
        if (getRank(paramClient.playerName) < this.whoCanTalk) {
            paramClient.sendMessage("Only " + getRankTitle(this.whoCanTalk) + "s+ may talk in this chat.");
            return;
        }
/*		if (System.currentTimeMillis() < paramClient.muteEnd) {
			paramClient.sendMessage("You are muted, you cannot talk in this chat.");
			return;
		}*/
        for (int j = 0; j < server.playerHandler.players.length; j++) {
            if (PlayerHandler.players[j] != null) {
                client c = (client) PlayerHandler.players[j];
                if ((c != null) && (this.activeMembers.contains(c.playerName)))
                    //paramString.replace("/", "")
                    c.sendMessage("<col=0>[<col=255>" + getTitle() + "<col=0>] <img=" + (paramClient.getRights().getValue() - 1) + "><col=0>"
                            + misc.capitalize(paramClient.playerName) + ": <col=800000>" + paramString.replace("/", ""));
            }
        }
    }

    /**
     * Sends a message to the clan.
     *
     * @param player
     * @param message
     */
    public void sendMessage(String message) {
        for (int index = 0; index < Config.MAX_PLAYERS; index++) {
            client p = (client) PlayerHandler.players[index];
            if (p != null) {
                if (activeMembers.contains(p.playerName)) {
                    p.sendMessage(message);
                }
            }
        }
    }

    /**
     * Sends a message to the clan.
     * @param player
     * @param message
     */
	/*public void sendMessage(String message) {
		for (int index = 0; index < Config.MAX_PLAYERS; index++) {
			client p = (client) PlayerHandler.players[index];
			if (p != null) {
				if (activeMembers.contains(p.playerName)) {
					p.sendMessage(message);
				}
			}
		}
	}*/

    /**
     * Sets the rank for the specified name.
     * @param name
     * @param rank
     */
    public void setRank(String name, int rank) {
        if (rankedMembers.contains(name)) {
            ranks.set(rankedMembers.indexOf(name), rank);
        } else {
            rankedMembers.add(name);
            ranks.add(rank);
        }
        save();
    }

    /**
     * Demotes the specified name.
     * @param name
     */
    public void demote(String name) {
        if (!rankedMembers.contains(name)) {
            return;
        }
        int index = rankedMembers.indexOf(name);
        rankedMembers.remove(index);
        ranks.remove(index);
        save();
    }

    /**
     * Gets the rank of the specified name.
     * @param name
     * @return
     */
    public int getRank(String name) {
        name = misc.capitalize(name);
        if (rankedMembers.contains(name)) {
            return ranks.get(rankedMembers.indexOf(name));
        }
        if (isFounder(name)) {
            return Rank.OWNER;
        }
        //XXX Problem was here for fixing project folder
        return -1;
    }

    /**
     * Can they kick?
     * @param name
     * @return
     */
    public boolean canKick(String name) {
        if (isFounder(name)) {
            return true;
        }
        if (getRank(name) >= whoCanKick) {
            return true;
        }
        return false;
    }
    public boolean canTeleport;
    public boolean canCopy;

    /**
     * Can they ban?
     * @param name
     * @return
     */
    public boolean canBan(String name) {
        if (isFounder(name)) {
            return true;
        }
        if (getRank(name) >= whoCanBan) {
            return true;
        }
        return false;
    }

    /**
     * Returns whether or not the specified name is the founder.
     * @param name
     * @return
     */
    public boolean isFounder(String name) {
        if (getFounder().equalsIgnoreCase(name)) {
            return true;
        }
        return false;
    }

    /**
     * Returns whether or not the specified name is a ranked user.
     * @param name
     * @return
     */
    public boolean isRanked(String name) {
        name = misc.capitalize(name);
        if (rankedMembers.contains(name)) {
            return true;
        }
        return false;
    }

    /**
     * Returns whether or not the specified name is banned.
     * @param name
     * @return
     */
    public boolean isBanned(String name) {
        name = misc.capitalize(name);
        if (bannedMembers.contains(name)) {
            return true;
        }
        return false;
    }

    /**
     * Kicks the name from the clan chat.
     * @param name
     */
    public void kickMember(int playerid_) {
        client player = (client) PlayerHandler.getPlayer(playerid_);
        if (!activeMembers.contains(player.playerName)) {
            return;
        }
        if (player.playerName.equalsIgnoreCase(getFounder())) {
            return;
        }
        removeMember(playerid_);
        if (player != null) {
            player.sendMessage("You have been kicked from the clan chat.");
        }
        sendMessage(misc.capitalize(player.playerName) + " has been kicked from the clan chat.");
    }

    /**
     * Bans the name from entering the clan chat.
     * @param name
     */
    public void banMember(int  playerid) {
        client player = (client) PlayerHandler.getPlayer(playerid);
        player.playerName = misc.capitalize(player.playerName);
        if (bannedMembers.contains(player.playerName)) {
            return;
        }
        if (player.playerName.equalsIgnoreCase(getFounder())) {
            return;
        }
        if (isRanked(player.playerName)) {
            return;
        }
        removeMember(playerid);
        bannedMembers.add(player.playerName);
        save();
        if (player != null && player.clan == this) {
            player.sendMessage("You have been banned from the clan chat.");
        }
        sendMessage(misc.capitalize(player.playerName) + " has been banned from the clan chat.");
    }

    /**
     * Unbans the name from the clan chat.
     * @param name
     */
    public void unbanMember(String name) {
        name = misc.capitalize(name);
        if (bannedMembers.contains(name)) {
            bannedMembers.remove(name);
            save();
        }
    }

    /**
     * Saves the clan.
     */
    public void save() {
        server.clanManager.save(this);
        updateMembers();
    }

    /**
     * Deletes the clan.
     */
    public void delete(int playerid) {
        for (String name : activeMembers) {
            client player = (client) PlayerHandler.getPlayer(playerid);
            removeMember(playerid);
            player.sendMessage("The clan you were in has been deleted.");
        }
       server.clanManager.delete(this);
    }

    /**
     * Creates a new clan for the specified player.
     * @param player
     */
    public Clan(client player) {
        setTitle(player.playerName + "'s Clan");
        setFounder(player.playerName.toLowerCase());
    }

    /**
     * Creates a new clan for the specified title and founder.
     * @param title
     * @param founder
     */
    public Clan(String title, String founder) {
        setTitle(title);
        setFounder(founder);
    }

    /**
     * Gets the founder of the clan.
     * @return
     */
    public String getFounder() {
        return founder;
    }

    /**
     * Sets the founder.
     * @param founder
     */
    public void setFounder(String founder) {
        this.founder = founder;
    }

    public void allowTeleport(client player) {
        if(isFounder(player.playerName) && !getTeleport()) {
            setTeleport(true);
            player.sendFrame126("<col=65280>Yes", 18530);
            player.sendMessage("You have <col=255>enabled<col=0> the ability for clan members to teleport to other clan members!");
            updateMembers();
        } else if(player.clan.isFounder(player.playerName) && getTeleport()) {
            //canTeleport = false;
            setTeleport(false);
            player.sendFrame126("<col=ff0000>No", 18530);
            player.sendMessage("You have <col=255>disabled<col=0> the ability for clan members to teleport to other clan members!");
            updateMembers();
        }
    }

    public void allowCopyKit(client player) {
        if(player.clan.isFounder(player.playerName) && !getCanCopy()) {
            setCanCopy(true);
            player.sendFrame126("<col=65280>Yes", 18533);
            player.sendMessage("You have <col=255>enabled<col=0> the ability for clan members to copy other members armour kits!");
            updateMembers();
        } else if(player.clan.isFounder(player.playerName) && getCanCopy()) {
            setCanCopy(false);
            player.sendFrame126("<col=ff0000>No", 18533);
            player.sendMessage("You have <col=255>disabled<col=0> the ability for clan members to copy other members armour kits!");
            updateMembers();
        }
    }

    /**
     * Gets the title of the clan.
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the allowTeleport check
     * @return
     */

    public Boolean getTeleport() {
        return canTeleport;
    }

    /**
     * Sets the teleport to true or false.
     * @param title
     * @return
     */
    public void setTeleport(Boolean teleport) {
        canTeleport = teleport;
    }

    /**
     * Gets the allowTeleport check
     * @return
     */

    public Boolean getCanCopy() {
        return canCopy;
    }

    /**
     * Sets the teleport to true or false.
     * @param title
     * @return
     */
    public void setCanCopy(Boolean copy) {
        canCopy = copy;
    }


    /**
     * Sets the title.
     * @param title
     * @return
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The title of the clan.
     */
    public String title;

    public Boolean teleport;

    /**
     * The founder of the clan.
     */
    public String founder;

    /**
     * The active clan members.
     */
    public LinkedList<String> activeMembers = new LinkedList<>();

    /**
     * The banned members.
     */
    public LinkedList<String> bannedMembers = new LinkedList<>();

    /**
     * The ranked clan members.
     */
    public LinkedList<String> rankedMembers = new LinkedList<>();

    /**
     * The clan member ranks.
     */
    public LinkedList<Integer> ranks = new LinkedList<>();

    /**
     * The clan ranks.
     * @author Galkon
     *
     */
    public static class Rank {
        public final static int ANYONE = -1;
        public final static int FRIEND = 0;
        public final static int RECRUIT = 1;
        public final static int CORPORAL = 2;
        public final static int SERGEANT = 3;
        public final static int LIEUTENANT = 4;
        public final static int CAPTAIN = 5;
        public final static int GENERAL = 6;
        public final static int OWNER = 7;
    }

    /**
     * Gets the rank title as a string.
     * @param rank
     * @return
     */
    public String getRankTitle(int rank) {
        switch (rank) {
            case -1:
                return "Anyone";
            case 0:
                return "Friend";
            case 1:
                return "Recruit";
            case 2:
                return "Corporal";
            case 3:
                return "Sergeant";
            case 4:
                return "Lieutenant";
            case 5:
                return "Captain";
            case 6:
                return "General";
            case 7:
                return "Only Me";
        }
        return "";
    }

    /**
     * Sets the minimum rank that can join.
     * @param rank
     */
    public void setRankCanJoin(int rank) {
        whoCanJoin = rank;
    }

    /**
     * Sets the minimum rank that can talk.
     * @param rank
     */
    public void setRankCanTalk(int rank) {
        whoCanTalk = rank;
    }

    /**
     * Sets the minimum rank that can kick.
     * @param rank
     */
    public void setRankCanKick(int rank) {
        whoCanKick = rank;
    }

    /**
     * Sets the minimum rank that can ban.
     * @param rank
     */
    public void setRankCanBan(int rank) {
        whoCanBan = rank;
    }

    /**
     * Clan Wars variables.
     */
    public Clan belligerent;
    private static boolean isWarHost;

    private static boolean isAtWar;

    /**
     * Represents whether the clan has challenged another clan.
     * @return	true if the clan is the host of a Clan War
     */
    public boolean isWarHost() {
        return isWarHost;
    }

    /**
     * Gets the clan that this <code>Clan</code> is currently at war with.
     * @return
     */
    public Clan getBelligerent() {
        return belligerent;
    }

    /**
     * Gets whether this <code>Clan</clan> is at war.
     * @return
     */
    public boolean atWar() {
        return isAtWar;
    }

    /**
     * The ranks privileges require (joining, talking, kicking, banning).
     */
    public int whoCanJoin = Rank.ANYONE;
    public int whoCanTalk = Rank.ANYONE;
    public int whoCanKick = Rank.GENERAL;
    public int whoCanBan = Rank.OWNER;


}