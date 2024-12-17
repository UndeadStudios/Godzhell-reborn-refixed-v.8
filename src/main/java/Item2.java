// This file is free software; you can redistribute it and/or modify it under
// the terms of the GNU General Public License version 2, 1991 as published by
// the Free Software Foundation.

// This program is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
// details.

// A copy of the GNU General Public License can be found at:
// http://www.gnu.org/licenses/gpl.html

// a collection of item methods


public class Item2 {
    public static int Runerock[] = {
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.UNCUT_SAPPHIRE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.UNCUT_DIAMOND, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.UNCUT_EMERALD, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.UNCUT_RUBY, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE,
            ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE, ItemIDs.RUNITE_ORE};

    public static int randomRuneRock() {
        return Runerock[(int) (Math.random() * Runerock.length)];
    }

    public static int present[] = {ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 15340, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 15341, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 15342, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 15343, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randompresent() {
        return present[(int) (Math.random() * present.length)];
    }

    public static int flowers[] = {2980, 2981, 2982, 2983, 2984, 2985, 2986, 2987, 2988,};

    public static int randomflowers() {
        return flowers[(int) (Math.random() * flowers.length)];
    }

    public static int balloon[] = {115, 116, 117, 118, 119, 120, 121, 122,};

    public static int randomballoon() {
        return balloon[(int) (Math.random() * balloon.length)];
    }
	
	    public static int corp[] = {ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13734, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13754, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13746, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13748, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13748, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13750, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13752, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,};

    public static int randomcorp() {
        return corp[(int) (Math.random() * corp.length)];
    }

    public static int coalrock[] = {
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.UNCUT_SAPPHIRE, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.UNCUT_DIAMOND, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.UNCUT_EMERALD, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.UNCUT_RUBY, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL,
            ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL, ItemIDs.COAL};

    public static int randomCoalRock() {
        return coalrock[(int) (Math.random() * coalrock.length)];
    }

    public static int daggy[] = {
    	};

    public static int randomdaggy() {
        return daggy[(int) (Math.random() * daggy.length)];
    }

    public static int whiteknight[] = {
    	 ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.WHITE_CLAWS, 6589, 6591, 6599, 6601, 6605, 6607, 6609, 6611, 6613, 6615, 6617, 6619, 6621, 6623, 6625, 6627, 6629, 6631, 6633, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randomwhiteknight() {
        return whiteknight[(int) (Math.random() * whiteknight.length)];
    }
	
	   public static int easteregg[] = {
    	 7928,7929,7930,7931,7932,7933};

    public static int randomeastergg() {
        return easteregg[(int) (Math.random() * easteregg.length)];
    }

    public static int Copperrock[] = {
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.UNCUT_SAPPHIRE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.UNCUT_DIAMOND, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.UNCUT_EMERALD, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.UNCUT_RUBY, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE,
            ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE, ItemIDs.COPPER_ORE};

    public static int randomCopperRock() {
        return Copperrock[(int) (Math.random() * Copperrock.length)];
    }

    public static int Tinrock[] = {
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.UNCUT_SAPPHIRE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.UNCUT_DIAMOND, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.UNCUT_EMERALD, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.UNCUT_RUBY, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE,
            ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE, ItemIDs.TIN_ORE};

    public static int randomTinRock() {
        return Tinrock[(int) (Math.random() * Tinrock.length)];
    }

    public static int Ironrock[] = {
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.UNCUT_SAPPHIRE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.UNCUT_DIAMOND, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.UNCUT_EMERALD, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.UNCUT_RUBY, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE,
            ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE, ItemIDs.IRON_ORE};

    public static int randomIronRock() {
        return Ironrock[(int) (Math.random() * Ironrock.length)];
    }

    public static int Phat[] = {
            ItemIDs.RED_PARTYHAT, ItemIDs.YELLOW_PARTYHAT, ItemIDs.BLUE_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.PURPLE_PARTYHAT,  ItemIDs.WHITE_PARTYHAT, ItemIDs.UNKNOWED_WHITE_PARTYHAT, 14560, 14110, 14111, 14112, 14113, 14114, 14115, 14116, 14117, 14118,};
    public static int randomPhat() {
        return Phat[(int) (Math.random() * Phat.length)];
    }

    public static int Silvchest[] = {601, 758, 788, 983};

    public static int randomSilvchest() {
        return Silvchest[(int) (Math.random() * Silvchest.length)];
    }

    public static int fish[] = {385, 385, 379, 379, 379, 379, 379};

    public static int randomFish() {
        return fish[(int) (Math.random() * fish.length)];
    }

    public static int rat[] = {
    	5698, 1305, 3105, 1725, 1704, 1323, 1153, 1115, 1067, 1081, 1157, 1119,
            1069, 1083};

    public static int randomrat() {
        return rat[(int) (Math.random() * rat.length)];
    }
    
    public static int td[] = {
    	 ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13664, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,15185, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,15195};

public static int randomtd() {
    return td[(int) (Math.random() * td.length)];
}

    public static int barrowchest2[] = {
    	4708, 4710, 4712, 4714, 4716, 4718, 4720, 4722, 4724, 4726, 4728, 4730, 4732, 4734, 4736, 4740, 4745, 4747, 4749, 4751, 4753, 4755, 4757, 4758,};

    public static int randombarrowchest2() {
        return barrowchest2[(int) (Math.random() * barrowchest2.length)];
    }

    public static int well[] = {15195, 15185, 15348, 14520, 15334, 7449, 15346,};

    public static int randomwell() {
        return well[(int) (Math.random() * well.length)];
    }

    public static int soldier[] = {
    	ItemIDs.RUNE_CLAWS, ItemIDs.RUNE_LONGSWORD, ItemIDs.RUNE_HALBERD,
            ItemIDs.RUNE_SCIMITAR, ItemIDs.RUNE_2H_SWORD,  ItemIDs.RUNE_CHAINBODY,
            ItemIDs.RUNE_PLATEBODY, ItemIDs.RUNE_MED_HELM, ItemIDs.RUNE_PLATESKIRT, ItemIDs.RUNE_PLATELEGS,
            ItemIDs.RUNE_BATTLEAXE, ItemIDs.RUNE_BOOTS, ItemIDs.COINS, ItemIDs.RUNE_CROSSBOW, ItemIDs.RUNE_JAVELIN,  ItemIDs.RUNE_KITESHIELD, ItemIDs.RUNE_SQ_SHIELD
            /*ItemIDs.RUNE_KITESHIELD_2, ItemIDs.RUNE_KITESHIELD_3, ItemIDs.RUNE_KITESHIELD_4, ItemIDs.RUNE_KITESHIELD_5, ItemIDs.RUNE_KITESHIELD_6,
            ItemIDs.RUNE_KITESHIELD_7, ItemIDs.RUNE_KITESHIELD_8, ItemIDs.RUNE_KITESHIELD_9, ItemIDs.RUNE_KITESHIELD_10, ItemIDs.RUNE_KITESHIELD_11,
            ItemIDs.RUNE_KITESHIELD_12, ItemIDs.RUNE_KITESHIELD_13, ItemIDs.RUNE_KITESHIELD_14, ItemIDs.RUNE_KITESHIELD_15, ItemIDs.RUNE_KITESHIELD_16, ItemIDs.RUNE_KITESHIELD_17*/
    };

    public static int randomsoldier() {
        return soldier[(int) (Math.random() * soldier.length)];
    }

    public static int bluedragon[] = {
    	2957, 1050, 14242, 4039, 14238, 14239, 14240, 14241, 14242, 1959, 6857,  6082, 4084, 2526, 6861, 7399, 7398, 2651, 6859, 4565, 7594, 10014, 6863, 2524, 4702, 7400};

    public static int randombluedragon() {
        return bluedragon[(int) (Math.random() * bluedragon.length)];
    }


    public static int MossGiants[] = {
    	1179, 1141, 1193, 1389, 1243, 1285, 199, 201, 203, 205, 207, 209, 211, 213, 215, 217, 219, 556, 562, 557, 561, 563, 562, 560, 5323, 5104, 5311, 5292, 5293, 5294, 5281, 5100, 5296, 5105, 5282, 4206, 5298, 5280, 5297, 5299, 5106, 5295, 5301, 5302, 5321, 5300, 5304, 5303};

public static int randomMossGiants() {
    return MossGiants[(int) (Math.random() * MossGiants.length)];
}
    public static int irondragon[] = {
    	2351, 2351, 2351, 2351, 6750, 2351, 2351, 2351, 2351, 6752, 2351, 2351, 2351, 2351};

    public static int randomirondragon() {
        return irondragon[(int) (Math.random() * irondragon.length)];
    }

    public static int ogre[] = {837, 5018, ItemIDs.COINS};

    public static int randomogre() {
        return ogre[(int) (Math.random() * ogre.length)];
    }

    public static int chicken[] = {834, ItemIDs.PRESENT};

    public static int randomchicken() {
        return chicken[(int) (Math.random() * chicken.length)];
    }

    public static int Partyroom[] = {ItemIDs.RED_PARTYHAT, ItemIDs.YELLOW_PARTYHAT, ItemIDs.BLUE_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.PURPLE_PARTYHAT,
            ItemIDs.WHITE_PARTYHAT, 1050, 4716, 4718, 4720, 4722, 746, 667, 2402, 14507, 14508, 14511,
            2633, 2635, 2637, 2978, 2980, 2982, 2984, 2986, 2988, 2990, 2992, 2994,
            2957, 2653, 2655, 2659, 3478, 2665, 2661, 2663, 2667, 3479, 2673, 2669,
            2671, 3480, 35, 278, 426, 428, 1475, 4724, 4728, 4730, 4726, 6570, 1037, 1050, 6857, 6859, 6861,
            6863, 6856, 6858, 6860, 6862, 6818, 2591, 2593, 2595, 2597, 2607,
            2609, 2611, 2613, 2615, 2617, 2619, 2621, 3473, 3475, 3476, 3669, 3671,
            3672, 9004, 7319, 7321, 7323, 7325, 7327, 5527, 5529, 5531, 5533, 5535,
            5537, 5539, 5541, 5543, 5545, 5547, 5549, 5551};

    public static int randomPartyroom() {
        return Partyroom[(int) (Math.random() * Partyroom.length)];
    }
    public static int mbox[] = {ItemIDs.RED_PARTYHAT, ItemIDs.YELLOW_PARTYHAT, ItemIDs.BLUE_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.PURPLE_PARTYHAT,
            ItemIDs.WHITE_PARTYHAT, 1050, 4716, 4718, 4720, 4722, 746, 667, 2402, 14507, 14508, 14511,
            2633, 2635, 2637, 2978, 2980, 2982, 2984, 2986, 2988, 2990, 2992, 2994,
            2957, 2653, 2655, 2659, 3478, 2665, 2661, 2663, 2667, 3479, 2673, 2669,
            2671, 3480, 35, 278, 426, 428, 1475, 4724, 4728, 4730, 4726, 6570, 1037, 1050, 6857, 6859, 6861,
            6863, 6856, 6858, 6860, 6862, 6818, 2591, 2593, 2595, 2597, 2607,
            2609, 2611, 2613, 2615, 2617, 2619, 2621, 3473, 3475, 3476, 3669, 3671,
            3672, 9004, 7319, 7321, 7323, 7325, 7327, 5527, 5529, 5531, 5533, 5535,
            5537, 5539, 5541, 5543, 5545, 5547, 5549, 5551, ItemIDs.A_POWDERED_WIG, ItemIDs.FLARED_TROUSERS, ItemIDs.PANTALOONS, ItemIDs.SLEEPING_CAP, ItemIDs.BLACK_ELEGANT_SHIRT, ItemIDs.BLACK_ELEGANT_LEGS, ItemIDs.RED_ELEGANT_SHIRT, ItemIDs.RED_ELEGANT_LEGS, ItemIDs.BLUE_ELEGANT_SHIRT, ItemIDs.BLUE_ELEGANT_LEGS, ItemIDs.GREEN_ELEGANT_SHIRT, ItemIDs.GREEN_ELEGANT_LEGS, ItemIDs.PURPLE_ELEGANT_SHIRT, ItemIDs.PURPLE_ELEGANT_LEGS, ItemIDs.WHITE_ELEGANT_BLOUSE, ItemIDs.WHITE_ELEGANT_SKIRT, ItemIDs.RED_ELEGANT_BLOUSE, ItemIDs.RED_ELEGANT_SKIRT, ItemIDs.BLUE_ELEGANT_BLOUSE, ItemIDs.BLUE_ELEGANT_SKIRT, ItemIDs.GREEN_ELEGANT_BLOUSE, ItemIDs.GREEN_ELEGANT_SKIRT, ItemIDs.PURPLE_ELEGANT_BLOUSE, ItemIDs.PURPLE_ELEGANT_SKIRT};

    public static int randommbox() {
        return mbox[(int) (Math.random() * mbox.length)];
    }

    public static int skeleton[] = {
    	6137, 6139, 6141,  ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randomskeleton() {
        return skeleton[(int) (Math.random() * skeleton.length)];
    }

    public static int crawlinghand[] = {
    	2615, ItemIDs.RUNE_SCIMITAR, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526};

    public static int randomcrawlinghand() {
        return crawlinghand[(int) (Math.random() * crawlinghand.length)];
    }

    public static int Keys[] = {
            5698, 1305, 3105, 1725, 1704, 1323, 1153, 1115, 1067, 1081, 1157, 1119,
            1069, 1083, ItemIDs.RUNE_CLAWS, ItemIDs.RUNE_LONGSWORD, ItemIDs.RUNE_HALBERD, ItemIDs.RUNE_SCIMITAR, ItemIDs.RUNE_2H_SWORD, ItemIDs.RUNE_CHAINBODY, ItemIDs.RUNE_PLATEBODY, ItemIDs.RUNE_MED_HELM, ItemIDs.RUNE_PLATESKIRT, ItemIDs.RUNE_PLATELEGS,
            ItemIDs.RUNE_BATTLEAXE, ItemIDs.RUNE_BOOTS, 2957, 1050, 4039, 1959, 6857, 6082, 4084, 2526, 6861,
            7399, 7398, 2651, 6859, 4565, 7594, 10014, 6863, 2524, 4702, 7400, ItemIDs.RED_PARTYHAT,
            ItemIDs.YELLOW_PARTYHAT, ItemIDs.BLUE_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.PURPLE_PARTYHAT, ItemIDs.WHITE_PARTYHAT, 1050, 15334, 15336, 15333, 15335, 4716, 4718, 4720, 4722,
            14507, 14508, 14511, 2633, 2635, 2637, 2978, 2980, 2982, 2984, 2986, 2988, 2990, 2992, 2994,
            2957, 2653, 2655, 2659, 3478, 2665, 2661, 2663, 2667, 3479, 2673, 2669,
            2671, 3480, 4724, 4728, 4730, 4726, 6570, 1037, 1050, 6857, 6859, 6861,
            6863, 6856, 6858, 6860, 6862, 6818, 4119, 4121, 4123, 4125, 4127, 4129, ItemIDs.RUNE_BOOTS, 1725, 1704,
            ItemIDs.RED_PARTYHAT, 3105, 1305, 5698, 4587, 4726, 7386, 7394, 7390, 1037, 1989, 6666, 2944, 6779, 9093,
            8013, 8014, 8015, 8016, 8017, 8018, 8019, 4565, 1959, 1053, 1055, 1057, ItemIDs.BLUE_PARTYHAT, ItemIDs.YELLOW_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.RED_PARTYHAT, ItemIDs.PURPLE_PARTYHAT, 1050, 1641, 2633, 2635, 2637, 2978, 2980, 2982, 2984, 2986, 2988, 2990, 2992, 2994,
            2957, 2653, 2655, 2659, 3478, 2665, 2661, 2663, 2667, 3479, 2673, 2669,
            2671, 3480, 4724, 4728, 4730, 4726, 6570, 1037, 1050, 6857, 6859, 6861,
            6863, 6856, 6858, 6860, 6862, 6818, 1641, ItemIDs.RED_PARTYHAT, ItemIDs.YELLOW_PARTYHAT, ItemIDs.BLUE_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.PURPLE_PARTYHAT, ItemIDs.WHITE_PARTYHAT, 8000, 10560};

    public static int randomKeys() {
        return Keys[(int) (Math.random() * Keys.length)];
    }

    public static int cavebug[] = {
    	4119, 4121, 4123, 4125, 4127, 4129, ItemIDs.RUNE_BOOTS, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526};

    public static int randomcavebug() {
        return cavebug[(int) (Math.random() * cavebug.length)];
    }

    public static int jelly[] = {
    	14860, 6809, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526};

    public static int randomjelly() {
        return jelly[(int) (Math.random() * jelly.length)];
    }

    public static int aberrantspecter[] = {
    	3840, 3842, 3844, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526};

    public static int randomaberrantspecter() {
        return aberrantspecter[(int) (Math.random() * aberrantspecter.length)];
    }

    public static int abyssaldemon[] = {
    	4151, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526};

    public static int randomabyssaldemon() {
        return abyssaldemon[(int) (Math.random() * abyssaldemon.length)];
    }

    public static int darkbeast[] = {
    	6818, 11192, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526, 526,
            526, 526, 526, 526, 526, 526, 526, 526};

    public static int randomdarkbeast() {
        return darkbeast[(int) (Math.random() * darkbeast.length)];
    }

    public static int barbarian[] = {
    	1725, 1704, ItemIDs.RED_PARTYHAT, 3105, 1305, 5698, 4587,  4726, 7386,  7394, 7390, ItemIDs.COINS};

    public static int randombarbarian() {
        return barbarian[(int) (Math.random() * barbarian.length)];
    }

    public static int fishy[] = {
    	 ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 35, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 773, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randomfishy() {
        return fishy[(int) (Math.random() * fishy.length)];
    }

    public static int Dagannoths[] = {
    	1037, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 1989, 6666, 2944, 6779, 9093,  8013, 8014, 13444, 13445, 13446, 13447, 13448, 13449, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13450, 13451, 13452, 13453, 13454, 13455, 13456, 13457, 13558, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 13459, 13460, 13461, 13462, 13463, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,13464, 13465, 13466, 13467, 13468, 13469, 13470, 13471, 13472, 13473, 13474, 13475, 13476, 13477, 13478, 13479, 13480, 13481, 8015, 8016, 8017, 8018, 8019, 4565, 1959, 1053, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, 1055, 1057, ItemIDs.BLUE_PARTYHAT, ItemIDs.YELLOW_PARTYHAT, ItemIDs.GREEN_PARTYHAT, ItemIDs.RED_PARTYHAT, ItemIDs.PURPLE_PARTYHAT, 1050};

    public static int randomDagannoths() {
        return Dagannoths[(int) (Math.random() * Dagannoths.length)];
    }

    public static int unicorn[] = {
    	6966, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randomunicorn() {
        return unicorn[(int) (Math.random() * unicorn.length)];
    }

    public static int battlemagesara[] = {
    	14507, 14508, 14513, 5698, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randombattlemagesara() {
        return battlemagesara[(int) (Math.random() * battlemagesara.length)];
    }

    public static int battlemagezammy[] = {
    	14507, 14508, 14512, 5698, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randombattlemagezammy() {
        return battlemagezammy[(int) (Math.random() * battlemagezammy.length)];
    }

    public static int battlemageguthix[] = {
    	14507, 14508, 14511, 5698, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randombattlemageguthix() {
        return battlemageguthix[(int) (Math.random() * battlemageguthix.length)];
    }

    public static int troll[] = {
    	3741, 3741, 3741, 3741, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS,
            ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS, ItemIDs.COINS};

    public static int randomtroll() {
        return troll[(int) (Math.random() * troll.length)];
    }

    public static int KQ[] = {
            2633, 2635, 2637, 2978, 2980, 2982, 2984, 2986, 2988, 2990, 2992, 2994,
            2957, 2653, 2655, 2659, 3478, 2665, 2661, 2663, 2667, 3479, 2673, 2669,
            2671, 3480, 4724, 4728, 4730, 4726, 6570, 1037, 1050, 6857, 6859, 6861,
            6863, 6856, 6858, 6860, 6862,  6818};

    public static int randomKQ() {
        return KQ[(int) (Math.random() * KQ.length)];
    }

    public static int Jogre[] = {4587,  15352, 7158,  1149, 4151, 5698, 1377, 1305, 1434};

    public static int randomJogre() {
        return Jogre[(int) (Math.random() * Jogre.length)];
    }

    public static int Ice_giant[] = {1543,  1546, 1545, 1548};

    public static int randomIce_giant() {
        return Ice_giant[(int) (Math.random() * Ice_giant.length)];
    }

    public static int Dagannoth_Rex[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 15348, 15349, 532, 532, 532};

    public static int randomDagannoth_Rex() {
        return Dagannoth_Rex[(int) (Math.random() * Dagannoth_Rex.length)];
    }

    public static int Dagannoth_Prime[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 15350, 15334, 532, 532, 532};

    public static int randomDagannoth_Prime() {
        return Dagannoth_Prime[(int) (Math.random() * Dagannoth_Prime.length)];
    }

    public static int Dagannoth_Supreme[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 15185, 15195, 532, 532, 532};

    public static int randomDagannoth_Supreme() {
        return Dagannoth_Supreme[(int) (Math.random() * Dagannoth_Supreme.length)];
    }

    public static int Flambeed[] = {6104, 991};

    public static int randomFlambeed() {
        return Flambeed[(int) (Math.random() * Flambeed.length)];
    }

    public static int Black_Demon[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 14503, 14505, 14504, 532, 532, 532};

    public static int randomBlack_Demon() {
        return Black_Demon[(int) (Math.random() * Black_Demon.length)];
    }

    public static int Skeleton_Hellhound[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 14507, 14506, 14508, 14509, 532, 532, 532};

    public static int randomSkeleton_Hellhound() {
        return Skeleton_Hellhound[(int) (Math.random() * Skeleton_Hellhound.length)];
    }

    public static int Agrith_Naar[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 7449, 3140, 532, 532, 532};

    public static int randomAgrith_Naar() {
        return Agrith_Naar[(int) (Math.random() * Agrith_Naar.length)];
    }


    public static int Arzinian_Being_of_Bordanzan[] = {532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 532, 15345, 14521, 15346, 532, 532, 532};

    public static int randomArzinian_Being_of_Bordanzan() {
        return Arzinian_Being_of_Bordanzan[(int) (Math.random() * Arzinian_Being_of_Bordanzan.length)];
    }

    public static int KBD[] = {15352, 15334, 4585, 14519, 4087, 15195};

    public static int randomKBD() {
        return KBD[(int) (Math.random() * KBD.length)];
    }
}
