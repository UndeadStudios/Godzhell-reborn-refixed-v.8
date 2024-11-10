class Mining {

    private static final int MINIMUM_EXTRACTION_TIME = 2;

    /**
     * The player that this {@link Mining} object is created for
     */
    private final client player;

    /**
     * Constructs a new mining class for a singular player
     * @param player	the player this class is being created for
     */
    public Mining(client player) {
        this.player = player;
    }

    /**
     * This function allows a singular player to start mining if possible
     * @param objectId	the object the player is trying to mine from
     * @param location	the location of the object
     */
    public void mine(int objectId, Location3D location) {
        Mineral mineral = Mineral.forObjectId(objectId);
        if (mineral == null) {
            return;
        }
        if (player.playerLevel[Skill.MINING.id] < mineral.getLevel()) {
            player.sendMessage("You need a mining level of " + mineral.getLevel() + " to mine this.");
            return;
        }
        if (server.getGlobalObjects().exists(mineral.getDepleteObject(), location.getX(), location.getY(), location.getZ())) {
            player.sendMessage("This vein contains no more minerals.");

            return;
        }
        Pickaxe pickaxe = Pickaxe.getBestPickaxe(player);
        if (pickaxe == null) {
            player.sendMessage("You need a pickaxe to mine this vein.");
            return;
        }
        if (player.freeSlots() == 0) {
            player.sendMessage("You have no more free slots.");
            return;
        }
        int levelReduction = (int) Math.floor(player.playerLevel[Skill.MINING.id] / 10);
        int pickaxeReduction = pickaxe.getExtractionReduction();
        int extractionTime = mineral.getExtractionRate() - (levelReduction + pickaxeReduction);
        if (extractionTime < MINIMUM_EXTRACTION_TIME) {
            extractionTime = MINIMUM_EXTRACTION_TIME;
        }
        player.sendMessage("You swing your pickaxe at the rock.");
        player.setAnimation(pickaxe.getAnimation());
        player.sendSound(soundList.MINING_ORE, 100, 0);
        player.face(location.getX(), location.getY());
        player.getSkilling().add(new MiningEvent(player, objectId, location, mineral, pickaxe), extractionTime+600);
    }

    /**
     * This function allows a singular player to start mining on an npc if possible
     * @param npc		the non playable character we're mining from
     * @param mineral	the mineral we're going to obtain from mining
     * @param location	the location of the npc and or mineral
     */
    public void mine(NPC npc, Mineral mineral, Location3D location) {
        if (npc == null || npc.IsDead) {
            player.sendMessage("This contains no more minerals.");
            return;
        }
        Pickaxe pickaxe = Pickaxe.getBestPickaxe(player);
        if (pickaxe == null) {
            player.sendMessage("You need a pickaxe to mine this vein.");
            return;
        }
        if (player.freeSlots() == 0) {
            player.resetAnimation();
            player.sendMessage("You have no more free slots.");
            return;
        }
        int levelReduction = (int) Math.floor(player.playerLevel[Skill.MINING.id] / 10);
        int pickaxeReduction = pickaxe.getExtractionReduction();
        int extractionTime = mineral.getExtractionRate() - (levelReduction + pickaxeReduction);
        if (extractionTime < MINIMUM_EXTRACTION_TIME) {
            extractionTime = MINIMUM_EXTRACTION_TIME;
        }
        player.sendMessage("You swing your pickaxe at the rock.");
        player.setAnimation(pickaxe.getAnimation());
        player.sendSound(432, 100, 0);
       // player.face(location.getX(), location.getY());
        player.getSkilling().add(new MiningEvent(player, npc, location, mineral, pickaxe), extractionTime);
    }
}