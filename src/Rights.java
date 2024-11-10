import java.util.Arrays;

/**
 * The rights of a player determines their authority. Every right can be viewed
 * with a name and a value. The value is used to separate each right from one another.
 *
 * @author Jason
 * @date January 22, 2015, 5:23:49 PM
 */
public enum Rights {
    PLAYER(0),
    MODERATOR(1, PLAYER),
    ADMINISTRATOR(2, MODERATOR),
    OWNER(9, ADMINISTRATOR, MODERATOR),
    Co_OWNER(10,OWNER, ADMINISTRATOR, MODERATOR),
    //UNKNOWN(4),
    DONATOR(3, PLAYER), //  contributor
    SUPER_DONATOR(7), // sponsor
    RESPECTED_DONATOR(8), // supporter
    LEGENDARY_DONATOR(21), //vip
    RAINBOW_DONATOR(22),
    DEVELOPER(4),
    YOUTUBER(10),
    HELPER(11),
    IRONMAN(23),
    ULTIMATE_IRONMAN(24),
    HARDCORE_IRONMAN(25),
    STREAMER(13),
    HIDDEN(15, ADMINISTRATOR, MODERATOR);

    /**
     * The level of rights that define this
     */
    private final int right;

    /**
     * The right or rights inherited by this right
     */
    private final Rights[] inherited;

    /**
     * Creates a new right with a value to differentiate it between the others
     * @param right			the right required
     * @param inherited		the right or rights inherited with this level of right
     */
    private Rights(int right, Rights... inherited) {
        this.right = right;
        this.inherited = inherited;
    }

    /**
     * The rights of this enumeration
     * @return	the rights
     */
    public int getValue() {
        return right;
    }

    /**
     * Determines if this level of rights inherited another level of rights
     * @param rights	the level of rights we're looking to determine is inherited
     * @return			{@code true} if the rights are inherited, otherwise {@code false}
     */
    public boolean inherits(Rights rights) {
        return equals(rights) || Arrays.asList(inherited).contains(rights);
    }

    /**
     * Determines if the player has rights equal to that of {@linkplain PLAYER}.
     * @return	true if they are of type player
     */
    public boolean isPlayer() {
        return equals(PLAYER);
    }

    /**
     * Determines if the players rights equal that of {@linkplain MODERATOR}
     * @return	true if they are of type moderator
     */
    public boolean isModerator() {
        return equals(MODERATOR);
    }

    /**
     * Determines if the players rights equal that of {@linkplain ADMINISTRATOR}
     * @return	true if they are of type administrator
     */
    public boolean isAdministrator() {
        return equals(ADMINISTRATOR);
    }

    /**
     * Determines if the players rights equal that of {@linkplain OWNER}
     * @return	true if they are of type owner
     */
    public boolean isOwner() {
        return equals(OWNER);
    }
    public boolean isCoOwner() {
        return equals(Co_OWNER);
    }

    public boolean isHidden() {
        return equals(HIDDEN);
    }
    /**
     * Determines if the players rights equal that of {@linkplain OWNER}
     * @return	true if they are of type owner
     */
    public boolean isDeveloper() {
        return equals(DEVELOPER);
    }

    /**
     * Determines if the players rights equal that of {@linkplain CONTRIBUTOR}
     * @return	true if they are of type contributor
     */
    public boolean isContributor() {
        return equals(DONATOR);
    }

    /**
     * Determines if the players rights equal that of {@linkplain SPONSOR}
     * @return	true if they are of type sponsor
     */
    public boolean isSuperDonater() {
        return equals(SUPER_DONATOR);
    }

    /**
     * Determines if the players rights equal that of {@linkplain SUPPORTER}
     * @return	true if they are of type supporter
     */
    public boolean isExtremeDonator() {
        return equals(RESPECTED_DONATOR);
    }

    /**
     * Determines if the players rights equal that of {@linkplain V_I_P}
     * @return	true if they are of type v.i.p
     */
    public boolean isVIP() {
        return equals(LEGENDARY_DONATOR);
    }
    public boolean isRainbow() {
        return equals(RAINBOW_DONATOR);
    }

    /**
     * Determines if the players rights equal that of {@linkplain SUPER_V_I_P}
     * @return	true if they are of type super v.i.p
     */
    public boolean isYoutuber() {
        return equals(YOUTUBER);
    }


    /**
     * Determines if the players rights equal that of {@linkplain HELPER}
     * @return	true if they are of type helper
     */
    public boolean isHelper() {
        return equals(HELPER);
    }
    /**
     *
     * @return true if they are of type ironman
     */
    public boolean isIronman() {
        return equals(IRONMAN);
    }
    /**
     *
     * @return true if they are Ultimate Ironman
     */
    public boolean isUltimateIronman() {
        return equals(ULTIMATE_IRONMAN);
    }
    /**
     *
     * @return true if they are Hardcore Ironman
     */
    public boolean isHardcoreIronman() {
        return equals(HARDCORE_IRONMAN);
    }
    /**
     * Determines if the players rights equal that of {@linkplain STREAMER}
     * @return	true if they are of type Streamer
     */
    public boolean isStreamer() {
        return equals(STREAMER);
    }

    /**
     * Determines if the players rights equal that of {@link CONTRIBUTOR},
     * {@link SPONSOR}, {@link SUPPORTER}, {@link V_I_P}, and {@link SUPER_V_I_P}
     * @return	true if they are any of the predefined types
     */
    public boolean isDonator() {
        return isContributor() || isSuperDonater() || isExtremeDonator() || isVIP() || isRainbow();
    }

    /**
     * Determines if the players right equal that of {@link MODERATOR}, {@link ADMINISTRATOR},
     * and {@link OWNER}
     * @return	true if they are any of the predefined types
     */
    public boolean isStaff() {
        return  isHelper() || isModerator() ||isAdministrator() || isOwner() || isCoOwner() || isDeveloper() ;
    }

    /**
     * Determines if the players rights are in-between two values.
     * @param start	the lowest range
     * @param end	the highest range
     * @return		true if the rights are greater than the start and lower
     * than the end value.
     */
    public boolean isBetween(int start, int end) {
        if (start < 0 || end < 0 || start > end || start == end) {
            throw new IllegalStateException();
        }
        return right >= start && right <= end;
    }

    /**
     * Returns a {@link Rights} object for the value.
     * @param value	the right level
     * @return	the rights object
     */
    public static Rights get(int value) {
        return Arrays.asList(values()).stream().filter(element -> element.right == value).findFirst().orElse(PLAYER);
    }

    @Override
    public String toString() {
        return misc.capitalize(name().toLowerCase());
    }
}
