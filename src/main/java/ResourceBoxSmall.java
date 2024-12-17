import java.util.Random;

public class ResourceBoxSmall {

    public enum ResourceBox {
        // New items added as requested
        GRIMY_GUAM(200, 1, 3),
        GRIMY_MARRENTILL(202, 1, 3),
        GRIMY_TARROMIN(204, 1, 3),
        GRIMY_HARRALANDER(206, 1, 3),
        GRIMY_RANARR(208, 1, 3),
        IRON_ORE(441, 1, 5),
        COAL_NEW(454, 1, 5),  // New coal entry
        MITHRIL_ORE_NEW(448, 1, 5),  // New mithril ore entry
        BRONZE_BAR(2350, 1, 2),
        IRON_BAR(2352, 1, 2),
        STEEL_BAR(2354, 1, 2),
        MITHRIL_BAR_NEW(2360, 1, 2),  // New mithril bar entry
        LOGS(1512, 1, 5),
        OAK_LOGS(1522, 1, 5),
        WILLOW_LOGS(1520, 1, 5),
        MAPLE_LOGS(1518, 1, 5),
        UNCUT_SAPPHIRE(1624, 1, 3),
        UNCUT_EMERALD(1622, 1, 3),
        RAW_TUNA(360, 1, 3),
        RAW_LOBSTER(378, 1, 3),
        RAW_BASS(364, 1, 3),
        RAW_SWORDFISH(372, 1, 3);

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
        if(c.playerHasItem(13000)){
            if(c.freeSlots() >= 3){
                c.deleteItem2(13000, 1);
                    c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
                c.addItem(ResourceBox.getRandomBox().getItemId(), ResourceBox.getRandomBox().getRandomValue());
          } else {
                c.sendMessage("You need 3 free slots to open this.");
            }
        }
        // Placeholder method for future implementation
    }

    // The Client class needs to be defined elsewhere in your project
}
