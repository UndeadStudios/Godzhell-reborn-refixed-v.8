public class Fletching extends SkillHandler {

    public enum fletchingData {
        SHORTBOW(new int[][] { { 34189, 1 }, { 34188, 5 }, { 34187, 10 }, { 34186, 28 } }, 1511, 50, 5, 5), LONGBOW(
                new int[][] { { 34185, 1 }, { 34184, 5 }, { 34183, 10 }, { 34182, 28 } }, 1511, 48, 10,
                10), ARROW_SHAFT(new int[][] { { 34193, 1 }, { 34192, 5 }, { 34191, 10 }, { 34190, 28 } }, 1511, 52, 1,
                5), OAK_SHORTBOW(new int[][] { { 34189, 1 }, { 34188, 5 }, { 34187, 10 }, { 34186, 28 } }, 1521,
                54, 20, 17), OAK_LONGBOW(
                new int[][] { { 34185, 1 }, { 34184, 5 }, { 34183, 10 }, { 34182, 28 } }, 1521,
                56, 25, 25), OAK_STOCK(
                new int[][] { { 34193, 1 }, { 34192, 5 }, { 34191, 10 },
                        { 34190, 28 } },
                1521, 9442, 24, 16), WILLOW_SHORTBOW(
                new int[][] { { 34189, 1 }, { 34188, 5 }, { 34187, 10 },
                        { 34186, 28 } },
                1519, 60, 35, 33), WILLOW_LONGBOW(
                new int[][] { { 34185, 1 }, { 34184, 5 }, { 34183, 10 },
                        { 34182, 28 } },
                1519, 58, 40, 42), WILLOW_STOCK(
                new int[][] { { 34193, 1 }, { 34192, 5 },
                        { 34191, 10 }, { 34190, 28 } },
                1519, 9444, 39, 22), MAPLE_SHORTBOW(
                new int[][] { { 34189, 1 },
                        { 34188, 5 }, { 34187, 10 },
                        { 34186, 28 } },
                1517, 64, 50,
                50), MAPLE_LONGBOW(new int[][] {
                { 34185, 1 }, { 34184, 5 },
                { 34183, 10 }, { 34182, 28 } },
                1517, 62, 55, 58), MAPLE_STOCK(
                new int[][] {
                        { 34193, 1 },
                        { 34192, 5 },
                        { 34191, 10 },
                        { 34190, 28 } },
                1517, 9448, 54,
                32), YEW_SHORTBOW(
                new int[][] {
                        { 34189, 1 },
                        { 34188, 5 },
                        { 34187, 10 },
                        { 34186, 28 } },
                1515, 68, 65,
                68), YEW_LONGBOW(
                new int[][] {
                        { 34185, 1 },
                        { 34184, 5 },
                        { 34183, 10 },
                        { 34182, 28 } },
                1515,
                66, 70,
                75), YEW_STOCK(
                new int[][] {
                        { 34193, 1 },
                        { 34192, 5 },
                        { 34191, 10 },
                        { 34190, 28 } },
                1515,
                9452,
                69,
                50), MAGIC_SHORTBOW(
                new int[][] {
                        { 34189, 1 },
                        { 34188, 5 },
                        { 34187, 10 },
                        { 34186, 28 } },
                1513,
                72,
                80,
                83), MAGIC_LONGBOW(
                new int[][] {
                        { 34185, 1 },
                        { 34184, 5 },
                        { 34183, 10 },
                        { 34182, 28 } },
                1513,
                70,
                85,
                92);

        private int[][] buttonId;
        private int logid, product, level;
        private int xp;

        private fletchingData(final int[][] buttonId, final int logid, final int product, final int level,
                              final int xp) {
            this.buttonId = buttonId;
            this.logid = logid;
            this.product = product;
            this.level = level;
            this.xp = xp;
        }

        public int getButtonId(final int button) {
            for (int i = 0; i < buttonId.length; i++) {
                if (button == buttonId[i][0]) {
                    return buttonId[i][0];
                }
            }
            return -1;
        }

        public int getAmount(final int button) {
            for (int i = 0; i < buttonId.length; i++) {
                if (button == buttonId[i][0]) {
                    return buttonId[i][1];
                }
            }
            return -1;
        }

        public String getName() {
            String s = name().toLowerCase();
            String t = s.substring(0, 1).toUpperCase() + s.substring(1);
            t = t.replaceAll("_", " ");
            return t;
        }

        public int getLogId() {
            return logid;
        }

        public int getProduct() {
            return product;
        }

        public int getLevel() {
            return level;
        }

        public int getXP() {
            return xp * Config.FLETCHING_EXPERIENCE;
        }

    }

    private static final int[][] ITEM_ON_ITEM = { { 52, 314, 53, 1, 1 }, { 53, 39, 882, 3, 1 }, { 53, 40, 884, 4, 15 },
            { 53, 41, 886, 6, 30 }, { 53, 42, 888, 8, 45 }, { 53, 43, 890, 11, 60 }, { 53, 44, 892, 14, 75 },
            { 53, 11237, 11212, 16, 90 }, { 314, 819, 806, 2, 1 }, { 314, 820, 807, 4, 22 }, { 314, 821, 808, 8, 37 },
            { 314, 822, 809, 11, 52 }, { 314, 823, 810, 15, 67 }, { 314, 824, 811, 19, 81 },
            { 314, 11232, 11230, 25, 95 }, };

    public static boolean arrows(client c, int item1, int item2) {
        for (int i = 0; i < ITEM_ON_ITEM.length; i++) {
            if ((item1 == ITEM_ON_ITEM[i][0] || item1 == ITEM_ON_ITEM[i][1])
                    && (item2 == ITEM_ON_ITEM[i][1] || item2 == ITEM_ON_ITEM[i][0])) {
                return true;
            }
        }
        return false;
    }

    public static void makeArrows(client c, int item1, int item2) {
        for (int j = 0; j < ITEM_ON_ITEM.length; j++) {
            if ((item1 == ITEM_ON_ITEM[j][0] && item2 == ITEM_ON_ITEM[j][1])
                    || (item2 == ITEM_ON_ITEM[j][0] && item1 == ITEM_ON_ITEM[j][1])) {

                if (!hasRequiredLevel(c, c.playerFletching, ITEM_ON_ITEM[j][4], "fletching",
                        "make " + c.getItemName(ITEM_ON_ITEM[j][2]) + "")) {
                    return;
                }

                if (!noInventorySpace(c, "fletching")) {
                    return;
                }
                int amount1 = c.getItemAmount(item1);
                int amount2 = c.getItemAmount(item2);

                int otherAmount = 0;
                if (amount1 >= 15) {
                    amount1 = 15;
                }
                if (amount2 >= 15) {
                    amount2 = 15;
                }
                if (amount1 > amount2) {
                    otherAmount = amount1 - amount2;
                    amount1 = amount1 - otherAmount;
                } else if (amount2 > amount1) {
                    otherAmount = amount2 - amount1;
                    amount2 = amount2 - otherAmount;
                }
                int xp = 0;
                if (amount1 >= amount2) {
                    xp = amount1;
                } else {
                    xp = amount2;
                }
                if (c.playerHasItem(item1, amount1) && c.playerHasItem(item2, amount2)) {
                    c.deleteItem(item1, c.getItemSlot(item1), amount1);
                    c.deleteItem(item2, c.getItemSlot(item2), amount2);
                    c.addItem(ITEM_ON_ITEM[j][2], amount1);
                    c.addSkillXP((ITEM_ON_ITEM[j][3] * xp) * FLETCHING_XP, c.playerFletching);
                }
            }
        }
    }

    public static void makeJavelins(client c, int itemA, int itemB) {
        int javelinId = -1;


        int amountA = c.getItemAmount(itemA);
        int amountB = c.getItemAmount(itemB);

        if (amountA <= 0 || amountB <= 0) {
            return;
        }

        int amount = Math.min(amountA, amountB);

        c.deleteItem2(itemA, amount);
        c.deleteItem2(itemB, amount);
        c.addItem(javelinId, amount);
        c.addSkillXP(500 * 3 * Config.FLETCHING_EXPERIENCE, c.playerFletching);
    }

    public static void normal(client c, int itemUsed, int useWith) {
        final int result = (itemUsed == 946 ? useWith : itemUsed);
        if ((itemUsed == 946 && useWith == 1511) || (itemUsed == 1151 && useWith == 946)) {
            showInterfaceFletching(c, new int[] { 50, 48, 52 }, 0);
        }
        c.fletchingType = result;
    }

    public static void others(client c, int itemUsed, int useWith) {
        final int result = (itemUsed == 946 ? useWith : itemUsed);
        for (int i = 0; i < DATA.length; i++) {
            if ((itemUsed == 946 && useWith == DATA[i][0]) || (itemUsed == DATA[i][0] && useWith == 946)) {
                showInterfaceOthers(c, new int[] { DATA[i][1], DATA[i][4], DATA[i][8] }, DATA[i][7]);
            }
            c.fletchingType = result;
        }
    }

    private static final int[][] DATA = { { 1521, 54, 20, 17, 56, 25, 25, 0, 9442 },
            { 1519, 60, 35, 33, 58, 40, 41, 1, 9444 }, { 1517, 64, 50, 50, 62, 55, 58, 2, 9448 },
            { 1515, 68, 65, 68, 66, 70, 75, 3, 9452 }, { 1513, 72, 80, 83, 70, 85, 91, 4, 9440 }, };

    private static void showInterfaceOthers(client c, int[] items, int type) {
        for (int i = 0; i < DATA.length; i++) {
            if (type == DATA[i][7]) {
                for (int l = 0; l < DATA.length; l++) {
                    c.playerSkillProp[9][l] = DATA[i][l];
                }
            }
        }
        c.sendFrame164(8880);
        c.sendFrame126("What would you like to make?", 8879);
        c.sendFrame246(8884, 190, items[0]);
        c.sendFrame246(8883, 190, items[1]);
        c.sendFrame246(8885, 190, items[2]);
        c.sendFrame126("" + c.getItemName(items[1]) + "", 8889);
        c.sendFrame126("" + c.getItemName(items[0]) + "", 8893);
        c.sendFrame126("" + c.getItemName(items[2]) + "", 8897);
        c.playerIsfFetching = true;
    }

    private static void showInterfaceFletching(client c, int[] items, int type) {
        c.sendFrame164(8880);
        c.sendFrame126("What would you like to make?", 8879);
        c.sendFrame246(8884, 190, items[0]);
        c.sendFrame246(8883, 190, items[1]);
        c.sendFrame246(8885, 190, items[2]);
        c.sendFrame126("" + c.getItemName(items[1]) + "", 8889);
        c.sendFrame126("" + c.getItemName(items[0]) + "", 8893);
        c.sendFrame126("" + c.getItemName(items[2]) + "", 8897);
        c.playerIsfFetching = true;
    }

    public static int[][] normal = { { 1511, 50, 52, 50, 1, 0, 6684, 52 }, };

    public static void attemptData(final client c, final int buttonId) {
        for (final fletchingData l : fletchingData.values()) {
            if (buttonId == l.getButtonId(buttonId)) {
                if (c.fletchingType == l.getLogId()) {
                    if (c.playerLevel[9] < l.getLevel()) {
                        c.sendMessage("You need a Fletching level of " + l.getLevel() + " to make this.");
                        c.RemoveAllWindows();
                        return;
                    }
                    int item = c.getItemAmount(l.getAmount(buttonId));
                    int amount = l.getAmount(buttonId);
                    c.doAmount = amount;
                    if (c.playerSkilling[9]) {
                        return;
                    }
                    c.playerSkilling[9] = true;
                    c.stopPlayerSkill = true;
                    c.RemoveAllWindows();

                    final int itemToDelete = l.getLogId();

                    final int addItem = l.getProduct();
                    final int addXP = l.getXP();

                    c.setAnimation(6702);
                    EventManager.getSingleton().addEvent(c, new Event() {
                        @Override
                        public void execute(EventContainer container) {
                            if (c == null || c.disconnected  || c.IsDead) {
                                container.stop();
                                return;
                            }
                            if (l.getLogId() > 0) {
                                c.deleteItem2(c.fletchingType, 1);
                                c.addItem(addItem, addItem == 52 ? 15 : 1);
                                c.addSkillXP(addXP, 9);

                            }
                            c.setAnimation(6702);
                            deleteTime(c);
                            if (!c.playerHasItem(l.getLogId(), 1) || c.doAmount <= 0) {
                                resetFletching(c);
                                container.stop();
                            }
                            if (!c.stopPlayerSkill) {
                                resetFletching(c);
                                container.stop();
                            }
                        }

                        @Override
                        public void stop() {

                        }
                    }, AnimationLength.getFrameLength(6702)+600);
                }
            }
        }
    }

    public static void resetFletching(client c) {
        c.playerSkilling[9] = false;
        c.stopPlayerSkill = false;
        c.playerIsfFetching = false;
        for (int i = 0; i < 9; i++) {
            c.playerSkillProp[9][i] = -1;
        }
        c.setAnimation(65535);
    }
}