public class soundConfig {
    public static int getPlayerBlockSounds(client c) {

        int blockSound = 69;

        if (c.playerEquipment[c.playerChest] == 2499
                || c.playerEquipment[c.playerChest] == 2501
                || c.playerEquipment[c.playerChest] == 2503
                || c.playerEquipment[c.playerChest] == 4746
                || c.playerEquipment[c.playerChest] == 4757
                || c.playerEquipment[c.playerChest] == 10330) {// Dragonhide
            // sound
            blockSound = 24;
        } else if (c.playerEquipment[c.playerChest] == 10551 || // Torso
                c.playerEquipment[c.playerChest] == 10438) {// 3rd age
            blockSound = 32;// Weird sound
        } else if (c.playerEquipment[c.playerChest] == 10338 || // 3rd age
                c.playerEquipment[c.playerChest] == 7399 || // Enchanted
                c.playerEquipment[c.playerChest] == 6107 || // Ghostly
                c.playerEquipment[c.playerChest] == 4091 || // Mystic
                c.playerEquipment[c.playerChest] == 4101 || // Mystic
                c.playerEquipment[c.playerChest] == 4111 || // Mystic
                c.playerEquipment[c.playerChest] == 1035 || // Zamorak
                c.playerEquipment[c.playerChest] == 12971) {// Combat
            blockSound = 14;// Robe sound
        } else if (c.playerEquipment[c.playerShield] == 4224) {// Crystal Shield
            blockSound = 30;// Crystal sound
        } else if (c.playerEquipment[c.playerChest] == 1101
                || // Chains
                c.playerEquipment[c.playerChest] == 1103
                || c.playerEquipment[c.playerChest] == 1105
                || c.playerEquipment[c.playerChest] == 1107
                || c.playerEquipment[c.playerChest] == 1109
                || c.playerEquipment[c.playerChest] == 1111
                || c.playerEquipment[c.playerChest] == 1113
                || c.playerEquipment[c.playerChest] == 1115
                || // Plates
                c.playerEquipment[c.playerChest] == 1117
                || c.playerEquipment[c.playerChest] == 1119
                || c.playerEquipment[c.playerChest] == 1121
                || c.playerEquipment[c.playerChest] == 1123
                || c.playerEquipment[c.playerChest] == 1125
                || c.playerEquipment[c.playerChest] == 1127
                || c.playerEquipment[c.playerChest] == 4720
                || // Barrows armour
                c.playerEquipment[c.playerChest] == 4728
                || c.playerEquipment[c.playerChest] == 4749
                || c.playerEquipment[c.playerChest] == 4712
                || c.playerEquipment[c.playerChest] == 11720
                || // Godwars armour
                c.playerEquipment[c.playerChest] == 11724
                || c.playerEquipment[c.playerChest] == 3140
                || // Dragon
                c.playerEquipment[c.playerChest] == 2615
                || // Fancy
                c.playerEquipment[c.playerChest] == 2653
                || c.playerEquipment[c.playerChest] == 2661
                || c.playerEquipment[c.playerChest] == 2669
                || c.playerEquipment[c.playerChest] == 2623
                || c.playerEquipment[c.playerChest] == 3841
                || c.playerEquipment[c.playerChest] == 1127) {// Metal armour
            // sound
            blockSound = 791;
        } else {
            blockSound = 816;
        }
        return blockSound;
    }
    public static int getWeaponSounds(client c) {
        if (c.playerEquipment[c.playerWeapon] <= 0) {
            return 417;
        }
        if (c.playerEquipment[c.playerWeapon] >= 1) {
            String wep = Item.getItemName(c.playerEquipment[c.playerWeapon]).toLowerCase();


            if (c.playerEquipment[c.playerWeapon] == 4718) {// Dharok's
                // Greataxe
                return 1320;
            }
            if (c.playerEquipment[c.playerWeapon] == 4734) {// Karil's Crossbow
                return 1081;
            }
            if (c.playerEquipment[c.playerWeapon] == 4747) {// Torag's Hammers
                return 1330;
            }
            if (c.playerEquipment[c.playerWeapon] == 4710) {// Ahrim's Staff
                return 2555;
            }
            if (c.playerEquipment[c.playerWeapon] == 4755) {// Verac's Flail
                return 1323;
            }
            if (c.playerEquipment[c.playerWeapon] == 4726) {// Guthan's
                // Warspear
                return 2562;
            }

            if (c.playerEquipment[c.playerWeapon] == 772
                    || c.playerEquipment[c.playerWeapon] == 1379
                    || c.playerEquipment[c.playerWeapon] == 1381
                    || c.playerEquipment[c.playerWeapon] == 1383
                    || c.playerEquipment[c.playerWeapon] == 1385
                    || c.playerEquipment[c.playerWeapon] == 1387
                    || c.playerEquipment[c.playerWeapon] == 1389
                    || c.playerEquipment[c.playerWeapon] == 1391
                    || c.playerEquipment[c.playerWeapon] == 1393
                    || c.playerEquipment[c.playerWeapon] == 1395
                    || c.playerEquipment[c.playerWeapon] == 1397
                    || c.playerEquipment[c.playerWeapon] == 1399
                    || c.playerEquipment[c.playerWeapon] == 1401
                    || c.playerEquipment[c.playerWeapon] == 1403
                    || c.playerEquipment[c.playerWeapon] == 1405
                    || c.playerEquipment[c.playerWeapon] == 1407
                    || c.playerEquipment[c.playerWeapon] == 1409
                    || c.playerEquipment[c.playerWeapon] == 9100) { // Staff
                // wack
                return 394;
            }
            if (c.playerEquipment[c.playerWeapon] == 839
                    || c.playerEquipment[c.playerWeapon] == 841
                    || c.playerEquipment[c.playerWeapon] == 843
                    || c.playerEquipment[c.playerWeapon] == 845
                    || c.playerEquipment[c.playerWeapon] == 847
                    || c.playerEquipment[c.playerWeapon] == 849
                    || c.playerEquipment[c.playerWeapon] == 851
                    || c.playerEquipment[c.playerWeapon] == 853
                    || c.playerEquipment[c.playerWeapon] == 855
                    || c.playerEquipment[c.playerWeapon] == 857
                    || c.playerEquipment[c.playerWeapon] == 859
                    || c.playerEquipment[c.playerWeapon] == 861
                    || c.playerEquipment[c.playerWeapon] == 4734
                    || c.playerEquipment[c.playerWeapon] == 2023 // RuneC'Bow
                    || c.playerEquipment[c.playerWeapon] == 4212
                    || c.playerEquipment[c.playerWeapon] == 4214
                    || c.playerEquipment[c.playerWeapon] == 4934
                    || c.playerEquipment[c.playerWeapon] == 9104
                    || c.playerEquipment[c.playerWeapon] == 9107) { // Bows/Crossbows
                return 370;
            }
            if (c.playerEquipment[c.playerWeapon] == 1363
                    || c.playerEquipment[c.playerWeapon] == 1365
                    || c.playerEquipment[c.playerWeapon] == 1367
                    || c.playerEquipment[c.playerWeapon] == 1369
                    || c.playerEquipment[c.playerWeapon] == 1371
                    || c.playerEquipment[c.playerWeapon] == 1373
                    || c.playerEquipment[c.playerWeapon] == 1375
                    || c.playerEquipment[c.playerWeapon] == 1377
                    || c.playerEquipment[c.playerWeapon] == 1349
                    || c.playerEquipment[c.playerWeapon] == 1351
                    || c.playerEquipment[c.playerWeapon] == 1353
                    || c.playerEquipment[c.playerWeapon] == 1355
                    || c.playerEquipment[c.playerWeapon] == 1357
                    || c.playerEquipment[c.playerWeapon] == 1359
                    || c.playerEquipment[c.playerWeapon] == 1361
                    || c.playerEquipment[c.playerWeapon] == 9109) { // BattleAxes/Axes
                return 399;
            }
            if (c.playerEquipment[c.playerWeapon] == 4718
                    || c.playerEquipment[c.playerWeapon] == 7808) { // Dharok
                // GreatAxe
                return 400;
            }
            if (c.playerEquipment[c.playerWeapon] == 6609
                    || c.playerEquipment[c.playerWeapon] == 1307
                    || c.playerEquipment[c.playerWeapon] == 1309
                    || c.playerEquipment[c.playerWeapon] == 1311
                    || c.playerEquipment[c.playerWeapon] == 1313
                    || c.playerEquipment[c.playerWeapon] == 1315
                    || c.playerEquipment[c.playerWeapon] == 1317
                    || c.playerEquipment[c.playerWeapon] == 1319) { // 2h
                return 425;
            }
            if (wep.contains("scimitar") || wep.contains("longsword")) {
                return 396;
            }
            if (wep.contains("halberd")) {
                return 420;
            }
            if (wep.contains("long")) {
                return 396;
            }
            if (wep.contains("knife")) {
                return 368;
            }
            if (wep.contains("javelin")) {
                return 364;
            }
            if (c.playerEquipment[c.playerWeapon] == 1205 //Daggers
                    || c.playerEquipment[c.playerWeapon] == 1203
                    || c.playerEquipment[c.playerWeapon] == 1207
                    || c.playerEquipment[c.playerWeapon] == 1209
                    || c.playerEquipment[c.playerWeapon] == 1211
                    || c.playerEquipment[c.playerWeapon] == 1213) {
                if (c.fightMode == 0)
                    return 403;
                else
                    return 396;
            }

            if (c.playerEquipment[c.playerWeapon] == 1215) //Dragon Dagger
                return 403;

            if (c.playerEquipment[c.playerWeapon] == 1277 //Swords
                    || c.playerEquipment[c.playerWeapon] == 1279
                    || c.playerEquipment[c.playerWeapon] == 1281
                    || c.playerEquipment[c.playerWeapon] == 1283
                    || c.playerEquipment[c.playerWeapon] == 1285
                    || c.playerEquipment[c.playerWeapon] == 1287
                    || c.playerEquipment[c.playerWeapon] == 1289) {
                if (c.fightMode == 0)
                    return 403;
                else
                    return 396;
            }

            if (c.playerEquipment[c.playerWeapon] == 9110) {
                return 401;
            }
            if (c.playerEquipment[c.playerWeapon] == 4755) {
                return 1059;
            }
            if (c.playerEquipment[c.playerWeapon] == 4153) {
                return 1079;
            }
            if (c.playerEquipment[c.playerWeapon] == 9103) {
                return 385;
            }
            if (c.playerEquipment[c.playerWeapon] == -1) { // fists
                return 417;
            }
            if (c.playerEquipment[c.playerWeapon] == 2745
                    || c.playerEquipment[c.playerWeapon] == 2746
                    || c.playerEquipment[c.playerWeapon] == 2747
                    || c.playerEquipment[c.playerWeapon] == 2748) { // Godswords
                return 390;
            }
            if (c.playerEquipment[c.playerWeapon] == 4151) {
                return 1080;
            }
        }
        return 398;
    }

    public static int specialSounds(int id) {
        if (id == 4151) {// whip
            return 1081;
        } else if (id == 5698 || id == 1231 || id == 1215 || id == 5680) {// dds
            return 385;
        } else if (id == 1434) {// Mace
            return 387;
        } else if (id == 3204) {// halberd
            return 420;
        } else if (id == 4153) { // gmaul
            return 1082;
        } else if (id == 7158) { // d2h
            return 426;
        } else if (id == 4587) { // dscim
            return 1305;
        } else if (id == 1305) { // D Long
            return 390;
        } else if (id == 861 || id == 11235 || id == 859) { // MSB, Darkbow
            return 386;
        } else if (id == 1377) { // DBAxe
            return 389;
        }
        return -1;
    }
}
