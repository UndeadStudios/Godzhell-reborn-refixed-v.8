public class SkillHandler {

    private static final int SKILLING_XP = 40;
    public static final int AGILITY_XP = SKILLING_XP;
    public static final int PRAYER_XP = SKILLING_XP;
    public static final int MINING_XP = SKILLING_XP;
    public static final int COOKING_XP = SKILLING_XP;
    public static final int RUNECRAFTING_XP = SKILLING_XP;
    public static final int WOODCUTTING_XP = SKILLING_XP;
    public static final int THIEVING_XP = SKILLING_XP;
    public static final int HERBLORE_XP = SKILLING_XP;
    public static final int FISHING_XP = SKILLING_XP;
    public static final int FLETCHING_XP = SKILLING_XP;
    // public static final int FIREMAKING_XP = SKILLING_XP;
    public static boolean[] isSkilling = new boolean[25];

    public static boolean noInventorySpace(client c, String skill) {
        if (c.freeSlots() == 0) {
            c.sendMessage("You haven't got enough inventory space to continue " + skill + "!");
            return false;
        }
        return true;
    }

    public static boolean view190 = true;

    public static void resetPlayerSkillVariables(client c) {
        for (int i = 0; i < 20; i++) {
            if (c.playerSkilling[i]) {
                for (int l = 0; l < 15; l++) {
                    c.playerSkillProp[i][l] = -1;
                }
            }
        }
    }

    public static boolean hasRequiredLevel(final client c, int id, int lvlReq, String skill, String event) {
        if (c.playerLevel[id] < lvlReq) {
            c.sendMessage("Your " + skill + " level not high enough to " + event + "");
            c.sendMessage("You at least need the " + skill + " level of " + lvlReq + ".");
            return false;
        }
        return true;
    }

    public static void deleteTime(client c) {
        c.doAmount--;
    }
}
