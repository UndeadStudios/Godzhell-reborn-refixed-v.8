import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: vayken Date: 24/02/12 Time: 20:34 To change refractor by DragonSmi
* this template use File | Settings | File Templates.
 */
public class Allotments {

    private client player;

    // set of global constants for Farming

    private static final int START_HARVEST_AMOUNT = 3;
    private static final int END_HARVEST_AMOUNT = 56;

    private static final double WATERING_CHANCE = 0.5;
    private static final double COMPOST_CHANCE = 0.9;
    private static final double SUPERCOMPOST_CHANCE = 0.7;
    private static final double CLEARING_EXPERIENCE = 4;

    public Allotments(client player) {
        this.player = player;
    }

    // Farming data
    public int[] farmingStages = new int[8];
    public int[] farmingSeeds = new int[8];
    public int[] farmingHarvest = new int[8];
    public int[] farmingState = new int[8];
    public long[] farmingTimer = new long[8];
    public double[] diseaseChance = {1, 1, 1, 1, 1, 1, 1, 1};
    public boolean[] farmingWatched = {false, false, false, false, false, false, false, false};
    public boolean[] hasFullyGrown = {false, false, false, false, false, false, false, false};

    /* set of the constants for the patch */

    // states - 2 bits plant - 6 bits
    public static final int GROWING = 0x00;
    public static final int WATERED = 0x01;
    public static final int DISEASED = 0x02;
    public static final int DEAD = 0x03;

    public static final int FALADOR_AND_CATHERBY_CONFIG = 504;
    public static final int ARDOUGNE_AND_PHASMATYS_CONFIG = 505;

    /* This is the enum holding the seeds info */

    public enum AllotmentData {

        POTATO(5318, 1942, 5096, 3, 1, new int[]{6032, 2}, 40, 0.30, 8, 9.5, 0x06, 0x0c), ONION(5319, 1957, 5096, 3, 5, new int[]{5438, 1}, 40, 0.30, 9.5, 10.5, 0x0d, 0x13), CABBAGE(5324, 1965, 5097, 3, 7, new int[]{5458, 1}, 40, 0.25, 10, 11.5, 0x14, 0x1a), TOMATO(5322, 1982, 5096, 3, 12, new int[]{5478, 2}, 40, 0.25, 12.5, 14, 0x1b, 0x21), SWEETCORN(5320, 5986, 6059, 3, 20, new int[]{5931, 10}, 40, 0.20, 17, 19, 0x22, 0x2a), STRAWBERRY(5323, 5504, -1, 3, 31, new int[]{5386, 1}, 40, 0.20, 26, 29, 0x2b, 0x33), WATERMELON(5321, 5982, 5098, 3, 47, new int[]{5970, 10}, 40, 0.20, 48.5, 54.5, 0x34, 0x3e);

        private int seedId;
        private int harvestId;
        private int flowerProtect;
        private int seedAmount;
        private int levelRequired;
        private int[] paymentToWatch;
        private int growthTime;
        private double diseaseChance;
        private double plantingXp;
        private double harvestXp;
        private int startingState;
        private int endingState;

        private static Map<Integer, AllotmentData> seeds = new HashMap<Integer, AllotmentData>();

        static {
            for (AllotmentData data : AllotmentData.values()) {
                seeds.put(data.seedId, data);
            }
        }

        AllotmentData(int seedId, int harvestId, int flowerProtect, int seedAmount, int levelRequired, int[] paymentToWatch, int growthTime, double diseaseChance, double plantingXp, double harvestXp, int startingState, int endingState) {
            this.seedId = seedId;
            this.harvestId = harvestId;
            this.flowerProtect = flowerProtect;
            this.seedAmount = seedAmount;
            this.levelRequired = levelRequired;
            this.paymentToWatch = paymentToWatch;
            this.growthTime = growthTime;
            this.diseaseChance = diseaseChance;
            this.plantingXp = plantingXp;
            this.harvestXp = harvestXp;
            this.startingState = startingState;
            this.endingState = endingState;
        }

        public static AllotmentData forId(int seedId) {
            return seeds.get(seedId);
        }

        public int getSeedId() {
            return seedId;
        }

        public int getHarvestId() {
            return harvestId;
        }

        public int getFlowerProtect() {
            return flowerProtect;
        }

        public int getSeedAmount() {
            return seedAmount;
        }

