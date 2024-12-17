import java.util.Arrays;
import java.util.Optional;

public class WarriorsGuild {

    public static final Boundary CYCLOPS_BOUNDARY = new Boundary(2833, 3530, 2880, 3560, 2);

    public static final Boundary[] WAITING_ROOM_BOUNDARY = new Boundary[] {
            new Boundary(2838, 3536, 2846, 3542, 2),
            new Boundary(2847, 3537, 2847, 3537, 2)
    };

    private client player;

    private boolean active;

    public static final int[][] DEFENDER_DATA = {
            {8844, 10},
            {8845, 15},
            {8846, 20},
            {8848, 25},
            {8849, 30},
            {8850, 35}
    };

    public WarriorsGuild(client player) {
        this.player = player;
    }

    public void cycle() {
        EventManager.getSingleton().stopEvents(this);
        setActive(true);
        EventManager.getSingleton().addEvent(this, new Event() {

            @Override
            public void execute(EventContainer event) {
                if(player == null || player.disconnected) {
                    event.stop();
                    return;
                }
                if(!player.playerHasItem(8851, 10)) {
                    removeFromRoom();
                    setActive(false);
                    event.stop();
                    return;
                }
                if(!Boundary.isIn(player, CYCLOPS_BOUNDARY) || Boundary.isIn(player, WAITING_ROOM_BOUNDARY)) {
                    setActive(false);
                    event.stop();
                    return;
                }
                player.deleteItem2(8851, 20);
                player.sendMessage("You notice some of your warrior guild tokens disappear..", 255);
            }

            @Override
            public void stop() {

            }

        }, 100 * 600);
    }

    public void handleDoor() {
        if(player.absX == 2847 && player.absY == 3540 || player.absX == 2847 && player.absY == 3541) {
            EventManager.getSingleton().stopEvents(this);
            player.movePlayer(player.absX - 1, player.absY, 2);
        } else if(player.absX == 2846 && player.absY == 3540 || player.absX == 2846 && player.absY == 3541 || Boundary.isIn(player, WAITING_ROOM_BOUNDARY)) {
            if(player.playerHasItem(8851, 100)) {
                int current = currentDefender();
                if (current == -1) {
                    player.talk3(9760,
                            "You are not in the possession of a defender.",
                            "You must kill cyclops to obtain a defender.",
                            "The fee for entering the area is 100 tokens.", 4289);
                    player.NpcDialogue = 627;
                } else {
                    player.talk2(9760,
                            "You are currently in possession of a "+player.getItemName(current)+".",
                            "The fee for re-entering the area is 100 tokens.", 4289);
                    player.NpcDialogue = 627;
                }
            } else {
                player.talk2(9760,"You need atleast 100 warrior guild tokens.", "You can get some by operating the armour animator.", 2461);
                player. NpcDialogue = 0;
            }
        }
    }

    /**
     * Attempts to return the value of the defender the player is wearing or is in posession of
     * in their inventory.
     * @return	-1 will be returned in the case that the player does not have a defender
     */
    private int currentDefender() {
        for(int index = DEFENDER_DATA.length - 1; index > -1; index--) {
            int[] defender = DEFENDER_DATA[index];
            if (player.playerHasItem(defender[0])
                    || player.isWearingItem(defender[0])) {
                return defender[0];
            }
        }
        return -1;
    }

    /**
     * Attempts to return the next best defender.
     * @return	The first defender, bronze, if the player doesnt have a defender.
     * If the player has the best it will return the best. If either of the afforementioned
     * conditions are not met, the next best defender is returned.
     */
    private int nextDefender() {
        int defender = currentDefender();
        if (defender == -1) {
            return DEFENDER_DATA[0][0];
        }
        int best = DEFENDER_DATA[DEFENDER_DATA.length - 1][0];
        if (best == defender) {
            return best;
        }
        int index = indexOf(defender);
        if (index != -1) {
            defender = DEFENDER_DATA[index + 1][0];
        }
        return defender;
    }

    /**
     * Attempts to retrieve the index in the array of the defender
     * @param defender	the defender
     * @return	-1 will be returned if the defender cannot be found
     */
    private int indexOf(int defender) {
        for (int index = 0; index < DEFENDER_DATA.length; index++) {
            if (defender == DEFENDER_DATA[index][0]) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Retrieves the drop chance of the next best defender the player
     * can receive.
     * @return	the chance of the dropped dagger.
     */
    private int chance() {
        Optional<int[]> defender = Arrays.asList(DEFENDER_DATA).stream().filter(
                data -> data[0] == nextDefender()).findFirst();
        return defender.isPresent() ? defender.get()[1] : 0;
    }

    public void dropDefender(int x, int y) {
        int amount = player.getItemAmount(8851);
        if(isActive() && Boundary.isIn(player, CYCLOPS_BOUNDARY) && !Boundary.isIn(player, WAITING_ROOM_BOUNDARY) && amount > 1) {
            int chance = chance();
            int current = currentDefender();
            int item = current == -1 ? DEFENDER_DATA[0][0] : nextDefender();
            if (misc.random(chance) == 0) {
                server.itemHandler.addItem(item, x, y,  1, player.playerId, false);
                player.sendMessage("The cyclops dropped a "+player.getItemName(item)+" on the ground.", 600000);
                //	player.sendMessage("Rolled:"+chance / chance());
            }
        }
    }

    public void removeFromRoom() {
        if (Boundary.isIn(player, CYCLOPS_BOUNDARY)) {
            player.movePlayer(2846, 3540, 2);
            player.sendStatement("You do not have enough tokens to continue.");
            player.setNext = 0;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
