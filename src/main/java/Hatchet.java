public enum Hatchet {
    BRONZE(1351, 1, 879, 1.0),
    IRON(1349, 1, 877, 1.0),
    STEEL(1353, 6, 875, .9),
    BLACK(1361, 6, 873, .9),
    MITHRIL(1355, 21, 871, .80),
    ADAMANT(1357, 31, 869, .65),
    RUNE(1359, 41, 867, .55),
    DRAGON(6739, 61, 2846, .45),
    INFERNAL(13241, 61, 2117, .45),
    THIRD(20011, 61, 7264, .45);

    private int itemId, levelRequired, animation;
    private double chopSpeed;

    /**
     * Constructs a new {@link Hatchet} used to cut down trees.
     * @param itemId			the item identification value of the hatchet
     * @param levelRequired		the level required for use
     * @param animation			the animation displayed during use
     * @param chopSpeed			the effectiveness of the hatchet when determining a log has been cut
     */
    private Hatchet(int itemId, int levelRequired, int animation, double chopSpeed) {
        this.itemId = itemId;
        this.levelRequired = levelRequired;
        this.animation = animation;
        this.chopSpeed = chopSpeed;
    }

    /**
     * The item id associated with the hatchet.
     * @return	the item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * The level required to operate the hatchet whether its in your inventory or
     * in your equipment.
     * @return	the level required for operation
     */
    public int getLevelRequired() {
        return levelRequired;
    }

    /**
     * The animation displayed when the hatchet is being operated
     * @return	the hatchet animation
     */
    public int getAnimation() {
        return animation;
    }

    /**
     * The speed at which this axe effects log cut time
     * @return	the chop speed of the hatchet
     */
    public double getChopSpeed() {
        return chopSpeed;
    }

    /**
     * Determines the best hatchet the player has in their inventory, or equipment.
     * @param player	the player we're trying to find the best axe for
     * @return			null if the player doesn't have a hatchet they can operate, otherwise
     * the best hatchet on their person.
     */
    public static Hatchet getBest(client player) {
        Hatchet hatchet = null;
        for (Hatchet h : values()){
            if ((player.playerHasItem(h.itemId) || player.isWearingItem(h.itemId))
                    && player.playerLevel[player.playerWoodcutting] >= h.levelRequired) {
                if (hatchet == null) {
                    hatchet = h;
                    continue;
                }
                if (hatchet.levelRequired < h.levelRequired) {
                    hatchet = h;
                }
            }
        }
        return hatchet;
    }
}