        public int getLevelRequired() {
            return levelRequired;
        }

        public int[] getPaymentToWatch() {
            return paymentToWatch;
        }

        public int getGrowthTime() {
            return growthTime;
        }

        public double getDiseaseChance() {
            return diseaseChance;
        }

        public double getPlantingXp() {
            return plantingXp;
        }

        public double getHarvestXp() {
            return harvestXp;
        }

        public int getStartingState() {
            return startingState;
        }

        public int getEndingState() {
            return endingState;
        }
    }

    /* This is the enum data about the different patches */

    public enum AllotmentFieldsData {

        CATHERBY_NORTH(0, new Position[]{new Position(2805, 3466), new Position(2806, 3468), new Position(2805, 3467), new Position(2814, 3468)}, 2324),

        CATHERBY_SOUTH(1, new Position[]{new Position(2805, 3459), new Position(2806, 3461), new Position(2802, 3459), new Position(2814, 3460)}, 2324),

        FALADOR_NORTH_WEST(2, new Position[]{new Position(3050, 3307), new Position(3051, 3312), new Position(3050, 3311), new Position(3054, 3312)}, 2323),

        FALADOR_SOUTH_EAST(3, new Position[]{new Position(3055, 3303), new Position(3059, 3304), new Position(3058, 3303), new Position(3059, 3308)}, 2323),

        PHASMATYS_NORTH_WEST(4, new Position[]{new Position(3597, 3525), new Position(3598, 3530), new Position(3597, 3529), new Position(3601, 3530)}, 2326),

        PHASMATYS_SOUTH_EAST(5, new Position[]{new Position(3602, 3521), new Position(3606, 3522), new Position(3605, 3521), new Position(3606, 3526)}, 2326),

        ARDOUGNE_NORTH(6, new Position[]{new Position(2662, 3377), new Position(2663, 3379), new Position(2662, 3378), new Position(2671, 3379)}, 2325),

        ARDOUGNE_SOUTH(7, new Position[]{new Position(2662, 3370), new Position(2663, 3372), new Position(2662, 3370), new Position(2671, 3371)}, 2325);

        private int allotmentIndex;
        private Position[] allotmentPosition;
        private int farmerBelonging;

        AllotmentFieldsData(int allotmentIndex, Position[] allotmentPosition, int farmerBelonging) {
            this.allotmentIndex = allotmentIndex;
            this.allotmentPosition = allotmentPosition;
            this.farmerBelonging = farmerBelonging;
        }

        public static AllotmentFieldsData forIdPosition(Position position) {
            for (AllotmentFieldsData allotmentFieldsData : AllotmentFieldsData.values()) {
                if (FarmingConstants.inRangeArea(allotmentFieldsData.getAllotmentPosition()[0], allotmentFieldsData.getAllotmentPosition()[1], position) || FarmingConstants.inRangeArea(allotmentFieldsData.getAllotmentPosition()[2], allotmentFieldsData.getAllotmentPosition()[3], position)) {
                    return allotmentFieldsData;
                }
            }
            return null;
        }

        public static ArrayList<Integer> listIndexProtected(int npcId) {
            ArrayList<Integer> array = new ArrayList<Integer>();
            for (AllotmentFieldsData allotmentFieldsData : AllotmentFieldsData.values()) {
                if (allotmentFieldsData.getFarmerBelonging() == npcId)
                    array.add(allotmentFieldsData.allotmentIndex);
            }
            return array;

        }

        public int getAllotmentIndex() {
            return allotmentIndex;
        }

        public Position[] getAllotmentPosition() {
            return allotmentPosition;
        }

        public int getFarmerBelonging() {
            return farmerBelonging;
        }
    }

    /* This is the enum that hold the different data for inspecting the plant */

