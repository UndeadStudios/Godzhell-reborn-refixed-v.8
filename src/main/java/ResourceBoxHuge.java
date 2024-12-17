import java.util.Random;

public class ResourceBoxHuge {

    public enum ResourceBox {
        GRIMY_LANTADYME(3050, 5, 7),
        GRIMY_DWARF_WEED(212, 5, 7),
        GRIMY_TORSTOL(214, 5, 7),
        COAL(454, 7, 10),
        MITHRIL_ORE(448, 7, 10),
        ADAMANTITE_ORE(450, 7, 10),
        RUNITE_ORE(452, 7, 10),
        MITHRIL_BAR(2360, 2, 5),
        ADAMANTITE_BAR(2362, 2, 5),
        RUNITE_BAR(2364, 2, 5),
        YEW_LOGS(1516, 7, 10),
        MAGIC_LOGS(1514, 7, 10),
        UNCUT_RUBY(1620, 5, 7),
        UNCUT_DIAMOND(1618, 5, 7),
        UNCUT_DRAGONSTONE(1632, 5, 7),
        RAW_MONKFISH(7945, 7, 10),
        RAW_KARAMBWAN(3143, 7, 10),
        RAW_SHARK(384, 7, 10),
        RAW_MANTA_RAY(390, 7, 10);

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
        if(c.playerHasItem(13003)){
            if(c.freeSlots() >= 10){
                c.deleteItem2(13003, 1);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue()*3);
            } else {
                c.sendMessage("You need 10 free slots to open this.");
            }
        }
        // Placeholder method for future implementation
    }

    // The Client class needs to be defined elsewhere in your project
}
