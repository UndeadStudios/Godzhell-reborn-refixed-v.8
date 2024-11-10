public class Herblore {
    client c;

    //unidHerb ID, identifiedHerbId, level req, exp
    int[][] unidHerbInfo = {
            //Guam
            {199, 249, 1, 3},
            //Marrentill
            {201, 251, 5, 4},
            //Tarromin
            {203, 253, 11, 5},
            //Harralander
            {205, 255, 20, 6},
            //Ranarr
            {207, 257, 25, 8},
            //Toadflax
            {3049, 2998, 30, 8},
            //Irit leaf
            {209, 259, 40, 9},
            //Avantoe
            {211, 261, 48, 10},
            //Kwuarm
            {213, 263, 54, 11},
            //Snapdragon
            {3051, 3000, 59, 12},
            //Cadantine
            {215, 265, 65, 13},
            //Lantadyme
            {2485, 2481, 67, 13},
            //Dwarf weed
            {217, 267, 70, 14},
            //Torstol
            {219, 269, 75, 15}};

    //identifiedHerbID, 1dosepotID, 2dosepotID, 3dosepotID, 4dosepotID, secondary ingredient, level req, exp
    int[][] herbInfo = {
            //Guam - attack pot
            {249, 125, 123, 121, 2428, 1, 25},
            //Marrentill - antipoision
            {251, 179, 177, 175, 2446, 5, 38},
            //Tarromin - str pot
            {253, 119, 117, 115, 113, 12, 50},
            //Harralander - restore pot
            {255, 131, 129, 127, 2430, 22, 63},
            //Ranarr - prayer pot
            {257, 143, 141, 139, 2434, 38, 88},
            //Avantoe - super energy
            {261, 3022, 3020, 3018, 3016, 40, 100},
            //Irit leaf - super attack
            {259, 149, 147, 145, 2436, 45, 100},
            //Kwuarm - super str
            {263, 161, 159, 157, 2440, 55, 125},
            //Snapdragon - super restore
            {3000, 3030, 3028, 3026, 3024, 63, 143},
            //Cadantine - super def
            {265, 167, 165, 163, 2442, 66, 155},
            //Lantadyme - antifire
            {2481, 2458, 2456, 2454, 2452, 69, 158},
            //Dwarf weed - range pot
            {267, 173, 171, 169, 2444, 72, 163},
            //Torstol - zamorak brew
            {269, 193, 191, 189, 2450, 78, 175},
            //Toadflax - saradomin brew
            {2998, 6691, 6689, 6687, 6685, 81, 180}
    };

    public Herblore(client c) {
        this.c = c;
    }

    //making the actual potion
    public void makePot(int itemUsed, int itemUsedOn) {
        boolean item1IsHerb = isHerb(itemUsed);
        boolean item2IsHerb = isHerb(itemUsedOn);

        //finding the herb index so you know which array in 'herbInfo' to use
        int herbIndex = -1;
        if (item1IsHerb) {
            herbIndex = getHerbIndex(itemUsed);
        }
        if (item2IsHerb) {
            herbIndex = getHerbIndex(itemUsedOn);
        }

        //if the first item is a herb and the second is water, or vice versa
        if ((isHerb(itemUsed) && itemUsedOn == 227) || (itemUsed == 227 && isHerb(itemUsedOn))) {
            //make sure the player has the required level to make the pot
            if (c.playerLevel[15] >= herbInfo[herbIndex][5]) {
                c.setAnimation(1652);
                c.deleteItem(itemUsed, c.getItemSlot(itemUsed), 1);
                c.deleteItem(itemUsedOn, c.getItemSlot(itemUsedOn), 1);
                c.addItem(herbInfo[herbIndex][3], 1);
                c.addSkillXP(herbInfo[herbIndex][5], 15);
                c.sM("You make the potion.");
            } else {
                c.sM("You must have a Herblore level of " + herbInfo[herbIndex][5] + " to make this potion.");
            }
            //if the items being used are pots
        } else if (getDose(itemUsed) > 0 && getDose(itemUsedOn) > 0) {
            int dose1 = getDose(itemUsed), index = -1, dose2 = getDose(itemUsedOn);
            for (int i = 0; i < herbInfo.length; i++) {
                if (itemUsed == herbInfo[i][dose1]) {
                    index = i;
                }
            }
            if (itemUsedOn == herbInfo[index][dose2]) {
                decant(dose1, dose2, index);
            }
        }
    }

    //decants the potions used. Parameters are the dose of the first pot,
    //the dose of the second potion, and the index
    //of the herbInfo array where the potion is
    public void decant(int dose1, int dose2, int index) {
        int pot = dose1 + dose2, itemUsed = herbInfo[index][dose1],
                itemUsedOn = herbInfo[index][dose2];
        if (pot > 4) {
            //if the player tries to use a 3 dose pot on another 3 dose pot
            if (dose1 == dose2) {
                c.deleteItem(itemUsed, c.getItemSlot(itemUsed), 1);
                c.deleteItem(itemUsedOn, c.getItemSlot(itemUsedOn), 1);
                c.addItem(herbInfo[index][dose1 + 1], 1);
                c.addItem(herbInfo[index][dose2 - 1], 1);
                c.sM("You mix the two potions.");
            } else {
                //if the player uses a 3 dose pot on a 2 dose
                c.deleteItem(itemUsed, c.getItemSlot(itemUsed), 1);
                c.deleteItem(itemUsedOn, c.getItemSlot(itemUsedOn), 1);
                //if the first pot is 3 and the second is 2
                if (dose1 > dose2) {
                    c.addItem(herbInfo[index][dose1 + 1], 1);
                    c.addItem(herbInfo[index][dose2 - 1], 1);
                } else {
                    //if the first is 2 and the second is 3
                    c.addItem(herbInfo[index][dose2 + 1], 1);
                    c.addItem(herbInfo[index][dose1 - 1], 1);
                }
            }
        }
        if (pot <= 4 && pot > 0) {
            c.deleteItem(itemUsed, c.getItemSlot(itemUsed), 1);
            c.deleteItem(itemUsedOn, c.getItemSlot(itemUsedOn), 1);
            c.addItem(herbInfo[index][pot], 1);
            c.addItem(229, 1);
            c.sM("You mix the potions into " + pot + " doses.");
        }
    }

    public void identify(int item) {
        //checking whether the herb is unidentified
        if (isUnid(item)) {
            int index = 0;
            //finding which herb to use
            for (int i = 0; i < unidHerbInfo.length; i++) {
                if (item == unidHerbInfo[i][0])
                    index = i;
            }
            //checking whether the player has the req level to identify the herb
            //if so, delete the unid, add the identified herb, give the player herblore xp,
            //and send the message "you identify the herb"
            if (c.playerLevel[15] >= unidHerbInfo[index][2]) {
                c.deleteItem(item, 1);
                c.addItem(unidHerbInfo[index][1], 1);
                c.addSkillXP(unidHerbInfo[index][3], 15);
                c.sM("You identify the herb.");
            } else {
                c.sM("You must have a Herblore level of " + unidHerbInfo[index][2] + "to identify this herb.");
            }
        }
    }

    //determines whether the item is a potion. If it is, return the dose
    public int getDose(int item) {
        String itemName = c.getItemName(item);
        if (itemName.contains("(3)"))
            return 3;
        else if (itemName.contains("(2)"))
            return 2;
        else if (itemName.contains("(1)"))
            return 1;
        else return -1;
    }

    //checking if the item is an identified herb
    public boolean isHerb(int item) {
        for (int i = 0; i < herbInfo.length; i++) {
            if (item == herbInfo[i][0])
                return true;
        }
        return false;
    }

    //checking if the item is an UNidentified herb
    public boolean isUnid(int item) {
        for (int i = 0; i < unidHerbInfo.length; i++) {
            if (item == unidHerbInfo[i][0]) {
                return true;
            }
        }
        return false;
    }

    //gets the herb-array so we know which index to use to get the exp, level req, etc
    public int getHerbIndex(int herb) {
        for (int i = 0; i < herbInfo.length; i++) {
            if (herb == herbInfo[i][0]) {
                return i;
            }
        }
        return -1;
    }

}