    public enum InspectData {
        POTATOES(5318, new String[][]{{"The potato seeds have only just been planted."}, {"The potato plants have grown to double their", "previous height."}, {"The potato plants now are the same height as the", "surrounding weeds."}, {"The potato plants now spread their branches wider,", "not growing as much as before."}, {"The potato plants are ready to harvest. A white", "flower at the top of each plant opens up."}}), ONIONS(5319, new String[][]{{"The onion seeds have only just been planted."}, {"The onions are partially visible and the stems", "have grown."}, {"The top of the onion of the onion plant is clear", "above the ground and the onion is white."}, {"The onion plant is slightly larger than before and", "the onion is cream coloured."}, {"The onion stalks are larger than before and the", "onion is now light and brown coloured."}}), CABBAGES(5324, new String[][]{{"The cabbage seeds have only just been planted,", "the cabbages are small and bright green."},
                {"The cabbages are much larger, with more leaves", "surrounding the head."}, {"The cabbages are larger than before, and textures", "of leaves are now easily observable."}, {"The cabbage head has swollen larger, and the", "surrounding leaves are more close to the ground."}, {"The cabbage plants are ready to harvest. The", "centre of each cabbage head is light green coloured."}}), TOMATOES(5322, new String[][]{{"The tomato seeds have only just been planted."}, {"The tomato plants grow twice as large as before."}, {"The tomato plants grow larger, and small green", "tomatoes are now observable."}, {"The tomato plants grow thicker to hold up the", "weight of the tomatoes. The tomatoes are now light", "orange and slightly larger on the plant."}, {"The tomato plants are ready to harvest. The tomato", "plants leaves are larger and the tomatoes are", "ripe red."}}), SWEETCORNS(5320, new String[][]{{"The sweetcorn plants have only just been planted."},
                {"The sweetcorn plants are waist tall now and are", "leafy."}, {"The sweetcorn plants are slightly taller than", "before and slightly thicker."}, {"The sweetcorn leaves are larger at the base, and", "the plants are slightly taller."}, {"Closed corn cobs are now observable on the", "sweetcorn plants."}, {"The sweetcorn plants are ready to harvest. The", "corn cobs are open and visibly yellow."}}), STRAWBERRIES(5323, new String[][]{{"The strawberry seeds have only just been planted."}, {"The strawberry plants have more leaves than before."}, {"The strawberry plants have even more leaves and is", "slightly taller than before."}, {"Each strawberry plant has opened one white", "flower each."}, {"The strawberry plants are slightly larger, and", "have small strawberries visible at their bases."}, {"The strawberry plants are slightly larger, opened", "a second flower each, and have more strawberries."},
                {"The strawberry plants are ready to harvest. The", "strawberries are almost as large as the flowers."}}), WATERMELONS(5321, new String[][]{{"The strawberry seeds have only just been planted."}, {"The strawberry plants have more leaves than before."}, {"The strawberry plants have even more leaves and is", "slightly taller than before."}, {"Each strawberry plant has opened one white", "flower each."}, {"The strawberry plants are slightly larger, and", "have small strawberries visible at their bases."}, {"The strawberry plants are slightly larger, opened", "a second flower each, and have more strawberries."}, {"The strawberry plants are ready to harvest. The", "strawberries are almost as large as the flowers."}});

        private int seedId;
        private String[][] messages;

        private static Map<Integer, InspectData> seeds = new HashMap<Integer, InspectData>();

        static {
            for (InspectData data : InspectData.values()) {
                seeds.put(data.seedId, data);
            }
        }

        InspectData(int seedId, String[][] messages) {
            this.seedId = seedId;
            this.messages = messages;
        }

        public static InspectData forId(int seedId) {
            return seeds.get(seedId);
        }

        public int getSeedId() {
            return seedId;
        }

        public String[][] getMessages() {
            return messages;
        }
    }

    /* update all the patch states */

    public void updateAllotmentsStates() {
        // catherby north - catherby south - falador north west - falador south
        // east - phasmatys north west - phasmatys south east - ardougne north -
        // ardougne south
        int[] configValues = new int[farmingStages.length];

        int configValue;
        for (int i = 0; i < farmingStages.length; i++) {
            configValues[i] = getConfigValue(farmingStages[i], farmingSeeds[i], farmingState[i], i);
        }

        configValue = (configValues[0] << 16) + (configValues[1] << 8 << 16) + configValues[2] + (configValues[3] << 8);
        player.sendConfig(FALADOR_AND_CATHERBY_CONFIG, configValue);

        configValue = configValues[4] << 16 | configValues[5] << 8 << 16 | configValues[6] | configValues[7] << 8;
        player.sendConfig(ARDOUGNE_AND_PHASMATYS_CONFIG, configValue);

    }

    /* getting the different config values */

