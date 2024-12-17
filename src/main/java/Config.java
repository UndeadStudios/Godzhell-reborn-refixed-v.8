
public class Config {
	
	public static final int[] CAT_ITEMS 	= 	{1555,1556,1557,1558,1559,1560,1561,1562,1563,1564,1565,7585,7584}; // TO MAKE CATS NOT BE ABLE TO DROP WHEN UR HAVEING ONE SUMMONED

	public static final int FISHING_EXPERIENCE = 40;

	//combat exp
	public static final int EXP_RATE = 100;
	
	public static final int MAX_ITEMS = 29999;
	public static final String VOTE_LINK = "https://ghreborn.everythingrs.com/services/vote";
	public static final String DONATION_LINK = "https://ghreborn.everythingrs.com/services/store";
	public static final boolean FARMING_ENABLED = true;
    public static final boolean DISABLE_DISCORD_MESSAGING = false;
    public static final double MINING_EXPERIENCE = 50;
	public static final double PRAYER_EXPERIENCE = 50;
    public static final int CRAFTING_EXPERIENCE = 50;
	public static final int SLAYER_EXPERIENCE = 50;
	public static final int THIEVING_EXPERIENCE = 50;
	public static boolean ADMIN_DROP_ITEMS = false;
	public static  boolean ADMIN_CAN_SELL_ITEMS = false;
	public static  boolean MINI_GAMES = false;
	public static  boolean LOCK_EXPERIENCE = false;
	public static final boolean DOUBLE_EXP = false;
	public static String LOGOUT_MESSAGE = "";
	public static String DEATH_MESSAGE = "";
	public static String SERVER_NAME = "GodzHell Reborn and remastered";
	public static boolean ADMIN_CAN_TRADE = false;
	public static final int MAX_PLAYERS = 2000;
	public static final int MAX_NPCS = 11256;

	/**
	 * Server's first world - connect's on port 43594
	 */
	public static boolean WORLD_ONE = true;
	
	/**
	 * Server's second world - connect's on port 5555
	 */
	public static boolean WORLD_TWO = false;

	public static boolean bonusXP;
	public static boolean UPDATE_DISCORD_STATUS = true;
	public static int WOODCUTTING_EXPERIENCE = 50;
	public static int SMITHING_EXPERIENCE = 50;
	public static int FLETCHING_EXPERIENCE = 50;
	static int[][] FirstFloorSos = {
			{1865, 5227}, {1865, 5226}, {1868, 5226}, {1868, 5227}, {1867, 5217}, {1867, 5218}, {1870, 5217}, {1870, 5218},
			{1894, 5213}, {1894, 5212}, {1897, 5213}, {1897, 5212}, {1904, 5203}, {1904, 5204}, {1907, 5203}, {1907, 5204},
			{1882, 5188}, {1882, 5189}, {1879, 5189}, {1879, 5188}, {1879, 5240}, {1879, 5239}, {1876, 5240}, {1876, 5239},
			{1884, 5244}, {1884, 5243}, {1887, 5244}, {1887, 5243}, {1889, 5235}, {1889, 5236}, {1886, 5235}, {1886, 5236},
			{1904, 5242}, {1904, 5243}, {1908, 5242}, {1908, 5243}

	};
	static int[][] SecondFloorSos = {
			{2040, 5244}, {2040, 5245}, {2037, 5245}, {2037, 5245}, {2037, 5244}, {2000, 5216}, {2000, 5215}, {1997, 5216},
			{1997, 5215}, {2009, 5215}, {2009, 5216}, {2006, 5215}, {2006, 5216}, {2043, 5223}, {2043, 5222}, {2040, 5222},
			{2040, 5223}, {2037, 5185}, {2037, 5186}, {2034, 5185}, {2034, 5186}, {2016, 5228}, {2016, 5227}, {2019, 5228},
			{2019, 5227}

	};
	static int[][] thirdFloorSos = {
			{2141, 5263}, {2141, 5262}, {2138, 5263}, {2138, 5262}, {2154, 5264}, {2154, 5263}, {2157, 5264}, {2157, 5263},
			{2168, 5271}, {2168, 5272}, {2171, 5272}, {2171, 5271}, {2153, 5291}, {2153, 5292}, {2149, 5291}, {2149, 5292},
			{2127, 5287}, {2127, 5288}, {2124, 5287}, {2124, 5288}, {2138, 5294}, {2138, 5295}, {2141, 5294}, {2141, 5295}

	};
	static int[][] fourthFloorsos = {
			{2336, 5237}, {2336, 5238}, {2333, 5237}, {2333, 5238}, {2363, 5193}, {2363, 5194}, {2360, 5194}, {2362, 5189},
			{2362, 5188}, {2359, 5189}, {2359, 5188}, {2347, 5187}, {2347, 5188}, {2344, 5188}, {2344, 5187}, {2336, 5194},
			{2336, 5193}, {2333, 5194}, {2333, 5193}, {2312, 5205}, {2312, 5204}, {2309, 5205}, {2309, 5204}, {2356, 5245},
			{2356, 5246}, {2353, 5245}, {2353, 5246}, {2311, 5225}, {2311, 5224}, {2308, 5225}, {2308, 5224}, {2336, 5227},
			{2336, 5226}, {2333, 5227}, {2333, 5226}, {2311, 5225}, {2311, 5224}, {2308, 5225}, {2308, 5224}
	};
}
