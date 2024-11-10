public enum Tree {
    NORMAL(new int[]{1276, 1278, 1279}, 1342, 1511, 1, 5, 20, 25, 15, 12000),
    EVERGREEN(new int[]{1315}, 1342, 1511, 1, 5, 20, 25, 15, 12000),
    OAK(new int[]{1281}, 1356, 1521, 15, 8, 50, 38, 25, 11500),
    WILLOW(new int[]{ObjectIDs.WILLOW}, 7399, 1519, 30, 10, 60, 68, 35, 11000),
    WILLOW_2(new int[]{ObjectIDs.WILLOW_2, ObjectIDs.WILLOW_3, ObjectIDs.WILLOW_4, ObjectIDs.WILLOW_5}, 5554, 1519, 30, 10, 60, 68, 35, 11000),
    TEAK(new int[]{ObjectIDs.TEAK}, 1356, 6333, 35, 10, 65, 68, 35, 10500),
    MAPLE(new int[]{ObjectIDs.MAPLE_TREE, ObjectIDs.MAPLE_TREE_2}, 7400, 1517, 45, 13, 75, 100, 45, 10000),
    ARCTIC_PINE(new int[]{ObjectIDs.ARCTIC_PINE}, 1356, 10810, 54, 14, 85, 100, 50, 90400),
    YEW(new int[]{ObjectIDs.YEW}, 7402, 1515, 60, 15, 100, 175, 60, 9000),
    MAGIC(new int[]{ObjectIDs.MAGIC_TREE}, 7401, 1513, 75, 20, 125, 250, 75, 8600);

    private int[] treeIds;
    private int stumpId, wood, levelRequired, chopsRequired, deprecationChance, respawn, petChance;
    private double experience;

    private Tree (int[] treeIds, int stumpId, int wood, int levelRequired, int chopsRequired, int deprecationChance, double experience, int respawn, int petChance) {
        this.treeIds = treeIds;
        this.stumpId = stumpId;
        this.wood = wood;
        this.levelRequired = levelRequired;
        this.experience = experience;
        this.deprecationChance = deprecationChance;
        this.chopsRequired = chopsRequired;
        this.respawn = respawn;
        this.petChance = petChance;
    }

    public int[] getTreeIds () {
        return treeIds;
    }

    public int getStumpId () {
        return stumpId;
    }

    public int getWood () {
        return wood;
    }

    public int getLevelRequired () {
        return levelRequired;
    }

    public int getChopsRequired () {
        return chopsRequired;
    }

    public int getChopdownChance () {
        return deprecationChance;
    }

    public double getExperience () {
        return experience;
    }

    public int getRespawnTime () {
        return respawn;
    }

    public int getPetChance () {
        return petChance;
    }

    public static Tree forObject (int objectId) {
        for (Tree tree : values()) {
            for (int treeId : tree.treeIds) {
                if (treeId == objectId) {
                    return tree;
                }
            }
        }
        return null;
    }
}