    public int getConfigValue(int allotmentStage, int seedId, int plantState, int index) {
        AllotmentData allotmentData = AllotmentData.forId(seedId);
        switch (allotmentStage) {
            case 0 :// weed
                return (GROWING << 6) + 0x00;
            case 1 :// weed cleared
                return (GROWING << 6) + 0x01;
            case 2 :
                return (GROWING << 6) + 0x02;
            case 3 :
                return (GROWING << 6) + 0x03;
        }
        if (allotmentData == null) {
            return -1;
        }
        if (allotmentData.getEndingState() == allotmentData.getStartingState() + allotmentStage - 1) {
            hasFullyGrown[index] = true;
        }

        return (getPlantState(plantState) << 6) + allotmentData.getStartingState() + allotmentStage - 4;
    }

    /* getting the plant states */

    public int getPlantState(int plantState) {
        switch (plantState) {
            case 0 :
                return GROWING;
            case 1 :
                return WATERED;
            case 2 :
                return DISEASED;
            case 3 :
                return DEAD;
        }
        return -1;
    }

    /* calculating the disease chance and making the plant grow */

    public void doCalculations() {
        for (int i = 0; i < farmingSeeds.length; i++) {
            if (farmingStages[i] > 0 && farmingStages[i] <= 3 && server.getMinutesCounter() - farmingTimer[i] >= 5) {
                farmingStages[i]--;
                farmingTimer[i] = server.getMinutesCounter();
                updateAllotmentsStates();
            }
            AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[i]);
            if (allotmentData == null) {
                continue;
            }

            long difference = server.getMinutesCounter() - farmingTimer[i];
            long growth = allotmentData.getGrowthTime();
            int nbStates = allotmentData.getEndingState() - allotmentData.getStartingState();
            int state = (int) (difference * nbStates / growth);
            if (farmingTimer[i] == 0 || farmingState[i] == 3 || state > nbStates) {
                continue;
            }
            if (4 + state != farmingStages[i]) {
                farmingStages[i] = 4 + state;
                if (farmingStages[i] <= 4 + state)
                    for (int j = farmingStages[i]; j <= 4 + state; j++)
                        doStateCalculation(i);
                updateAllotmentsStates();
            }
        }
    }

    public void modifyStage(int i) {
        AllotmentData bushesData = AllotmentData.forId(farmingSeeds[i]);
        if (bushesData == null)
            return;
        long difference = server.getMinutesCounter() - farmingTimer[i];
        long growth = bushesData.getGrowthTime();
        int nbStates = bushesData.getEndingState() - bushesData.getStartingState();
        int state = (int) (difference * nbStates / growth);
        farmingStages[i] = 4 + state;
        updateAllotmentsStates();

    }

    /* calculations about the diseasing chance */

    public void doStateCalculation(int index) {
        if (farmingState[index] == 3) {
            return;
        }
        // if the patch is diseased, it dies, if its watched by a farmer, it
        // goes back to normal
        if (farmingState[index] == 2) {
            if (farmingWatched[index]) {
                farmingState[index] = 0;
                AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[index]);
                if (allotmentData == null)
                    return;
                int difference = allotmentData.getEndingState() - allotmentData.getStartingState();
                int growth = allotmentData.getGrowthTime();
                farmingTimer[index] += (growth / difference);
                modifyStage(index);
            } else {
                farmingState[index] = 3;
            }
        }

        if (farmingState[index] == 1) {
            diseaseChance[index] *= 2;
            farmingState[index] = 0;
        }

        if (farmingState[index] == 5 && farmingStages[index] != 3) {
            farmingState[index] = 0;
        }

        if (farmingState[index] == 0 && farmingStages[index] >= 5 && !hasFullyGrown[index]) {
            handleFlowerProtection(index);
        }
    }

    /* watering the patch */

    public boolean waterPatch(int objectX, int objectY, int itemId) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null) {
            return false;
        }
        AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[allotmentFieldsData.getAllotmentIndex()]);
        if (allotmentData == null) {
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        if (farmingState[allotmentFieldsData.getAllotmentIndex()] == 1 || farmingStages[allotmentFieldsData.getAllotmentIndex()] <= 1 || farmingStages[allotmentFieldsData.getAllotmentIndex()] == allotmentData.getEndingState() - allotmentData.getStartingState() + 4) {
            player.sendMessage("This patch doesn't need watering.");
            return true;
        }
        player.deleteItem(itemId, 1);
        player.addItem(itemId == 5333 ? itemId - 2 : itemId - 1, 1);

        if (!player.playerHasItem(FarmingConstants.RAKE)) {
            player.sendMessage("You need a seed dibber to plant seed here.");
            return true;
        }
        player.sendMessage("You water the patch.");
        player.startAnimation(FarmingConstants.WATERING_CAN_ANIM);
        player.updateRequired = true;
        player.appearanceUpdateRequired = true;


        EventManager.getSingleton().addEvent(player,new Event() {

            public void execute(EventContainer container) {
                diseaseChance[allotmentFieldsData.getAllotmentIndex()] *= WATERING_CHANCE;
                farmingState[allotmentFieldsData.getAllotmentIndex()] = 1;
                container.stop();
            }

            @Override
            public void stop() {
                updateAllotmentsStates();
                player.resetAnimation();
            }
        }, AnimationLength.getFrameLength(FarmingConstants.WATERING_CAN_ANIM)*600);
        return true;
    }

    /* clearing the patch with a rake of a spade */

    public boolean clearPatch(int objectX, int objectY, int itemId) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        int finalAnimation;
        int finalDelay;
        if (allotmentFieldsData == null || (itemId != FarmingConstants.RAKE && itemId != FarmingConstants.SPADE)) {
            return false;
        }
        if (farmingStages[allotmentFieldsData.getAllotmentIndex()] == 3) {
            return true;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        if (farmingStages[allotmentFieldsData.getAllotmentIndex()] <= 3) {
            if (!player.playerHasItem(FarmingConstants.RAKE)) {
                player.sendMessage("You need a rake to clear this path.");
                return true;
            } else {
                finalAnimation = FarmingConstants.RAKING_ANIM;
                finalDelay = 5;
            }
        } else {
            if (!player.playerHasItem(FarmingConstants.SPADE)) {
                player.sendMessage("You need a spade to clear this path.");
                return true;
            } else {
                finalAnimation = FarmingConstants.SPADE_ANIM;
                finalDelay = 3;
            }
        }
        final int animation = finalAnimation;
        player.startAnimation(animation);
        player.animationUpdateRequired = true;
        player.updateRequired = true;
        player.appearanceUpdateRequired = true;
        EventManager.getSingleton().addEvent(player,new Event() {

            @Override
            public void execute(EventContainer container) {
                player.startAnimation(animation);
                player.animationUpdateRequired = true;
                player.updateRequired = true;
                player.appearanceUpdateRequired = true;
                if (farmingStages[allotmentFieldsData.getAllotmentIndex()] <= 2) {
                    farmingStages[allotmentFieldsData.getAllotmentIndex()]++;
                    player.addItemorDrop(6055, 1);
                } else {
                    farmingStages[allotmentFieldsData.getAllotmentIndex()] = 3;
                    container.stop();
                }
                player.addSkillXP(CLEARING_EXPERIENCE, player.playerFarming);
                farmingTimer[allotmentFieldsData.getAllotmentIndex()] = server.getMinutesCounter();
                updateAllotmentsStates();
                if (farmingStages[allotmentFieldsData.getAllotmentIndex()] == 3) {
                    container.stop();
                    return;
                }
            }

            @Override
            public void stop() {
                resetAllotments(allotmentFieldsData.getAllotmentIndex());
                player.sendMessage("You clear the patch.");
                player.resetAnimation();
            }
        }, AnimationLength.getFrameLength(animation)*600);
        return true;

    }

    /* planting the seeds */

    public boolean plantSeed(int objectX, int objectY, final int seedId) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        final AllotmentData allotmentData = AllotmentData.forId(seedId);
        if (allotmentFieldsData == null || allotmentData == null) {
            return false;
        }
        if (farmingStages[allotmentFieldsData.getAllotmentIndex()] != 3) {
            player.sendMessage("You can't plant a seed here.");
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        if (allotmentData.getLevelRequired() > player.playerLevel[player.playerFarming]) {
            player.sendMessage("You need a farming level of " + allotmentData.getLevelRequired() + " to plant this seed.");
            return true;
        }
        if (!player.playerHasItem(FarmingConstants.SEED_DIBBER)) {
            player.sendMessage("You need a seed dibber to plant seed here.");
            return true;
        }
        if (player.getItemAmount(allotmentData.getSeedId()) < allotmentData.getSeedAmount()) {
            player.sendMessage("You need atleast " + allotmentData.getSeedAmount() + " seeds to plant here.");
            return true;
        }
        player.startAnimation(FarmingConstants.SEED_DIBBING);
        player.updateRequired = true;
        player.appearanceUpdateRequired = true;
        farmingStages[allotmentFieldsData.getAllotmentIndex()] = 4;
        player.deleteItem(seedId, allotmentData.getSeedAmount());

       // player.setStopPacket(true);
        EventManager.getSingleton().addEvent(player,new Event() {

            public void execute(EventContainer container) {
                farmingState[allotmentFieldsData.getAllotmentIndex()] = 0;
                farmingSeeds[allotmentFieldsData.getAllotmentIndex()] = seedId;
                farmingTimer[allotmentFieldsData.getAllotmentIndex()] = server.getMinutesCounter();
                player.addSkillXP(allotmentData.getPlantingXp(), player.playerFarming);
                container.stop();
            }

            @Override
            public void stop() {
                updateAllotmentsStates();
            }
        }, AnimationLength.getFrameLength(FarmingConstants.SEED_DIBBING)*600);
        return true;
    }

    @SuppressWarnings("unused")
    private void displayAll() {
        for (int i = 0; i < farmingStages.length; i++) {
            System.out.println("index : " + i);
            System.out.println("state : " + farmingState[i]);
            System.out.println("harvest : " + farmingHarvest[i]);
            System.out.println("seeds : " + farmingSeeds[i]);
            System.out.println("level : " + farmingStages[i]);
            System.out.println("timer : " + farmingTimer[i]);
            System.out.println("disease chance : " + diseaseChance[i]);
            System.out.println("-----------------------------------------------------------------");
        }
    }

    /* harvesting the plant resulted */

    public boolean harvest(int objectX, int objectY) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null) {
            return false;
        }
        final AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[allotmentFieldsData.getAllotmentIndex()]);
        if (allotmentData == null) {
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        if (!player.playerHasItem(FarmingConstants.SPADE)) {
            player.sendMessage("You need a spade to harvest here.");
            return true;
        }
       // final int task = player.getTask();
        player.startAnimation(FarmingConstants.SPADE_ANIM);
        player.updateRequired = true;
        player.appearanceUpdateRequired = true;
        EventManager.getSingleton().addEvent(player,new Event() {


            public void execute(EventContainer container) {
                if (farmingHarvest[allotmentFieldsData.getAllotmentIndex()] == 0) {
                    farmingHarvest[allotmentFieldsData.getAllotmentIndex()] = (int) (1 + (START_HARVEST_AMOUNT + misc.random(END_HARVEST_AMOUNT - START_HARVEST_AMOUNT)) * (player.playerHasItem(7409) ? 1.10 : 1));
                }
                if (farmingHarvest[allotmentFieldsData.getAllotmentIndex()] == 1) {
                    resetAllotments(allotmentFieldsData.getAllotmentIndex());
                    farmingStages[allotmentFieldsData.getAllotmentIndex()] = 3;
                    farmingTimer[allotmentFieldsData.getAllotmentIndex()] = server.getMinutesCounter();
                    container.stop();
                    return;
                }
                if (player.freeSlots() <= 0) {
                    container.stop();
                    return;
                }
                farmingHarvest[allotmentFieldsData.getAllotmentIndex()]--;
                player.startAnimation(FarmingConstants.SPADE_ANIM);
                player.updateRequired = true;
                player.appearanceUpdateRequired = true;
                player.sendMessage("You harvest the crop, and get some vegetables.");
                player.addItem(allotmentData.getHarvestId(), 1);
                player.addSkillXP(allotmentData.getHarvestXp(), player.playerFarming);
            }

            @Override
            public void stop() {
                updateAllotmentsStates();
                player.resetAnimation();
            }
        }, AnimationLength.getFrameLength(FarmingConstants.SPADE_ANIM)*600);

        return true;
    }

    /* putting compost onto the plant */

    public boolean putCompost(int objectX, int objectY, final int itemId) {
        if (itemId != 6032 && itemId != 6034) {
            return false;
        }
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null) {
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        if (farmingStages[allotmentFieldsData.getAllotmentIndex()] != 3 || farmingState[allotmentFieldsData.getAllotmentIndex()] == 5) {
            player.sendMessage("This patch doesn't need compost.");
            return true;
        }
        player.deleteItem(itemId, 1);
        player.addItem(1925, 1);

        player.sendMessage("You pour some " + (itemId == 6034 ? "super" : "") + "compost on the patch.");
        player.startAnimation(FarmingConstants.PUTTING_COMPOST);
        player.updateRequired = true;
        player.appearanceUpdateRequired = true;
        //player.getSkill().addExp(Skill.FARMING, itemId == 6034 ? Compost.SUPER_COMPOST_EXP_USE : Compost.COMPOST_EXP_USE);

        //player.setStopPacket(true);
        EventManager.getSingleton().addEvent(player,new Event() {

            public void execute(EventContainer container) {
                diseaseChance[allotmentFieldsData.getAllotmentIndex()] *= itemId == 6032 ? COMPOST_CHANCE : SUPERCOMPOST_CHANCE;
                farmingState[allotmentFieldsData.getAllotmentIndex()] = 5;
                container.stop();
            }

            @Override
            public void stop() {
                //player.setStopPacket(false);
                player.resetAnimation();
            }
        }, AnimationLength.getFrameLength(FarmingConstants.PUTTING_COMPOST)*600);
        return true;
    }

    /* inspecting a plant */

    public boolean inspect(int objectX, int objectY) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null) {
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        final InspectData inspectData = InspectData.forId(farmingSeeds[allotmentFieldsData.getAllotmentIndex()]);
        final AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[allotmentFieldsData.getAllotmentIndex()]);
        if (farmingState[allotmentFieldsData.getAllotmentIndex()] == 2) {
            player.sendMessage("This plant is diseased. Use a plant cure on it to cure it, or clear the patch with a spade.");
            return true;
        } else if (farmingState[allotmentFieldsData.getAllotmentIndex()] == 3) {
            player.sendMessage("This plant is dead. You did not cure it while it was diseased.Clear the patch with a spade.");
            return true;
        }
        if (farmingStages[allotmentFieldsData.getAllotmentIndex()] == 0) {
            player.sendMessage("This is an allotment patch. The soil has not been treated. The patch needs weeding.");
        } else if (farmingStages[allotmentFieldsData.getAllotmentIndex()] == 3) {
            player.sendMessage("This is an allotment patch. The soil has not been treated. The patch is empty and weeded.");
        } else if (inspectData != null && allotmentData != null) {
            player.sendMessage("You bend down and start to inspect the patch...");

            player.startAnimation(1331);
            player.updateRequired = true;
            player.appearanceUpdateRequired = true;
            //player.setStopPacket(true);
            EventManager.getSingleton().addEvent(player,new Event() {

                        public void execute(EventContainer container) {
                            if (farmingStages[allotmentFieldsData.getAllotmentIndex()] - 4 < inspectData.getMessages().length - 2) {
                                //player.getDialogue().sendStatement(inspectData.getMessages()[farmingStages[allotmentFieldsData.getAllotmentIndex()] - 4]);
                            } else if (farmingStages[allotmentFieldsData.getAllotmentIndex()] < allotmentData.getEndingState() - allotmentData.getStartingState() + 2) {
                                //player.getDialogue().sendStatement(inspectData.getMessages()[inspectData.getMessages().length - 2]);
                            } else {
                                // player.getDialogue().sendStatement(inspectData.getMessages()[inspectData.getMessages().length - 1]);
                            }
                            container.stop();
                        }

                        @Override
                        public void stop() {
                            player.startAnimation(1332);
                            //player.setStopPacket(false);
                            // player.reset();
                        }
                    },
                    5 * 600);
        }
        return true;
    }

    /* opening the corresponding guide about the patch */

    public boolean guide(int objectX, int objectY) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null) {
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        //player.getSkillGuide().farmingComplex(1);
       // player.getSkillGuide().selected = 20;
        return true;
    }

    /* protects the patch with the flowers */

    public void handleFlowerProtection(int index) {
        AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[index]);
        if (allotmentData == null) {
            return;
        }
        double chance = diseaseChance[index] * allotmentData.getDiseaseChance();
        @SuppressWarnings("unused")
        int maxChance = (int) chance * 100;
        int indexGiven = 0;
        if (!farmingWatched[index]) {// Misc.random(100) <= maxChance) {
            switch (index) {
                case 0 :
                case 1 :
                    indexGiven = 3;
                    break;
                case 2 :
                case 3 :
                    indexGiven = 2;
                    break;
                case 4 :
                case 5 :
                    indexGiven = 1;
                    break;
                case 6 :
                case 7 :
                    indexGiven = 0;
                    break;

            }
            /*if (player.getFlowers().farmingSeeds[indexGiven] >= 0x21 && player.getFlowers().farmingSeeds[indexGiven] <= 0x24) {
                if (allotmentData.getFlowerProtect() == Flowers.SCARECROW) {
                    return;
                }
            }
            if (player.getFlowers().farmingState[indexGiven] != 3 && player.getFlowers().hasFullyGrown[indexGiven] && player.getFlowers().farmingSeeds[indexGiven] == allotmentData.getFlowerProtect()) {
                player.getFlowers().farmingState[indexGiven] = 3;
                player.getFlowers().updateFlowerStates();
            } else {
                farmingState[index] = 2;
            }*/
        }

    }

    /* Curing the plant */

    public boolean curePlant(int objectX, int objectY, int itemId) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null || itemId != 6036) {
            return false;
        }
        final AllotmentData allotmentData = AllotmentData.forId(farmingSeeds[allotmentFieldsData.getAllotmentIndex()]);
        if (allotmentData == null) {
            return false;
        }
        if (!Config.FARMING_ENABLED) {
            player.sendMessage("This skill is currently disabled.");
            return true;
        }
        if (farmingState[allotmentFieldsData.getAllotmentIndex()] != 2) {
            player.sendMessage("This plant doesn't need to be cured.");
            return true;
        }
        player.deleteItem(itemId, 1);
        player.addItem(229, 1);
        player.startAnimation(FarmingConstants.CURING_ANIM);
        player.updateRequired = true;
        player.appearanceUpdateRequired = true;
        //player.setStopPacket(true);
        farmingState[allotmentFieldsData.getAllotmentIndex()] = 0;
        EventManager.getSingleton().addEvent(player,new Event() {

            public void execute(EventContainer container) {
                player.sendMessage("You cure the plant with a plant cure.");
                container.stop();
            }

            @Override
            public void stop() {
                updateAllotmentsStates();
                //player.setStopPacket(false);
                player.resetAnimation();
            }
        }, 7 * 600);

        return true;

    }

    @SuppressWarnings("unused")
    private void resetAllotments() {
        for (int i = 0; i < farmingStages.length; i++) {
            farmingSeeds[i] = 0;
            farmingState[i] = 0;
            diseaseChance[i] = 0;
            farmingHarvest[i] = 0;
        }
    }

    /* reseting the patches */

    private void resetAllotments(int index) {
        farmingSeeds[index] = 0;
        farmingState[index] = 0;
        diseaseChance[index] = 1;
        farmingHarvest[index] = 0;
        farmingWatched[index] = false;
        hasFullyGrown[index] = false;
    }

    /* checking if the patch is raked */

    public boolean checkIfRaked(int objectX, int objectY) {
        final AllotmentFieldsData allotmentFieldsData = AllotmentFieldsData.forIdPosition(new Position(objectX, objectY));
        if (allotmentFieldsData == null)
            return false;
        if (farmingStages[allotmentFieldsData.getAllotmentIndex()] == 3)
            return true;
        return false;
    }

    public int[] getFarmingStages() {
        return farmingStages;
    }

    public void setFarmingStages(int i, int allotmentStages) {
        this.farmingStages[i] = allotmentStages;
    }

    public int[] getFarmingSeeds() {
        return farmingSeeds;
    }

    public void setFarmingSeeds(int i, int allotmentSeeds) {
        this.farmingSeeds[i] = allotmentSeeds;
    }

    public int[] getFarmingHarvest() {
        return farmingHarvest;
    }

    public void setFarmingHarvest(int i, int allotmentHarvest) {
        this.farmingHarvest[i] = allotmentHarvest;
    }

    public int[] getFarmingState() {
        return farmingState;
    }

    public void setFarmingState(int i, int allotmentState) {
        this.farmingState[i] = allotmentState;
    }

    public long[] getFarmingTimer() {
        return farmingTimer;
    }

    public void setFarmingTimer(int i, long allotmentTimer) {
        this.farmingTimer[i] = allotmentTimer;
    }

    public double[] getDiseaseChance() {
        return diseaseChance;
    }

    public void setDiseaseChance(int i, double diseaseChance) {
        this.diseaseChance[i] = diseaseChance;
    }

    public boolean[] getFarmingWatched() {
        return farmingWatched;
    }

    public void setFarmingWatched(int i, boolean allotmentWatched) {
        this.farmingWatched[i] = allotmentWatched;
    }

}

