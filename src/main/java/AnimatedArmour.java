/**
 *
 * @author Jason http://www.rune-server.org/members/jason
 * @date Oct 20, 2013
 */
public class AnimatedArmour {

    private static final int SPAWN_X = 2851;
    private static final int SPAWN_Y = 3536;

    public static boolean animator_west;

    public enum Armour {

        BRONZE(4278, 1155, 1117, 1075, 5, 10, 2, 20, 20),
        IRON(4279, 1153, 1115, 1067, 10, 20, 4, 30, 30),
        STEEL(4280, 1157, 1119, 1069, 15, 40, 6, 50, 50),
        MITHRIL(4282, 1159, 1121, 1071, 50, 80, 10, 100, 100),
        ADAMANT(4283, 1161, 1123, 1073, 60, 100, 13, 120, 120),
        RUNE(4284, 1163, 1127, 1079, 80, 120, 18, 150, 150);

        int npcId, helm, platebody, platelegs, tokens, health, max, attack, defence;

        Armour(int npcId, int helm, int platebody, int platelegs, int tokens, int health, int max, int attack, int defence) {
            this.npcId = npcId;
            this.helm = helm;
            this.platebody = platebody;
            this.platelegs = platelegs;
            this.tokens = tokens;
            this.health = health;
            this.max = max;
            this.attack = attack;
            this.defence = defence;
        }

        public int getNpcId() {
            return npcId;
        }

        public int getHelmId() {
            return helm;
        }

        public int getPlatebodyId() {
            return platebody;
        }

        public int getPlatelegsId() {
            return platelegs;
        }

        public int getAmountOfTokens() {
            return tokens;
        }

        public int getHealth() {
            return health;
        }

        public int getMax() {
            return max;
        }

        public int getAttack() {
            return attack;
        }

        public int getDefence() {
            return defence;
        }
    }

    private static Armour getArmourForItemId(int itemId) {
        for (Armour a : Armour.values())
            if (a.getHelmId() == itemId || a.getPlatebodyId() == itemId || a.getPlatelegsId() == itemId)
                return a;
        return null;
    }

    private static Armour getArmourForNpcId(int npcId) {
        for (Armour a : Armour.values())
            if (a.getNpcId() == npcId)
                return a;
        return null;
    }

    public static boolean isAnimatedArmourNpc(int npcId) {
        for (Armour armour : Armour.values()) {
            if (armour.npcId == npcId) {
                return true;
            }
        }
        return false;
    }

    public static void itemOnAnimator(final client player, int itemId) {
        int x = player.absX, y = player.absY;

        if (y != 3537) {
            player.sendMessage("You need to move closer.");
            return;
        }
        animator_west = x == 2851;
        if (player.isAnimatedArmourSpawned) {
            player.sendMessage("An Animated Armour npc is already spawned.");
            return;
        }
        final Armour armour = getArmourForItemId(itemId);
        if (armour == null) {
            player.sendMessage("This is not a feasable animated armour item.");
            return;
        }
        if (!player.playerHasItem(armour.getPlatebodyId(), 1) || !player.playerHasItem(armour.getPlatelegsId(), 1)
                || !player.playerHasItem(armour.getHelmId(), 1)) {
            player.sendMessage("You need the helm, platebody, and platelegs to spawn the animated armour.");
            return;
        }
        player.isAnimatedArmourSpawned = true;
        player.deleteItem2(armour.getPlatebodyId(), 1);
        player.deleteItem2(armour.getPlatelegsId(), 1);
        player.deleteItem2(armour.getHelmId(), 1);
        player.walkTo2(0, +3);
        EventManager.getSingleton().addEvent(player, new Event() {

            @Override
            public void execute(EventContainer event) {
                server.npcHandler.spawnNpc(player, armour.getNpcId(), animator_west ? SPAWN_X : 2857, SPAWN_Y, 0, 1,armour.getHealth(), armour.getMax(), armour.getAttack(), armour.getDefence(), true,
                        true);
                player.sendMessage("An animated armour has spawned...", 255);
                event.stop();
            }

            @Override
            public void stop() {

            }
        }, 6*600);
    }

    public static void dropTokens(client player, int npcType, int x, int y) {
        Armour npc = getArmourForNpcId(npcType);
        if (npc != null) {
            server.itemHandler.addItem(8851, x, y, npc.getAmountOfTokens(), player.playerId, false);
            player.isAnimatedArmourSpawned = false;
        }
    }

}
