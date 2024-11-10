/**
 * @author Tom
 */

public class Pottery {

    public static int unFire = 896;
    public static int Fire = 899;
    public static int softClay = 1761;

    public static void showUnfire(client c) {
        c.sendFrame164(8938);
        c.sendFrame126("What would you like to make?", 8879);
        c.sendFrame246(8941, 120, 1787); // first
        c.sendFrame246(8942, 150, 1789); // second
        c.sendFrame246(8943, 150, 1791); // third
        c.sendFrame246(8944, 120, 5352); // 4th
        c.sendFrame246(8945, 150, 4438); // 5th
        c.sendFrame126("Pot", 8949);
        c.sendFrame126("Pie Dish", 8953);
        c.sendFrame126("Bowl", 8957);
        c.sendFrame126("Plant pot", 8961);
        c.sendFrame126("Pot lid", 8965);
        c.showedUnfire = true;
    }

    public static void showFire(client c) {
        c.sendFrame164(8938);
        c.sendFrame126("What would you like to make?", 8879);
        c.sendFrame246(8941, 120, 1931); // first
        c.sendFrame246(8942, 150, 2313); // second
        c.sendFrame246(8943, 150, 1923); // third
        c.sendFrame246(8944, 120, 5350); // 4th
        c.sendFrame246(8945, 150, 4440); // 5th
        c.sendFrame126("Pot", 8949);
        c.sendFrame126("Pie Dish", 8953);
        c.sendFrame126("Bowl", 8957);
        c.sendFrame126("Plant pot", 8961);
        c.sendFrame126("Pot lid", 8965);
        c.showedFire = true;
    }

    public static void makeUnfire(final client c, final int id,
                                  final double xp, final int level, int amount) {
        c.RemoveAllWindows();
        c.doAmount = amount;

        c.isPotCrafting = true;
        if (c.playerHasItem(softClay)
                && c.playerLevel[12] >= level && c.isPotCrafting) {
            c.startAnimation(unFire);
            c.deleteItem(softClay, 1);
            c.addItem(id, 1);
            c.sendMessage(
                    "You make the soft clay into a "
                            + Item.getItemName(id) + ".");
            c.addSkillXP(xp* Config.CRAFTING_EXPERIENCE, c.playerCrafting);
            c.doAmount--;
        }
        EventManager.getSingleton().addEvent(c, new Event() {

            @Override
            public void execute(EventContainer container) {
                if (c.playerHasItem(softClay)
                        && c.playerLevel[12] >= level && !(c.doAmount <= 0)
                        && c.isPotCrafting) {
                    c.startAnimation(unFire);
                    c.deleteItem(softClay, 1);
                    c.addItem(id, 1);
                    c.sendMessage("You make the soft clay into a " + Item.getItemName(id) + ".");
                    c.addSkillXP(xp* Config.CRAFTING_EXPERIENCE, c.playerCrafting);
                    c.doAmount--;
                }

                if (c.playerLevel[12] < level) {
                    container.stop();
                    c.sendMessage("You need a crafting level of " + level + " to make this.");
                }

                if (!c.playerHasItem(softClay)) {
                    container.stop();
                    c.sendMessage("You need soft clay to do this.");
                }

                if (c.isPotCrafting == false) {
                    container.stop();
                }

                if (c.doAmount <= 0) {
                    container.stop();
                }

            }

            @Override
            public void stop() {
                c.isPotCrafting = false;
                c.startAnimation(65535);
            }
        }, 3+600);
    }

    public static void makeFire(final client player, final int startId,
                                final int finishId, final int level, final double xp, int amount) {
        player.RemoveAllWindows();
        player.doAmount = amount;
        player.isPotCrafting = true;
        if (player.playerHasItem(startId)
                && player.playerLevel[12] >= level && player.isPotCrafting) {
            player.deleteItem(startId, 1);
            player.addItem(finishId, 1);
            player.startAnimation(Fire);
            player.sendMessage("You put a " + Item.getItemName(startId) + " into the oven.");
            player.sendMessage("You retrieve the " + Item.getItemName(finishId) + " from the oven.");
            player.addSkillXP(xp* Config.CRAFTING_EXPERIENCE, player.playerCrafting);
            player.doAmount--;
        }

        if (player.playerLevel[12] < level) {
            player.sendMessage("You need a crafting level of " + level + " to make this.");
        }

        if (!player.playerHasItem(startId) && player.playerLevel[12] >= level) {
            player.sendMessage("You need an " + Item.getItemName(startId) + " to do this.");
        }

        EventManager.getSingleton().addEvent(player, new Event() {

            @Override
            public void execute(EventContainer container) {
                if (player.playerHasItem(startId) && player.playerLevel[12] >= level && player.isPotCrafting && !(player.doAmount <= 0)) {
                    player.deleteItem(startId, 1);
                    player.addItem(finishId, 1);
                    player.startAnimation(Fire);
                  //  player.sendSound(469, 100, 0);
                    player.sendMessage("You put a " + Item.getItemName(startId) + " into the oven.");
                    player.sendMessage("You retrieve the " + Item.getItemName(finishId) + " from the oven.");
                    player.addSkillXP(xp* Config.CRAFTING_EXPERIENCE, player.playerCrafting);
                    player.doAmount--;
                }

                if (player.isPotCrafting == false
                        || !player.playerHasItem(startId)
                        || player.playerLevel[12] < level) {
                    container.stop();
                }

                if (player.doAmount <= 0) {
                    container.stop();
                }

            }

            @Override
            public void stop() {
                player.isPotCrafting = false;
                player.startAnimation(65535);
            }
        }, 5+600);
    }

}