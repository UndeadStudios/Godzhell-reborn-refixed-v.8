import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Player {

	public boolean isWoodcutting;
	public boolean isCrafting = false;
	public boolean smeltInterface = false;
	public int smeltType; // 1 = bronze, 2 = iron, 3 = steel, 4 = gold, 5 =
	// mith, 6 = addy, 7 = rune
	public int smeltAmount;
	public int smeltTimer = 0;
	public boolean walkingToItem;
	public boolean playerIsfFetching = false;
	public boolean[] playerSkilling = new boolean[25];
	public int[][] playerSkillProp = new int[20][15];
	public int fletchingType;
	public long newactionTimer;
	public long climbDelay;
	public boolean showedFire;
	public boolean showedUnfire;
	public boolean isPotCrafting;
	public boolean isSpinning;
	public boolean clickedSpinning;
	public boolean hasfirstfloorDone;
	public boolean hassecoundfloorDone;
	public boolean hasthirdfloorDone;
	public boolean hasfourthfloorDone;
	public int leatherType;
	public long buryDelay;
	public Clan clan;
	public long buySlayerTimer;
	public boolean isMoving;
	private boolean hitUpdateRequired2;
	boolean stopPlayerSkill = false;
	int runEnergy = 100,  talkingNpc = -1;
	public int[] woodcut = new int[3];
	public int wcTimer = 0;
	public boolean isSmething = false;
	public int pItemX, pItemY, pItemId;
	public int doAmount;
	public int headIconPk = -1;
	public int skullTimer;

	public void println_debug(String str)
	{
		System.out.println("[player-"+playerId+"]: "+str);
	}
	public void println(String str)
	{
		System.out.println("[player-"+playerId+"]: "+str);
	}
	public int playerIsVisible = 1; // Gnarly: Player is visible, 1 = true, 0 = false.
	public boolean goodDistance(int objectX, int objectY, int playerX,
								int playerY, int distance) {
		for (int i = 0; i <= distance; i++) {
			for (int j = 0; j <= distance; j++) {
				if ((objectX + i) == playerX
						&& ((objectY + j) == playerY
						|| (objectY - j) == playerY || objectY == playerY)) {
					return true;
				} else if ((objectX - i) == playerX
						&& ((objectY + j) == playerY
						|| (objectY - j) == playerY || objectY == playerY)) {
					return true;
				} else if (objectX == playerX
						&& ((objectY + j) == playerY
						|| (objectY - j) == playerY || objectY == playerY)) {
					return true;
				}
			}
		}
		return false;
	}
	public Rights rights = Rights.PLAYER;
	public boolean maxed = false;

	public void isMaxed(){
		if(getLevelForXP(playerXP[0]) > 98 && getLevelForXP(playerXP[1]) > 98 && getLevelForXP(playerXP[2]) > 98 && getLevelForXP(playerXP[3]) > 98 && getLevelForXP(playerXP[4]) > 98 && getLevelForXP(playerXP[5]) > 98 && getLevelForXP(playerXP[6]) > 98){
			System.out.println("Player is maxed");
			maxed = true;
		}
	}
	public boolean wearingCape(int cape) {
		int capes[] = {9747, 9748, 9750, 9751,
				9753, 9754, 9756, 9757,
				9759, 9760, 9762, 9763,
				9765, 9766, 9768, 9769,
				9771, 9772, 9774, 9775,
				9777, 9778, 9780, 9781,
				9783, 9784, 9786, 9787,
				9789, 9790, 9792, 9793,
				9795, 9796, 9798, 9799,
				9801, 9802, 9804, 9805,
				9807, 9808, 9810, 9811,
				9813, 15150
		};
		for(int i = 0; i < capes.length; i++) {
			if(capes[i] == cape) {
				return true;
			}
		}
		return false;
	}

	public int skillcapeGfx(int cape) {
		int capeGfx[][] = {
				{9747, 823}, {9748, 823},
				{9750, 828}, {9751, 828},
				{9753, 824}, {9754, 824},
				{9756, 832}, {9757, 832},
				{9759, 829}, {9760, 829},
				{9762, 813}, {9763, 813},
				{9765, 817}, {9766, 817},
				{9768, 833}, {9769, 833},
				{9771, 830}, {9772, 830},
				{9774, 835}, {9775, 835},
				{9777, 826}, {9778, 826},
				{9780, 818}, {9781, 818},
				{9783, 812}, {9784, 812},
				{9786, 827}, {9787, 827},
				{9789, 820}, {9790, 820},
				{9792, 814}, {9793, 814},
				{9795, 815}, {9796, 815},
				{9798, 819}, {9799, 819},
				{9801, 821}, {9802, 821},
				{9804, 831}, {9805, 831},
				{9807, 822}, {9808, 822},
				{9810, 825}, {9811, 825},
				{9813, 816}, {15150, 1515}
		};
		for(int i = 0; i < capeGfx.length; i++) {
			if(capeGfx[i][0] == cape) {
				return capeGfx[i][1];
			}
		}
		return -1;
	}

	public int skillcapeEmote(int cape) {
		int capeEmote[][] = {
				{9747, 4959}, {9748, 4959},
				{9750, 4981}, {9751, 4981},
				{9753, 4961}, {9754, 4961},
				{9756, 4973}, {9757, 4973},
				{9759, 4979}, {9760, 4979},
				{9762, 4939}, {9763, 4939},
				{9765, 4947}, {9766, 4947},
				{9768, 4971}, {9769, 4971},
				{9771, 4977}, {9772, 4977},
				{9774, 4969}, {9775, 4969},
				{9777, 4965}, {9778, 4965},
				{9780, 4949}, {9781, 4949},
				{9783, 4937}, {9784, 4937},
				{9786, 4967}, {9787, 4967},
				{9789, 4953}, {9790, 4953},
				{9792, 4941}, {9793, 4941},
				{9795, 4943}, {9796, 4943},
				{9798, 4951}, {9799, 4951},
				{9801, 4955}, {9802, 4955},
				{9804, 4975}, {9805, 4975},
				{9807, 4957}, {9808, 4957},
				{9810, 4963}, {9811, 4963},
				{9813, 4945}, {15150, 8525}
		};
		for(int i = 0; i < capeEmote.length; i++) {
			if(capeEmote[i][0] == cape) {
				return capeEmote[i][1];
			}
		}
		return -1;
	}

	public boolean newhptype = false;
	public int hptype = 0;
	public boolean poisondmg = false;
	public boolean debugMessages = false;
	public boolean duelRequested;
	public boolean[] duelRule = new boolean[22];
	public boolean instantWalk = false;
	public int loyaltyRank;
	public int duelTimer, duelTeleX, duelTeleY, duelSlot, duelSpaceReq,
			duelOption, duelingWith;
	public int startTz;
	public String displayName = "notset";
	public boolean keep6570;
	public boolean playerIsFishing;
	/* Cannon Variables */
	public boolean settingUpCannon, hasCannon, cannonIsShooting, setUpBase, setUpStand, setUpBarrels, setUpFurnace;
	public int cannonBalls, cannonBaseX, cannonBaseY, cannonBaseH, rotation, cannonID;
	public Objects3 oldCannon;
	/**
	 * Retrieves the rights for this player.
	 *
	 * @return the rights
	 */
	public Rights getRights() {
		return rights;
	}

	/**
	 * Updates the rights for this player by comparing the players current rights to
	 * that of the available rights and assigning the first rank found.
	 */
	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public int specMaxHitIncrease, freezeDelay, freezeTimer = -6, killerId, oldPlayerIndex, lastWeaponUsed, projectileStage, crystalBowArrowCount, playerMagicBook, teleGfx, teleEndAnimation, teleHeight, teleX, teleY, teleEndGfx, rangeItemUsed, killingNpcIndex, oldNpcIndex, fightMode, attackTimer, npcIndex,npcClickIndex, npcType, castingSpellId, oldSpellId, spellId, hitDelay;
	public int[] fishingProp = new int[11];
	public ArrayList<Integer> addPlayerList = new ArrayList<Integer>();
	public int addPlayerSize = 0;
	public int killedJad;
	public int tzhaarTimer;
	public int objRot;
	public int droppedItem = -1;
	public int objectId;
	public int ObjectX;
	public int ObjectY;
	public int followID;
	public String bankPin = "";
	public int attempts = 3;
	public boolean setPin = false;
	public int amDonated;
	public int followID2;
	int playerIndex, testinterfaceId;
	public boolean healers;
	public int TzWave = -1;
	public int WaveDelay = 40;
	public int KilledTz;
	public int rating = 1500, matchId = -1, matchLives = 2, loginReturn = 11,
			deathNum = 0, uid = -1, playerTicks = 100;
	public boolean premium = false, randomed = false;
	public int loginDelay = 1;

	//Mining
	public boolean Mining = false;
	public int MineTimer; //choptimer
	public int RockLevel; //Treelevel
	public int RockId; // TreeID
	public int RockXp; // TreeXp
	public int OreId; // LogId
	public int MinedId; //StumpId
	public int Gone2for; // Gonefor
	public int HowManyOre; //HowManyLogs
	public int RockX; //treex
	public int RockY; //treey
	public int RockFace; //treey
	public int soundTimer = 0;
	public int repeat2ani = 0;
	public int PickAni = 0;

	double secondsPlayed = 0;
	long minutesPlayed = 0;
	long daysPlayed = 0;
	long hoursPlayed = 0;
	public final int gems[] = { 1617, 1619, 1621, 1623, 1625, 1627, 1629, 1631, 6571 };
	public boolean bankPinOn;

	// some remarks: one map region is 8x8
	// a 7-bit (i.e. 128) value thus ranges over 16 such regions
	// the active area of 104x104 is comprised of 13x13 such regions, i.e. from
	// the center region that is 6 regions in each direction (notice the magical 6
	// appearing also in map region arithmetics...)
	public int combat = 0;
	public boolean inMulti() {
		if (Boundary.isIn(this, Boundary.BANDIT_CAMP_BOUNDARY) ||
				Boundary.isIn(this, Boundary.TzHarr_City)) {
			return true;
		}
		if (Boundary.isIn(this, Boundary.Train)) {
			return true;
		}
		if (Boundary.isIn(this, Boundary.CORP)) {
			return true;
		}
		if((absX >= 3136 && absX <= 3327 && absY >= 3519 && absY <= 3607) ||
				(absX >= 3190 && absX <= 3327 && absY >= 2568 && absY <= 3839) ||
				(absX >= 3200 && absX <= 3390 && absY >= 3840 && absY <= 3967) ||
				(absX >= 2992 && absX <= 3007 && absY >= 3912 && absY <= 3967) ||
				(absX >= 2946 && absX <= 2959 && absY >= 3816 && absY <= 3831) ||
				(absX >= 3008 && absX <= 3199 && absY >= 3856 && absY <= 3903) ||
				(absX >= 3008 && absX <= 3071 && absY >= 3600 && absY <= 3711) ||
				(absX >= 3072 && absX <= 3327 && absY >= 3608 && absY <= 2567) ||
				(absX >= 2624 && absX <= 2690 && absY >= 2550 && absY <= 2619) ||
				(absX >= 2371 && absX <= 2422 && absY >= 5062 && absY <= 5117) ||
				(absX >= 2896 && absX <= 2927 && absY >= 3595 && absY <= 3630) ||
				(absX >= 2892 && absX <= 2932 && absY >= 4435 && absY <= 4464) ||
				(absX >= 2256 && absX <= 2287 && absY >= 4680 && absY <= 4711)) {
			return true;
		}
		return false;
	}


	public Player(int _playerId) {
		playerId = _playerId;
		//playerName = "player"+playerId;
		rights = Rights.PLAYER;

		for (int i = 0; i < playerItems.length; i++) { //Setting player items
			playerItems[i] = 0;
		}
		for (int i = 0; i<playerItemsN.length; i++) { //Setting Item amounts
			playerItemsN[i] = 0;
		}

		for (int i=0; i<playerLevel.length; i++) { //Setting Levels
			if (i == 3) {
				playerLevel[i] = 99;
				playerXP[i] = 1155;
			} else {
				playerLevel[i] = 1;
				playerXP[i] = 0;
			}
		}

		for (int i = 0; i< playerBankSize; i++) { //Setting bank items
			bankItems[i] = 0;
		}

		for (int i = 0; i < playerBankSize; i++) { //Setting bank item amounts
			bankItemsN[i] = 0;
		}

		for (int i = 0; i< playerBankSize2; i++) { //Setting bank items
			bankItems2[i] = 0;
		}

		for (int i = 0; i < playerBankSize2; i++) { //Setting bank item amounts
			bankItemsN2[i] = 0;
		}
		for (int i = 0; i < playerEquipment.length; i++) {
			playerEquipment[i] = -1;
			playerEquipmentN[i] = 0;
		}
		//Perhaps by quoting the above out it will stop resetting users before loading, so the user can't be reset,
		//also making the playerName equal the player id it stops it from saving unless a savedgame was loaded...
		//tried, first thing i heard was "lmao i got reset for the 3rd time!"...ffs!

		//Setting Welcomescreen information
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int calc = ((year * 10000) + (month * 100) + day);
		playerLastLogin = calc;
		playerLastConnect = "";
		playerIsMember = 0;
		playerMessages = 0;
		amDonated = 0;

		//Setting player standard look
		playerAppearance[0] = 0;//gender
		playerAppearance[1] = 7;//head
		playerAppearance[2] = 25;//torso
		playerAppearance[3] = 29;//arms
		playerAppearance[4] = 35;//hands
		playerAppearance[5] = 39;//legs
		playerAppearance[6] = 44;//feet
		playerAppearance[7] = 14; //beard
		playerColor[0] = 7; //hair color
		playerColor[1] = 8; //torso color
		playerColor[2] = 9; //legs color
		playerColor[3] = 5; //feet color
		playerColor[4] = 0; //skin color
		/*playerLook[0] = 1;
		playerLook[1] = 5;
		playerLook[2] = 5;
		playerLook[3] = 6;
		playerLook[4] = 5;
		playerLook[5] = 10;*/

		// Giving the player an unique look
		playerEquipment[playerHat]=-1;
		playerEquipment[playerCape]=-1;
		playerEquipment[playerAmulet]=-1;
		playerEquipment[playerChest]=-1;
		playerEquipment[playerShield]=-1;
		playerEquipment[playerLegs]=-1;
		playerEquipment[playerHands]=-1;
		playerEquipment[playerFeet]=-1;
		playerEquipment[playerRing]=-1;
		playerEquipment[playerArrows]=-1;
		playerEquipment[playerWeapon]=-1;

/*
0-9: male head
10-17: male beard
18-25: male torso
26-32: male arms
33-35: male hands
36-41: male legs
42-44: male feet

45-55: fem head
56-60: fem torso
61-66: fem arms
67-69: fem hands
70-78: fem legs
79-81: fem feet
*/

		pHead=1;
		pTorso=18;
		pArms=26;
		pHands=33;
		pLegs=36;
		pFeet=42;
		pBeard=14;
		pBeard=8;

		// the first call to updateThisPlayerMovement() will craft the proper initialization packet
		teleportToX = 2466; // 2461;
		teleportToY = 3188; // 3177;
		// initial x and y coordinates of the player
		heightLevel = 0;

		// client initially doesn't know those values yet
		absX = absY = -1;
		mapRegionX = mapRegionY = -1;
		currentX = currentY = 0;
		resetWalkingQueue();
	}

	public int getMapRegionX() {
		return mapRegionX;
	}

	public int getMapRegionY() {
		return mapRegionY;
	}

	public int getX() {
		return absX;
	}

	public int getY() {
		return absY;
	}

	public int getLocalX() {
		return getX() - 8 * getMapRegionX();
	}

	public int getLocalY() {
		return getY() - 8 * getMapRegionY();
	}
	public boolean WithinDistance(int j, int k, int l, int i1, int j1)
	{
		for(int k1 = 0; k1 <= j1; k1++)
		{
			for(int l1 = 0; l1 <= j1; l1++)
			{
				if(j + k1 == l && (k + l1 == i1 || k - l1 == i1 || k == i1))
				{
					return true;
				}
				if(j - k1 == l && (k + l1 == i1 || k - l1 == i1 || k == i1))
				{
					return true;
				}
				if(j == l && (k + l1 == i1 || k - l1 == i1 || k == i1))
				{
					return true;
				}
			}

		}

		return false;
	}
	void destruct() {
		playerListSize = 0;
		for(int i = 0; i < maxPlayerListSize; i++) playerList[i] = null;
		npcListSize = 0;
		for(int i = 0; i < maxNPCListSize; i++) npcList[i] = null;
		absX = absY = -1;
		mapRegionX = mapRegionY = -1;
		currentX = currentY = 0;
		resetWalkingQueue();
	}
	public int FocusPointX = -1, FocusPointY = -1;
	private void appendSetFocusDestination(stream str) {
		str.writeWordBigEndianA(FocusPointX);
		str.writeWordBigEndian(FocusPointY);
	}
	public void TurnPlayerTo(int pointX, int pointY) {
		FocusPointX = 2*pointX+1;
		FocusPointY = 2*pointY+1;
	}
	public int pkilledinpit;
	public int onPin;
	public int enteredPin;
	public boolean pinChanged;
	public boolean inwildy = false;
	public boolean inwildy2 = false;
	int jailed;
	public int weedTimer = 0;
	public int weedAmount = 0;
	public int oak1Timer = 0;
	public int oak1Amount = 0;
	public int oak2Timer = 0;
	public int oak2Amount = 0;
	public int oak3Timer = 0;
	public int oak3Amount = 0;
	public int oak4Timer = 0;
	public int oak4Amount = 0;
	public int oak5Timer = 0;
	public int oak5Amount = 0;
	public int oakHarvestTimer = 0;
	public int oakHarvestAmount = 0;
	public int emoteTimer = 0;
	public int emoteAmount = 0;
	public int emote2Timer = 0;
	public int emote2Amount = 0;
	public int emote3Timer = 0;
	public int emote3Amount = 0;
	public int emote4Timer = 0;
	public int emote4Amount = 0;
	public static int brocount;
	public boolean isNpc;
	public int npcId;
	public boolean initialized = false, disconnected = false, savefile = true;
	public boolean isActive = false;
	public boolean isKicked = false;
	public boolean inCombat = false;
	public boolean CrackerMsg = false;
	public boolean CrackerForMe = false;
	public boolean IsGhost = false;

	public int actionTimer = 0;
	public int actionAmount = 0;
	public String actionName = "";

	public int theifTimer = 0;
	public int TakeMiscTimer = 0;

	public String connectedFrom = "";
	public String globalMessage = "";

	public static int killcount = 0;
	public int deathcount = 0;
	public int pkpoints = 0;
	public int spawnpoints = 0;
	public String lastKill = "";

	public int AttackingOn = 0;

	public int OptionObject = -1;

	public int ClimbStage = -1;

	public int hiddenPoints; // number of places found ;)
	public int foundz[] = new int[100]; // used for secret places being found ;)

	public int[] clueItems = new int[28];
	public int[] clueItemsN = new int[28];

	public int ActionType = -1;
	public int destinationX = -1;
	public int destinationY = -1;
	public int destinationID = -1;
	public int destinationRange = 1;
	public boolean WalkingTo = false;

	public int TreeHP = 20;
	public int TreeX = 0;
	public int TreeY = 0;
	public int TreeTimer = 0;
	public int logID = 0;
	public int logAmount = 0;
	public int WCxp = 0;
	public int playerAxe = -1;
	public boolean IsWcing = false;

	public boolean[] IsFireShowed = new boolean[server.objectHandler.MaxObjects];
	public boolean[] FireDelete = new boolean[server.objectHandler.MaxObjects];
	public boolean IsFireing = false;
	public boolean IsMakingFire = false;

	public int duelWith = 0;
	public int duelStatus = -1; // 0 = Requesting duel, 1 = in duel screen, 2 = waiting for other player to accept, 3 = in duel, 4 = won
	public int duelChatStage = -1;
	public int duelChatTimer = -1;
	public int duelItems[] = new int[28];
	public int duelItemsN[] = new int[28];
	public int otherDuelItems[] = new int[28];
	public int otherDuelItemsN[] = new int[28];
	public boolean winDuel = false;
	public boolean startDuel = false;
	public final int[] DUEL_RULE_ID = { 1, 2, 16, 32, 64, 128, 256, 512, 1024,
			4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 2097152,
			8388608, 16777216, 67108864, 134217728 };
	public boolean forcedChatUpdateRequired, inDuel, tradeAccepted, goodTrade,
			inTrade, tradeRequested, tradeResetNeeded, tradeConfirmed,
			tradeConfirmed2, canOffer, acceptTrade, acceptedTrade;
	public int tradeRequest = 0;
	public int tradeDecline = 0;
	public int tradeWith = 0;
	public int tradeWaitingTime = 0;
	public int tradeStatus = 0;
	public boolean tradeUpdateOther = false;
	public boolean tradeOtherDeclined = false;
	public int[] playerTItems = new int[28]; //player Trade Items
	public int[] playerTItemsN = new int[28];
	public int[] playerOTItems = new int[28]; //player Other Trade Items
	public int[] playerOTItemsN = new int[28];
	// Quest1 stuff @@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int Guard = 0;
	public boolean Killedqueen = false;
	// end of quest1 stuff @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	public boolean takeAsNote = false;

	public abstract void initialize();

	public abstract void update();

	public int playerId = -1, clanId = -1;		// -1 denotes world is full, otherwise this is the playerId
	// corresponds to the index in Player players[]

	public String playerName = null;			// name of the connecting client
	public String playerPass = null;			// name of the connecting client
	public boolean isRunning2 = false;
	public boolean stoprunning = false;
	public boolean nonWild() {
		return !inSafePvP() && (absX < 2944 || absX > 3392 || absY < 3523 || absY > 3967);
	}

	public boolean inSafePvP() {
		return absX >= 1889 && absX <= 1910 && absY >= 5345 && absY <= 5366 && heightLevel == 2;
	}


	public PlayerHandler handler = null;

	public int maxItemAmount = /*2147000000*/2147000000;
	public String md5pass = "", playerSalt = "";
	public String lastClanChat = "";
	public int[] playerItems = new int[28];
	public int[] playerItemsN = new int[28];

	public int playerBankSize = 352;
	public int[] bankItems = new int[800];
	public int[] bankItemsN = new int[800];
	public boolean bankNotes = false;

	public int playerBankSize2 = 352;
	public int[] bankItems2 = new int[800];
	public int[] bankItemsN2 = new int[800];

	public int playerBankSize3 = 352;
	public int[] bankItems3 = new int[800];
	public int[] bankItemsN3 = new int[800];
	public boolean bankNotes2 = false;

	public boolean checkDisplayName(String name) {
		try {
			File list = new File("./Data/displaynames.txt");
			FileReader read = new FileReader(list);
			BufferedReader reader = new BufferedReader(read);
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.equalsIgnoreCase(name)) {
					return true;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	public void createDisplayName(String name) {
		BufferedWriter names = null;
		try {
			names = new BufferedWriter(new FileWriter("./Data/displaynames.txt", true));
			names.write(name);
			names.newLine();
			names.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (names != null) {
				try {
					names.close();
				} catch (IOException e2) {
				}
			}
		}
	}

	public boolean playerNameExists(String name) {
		try {
			File names = new File("./Data/characters/"+name+".txt");
			if (names.exists()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void setNewWalkCmdX(int newWalkCmdX[]) {
		this.newWalkCmdX = newWalkCmdX;
	}

	public int[] getNewWalkCmdX() {
		return newWalkCmdX;
	}

	public void setNewWalkCmdY(int newWalkCmdY[]) {
		this.newWalkCmdY = newWalkCmdY;
	}

	public int[] getNewWalkCmdY() {
		return newWalkCmdY;
	}
	//Default appearance
	public int pHead;
	public int pTorso;
	public int pArms;
	public int pHands;
	public int pLegs;
	public int pFeet;
	public int turkeydelay = -1;
	public int pBeard;
	public int playerStandIndex = 0x328; // this being the original standing state
	public int  playerTurnIndex = 0x337;
	public int playerTurn180Index = 0x334;
	public int pWalk = 0x333; // original walking animation
	int attackIndex = 422,
			standIndex = 808,
			walkIndex = 819,
			runIndex = 824,
			blockIndex = 424,
			turnIndex = 820,
			turn180Index = 823,
			turn90CWIndex = 822,
			turn90CCWIndex = 821;

	public int headIcon = -1;

	public int[] playerEquipment = new int[14];
	public int[] playerEquipmentN = new int[14];
	private int runningDistanceTravelled;
	public int playerHat = 0;
	public int playerCape = 1;
	public int playerAmulet = 2;
	public static int playerWeapon = 3;
	public int playerChest = 4;
	public int playerShield = 5;
	public int playerLegs = 7;
	public int playerHands = 9;
	public int playerFeet = 10;
	public int playerRing = 12;
	public int playerArrows = 13;

	public int playerAttack = 0;
	public int playerDefence = 1;
	public int playerStrength = 2;
	public int playerHitpoints = 3;
	public int playerRanged = 4;
	public int playerPrayer = 5;
	public int playerMagic = 6;
	public int playerCooking = 7;
	public int playerWoodcutting = 8;
	public int playerFletching = 9;
	public int playerFishing = 10;
	public int playerFiremaking = 11;
	public int playerCrafting = 12;
	public int playerSmithing = 13;
	public static int playerMining = 14;
	public int playerHerblore = 15;
	public int playerAgility = 16;
	public int playerThieving = 17;
	public int playerSlayer = 18;
	public int playerFarming = 19;
	public int playerRunecrafting = 20;

	public int i = 0;

	public int[] playerLevel = new int[25];
	public int[] playerXP = new int[25];
	public int currentHealth = playerLevel[playerHitpoints];
	public int maxHealth = playerLevel[playerHitpoints];

	public int summonLevel = 1;
	public int summonXP = 0;
	public int summonedNPCS = 0;

	// the list of players currently seen by thisPlayer
	// this has to be remembered because the client will build up exactly the same list
	// and will be used on subsequent player movement update packets for efficiency
	public final static int maxPlayerListSize = PlayerHandler.maxPlayers;
	public Player playerList[] = new Player[maxPlayerListSize];
	public int playerListSize = 0;
	// bit at position playerId is set to 1 incase player is currently in playerList
	public byte playerInListBitmap[] = new byte[(PlayerHandler.maxPlayers+7) >> 3];

	// the list of npcs currently seen by thisPlayer
	// this has to be remembered because the client will build up exactly the same list
	// and will be used on subsequent player movement update packets for efficiency
	public final static int maxNPCListSize = NPCHandler.maxNPCs;
	public NPC npcList[] = new NPC[maxNPCListSize];
	public int npcListSize = 0;
	// bit at position npcId is set to 1 incase player is currently in playerList
	public byte npcInListBitmap[] = new byte[(NPCHandler.maxNPCs+7) >> 3];


	// supported within the packet adding new players are coordinates relative to thisPlayer
	// that are >= -16 and <= 15 (i.e. a signed 5-bit number)
	public boolean withinDistance(Player otherPlr) {
		if(heightLevel != otherPlr.heightLevel) return false;
		int deltaX = otherPlr.absX-absX, deltaY = otherPlr.absY-absY;
		return deltaX <= 15 && deltaX >= -16 && deltaY <= 15 && deltaY >= -16;
	}

	public boolean withinDistance(NPC npc) {
		if (heightLevel != npc.heightLevel) return false;
		if (npc.NeedRespawn == true) return false;
		int deltaX = npc.absX-absX, deltaY = npc.absY-absY;
		return deltaX <= 15 && deltaX >= -16 && deltaY <= 15 && deltaY >= -16;
	}


	public int mapRegionX, mapRegionY;		// the map region the player is currently in
	public int absX, absY;					// absolute x/y coordinates
	public int currentX, currentY;			// relative x/y coordinates (to map region)
	// Note that mapRegionX*8+currentX yields absX
	public int heightLevel;		// 0-3 supported by the client

	public boolean updateRequired = true;		// set to true if, in general, updating for this player is required
	// i.e. this should be set to true whenever any of the other
	// XXXUpdateRequired flags are set to true
	// Important: this does NOT include chatTextUpdateRequired!

	// walking related stuff - walking queue etc...
	public static final int walkingQueueSize = 50;
	public int walkingQueueX[] = new int[walkingQueueSize], walkingQueueY[] = new int[walkingQueueSize];
	public int wQueueReadPtr = 0;		// points to slot for reading from queue
	public int wQueueWritePtr = 0;		// points to (first free) slot for writing to the queue
	public boolean runningToggled = true;
	public boolean isSkulled;
	public int teleportToX = -1, teleportToY = -1;	// contain absolute x/y coordinates of destination we want to teleport to



	public void resetWalkingQueue() {
		wQueueReadPtr = wQueueWritePtr = 0;
		// properly initialize this to make the "travel back" algorithm work
		for(int i = 0; i < walkingQueueSize; i++) {
			walkingQueueX[i] = currentX;
			walkingQueueY[i] = currentY;
		}
	}

	public void updateVisiblePlayers()
	{
		for(int i = 0; i < PlayerHandler.maxPlayers; i++)
		{
			if(server.playerHandler.players[i] == null || !server.playerHandler.players[i].isActive || server.playerHandler.players[i] == this)
				continue;

			int id = server.playerHandler.players[i].playerId;

			if ((playerInListBitmap[id >> 3] & (1 << (id & 7))) != 0)
			{
				continue;
			}

			if(!withinDistance(server.playerHandler.players[i])
					|| addPlayerList.contains(id))
			{
				continue;
			}

			addPlayerList.add(id);
			addPlayerSize++;

			server.playerHandler.players[i].addPlayerList.add(playerId);
			server.playerHandler.players[i].addPlayerSize++;
		}
	}

	public void addToWalkingQueue(int x, int y) {
		int next = (wQueueWritePtr+1) % walkingQueueSize;
		if(next == wQueueWritePtr) return;		// walking queue full, silently discard the data
		walkingQueueX[wQueueWritePtr] = x;
		walkingQueueY[wQueueWritePtr] = y;
		wQueueWritePtr = next;
	}

	// returns 0-7 for next walking direction or -1, if we're not moving
	public int getNextWalkingDirection() {
		if(wQueueReadPtr == wQueueWritePtr)
			return -1;

		int dir;

		do {
			dir = misc.direction(currentX, currentY, walkingQueueX[wQueueReadPtr], walkingQueueY[wQueueReadPtr]);
			if(dir == -1)
				wQueueReadPtr = (wQueueReadPtr+1) % walkingQueueSize;
			else if((dir&1) != 0) {
				println_debug("Invalid waypoint in walking queue!");
				resetWalkingQueue();
				return -1;
			}
		} while(dir == -1 && wQueueReadPtr != wQueueWritePtr);
		if(dir == -1)
			return -1;
		dir >>= 1;
		currentX += misc.directionDeltaX[dir];
		currentY += misc.directionDeltaY[dir];
		absX += misc.directionDeltaX[dir];
		absY += misc.directionDeltaY[dir];
		return dir;
	}
	private Position walkingDestination = new Position(absX, absY, heightLevel);
	private Location location;
	private Location lastLocation;

	public void setWalkingDestination(Position walkingDestination) {
		this.walkingDestination = walkingDestination;
	}

	public boolean hasWalkingDestination() {
		return walkingDestination.getX() != absX || walkingDestination.getY() != absY;
	}

	private Runnable walkInteractionTask;

	public void setWalkInteractionTask(Runnable walkInteractionTask) {
		this.walkInteractionTask = walkInteractionTask;
	}

	public void submitWalkInteractionTask() {
		if (walkInteractionTask == null) {
			return;
		}
		walkInteractionTask.run();
		walkInteractionTask = null;
	}

	public Position getWalkingDestination() {
		return walkingDestination;
	}
	public boolean isRunningToggled() {
		return runningToggled;
	}
	// calculates directions of player movement, or the new coordinates when teleporting
	public boolean didTeleport = false;		// set to true if char did teleport in this cycle
	public boolean mapRegionDidChange = false;
	public int walkDirection = -1, runDirection = -1;		// direction char is going in this cycle
	public int poimiX = 0, poimiY = 0;
	public int[] lastTeleport = new int[2];
	public void getNextPlayerMovement() {
		mapRegionDidChange = false;
		didTeleport = false;
		walkDirection = runDirection = -1;
		updateVisiblePlayers(); // so that if you change regions it shows you players already in the area before you get there
		if(teleportToX != -1 && teleportToY != -1) {
			mapRegionDidChange = true;
			if(mapRegionX != -1 && mapRegionY != -1) {
				// check, whether destination is within current map region
				int relX = teleportToX - mapRegionX * 8, relY = teleportToY - mapRegionY * 8;
				if(relX >= 2*8 && relX < 11*8 && relY >= 2*8 && relY < 11*8)
					mapRegionDidChange = false;
			}
			if(mapRegionDidChange) {
				// after map region change the relative coordinates range between 48 - 55
				mapRegionX = (teleportToX>>3)-6;
				mapRegionY = (teleportToY>>3)-6;

				//playerListSize = 0;		// completely rebuild playerList after teleport AND map region change
			}

			currentX = teleportToX - 8*mapRegionX;
			currentY = teleportToY - 8*mapRegionY;
			lastTeleport[0] = currentX;
			lastTeleport[1] = currentY;
			absX = teleportToX;
			absY = teleportToY;
			resetWalkingQueue();
			teleportToX = teleportToY = -1;
			didTeleport = true;
			runningDistanceTravelled = 0;
		} else {
			walkDirection = getNextWalkingDirection();
			if(walkDirection == -1) {
				setWalkingDestination(new Position(absX, absY, heightLevel));
				submitWalkInteractionTask();
				runningDistanceTravelled = 0;
				return;        // standing
			}
			if (isRunningToggled()) {
				runDirection = getNextWalkingDirection();
				runningDistanceTravelled++;
			} else {
				runningDistanceTravelled = 0;
			}

			// check, if we're required to change the map region
			int deltaX = 0, deltaY = 0;
			if(currentX < 2*8) {
				deltaX = 4*8;
				mapRegionX -= 4;
				mapRegionDidChange = true;
			} else if(currentX >= 11*8) {
				deltaX = -4*8;
				mapRegionX += 4;
				mapRegionDidChange = true;
			}
			if(currentY < 2*8) {
				deltaY = 4*8;
				mapRegionY -= 4;
				mapRegionDidChange = true;
			} else if(currentY >= 11*8) {
				deltaY = -4*8;
				mapRegionY += 4;
				mapRegionDidChange = true;
			}

			if(mapRegionDidChange) {
				// have to adjust all relative coordinates
				currentX += deltaX;
				currentY += deltaY;
				for(int i = 0; i < walkingQueueSize; i++) {
					walkingQueueX[i] += deltaX;
					walkingQueueY[i] += deltaY;
				}
			}

		}
	}

	protected boolean faceUpdateRequired = false;
	public int face = -1;

	public void faceUpdate(int index) {
		face = index;
		faceUpdateRequired = true;
		updateRequired = true;
	}

	public void stopMovement() {
		resetWalkingQueue();
	}

	// handles anything related to character position, i.e. walking,running and teleportation
	// applies only to the char and the client which is playing it
	public void updateThisPlayerMovement(stream str) {
		if(mapRegionDidChange) {
			str.createFrame(73);
			str.writeWordA(mapRegionX+6);	// for some reason the client substracts 6 from those values
			str.writeWord(mapRegionY+6);
		}

		if(didTeleport == true) {
			str.createFrameVarSizeWord(81);
			str.initBitAccess();
			str.writeBits(1, 1);
			str.writeBits(2, 3);			// updateType
			str.writeBits(2, heightLevel);
			str.writeBits(1, 1);			// set to true, if discarding (clientside) walking queue
			str.writeBits(1, (updateRequired) ? 1 : 0);
			str.writeBits(7, currentY);
			str.writeBits(7, currentX);
			if (IsDead == true && IsDeadTimer == true && IsDeadTeleporting == true) {
				IsDead = false;
				IsDeadTimer = false;
				SafeMyLife = false;
				IsUsingSkill = false;
			}
			return ;
		}

		if(walkDirection == -1) {
			// don't have to update the character position, because we're just standing
			str.createFrameVarSizeWord(81);
			str.initBitAccess();
			isMoving = false;
			if(updateRequired) {
				// tell client there's an update block appended at the end
				str.writeBits(1, 1);
				str.writeBits(2, 0);
			} else {
				str.writeBits(1, 0);
			}
			if (DirectionCount < 50) {
				DirectionCount++;
			}
		} else {
			DirectionCount = 0;
			str.createFrameVarSizeWord(81);
			str.initBitAccess();
			str.writeBits(1, 1);

			if(runDirection == -1) {
				isMoving = true;
				str.writeBits(2, 1);		// updateType
				str.writeBits(3, misc.xlateDirectionToClient[walkDirection]);
				if(updateRequired) str.writeBits(1, 1);		// tell client there's an update block appended at the end
				else str.writeBits(1, 0);
			} else {
				isMoving = true;
				str.writeBits(2, 2);		// updateType
				str.writeBits(3, misc.xlateDirectionToClient[walkDirection]);
				str.writeBits(3, misc.xlateDirectionToClient[runDirection]);
				if(updateRequired)
					str.writeBits(1, 1);		// tell client there's an update block appended at the end
				else
					str.writeBits(1, 0);

			}
		}

	}

	// handles anything related to character position basically walking, running and standing
	// applies to only to "non-thisPlayer" characters
	public void updatePlayerMovement(stream str) {
		if(walkDirection == -1) {
			// don't have to update the character position, because the char is just standing
			if(updateRequired || chatTextUpdateRequired) {
				// tell client there's an update block appended at the end
				str.writeBits(1, 1);
				str.writeBits(2, 0);
			}
			else str.writeBits(1, 0);
		} else if(runDirection == -1) {
			// send "walking packet"
			str.writeBits(1, 1);
			str.writeBits(2, 1);
			str.writeBits(3, misc.xlateDirectionToClient[walkDirection]);
			str.writeBits(1, (updateRequired || chatTextUpdateRequired) ? 1: 0);
		} else {
			// send "running packet"
			str.writeBits(1, 1);
			str.writeBits(2, 2);
			str.writeBits(3, misc.xlateDirectionToClient[walkDirection]);
			str.writeBits(3, misc.xlateDirectionToClient[runDirection]);
			str.writeBits(1, (updateRequired || chatTextUpdateRequired) ? 1: 0);
		}
	}


	public static client client = null;
	//client = new client();
	public boolean dropsitem = false;
	public void removeequipped()
	{
		dropsitem = true;
	}
	public void setPlrAnimation(int i) {
		playerStandIndex = i;
		updateRequired = true;
		appearanceUpdateRequired = true;
	}
	public int GetPlrBlockAnim(int id)
	{
		if(id == 4755) // veracs flail
		{
			return 2063;
		}
		if(id == 4153) // maul
		{
			return 1666;
		}
		else
		{
			return 1834;
		}
	}
	// a bitmap of players that we want to keep track of whether char appearance has changed so
	// we know if we have to transmit those or can make use of the cached char appearances in the client
	public byte cachedPropertiesBitmap[] = new byte[(PlayerHandler.maxPlayers+7) >> 3];

	public void addNewNPC(NPC npc, stream str, stream updateBlock)
	{
		int id = npc.npcId;
		npcInListBitmap[id >> 3] |= 1 << (id&7);	// set the flag
		npcList[npcListSize++] = npc;

		str.writeBits(14, id);	// client doesn't seem to like id=0

		int z = npc.absY-absY;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// y coordinate relative to thisPlayer
		z = npc.absX-absX;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// x coordinate relative to thisPlayer

		str.writeBits(1, 0); //something??
		str.writeBits(14, npc.npcType);

		boolean savedUpdateRequired = npc.updateRequired;
		npc.updateRequired = true;
		npc.appendNPCUpdateBlock(updateBlock);
		npc.updateRequired = savedUpdateRequired;
		str.writeBits(1, 1); // update required
	}

	public void addNewPlayer(Player plr, stream str, stream updateBlock) {
		int id = plr.playerId;
		playerInListBitmap[id >> 3] |= 1 << (id&7);	// set the flag
		playerList[playerListSize++] = plr;

		str.writeBits(11, id);	// client doesn't seem to like id=0

		// TODO: properly implement the character appearance handling
		// send this everytime for now and don't make use of the cached ones in client
		str.writeBits(1, 1);	// set to true, if player definitions follow below
		boolean savedFlag = plr.appearanceUpdateRequired;
		boolean savedUpdateRequired = plr.updateRequired;
		plr.appearanceUpdateRequired = true;
		plr.updateRequired = true;
		plr.appendPlayerUpdateBlock(updateBlock);
		plr.appearanceUpdateRequired = savedFlag;
		plr.updateRequired = savedUpdateRequired;


		str.writeBits(1, 1);	// set to true, if we want to discard the (clientside) walking queue
		// no idea what this might be useful for yet
		int z = plr.absY-absY;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// y coordinate relative to thisPlayer
		z = plr.absX-absX;
		if(z < 0) z += 32;
		str.writeBits(5, z);	// x coordinate relative to thisPlayer
	}



	// player appearance related stuff
	protected boolean appearanceUpdateRequired = true;	// set to true if the player appearance wasn't synchronized
	// with the clients yet or changed recently

	protected static stream playerProps;
	static {
		playerProps = new stream(new byte[100]);
	}
	protected void appendPlayerAppearance(stream str)
	{
		playerProps.currentOffset = 0;

		// TODO: yet some things to figure out on this block + properly implement this
		playerProps.writeByte(playerAppearance[0]);		// player sex. 0=Male and 1=Female
		// playerProps.writeByte(1 & 1 >> 2);		// playerStatusMask - skull, prayers etc alkup 0
		playerProps.writeByte(headIcon);
		playerProps.writeByte(headIconPk);

		// defining the character shape - 12 slots following - 0 denotes a null entry and just a byte is used
		// slot 0,8,11,1 is head part - missing additional things are beard and eyepatch like things either 11 or 1
		// cape, apron, amulet... the remaining things...

		if (isNpc == false) {
			if (playerEquipment[playerHat] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerHat]);
			} else {
				playerProps.writeByte(0);
			}
			if (playerEquipment[playerCape] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerCape]);
			} else {
				playerProps.writeByte(0);
			}
			if (playerEquipment[playerAmulet] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerAmulet]);
			} else {
				playerProps.writeByte(0);
			}
			if (playerEquipment[playerWeapon] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerWeapon]);
			} else {
				playerProps.writeByte(0);
			}
			if (playerEquipment[playerChest] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerChest]);
			} else {
				playerProps.writeWord(256+pTorso);
			}
			if (playerEquipment[playerShield] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerShield]);
			} else {
				playerProps.writeByte(0);
			}
			if (!Item.isPlate(playerEquipment[playerChest])) {
				playerProps.writeWord(256+ playerAppearance[3]);
			} else {
				playerProps.writeByte(0);
			}
			if (playerEquipment[playerLegs] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerLegs]);
			} else {
				playerProps.writeWord(256+ playerAppearance[5]);
			}
			if (!Item.isFullHat(playerEquipment[playerHat]) && Item.isFullMask(playerEquipment[playerHat])) {
				playerProps.writeWord(256 + playerAppearance[1]);  // head
			} else {
				playerProps.writeByte(0);
			}
			if (playerEquipment[playerHands] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerHands]);
			} else {
				playerProps.writeWord(256+ playerAppearance[4]);
			}
			if (playerEquipment[playerFeet] > 1) {
				playerProps.writeWord(32768 + playerEquipment[playerFeet]);
			} else {
				playerProps.writeWord(256+ playerAppearance[6]);
			}
			if (playerAppearance[0] != 1 && Item.isFullMask(playerEquipment[playerHat])) {
				playerProps.writeWord(256 + playerAppearance[7]);
			} else{
				playerProps.writeByte(0);
			}
		} else {
			playerProps.writeWord(-1);
			playerProps.writeWord(npcId);
		}
		// array of 5 bytes defining the colors
		playerProps.writeWord(playerColor[0]);	// hair color
		playerProps.writeWord(playerColor[1]);	// torso color.
		playerProps.writeWord(playerColor[2]);	// leg color
		playerProps.writeWord(playerColor[3]);	// feet color
		playerProps.writeWord(playerColor[4]);	// skin color (0-6)

		playerProps.writeWord(playerStandIndex);		// standAnimIndex
		playerProps.writeWord(playerTurnIndex);		// standTurnAnimIndex
		playerProps.writeWord(playerWalkIndex);	// walkAnimIndex
		playerProps.writeWord(playerTurn180Index);		// turn180AnimIndex
		playerProps.writeWord(playerTurn90CWIndex);		// turn90CWAnimIndex
		playerProps.writeWord(playerTurn90CCWIndex);		// turn90CCWAnimIndex
		playerProps.writeWord(playerRunIndex);	// runAnimIndex

		playerProps.writeQWord(misc.playerNameToInt64(displayName));

		//Stat fix, combat decreases when your hp or any of these skills get lowerd, this fixes that problem.
		/*int att = (int)((double)(getLevelForXP(playerXP[0])) * 0.325);
		int def = (int)((double)(getLevelForXP(playerXP[1])) * 0.25);
		int str = (int)((double)(getLevelForXP(playerXP[2])) * 0.325);
		int hit = (int)((double)(getLevelForXP(playerXP[3])) * 0.25);
		int mag = (int)((double)(getLevelForXP(playerXP[4])) * 0.4875);
		int pra = (int)((double)(getLevelForXP(playerXP[5])) * 0.125);
		int ran = (int)((double)(getLevelForXP(playerXP[6])) * 0.4875);*/

		/*int mag = (int)((double)(getLevelForXP(playerXP[4])) * 1.5);
		int ran = (int)((double)(getLevelForXP(playerXP[6])) * 1.5);
		int attstr = (int)((double)(getLevelForXP(playerXP[0])) + (double)(getLevelForXP(playerXP[2])));

		int combatLevel = 0;
		if (ran > attstr) {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[6])) * 0.4875));
		} else if (mag > attstr) {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[4])) * 0.4875));
		} else {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[0])) * 0.325) + ((double)(getLevelForXP(playerXP[2])) * 0.325));
		}
		playerProps.writeByte(combatLevel);		// combat level
		playerProps.writeWord(loyaltyRank);			// incase != 0, writes skill-%d

		str.writeByteC(playerProps.currentOffset);		// size of player appearance block
		str.writeBytes(playerProps.buffer, playerProps.currentOffset, 0);
 	}*/


		int mag = (int)((double)(getLevelForXP(playerXP[4])) * 1.5);
		int ran = (int)((double)(getLevelForXP(playerXP[6])) * 1.5);
		int attstr = (int)((double)(getLevelForXP(playerXP[0])) + (double)(getLevelForXP(playerXP[2])));

		int combatLevel = 0;
		if (ran > attstr) {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[6])) * 0.4875));
		} else if (mag > attstr) {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[4])) * 0.4875));
		} else {
			combatLevel = (int)(((double)(getLevelForXP(playerXP[1])) * 0.25) + ((double)(getLevelForXP(playerXP[3])) * 0.25) + ((double)(getLevelForXP(playerXP[5])) * 0.125) + ((double)(getLevelForXP(playerXP[0])) * 0.325) + ((double)(getLevelForXP(playerXP[2])) * 0.325));
		}

		combat = combatLevel;
		playerProps.writeByte(combatLevel);		// combat level
		playerProps.writeWord(loyaltyRank);			// incase != 0, writes skill-%d
		playerProps.writeWord(0);
		playerProps.writeWord(playerIsVisible);
		str.writeByteC(playerProps.currentOffset);		// size of player appearance block
		str.writeBytes(playerProps.buffer, playerProps.currentOffset, 0);
	}
	protected boolean chatTextUpdateRequired = false;
	protected byte chatText[] = new byte[4096], chatTextSize = 0;
	protected int chatTextEffects = 0, chatTextColor = 0;
	protected void appendPlayerChatText(stream str) {
		str.writeWordBigEndian(((chatTextColor&0xFF) << 8) + (chatTextEffects&0xFF));
		str.writeByte(rights.getValue());
		str.writeByteC(chatTextSize);		// no more than 256 bytes!!!
		str.writeBytes_reverse(chatText, chatTextSize, 0);
	}
	public boolean update1Required = false;
	public int update1_1 = 0;
	public int update1_2 = 0;
	protected void appendUpdate1(stream str) {
		str.writeWordBigEndian(update1_1);
		str.writeByteC(update1_2);
	}
	public void appendPlayerUpdateBlock(stream str) {
		if (!updateRequired && !chatTextUpdateRequired) return;        // nothing required
		int updateMask = 0;
		if (forceMovement) {
			updateMask |= 1024;
		}
		if(gfxUpdateRequired) {
			updateMask |= 256;
		}
		if(animationRequest != -1) {
			updateMask |= 8;
		}
		if(string4UpdateRequired) {
			updateMask |= 4;
		}
		if(chatTextUpdateRequired) {
			updateMask |= 128;
		}
		if(appearanceUpdateRequired) {
			updateMask |= 16;
		}
		if(faceUpdateRequired) {
			updateMask |= 1;
		}
		if (FocusPointX != -1) {
			updateMask |= 2;
		}
		if(hitUpdateRequired) {
			updateMask |= 32;
		}
		if(hitUpdateRequired2) {
			updateMask |= 512;
		}

		if(updateMask >= 236) {
			// byte isn't sufficient
			updateMask |= 64;			// indication for the client that updateMask is stored in a word
			str.writeByte(updateMask & 255);
			str.writeByte(updateMask >> 8);
		} else {
			str.writeByte(updateMask);
		}

		// now writing the various update blocks itself - note that their order crucial
		if(forceMovement) {
			appendMask400Update(str);
		}
		if(gfxUpdateRequired) {
			appendMask100Update(str);
		}
		if(animationRequest != -1) {
			appendAnimationRequest(str);
		}
		if(string4UpdateRequired) {
			appendString4(str);
		}
		if(chatTextUpdateRequired) {
			appendPlayerChatText(str);
		}
		if(faceUpdateRequired) {
			appendFaceUpdate(str);
		}
		if(appearanceUpdateRequired) {
			appendPlayerAppearance(str);
		}
		if (FocusPointX != -1) {
			appendSetFocusDestination(str);
		}
		if(hitUpdateRequired) {
			appendHitUpdate(str);
		}
		if(hitUpdateRequired2) {
			appendHitUpdate2(str);
		}
	}

	public void clearUpdateFlags() { // Xerozcheez: ORDER IS CRUCIAL HERE TOO (although it's different order I think LOL) :|
		FocusPointX = FocusPointY = -1;
		updateRequired = false;
		//animationRequest = -1;
		string4UpdateRequired = false;
		chatTextUpdateRequired = false;
		appearanceUpdateRequired = false;
		hitUpdateRequired = false;
		hitUpdateRequired2 = false;
		dirUpdateRequired = false;
		animationRequest = -1;
		dirUpdate2Required = false;
		faceUpdateRequired = false;
		forceMovement = false;
		face = 65535;
		gfxUpdateRequired = false;
		update1Required = false;
		IsStair = false;
	}



	protected static int newWalkCmdX[] = new int[walkingQueueSize];
	protected static int newWalkCmdY[] = new int[walkingQueueSize];
	protected static int tmpNWCX[] = new int[walkingQueueSize];
	protected static int tmpNWCY[] = new int[walkingQueueSize];
	protected static int newWalkCmdSteps = 0;
	protected static boolean newWalkCmdIsRunning = false;
	protected static int travelBackX[] = new int[walkingQueueSize];
	protected static int travelBackY[] = new int[walkingQueueSize];
	protected static int numTravelBackSteps = 0;
	public static int deathStage;

	public void preProcessing() {
		newWalkCmdSteps = 0;
	}

	// is being called regularily every 500ms - do any automatic player actions herein
	public abstract void process();
	public abstract boolean packetSending();
	public boolean following = false;

	public void postProcessing() {
		if (newWalkCmdSteps > 0) {
			int firstX = getNewWalkCmdX()[0];
			int firstY = getNewWalkCmdY()[0];
			int lastDir = 0;
			boolean found = false;
			numTravelBackSteps = 0;
			int ptr = wQueueReadPtr;
			int dir = misc.direction(currentX, currentY, firstX, firstY);
			if (dir != -1 && (dir & 1) != 0) {
				do {
					lastDir = dir;
					if (--ptr < 0) ptr = walkingQueueSize - 1;
					travelBackX[numTravelBackSteps] = walkingQueueX[ptr];
					travelBackY[numTravelBackSteps++] = walkingQueueY[ptr];
					dir = misc.direction(walkingQueueX[ptr], walkingQueueY[ptr], firstX, firstY);
					if (lastDir != dir) {
						found = true;
						break;
					}
				} while (ptr != wQueueWritePtr);
			} else found = true;
			if (!found) println_debug("Fatal: couldn't find connection vertex! Dropping packet.");
			else {
				wQueueWritePtr = wQueueReadPtr;
				addToWalkingQueue(currentX, currentY);
				if (dir != -1 && (dir & 1) != 0) {
					for (int i = 0; i < numTravelBackSteps - 1; i++) {
						addToWalkingQueue(travelBackX[i], travelBackY[i]);
					}
					int wayPointX2 = travelBackX[numTravelBackSteps - 1];
					int wayPointY2 = travelBackY[numTravelBackSteps - 1];
					int wayPointX1;
					int wayPointY1;
					if (numTravelBackSteps == 1) {
						wayPointX1 = currentX;
						wayPointY1 = currentY;
					} else {
						wayPointX1 = travelBackX[numTravelBackSteps - 2];
						wayPointY1 = travelBackY[numTravelBackSteps - 2];
					}
					dir = misc.direction(wayPointX1, wayPointY1, wayPointX2, wayPointY2);
					if (dir == -1 || (dir & 1) != 0) {
						println_debug("Fatal: The walking queue is corrupt! wp1=(" + wayPointX1 + ", " + wayPointY1 + "), " + "wp2=(" + wayPointX2 + ", " + wayPointY2 + ")");
					} else {
						dir >>= 1;
						found = false;
						int x = wayPointX1;
						int y = wayPointY1;
						while (x != wayPointX2 || y != wayPointY2) {
							x += misc.directionDeltaX[dir];
							y += misc.directionDeltaY[dir];
							if ((misc.direction(x, y, firstX, firstY) & 1) == 0) {
								found = true;
								break;
							}
						}
						if (!found) {
							println_debug("Fatal: Internal error: unable to determine connection vertex!" + "  wp1=(" + wayPointX1 + ", " + wayPointY1 + "), wp2=(" + wayPointX2 + ", " + wayPointY2 + "), " + "first=(" + firstX + ", " + firstY + ")");
						} else addToWalkingQueue(wayPointX1, wayPointY1);
					}
				} else {
					for (int i = 0; i < numTravelBackSteps; i++) {
						addToWalkingQueue(travelBackX[i], travelBackY[i]);
					}
				}
				for (int i = 0; i < newWalkCmdSteps; i++) {
					addToWalkingQueue(getNewWalkCmdX()[i], getNewWalkCmdY()[i]);
				}
			}
		}
	}
	public void kick() {
		isKicked = true;
	}

	protected int hitDiff = 0;
	protected boolean hitUpdateRequired = false;
	protected boolean IsDead = false;
	protected int NewHP = 10;
	protected boolean SafeMyLife = false;
	protected boolean IsStair = false;
	protected boolean IsDeadTeleporting = false;
	protected boolean IsDeadTimer = false;
	protected void appendHitUpdate2(stream str) {
		try {
			str.writeByte(hitDiff); // What the perseon got 'hit' for
			if (hitDiff > 0 && newhptype == false && poisondmg == false) {
				str.writeByteA(1); // 0: red hitting - 1: blue hitting
			} else if (hitDiff > 0 && poisondmg == true) {
				str.writeByteA(0); // 0: red hitting - 1: blue hitting 2: poison 3: orange
			} else if (hitDiff > 0 && newhptype == true) {
				str.writeByteA(hptype); // 0: red hitting - 1: blue hitting
			} else {
				str.writeByteA(0); // 0: red hitting - 1: blue hitting
			}
			NewHP = (playerLevel[playerHitpoints] - hitDiff);
			if (NewHP <= 0) {
				NewHP = 0;
				IsDead = true;
			}
			str.writeByte(NewHP); // Their current hp, for HP bar
			str.writeByteC(getLevelForXP(playerXP[playerHitpoints])); // Their max hp, for HP bar
			poisondmg = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void appendHitUpdate(stream str) {
		try {
			str.writeByte(hitDiff); // What the perseon got 'hit' for
			if (hitDiff > 0 && newhptype == false && poisondmg == false) {
				str.writeByteS(1); // 0: red hitting - 1: blue hitting
			} else if (hitDiff > 0 && poisondmg == true) {
				str.writeByteS(2); // 0: red hitting - 1: blue hitting 2: poison 3: orange
			} else if (hitDiff > 0 && newhptype == true) {
				str.writeByteS(hptype); // 0: red hitting - 1: blue hitting
			} else {
				str.writeByteS(0); // 0: red hitting - 1: blue hitting
			}
			NewHP = (playerLevel[playerHitpoints] - hitDiff);
			if (NewHP <= 0) {
				NewHP = 0;
				IsDead = true;
			}
			str.writeByteC(NewHP); // Their current hp, for HP bar
			str.writeByte(getLevelForXP(playerXP[playerHitpoints])); // Their max hp, for HP bar
			poisondmg = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getLevelForXP(int exp) {
		int points = 0;
		int output = 0;

		for (int lvl = 1; lvl <= 150; lvl++) {
			points += Math.floor((double)lvl + 300.0 * Math.pow(2.0, (double)lvl / 7.0));
			output = (int)Math.floor(points / 4);
			if (output >= exp)
				return lvl;
		}
		return 0;
	}
	public final void face(int x, int y) {
		FocusPointX = 2 * x + 1;
		FocusPointY = 2 * y + 1;
		updateRequired = true;
		faceUpdateRequired = true;
	}

	public int animationRequest = -1, animationWaitCycles = 0;
	protected boolean animationUpdateRequired = false;
	public void startAnimation(int animIdx)
	{
		animationRequest = animIdx;
		updateRequired = true;
		animationUpdateRequired = true;
	}
	public void appendAnimationRequest(stream str)
	{
		str.writeWordBigEndian((animationRequest==-1) ? 65535 : animationRequest);
		str.writeByteC(animationWaitCycles);
	}
	public int playerEmotionReq = -1;
	public int playerEmotionDelay = 0;
	public void appendEmotionUpdate(stream str) {
		str.writeWordBigEndian((playerEmotionReq==-1) ? 65535 : playerEmotionReq);
		str.writeByteC(playerEmotionDelay);
	}
	public int mask1var = 0;
	protected boolean mask1update = false;
	public void appendMask1Update(stream str) {
		str.writeWordBigEndian(mask1var);
	}
	public void appendFaceUpdate(stream str) {
		str.writeWordBigEndian(face);
	}
	public int mask100var1 = 0;
	public int mask100var2 = 0;
	protected boolean gfxUpdateRequired = false;
	public void appendMask100Update(stream str) {
		str.writeWordBigEndian(mask100var1);
		str.writeDWord(mask100var2);
	}
	private int x1 = -1;
	private int y1 = -1;
	private int x2 = -1;
	private int y2 = -1;
	private int speed1 = -1;
	public int makeTimes;
	public int event;
	private int speed2 = -1;
	private int direction = -1;
	public boolean canWalk = true;
	protected boolean forceMovement = false;
	public void appendMask400Update(stream str) {
		str.writeByteS(x1);
		str.writeByteS(y1);
		str.writeByteS(x2);
		str.writeByteS(y2);
		str.writeWordBigEndianA(speed1);
		str.writeWordA(speed2);
		str.writeByteS(direction);
	}
	public String txt4 = "testing update mask string";
	protected boolean string4UpdateRequired = false;
	public void appendString4(stream str) { // Xerozcheez: Interesting mask, looks like to do with chat
		str.writeString(txt4);
	}
	public void appendDirUpdate2(stream str) {
		str.writeWordBigEndianA(viewToX);
		str.writeWordBigEndian(viewToY);
	}
	public void appendDirUpdate(stream str) {
		if (playerMD != -1) {
			/*str.writeBits(2, 1);		// updateType
			str.writeBits(3, misc.xlateDirectionToClient[playerMD]);
			if(updateRequired) {
				str.writeBits(1, 1);		// tell client there's an update block appended at the end
			} else {
				str.writeBits(1, 0);
			}*/
			str.writeWord(playerMD);
			playerMD = -1;
		}
	}
	public boolean[] IsDropped = new boolean[server.itemHandler.MaxDropItems];
	public boolean[] MustDelete = new boolean[server.itemHandler.MaxDropItems];
	public boolean IsDropping = false;

	//PM Stuff
	public abstract boolean isinpm(long l);
	public abstract void loadpm(long l, int world);
	public abstract void pmupdate(int pmid, int world);
	public int Privatechat = 0;
	public abstract void sendpm(long name,int rights,byte[] chatmessage, int messagesize);
	public long friends[] = new long[200];
	public long ignores[] = new long[100];
	public long lastCombat = 0;
	public boolean IsPMLoaded = false;

	public int playerIsMember;
	public int prestigeLevel;
	public int playerHasDonated;
	public int playerMessages;
	public String playerLastConnect;
	public int playerLastLogin;
	public int playerEnergy;
	public int playerEnergyGian;
	public int playerAppearance[] = new int[13];
	public int playerColor[] = new int[5];
	public boolean IsUsingSkill = false;
	public int playerBonus[] = new int[12];
	public int StrPotion = 0;
	public int StrPrayer = 0;
	public int FightType = 1;
	public int playerMaxHit = 0;
	public int playerSE = 0x328; //SE = Standard Emotion
	public int playerWalkIndex = 0x333; //SEW = Standard Emotion Walking
	public int playerRunIndex = 0x338; //SER = Standard Emotion Run
	public int playerSEA = 0x326; //SEA = Standard Emotion Attack
	public int playerTurn90CWIndex = 0x335; //SEA = Standard Emotion turn 90
	public int playerTurn90CCWIndex = 0x336; //SEA = Standard Emotion turn 90
	public int playerMD = -1;
	public int viewToX = -1;
	public int viewToY = -1;
	protected boolean dirUpdateRequired = false;
	protected boolean dirUpdate2Required = false;
	public boolean IsCutting = false;
	public boolean WannePickUp = false;
	public boolean IsInWilderness = false;
	public boolean IsAttacking = false;
	public boolean IsMining = false;
	public boolean IsAttackingNPC = false;
	public int attacknpc = -1;
	public int Essence;
	public boolean IsShopping = false;
	public int MyShopID = 0;
	public boolean UpdateShop = false;
	public boolean RebuildNPCList = false;
	public int IsSnowing = 0;
	public int NpcDialogue = 0;
	public boolean spinningFlax = false;
	public int NpcTalkTo = 0;
	public boolean NpcDialogueSend = false;
	public int NpcWanneTalk = 0;
	public int InBank = 0;
	public int WanneTrade = 0;
	public int WanneTradeWith = 0;
	public boolean TradeConfirmed = false;
	public boolean AntiTradeScam = false;
	public int playerFollow[] = new int[PlayerHandler.maxPlayers];
	public int playerFollowID = -1;
	public int DirectionCount = 0;
	public boolean playerAncientMagics = false;
	public String playerServer;
	public int playerGameTime;
	public int playerGameCount;
	public boolean ChangeDoor[] = new boolean[server.objectHandler.MaxObjects];
	public int respawnTimer;
	public int underAttackBy2;
	public int underAttackBy;
	public int lastNpcAttacked = 0;
	public int totalDamageDealt = 0;
	public boolean fishing = false;
	public String macAddress;
	public String uuid;
	public String countryCode;
	public int playerUID;
	public stream inStream = null, outStream = null;
	public int fishTimer = 0;


	public stream getOutStream() {
		return outStream;
	}
	public int distanceToPoint(int pointX, int pointY) {
		return (int) Math.sqrt(Math.pow(absX - pointX, 2) + Math.pow(absY - pointY, 2));
	}


}