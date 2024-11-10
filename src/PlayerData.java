import java.util.Optional;

public class PlayerData {
    private String username;
    private String password;
    private String displayName;
    private int heightLevel;
    private int absX;
    private int absY;
    private int rights;
    private int runEnergy;
    private boolean runningToggled;
    private long daysPlayed;
    private long hoursPlayed;
    private long minutesPlayed;
    private double secondsPlayed;
    private int amDonated;
    private boolean hasFirstFloorDone;
    private boolean hasSecondFloorDone;
    private boolean hasThirdFloorDone;
    private boolean hasFourthFloorDone;
    private int skullTimer;
    private int playerIsMember;
    private int playerHasDonated;
    private int jailed;
    private int playerMessages;
    private String playerLastConnect;
    private int playerUID;
    private String macAddress;
    private String uuid;
    private String countryCode;
    private int playerLastLogin;
    private int playerEnergy;
    private int playerGameTime;
    private int playerGameCount;
    private int prestigeLevel;

    // Slayer data
    private Optional<SlayerTask> slayerTask = Optional.empty(); // Optional field for SlayerTask

    private int slayerMaster;
    private int slayerTaskAmount;
    private int slayerPoints;
    private boolean slayerRecipe;
    private boolean slayerHelmet;
    private boolean slayerImbuedHelmet;
    private boolean biggerBossTasks;
    private boolean cerberusRoute;
    private boolean superiorSlayer;

    // Arrays
    private int[] playerEquipment;
    private int[] playerEquipmentN;
    private int[] playerAppearance;
    private int[] playerColor;
    private int[] playerLevel;
    private int[] playerXP;
    private int[] playerItems;
    private int[] playerItemsN;
    private int[] bankItems;
    private int[] bankItemsN;
    private int[] bankItems2;
    private int[] bankItemsN2;
    private int[] bankItems3;
    private int[] bankItemsN3;
    private long[] friends;
    private long[] ignores;
    private int consecutiveTasks; // Field for consecutive tasks
    private int loyaltyRank; // Field for loyalty rank

    // Add these methods to the class:
    public int getLoyaltyRank() {
        return loyaltyRank;
    }

    public void setLoyaltyRank(int loyaltyRank) {
        this.loyaltyRank = loyaltyRank;
    }

    // Add these methods to the class:
    public int getConsecutiveTasks() {
        return consecutiveTasks;
    }

    public void setConsecutiveTasks(int consecutiveTasks) {
        this.consecutiveTasks = consecutiveTasks;
    }
    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getHeightLevel() {
        return heightLevel;
    }

    public void setHeightLevel(int heightLevel) {
        this.heightLevel = heightLevel;
    }

    public int getAbsX() {
        return absX;
    }

    public void setAbsX(int absX) {
        this.absX = absX;
    }

    public int getAbsY() {
        return absY;
    }

    public void setAbsY(int absY) {
        this.absY = absY;
    }

    public int getRights() {
        return rights;
    }

    public void setRights(int rights) {
        this.rights = rights;
    }

    public int getRunEnergy() {
        return runEnergy;
    }

    public void setRunEnergy(int runEnergy) {
        this.runEnergy = runEnergy;
    }

    public boolean isRunningToggled() {
        return runningToggled;
    }

    public void setRunningToggled(boolean runningToggled) {
        this.runningToggled = runningToggled;
    }

    public long getDaysPlayed() {
        return daysPlayed;
    }

    public void setDaysPlayed(long daysPlayed) {
        this.daysPlayed = daysPlayed;
    }

