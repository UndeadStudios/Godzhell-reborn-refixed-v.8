/**
 * Class Prayer Handles Prayer
 * @author 2012 23:56 29/12/2010
 */

public class Prayer {

    private static int[][] data = {
            { 526, 5 }, // NPC BONES
            { 528, 5 }, // BURNT BONES
            { 530, 5 }, // BAT BONES
            { 2859, 5 }, // WOLF BONES
            { 3179, 5 }, // MONKEY BONES
            { 3180, 5 }, // MONKEY BONES
            { 3181, 5 }, // MONKEY BONES
            { 3182, 5 }, // MONKEY BONES
            { 3183, 5 }, // MONKEY BONES
            { 3185, 5 }, // MONKEY BONES
            { 3186, 5 }, // MONKEY BONES
            { 3187, 5 }, // MONKEY BONES
            { 532, 15 }, // BIG BONES
            { 534, 30 }, // BABY DRAGON BONES
            { 536, 72 }, // DRAGON BONES
            { 2530, 5 }, // PLAYER BONES
            { 3123, 25 }, // SHAIKAHAN BONES
            { 3125, 23 }, // JOGRE BONES
            { 3127, 25 }, // BURNT JOGRE BONES
            { 4812, 82 }, // ZOGRE BONES
            { 4830, 84 }, // FAYGR BONES
            { 4832, 96 }, // RAURG BONES
            { 4834, 140 }, // OURG BONES
            { 6729, 125 }, // DAGANNOTH BONES
            { 6812, 50 }, // WYVERN BONES
    };

    public static boolean playerBones(client player, int item) {
        for (int[] element : data) {
            if (item == element[0]) {
                return true;
            }
        }
        return false;
    }

    private static void handleBones(final client c, int i, int slot) {
        for (final int[] element : data) {
            if (i == element[0]) {
                if (System.currentTimeMillis() - c.buryDelay > 800) {
                    c.deleteItem(element[0], slot, 1);
                    c.addSkillXP(element[1], 5);
                    c.buryDelay = System.currentTimeMillis();
                    c.startAnimation(827);
                    //c.getPacketSender().sendSound(SoundList.BONE_BURY, 100, 0);
                    c.sendMessage("You dig a hole in the ground...");
                    EventManager.getSingleton().addEvent(c, new Event() {
                        @Override
                        public void execute(EventContainer container) {
                            c.sendMessage("You bury the " + Item.getItemName(element[0]).toLowerCase() + ".");
                            c.sendSound(soundList.BONE_BURY, 100, 0);
                            container.stop();
                        }
                        @Override
                        public void stop() {

                        }
                    }, 1+600);
                }
            }
        }
    }

    public static void buryBones(client c, int i, int slot) {
        handleBones(c, i, slot);
    }
}