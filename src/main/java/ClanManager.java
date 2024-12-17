import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class ClanManager {

    /**
     * Initializes the clan manager.
     */
    public ClanManager() {
        clans = new LinkedList<>();
    }

    /**
     * Gets the active clan count.
     * @return
     */
    public int getActiveClans() {
        return clans.size();
    }

    /**
     * Gets the clan count.
     * @return
     */
    public int getTotalClans() {
        File directory = new File("/Data/clan/");
        return directory.listFiles().length;
    }

    /**
     * Creates a new clan for the specified player.
     * @param player
     */
    public void create(client player) {
        Clan clan = new Clan(player);
        clans.add(clan);
        clan.addMember(player);
        clan.save();
        player.setClanData();
        player.sendMessage("<col=FF0000>You may change your clan settings by clicking the 'Clan Setup' button.");
    }

    /**
     * Gets the clan for the specified founder.
     * @param title
     * @return
     */
    public Clan getClan(String founder) {
        /*
         * Loop through the currently active clans and look for one
         * with the same founder as the one specified. If we find it,
         * return the clan instance.
         */
        for (int index = 0; index < clans.size(); index++) {
            if (clans.get(index).getFounder().equalsIgnoreCase(founder)) {
                return clans.get(index);
            }
        }
        /*
         * If the clan isn't found in the existing clans,
         * we will try to read the file for the specified founder.
         * If the read file isn't null, we'll add the read clan
         * to the list of clans. If the read data is null, we'll
         * return a null clan.
         */
        Clan read = read(founder);
        if (read != null) {
            clans.add(read);
            return read;
        }
        return null;
    }

    /**
     * Deletes the specified clan.
     * @param clan
     */
    public void delete(Clan clan) {
        /*
         * If the clan is null, stop the method.
         */
        if (clan == null) {
            return;
        }
        File file = new File("Data/clan/" + clan.getFounder() + ".cla");
        if (file.delete()) {
            clans.remove(clan);
        }
    }

    /**
     * Saves the clan data.
     */
    @SuppressWarnings("resource")
    public void save(Clan clan) {
        /*
         * If the clan is null, stop the method.
         */
        if (clan == null) {
            return;
        }
        File file = new File("Data/clan/" + clan.getFounder() + ".cla");
        try {
            RandomAccessFile out = new RandomAccessFile(file, "rwd");
            //DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            /*
             * Write the clan information.
             */
            out.writeUTF(clan.getTitle());
            out.writeByte(clan.whoCanJoin);
            out.writeByte(clan.whoCanTalk);
            out.writeByte(clan.whoCanKick);
            out.writeByte(clan.whoCanBan);
            out.writeBoolean(clan.canTeleport);
            out.writeBoolean(clan.canCopy);
            if (clan.rankedMembers != null && clan.rankedMembers.size() > 0) {
                out.writeShort(clan.rankedMembers.size());
                for (int index = 0; index < clan.rankedMembers.size(); index++) {
                    out.writeUTF(clan.rankedMembers.get(index));
                    out.writeShort(clan.ranks.get(index));
                }
            } else {
                out.writeShort(0);
            }
            /*
             * Close the file.
             */
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the Help clan or creates it if it doesn't exist yet.
     *
     * @return The Help clan.
     */
    public Clan getHelpClan() {
        for (int i = 0; i < this.clans.size(); i++) {
            if (clans.get(i).getFounder().equalsIgnoreCase("Help")) {
                return clans.get(i);
            }
        }

        Clan localClan = read("Help");
        if (localClan != null) {
            clans.add(localClan);
            return localClan;
        }
        localClan = new Clan("Help", "Help");
        clans.add(localClan);
        localClan.save();
        return localClan;
    }

    /**
     * Attempt to rejoin the last Clan channel upon login.
     *
     * @param client
     */
    public void joinOnLogin(client client) {
        String lastChannel = client.getLastClanChat();
        if (lastChannel != null && lastChannel.length() > 0) {
            client.sendMessage("Attempting to join " + lastChannel + "...");
            Clan localClan = getClan(lastChannel);
            if (localClan != null) {
                localClan.addMember(client);
            } else {
                client.sendMessage(lastChannel + " no longer exists.");
            }
        }
    }
    /**
     * Reads the clan file.
     * @param owner
     * @return
     */
    @SuppressWarnings("resource")
    private Clan read(String owner) {
        File file = new File("Data/clan/" + owner + ".cla");
        if (!file.exists()) {
            /*
             * Clan doesn't exist.
             */
            return null;
        }
        try {
            RandomAccessFile in = new RandomAccessFile(file, "rwd");
            //DataInputStream in = new DataInputStream(new FileInputStream(file));
            /*
             * Create a new clan out of the read data.
             */
            Clan clan = new Clan(in.readUTF(), owner);
            clan.whoCanJoin = in.readByte();
            clan.whoCanTalk = in.readByte();
            clan.whoCanKick = in.readByte();
            clan.whoCanBan = in.readByte();
            clan.canTeleport = in.readBoolean();
            clan.canCopy = in.readBoolean();
            int memberCount = in.readShort();
            if (memberCount != 0) {
                for (int index = 0; index < memberCount; index++) {
                    clan.rankedMembers.add(in.readUTF());
                    clan.ranks.add((int) in.readShort());
                }
            }
            in.close();
            /*
             * Data was read successfully.
             */
            return clan;
        } catch (IOException e) {
            /*
             * An error occurred while reading the data.
             */
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * Does the clan for the specified owner exist?
     * @param owner
     * @return
     */
    public boolean clanExists(String owner) {
        File file = new File("Data/clan/" + owner + ".cla");
        return file.exists();
    }

    /**
     * Gets the list of clans.
     * @return
     */
    public LinkedList<Clan> getClans() {
        return clans;
    }

    /**
     * The clans.
     */
    public LinkedList<Clan> clans;

}
