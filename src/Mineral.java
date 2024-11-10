import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * An enumeration of ore vein information.
 *
 * @author Jason MacKeigan
 * @date Feb 18, 2015, 5:14:50 PM
 */
public enum Mineral {
    CLAY(new int[] { 7487, 7454 }, 450,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    CLAY_BIG(new int[] { 15503 }, 11555,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    CLAY_SMALL(new int[] { 15504 }, 11556,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    CLAY_MID(new int[] { 15505 }, 11557,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    CLAY_BIG_2(new int[] { 9711 }, 9723,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    CLAY_SMALL_2(new int[] { 9712 }, 9724,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    CLAY_MID_2(new int[] { 9713 }, 9725,-1,"none", 1, 18, 0, 3, 15, 30000, true, generateExclusive(434)),
    COPPER(new int[] { 2091 }, 450,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_BIG(new int[] { 31080 }, 31059,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_SMALL(new int[] { 31081 }, 31060,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_MID(new int[] { 31082 }, 31061,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),

    COPPER_BIG_2(new int[] { 11960 }, 11555,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_SMALL_2(new int[] { 11961 }, 11556,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_MID_2(new int[] { 11962 }, 11557,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    TIN_BIG_3(new int[] { 11933 }, 11552,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_SMALL_3(new int[] { 11934 }, 11553,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_MID_3(new int[] { 11935 }, 11554,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    COPPER_BIG_3(new int[] { 11936 }, 11552,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_SMALL_3(new int[] { 11937 }, 11553,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_MID_3(new int[] { 11938 }, 11554,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_BIG_4(new int[] { 9708 }, 9723,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_SMALL_4(new int[] { 9709 }, 9724,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    COPPER_MID_4(new int[] { 9710 }, 9725,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(436)),
    TIN_BIG_4(new int[] { 9714 }, 9723,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_SMALL_4(new int[] { 9715 }, 9724,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_MID_4(new int[] { 9716 }, 9725,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),

    TIN(new int[] { 7485 }, 450,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_BIG(new int[] { 31077 }, 31059,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_SMALL(new int[] { 31078 }, 31060,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_MID(new int[] { 31079 }, 31061,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_BIG_2(new int[] { 11957 }, 11555,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_SMALL_2(new int[] { 11958 }, 11556,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    TIN_MID_2(new int[] { 11959 }, 11557,-1,"bronze", 1, 18, 5, 5, 15, 15000, true, generateExclusive(438)),
    IRON(new int[] { 7488 }, 450,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_BIG(new int[] { 31071 }, 31059,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_SMALL(new int[] { 31072 }, 31060,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_MID(new int[] { 31073 }, 31061,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),

    IRON_BIG_2(new int[] { 11954 }, 11555,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_SMALL_2(new int[] { 11955 }, 11556,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_MID_2(new int[] { 11956 }, 11557,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_BIG_3(new int[] { 9717 }, 9723,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_SMALL_3(new int[] { 9718 }, 9724,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),
    IRON_MID_3(new int[] { 9719 }, 9725,-1,"iron", 15, 35, 5, 8, 17, 14800, true, generateExclusive(440)),

    SILVER(new int[] { 7457 },450, -1,"silver", 20, 40, 5, 8, 17, 14800, true, generateExclusive(442)),
    SILVER_BIG(new int[] { 11948 },11555, -1,"silver", 20, 40, 5, 8, 17, 14800, true, generateExclusive(442)),
    SILVER_SMALL(new int[] { 11949 },11556, -1,"silver", 20, 40, 5, 8, 17, 14800, true, generateExclusive(442)),
    SILVER_MID(new int[] { 11950 },11557, -1,"silver", 20, 40, 5, 8, 17, 14800, true, generateExclusive(442)),
    COAL(new int[] { 2096 }, 450,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),
    COAL_BIG(new int[] { 11930}, 11552,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),
    COAL_SMALL(new int[] { 11931}, 11553,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),
    COAL_MID(new int[] { 11932}, 11554,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),
    COAL_BIG2(new int[] { 31068 }, 31059,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),
    COAL_SMALL2(new int[] { 31069}, 31060,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),
    COAL_MID2(new int[] { 31070}, 31061,-1,"none", 30, 50, 3, 15, 29, 14600, true, generateExclusive(453)),

    GOLD(new int[] { 2098 },450, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),
    GOLD_BIG(new int[] { 31065 },31059, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),
    GOLD_SMALL(new int[] { 31066 },31060, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),
    GOLD_MID(new int[] { 31067 },31061, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),
    GOLD_BIG_2(new int[] { 9720 }, 9723, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),
    GOLD_SMALL_2(new int[] { 9721 }, 9724, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),
    GOLD_MID_2(new int[] { 9722 }, 9725, -1,"gold", 40, 65, 3, 25, 32, 14200, true, generateExclusive(444)),


    MITHRIL(new int[] { 7492 }, 450, -1,"mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),
    MITHRIL_BIG(new int[] { 11942 }, 11552, 11927, "mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),
    MITHRIL_SMALL(new int[] { 11943 }, 11553, 11928,"mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),
    MITHRIL_MID(new int[] { 11944 }, 11554, 11929,"mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),
    MITHRIL_BIG2(new int[] { 31086 }, 31059, 11927, "mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),
    MITHRIL_SMALL2(new int[] { 31087 }, 31060, 11928,"mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),
    MITHRIL_MID2(new int[] { 31088 }, 31061, 11929,"mithril", 55, 80, 3, 40, 35, 13800, true, generateExclusive(447)),

    ADAMANT(new int[] { 7493 }, 450, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),
    ADAMANT_BIG(new int[] { 11939 }, 11552, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),
    ADAMANT_SMALL(new int[] { 11940 }, 11553, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),
    ADAMANT_MID(new int[] { 11941 }, 11554, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),
    ADAMANT_BIG2(new int[] { 31083 }, 31059, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),
    ADAMANT_SMALL2(new int[] { 31084 }, 31060, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),
    ADAMANT_MID2(new int[] { 31085 }, 31061, -1,"adamant", 70, 95, 2, 50, 37, 13200, true, generateExclusive(449)),

    RUNE(new int[] { 2106 },450,  -1,"rune", 85, 125, 0, 100, 39, 12500, true, generateExclusive(451)),
    ESSENCE(new int[] { 7471, 14912 }, 450, -1,"none", 1, 5, -1, -1, 5, 15000, false, generateExclusive(-1)),
    GEM(new int[] { 9030, 7464 }, 450, -1,"none", 40, 60, 20, 25, 20, 15000, true, new MineralReturn() {

        @Override
        public int generate() {
            int[] inclusives = inclusives();
            int percent = RandomUtils.nextInt(0, 100);

            return percent < 50 ? misc.randomSearch(inclusives, 0, 2) :
                    percent >= 50 && percent < 80 ? inclusives[2] :
                            percent >= 80 && percent < 98 ? misc.randomSearch(inclusives, 3, 5) :
                                    inclusives[inclusives.length - 1];
        }

        @Override
        public int[] inclusives() {
            return new int[] { 1625, 1627, 1623, 1621, 1619, 1617 };
        }

    });

    /**
     * An array of object ids that are associated with the mineral obtained from them
     */
    private final int[] objectIds;

    /**
     * A string of the bar name being created
     */
    private final String barName;

    /**
     * The level required to mine this ore
     */
    private final int level;

    /**
     * The experience gained from mining this mineral
     */
    private final double experience;

    /**
     * The probability that the mineral will deplete
     */
    private final int depletionProbability;

    /**
     * The amount of cycles that need to pass before the mineral is extractable
     */
    private final int respawnRate;

    /**
     * The default amount of cycles it takes to extract ore from a vein
     */
    private final int extractionRate;

    /**
     * The default amount of chance to receive a pet from mining
     */
    private final int petChance;

    /**
     * Determines if this mineral depletes
     */
    private final boolean depletes;

    private final int depleteObject;

    public final int bobleObject;

    /**
     * The mineral that is returned to the player as a result of mining the ore
     */
    private final MineralReturn mineralReturn;

    /**
     * Constructs a new mineral
     *
     * @param objectIds the objects that the mineral can be extracted from
     * @param level the level required to extract minerals from the object(s)
     * @param experience the experience gain after extraction
     * @param depletionProbability the probability in terms of a 1: {@link #depletionProbability} ratio.
     * @param respawnRate the rate at which the mineral respawn's to the world
     * @param extractionRate the rate at which the mineral is extracted
     * @param depletes determine if the mineral depletes in the world
     * @param mineralReturn the mineral that is returned to the player as a result of mining the resource
     */
    private Mineral(int[] objectIds, int depleteObject, int bobleObject, String barName, int level, double experience, int depletionProbability, int respawnRate, int extractionRate, int petChance, boolean depletes, MineralReturn mineralReturn) {
        this.objectIds = objectIds;
        this.depleteObject = depleteObject;
        this.bobleObject = bobleObject;
        this.barName = barName;
        this.level = level;
        this.experience = experience;
        this.depletionProbability = depletionProbability;
        this.respawnRate = respawnRate;
        this.extractionRate = extractionRate;
        this.petChance = petChance;
        this.depletes = depletes;
        this.mineralReturn = mineralReturn;
    }

    /**
     * The array of objectId values associated with this mineral
     *
     * @return the array of object id's
     */
    public int[] getObjectIds() {
        return objectIds;
    }

    public String getBarName() {
        return barName;
    }

    /**
     * The level required to extract minerals
     *
     * @return the level required
     */
    public int getLevel() {
        return level;
    }

    /**
     * The experience gained from extracting a mineral
     *
     * @return the experience gained
     */
    public double getExperience() {
        return experience;
    }

    /**
     * The rate, in cycles, the mineral respawns at
     *
     * @return the rate at which the mineral respawns
     */
    public int getRespawnRate() {
        return respawnRate;
    }
    public int getDepleteObject() {
        return depleteObject;
    }

    public int getBobleObject() {
        return bobleObject;
    }
    /**
     * Every mineral has a difference rate at which they deplete. Some minerals faster then others, and some minerals instantly after being extracted from.
     *
     * @return the probability of depletion. When the probability is 0 the chance of depletion is 1:1.
     */
    public int getDepletionProbability() {
        return depletionProbability;
    }

    /**
     * The default amount of cycles it takes for a single ore to be extracted
     *
     * @return the default extraction rate
     */
    public int getExtractionRate() {
        return extractionRate;
    }

    /**
     * The default amount of chance to receive a pet while mining
     *
     * @return the default pet rate
     */
    public int getPetChance() {
        return petChance;
    }

    /**
     * Determines if the mineral depletes or not
     *
     * @return true if object depletes
     */
    public boolean isDepletable() {
        return depletes;
    }

    /**
     * Accesses the {@link MineralReturn} instance's {@link MineralReturn#generate()} function.
     *
     * @return An {@link Integer} value as the result of mining the mineral
     */
    public MineralReturn getMineralReturn() {
        return mineralReturn;
    }

    /**
     * The identification value of the object with no mineral remaining after extraction
     */
    public static final int EMPTY_VEIN = 450;

    /**
     * An unmodifiable set of {@link Mineral} objects that will be used as a constant for obtaining information about certain minerals.
     */
    private static final Set<Mineral> MINERALS = Collections.unmodifiableSet(EnumSet.allOf(Mineral.class));

    /**
     * Retrieves the {@link Mineral} object with the same objectId as the parameter passed.
     *
     * @param objectId the object id of the mineral
     * @return the mineral object with the corresponding object id
     */
    public static Mineral forObjectId(int objectId) {
        return MINERALS.stream().filter(mineral -> Arrays.stream(mineral.objectIds).anyMatch(id -> id == objectId)).findFirst().orElse(null);
    }

    /**
     * Creates a {@link MineralReturn} object that always generates the same item.
     *
     * @param id the item identification value
     * @return an object that only returns the id specified
     */
    private static MineralReturn generateExclusive(int id) {
        return new MineralReturn() {

            @Override
            public int generate() {
                return id;
            }

            @Override
            public int[] inclusives() {
                return new int[] { id };
            }

        };
    }

}