    public long getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(long hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public long getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(long minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public double getSecondsPlayed() {
        return secondsPlayed;
    }

    public void setSecondsPlayed(double secondsPlayed) {
        this.secondsPlayed = secondsPlayed;
    }

    public int getAmDonated() {
        return amDonated;
    }

    public void setAmDonated(int amDonated) {
        this.amDonated = amDonated;
    }

    public boolean isHasFirstFloorDone() {
        return hasFirstFloorDone;
    }

    public void setHasFirstFloorDone(boolean hasFirstFloorDone) {
        this.hasFirstFloorDone = hasFirstFloorDone;
    }

    public boolean isHasSecondFloorDone() {
        return hasSecondFloorDone;
    }

    public void setHasSecondFloorDone(boolean hasSecondFloorDone) {
        this.hasSecondFloorDone = hasSecondFloorDone;
    }

    public boolean isHasThirdFloorDone() {
        return hasThirdFloorDone;
    }

    public void setHasThirdFloorDone(boolean hasThirdFloorDone) {
        this.hasThirdFloorDone = hasThirdFloorDone;
    }

    public boolean isHasFourthFloorDone() {
        return hasFourthFloorDone;
    }

    public void setHasFourthFloorDone(boolean hasFourthFloorDone) {
        this.hasFourthFloorDone = hasFourthFloorDone;
    }

    public int getSkullTimer() {
        return skullTimer;
    }

    public void setSkullTimer(int skullTimer) {
        this.skullTimer = skullTimer;
    }

    public int getPlayerIsMember() {
        return playerIsMember;
    }

    public void setPlayerIsMember(int playerIsMember) {
        this.playerIsMember = playerIsMember;
    }

    public int getPlayerHasDonated() {
        return playerHasDonated;
    }

    public void setPlayerHasDonated(int playerHasDonated) {
        this.playerHasDonated = playerHasDonated;
    }

    public int getJailed() {
        return jailed;
    }

    public void setJailed(int jailed) {
        this.jailed = jailed;
    }

    public int getPlayerMessages() {
        return playerMessages;
    }

    public void setPlayerMessages(int playerMessages) {
        this.playerMessages = playerMessages;
    }

    public String getPlayerLastConnect() {
        return playerLastConnect;
    }

    public void setPlayerLastConnect(String playerLastConnect) {
        this.playerLastConnect = playerLastConnect;
    }

    public int getPlayerUID() {
        return playerUID;
    }

    public void setPlayerUID(int playerUID) {
        this.playerUID = playerUID;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPlayerLastLogin() {
        return playerLastLogin;
    }

    public void setPlayerLastLogin(int playerLastLogin) {
        this.playerLastLogin = playerLastLogin;
    }

    public int getPlayerEnergy() {
        return playerEnergy;
    }

    public void setPlayerEnergy(int playerEnergy) {
        this.playerEnergy = playerEnergy;
    }

    public int getPlayerGameTime() {
        return playerGameTime;
    }

    public void setPlayerGameTime(int playerGameTime) {
        this.playerGameTime = playerGameTime;
    }

    public int getPlayerGameCount() {
        return playerGameCount;
    }

    public void setPlayerGameCount(int playerGameCount) {
        this.playerGameCount = playerGameCount;
    }

    public int getPrestigeLevel() {
        return prestigeLevel;
    }

    public void setPrestigeLevel(int prestigeLevel) {
        this.prestigeLevel = prestigeLevel;
    }

    // Getter for slayerTask
    public Optional<SlayerTask> getSlayerTask() {
        return slayerTask;
    }

    // Setter for slayerTask
    public void setSlayerTask(Optional<SlayerTask> slayerTask) {
        this.slayerTask = slayerTask;
    }

    // Method to set a non-optional SlayerTask
    public void setSlayerTask(SlayerTask task) {
        this.slayerTask = Optional.ofNullable(task);
    }

    public int getSlayerMaster() {
        return slayerMaster;
    }

    public void setSlayerMaster(int slayerMaster) {
        this.slayerMaster = slayerMaster;
    }

    public int getSlayerTaskAmount() {
        return slayerTaskAmount;
    }

    public void setSlayerTaskAmount(int slayerTaskAmount) {
        this.slayerTaskAmount = slayerTaskAmount;
    }

    public int getSlayerPoints() {
        return slayerPoints;
    }

    public void setSlayerPoints(int slayerPoints) {
        this.slayerPoints = slayerPoints;
    }

    public boolean isSlayerRecipe() {
        return slayerRecipe;
    }

    public void setSlayerRecipe(boolean slayerRecipe) {
        this.slayerRecipe = slayerRecipe;
    }

    public boolean isSlayerHelmet() {
        return slayerHelmet;
    }

    public void setSlayerHelmet(boolean slayerHelmet) {
        this.slayerHelmet = slayerHelmet;
    }

    public boolean isSlayerImbuedHelmet() {
        return slayerImbuedHelmet;
    }

    public void setSlayerImbuedHelmet(boolean slayerImbuedHelmet) {
        this.slayerImbuedHelmet = slayerImbuedHelmet;
    }

    public boolean isBiggerBossTasks() {
        return biggerBossTasks;
    }

    public void setBiggerBossTasks(boolean biggerBossTasks) {
        this.biggerBossTasks = biggerBossTasks;
    }

    public boolean isCerberusRoute() {
        return cerberusRoute;
    }

    public void setCerberusRoute(boolean cerberusRoute) {
        this.cerberusRoute = cerberusRoute;
    }

    public boolean isSuperiorSlayer() {
        return superiorSlayer;
    }

    public void setSuperiorSlayer(boolean superiorSlayer) {
        this.superiorSlayer = superiorSlayer;
    }

    // Array getters and setters
    public int[] getPlayerEquipment() {
        return playerEquipment;
    }

    public void setPlayerEquipment(int[] playerEquipment) {
        this.playerEquipment = playerEquipment;
    }

    public int[] getPlayerEquipmentN() {
        return playerEquipmentN;
    }

    public void setPlayerEquipmentN(int[] playerEquipmentN) {
        this.playerEquipmentN = playerEquipmentN;
    }

    public int[] getPlayerAppearance() {
        return playerAppearance;
    }

    public void setPlayerAppearance(int[] playerAppearance) {
        this.playerAppearance = playerAppearance;
    }

    public int[] getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(int[] playerColor) {
        this.playerColor = playerColor;
    }

    public int[] getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int[] playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int[] getPlayerXP() {
        return playerXP;
    }

    public void setPlayerXP(int[] playerXP) {
        this.playerXP = playerXP;
    }

    public int[] getPlayerItems() {
        return playerItems;
    }

    public void setPlayerItems(int[] playerItems) {
        this.playerItems = playerItems;
    }

    public int[] getPlayerItemsN() {
        return playerItemsN;
    }

    public void setPlayerItemsN(int[] playerItemsN) {
        this.playerItemsN = playerItemsN;
    }

    public int[] getBankItems() {
        return bankItems;
    }

    public void setBankItems(int[] bankItems) {
        this.bankItems = bankItems;
    }

    public int[] getBankItemsN() {
        return bankItemsN;
    }

    public void setBankItemsN(int[] bankItemsN) {
        this.bankItemsN = bankItemsN;
    }

    public int[] getBankItems2() {
        return bankItems2;
    }

    public void setBankItems2(int[] bankItems2) {
        this.bankItems2 = bankItems2;
    }

    public int[] getBankItemsN2() {
        return bankItemsN2;
    }

    public void setBankItemsN2(int[] bankItemsN2) {
        this.bankItemsN2 = bankItemsN2;
    }

    public int[] getBankItems3() {
        return bankItems3;
    }

    public void setBankItems3(int[] bankItems3) {
        this.bankItems3 = bankItems3;
    }

    public int[] getBankItemsN3() {
        return bankItemsN3;
    }

    public void setBankItemsN3(int[] bankItemsN3) {
        this.bankItemsN3 = bankItemsN3;
    }

    public long[] getFriends() {
        return friends;
    }

    public void setFriends(long[] friends) {
        this.friends = friends;
    }

    public long[] getIgnores() {
        return ignores;
    }

    public void setIgnores(long[] ignores) {
        this.ignores = ignores;
    }

}


