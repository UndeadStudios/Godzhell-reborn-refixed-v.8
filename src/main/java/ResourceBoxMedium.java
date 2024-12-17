import java.util.Random;

public class ResourceBoxMedium {

    public enum ResourceBox {
        GRIMY_TOADFLAX(3050, 2, 5),
        GRIMY_AVANTOE(212, 2, 5),
        GRIMY_KWUARM(214, 2, 5),
        GRIMY_SNAPDRAGON(3052, 2, 5),
        GRIMY_CADANTINE(216, 2, 5),
        COAL(454, 5, 7),
        MITHRIL_ORE(448, 5, 7),
        ADAMANTITE_ORE(450, 5, 7),
        RUNITE_ORE(452, 5, 7),
        MITHRIL_BAR(2360, 1, 5),
        ADAMANTITE_BAR(2362, 1, 5),
        RUNITE_BAR(2364, 1, 5),
        MAPLE_LOGS(1518, 5, 7),
        YEW_LOGS(1516, 5, 7),
        MAGIC_LOGS(1514, 5, 7),
        UNCUT_RUBY(1620, 2, 5),
        UNCUT_DIAMOND(1618, 2, 5),
        RAW_LOBSTER(378, 5, 7),
        RAW_SWORDFISH(372, 5, 7),
        RAW_MONKFISH(7945, 5, 7),
        RAW_KARAMBWAN(3143, 5, 7);

        private final int itemId;
        private final int min;
        private final int max;
        private static final Random random = new Random();

        ResourceBox(int itemId, int min, int max) {
            this.itemId = itemId;
            this.min = min;
            this.max = max;
        }

        public int getItemId() {
            return itemId;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public int getRandomValue() {
            return random.nextInt((max - min) + 1) + min;
        }

        // Static method to get a random ResourceBox
        public static ResourceBox getRandomBox() {
            ResourceBox[] boxes = values();
            return boxes[random.nextInt(boxes.length)];
        }
    }

    // Empty method with Client parameter
    public static void open(client c) {
        if(c.playerHasItem(13001)){
            if(c.freeSlots() >= 4){
                c.deleteItem2(13001, 1);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
           } else {
                c.sendMessage("You need 4 free slots to open this.");
            }
        }
        // Placeholder method for future implementation
    }

    // The Client class needs to be defined elsewhere in your project
}
