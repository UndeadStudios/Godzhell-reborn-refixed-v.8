import java.util.Objects;

public class BroadcastManager {

    public static Broadcast[] broadcasts = new Broadcast[1000];

    public static void removeBroadcast(int index) {
        if (broadcasts[index] != null) {
            broadcasts[index] = null;
        }
    }

    public static void addIndex(Broadcast broadcast) {
        int index = getFreeIndex();

        if (index == -1) {
            System.err.println("Error adding index.. broadcast list is full!");
            return;
        }

        broadcast.setIndex(index);

        broadcasts[index] = broadcast;

        for (Player p : PlayerHandler.players) { // loop so it effects all players
            if (p != null) { // weeds out the nulls from our function
                client castOn = (client) p; // specific player's client
                if (broadcast.sendChatMessage)
                    castOn.sendMessage(broadcast.getMessage());
                castOn.sendBroadCast(broadcasts[index]);
            }
        }
    }

    public static int getFreeIndex() {
        for (int i = 0; i < broadcasts.length; i++) {
            Broadcast broadcast = broadcasts[i];
            if (broadcast == null)
                return i;
        }
        return -1;
    }
}
