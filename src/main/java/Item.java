// a collection of item methods
import java.io.*;


public class Item {

    // Few item types for equipping
	public static int capes[] = {2731,2677,2683,2680,2701,2686,2689,2692,2737,2734,2716,2728,2695,2713,2725,2722,2707,2704,2710,2719,2737,2698,14590,2701,8102, 8075, 8044, 8045, 8042, 8043, 8037, 8038, 8025, 8026, 8018, 7858, 7994, 7983, 7984, 7985, 7986, 7987, 7982, 7978, 3781, 3783, 3785, 3787, 3789, 3777, 3779, 3759, 3761, 3763, 3765, 6111, 6570, 6568, 1007, 1019, 1021, 1023, 1027, 1029, 1031, 1052, 2412, 2413, 2414, 4304, 4315, 4317, 4319, 4321, 4323, 4325, 4327, 4329, 4331, 4333, 4335, 4337, 4339, 4341, 4343, 4345, 4347, 4349, 4351, 4353, 4355, 4357, 4359, 4361, 4363, 4365, 4367, 4369, 4371, 4373, 4375, 4377, 4379, 4381, 4383, 4385, 4387, 4389, 4391, 4393, 4395, 4397, 4399, 4401, 4403, 4405, 4407, 4409, 4411, 4413, 4514, 4516, 6070, 6568, 6570, 19111};
    public static int boots[] = {7596, 8029, 6619, 8017, 7159, 7991, 6666, 6061, 6106, 88, 89, 626, 628, 630, 632, 634, 1061, 1837, 1846, 2577, 2579, 2894, 2904, 2914, 2924, 2934, 3061, 3105, 3107, 3791, 4097, 4107, 4117, 4119, 4121, 4123, 4125, 4127, 4129, 4131, 4310, 5064, 5345, 5557, 6069, 6106, 6143, 6145, 6147, 6328, 6920, 6349, 6357, 3393};
    public static int gloves[] = {7595, 6629, 8021, 8016, 7964, 2491, 1065, 2487, 2489, 3060, 1495, 775, 777, 778, 6708, 1059, 1063, 1065, 1580, 2487, 2489, 2491, 2902, 2912, 2922, 2932, 2942, 3060, 3799, 4095, 4105, 4115, 4308, 5556, 6068, 6110, 6149, 6151, 6153, 6922, 7454, 7455, 7456, 7457, 7458, 7459, 7460, 7461, 7462, 6330, 3391};
    public static int shields[] = {7676,7053,7342, 7348, 7354, 7360, 7334, 7340, 7347, 7352, 7358, 7356, 7350, 7344, 8087, 8058, 8059, 8060, 8061, 8062, 8063, 6633, 7977, 7976, 7972, 7959, 6591, 7332, 7338, 7336, 7360, 1171, 1173, 1175, 1177, 1179, 1181, 1183, 1185, 1187, 1189, 1191, 1193, 1195, 1197, 1199, 1201, 1540, 2589, 2597, 2603, 2611, 2621, 2629, 2659, 2667, 2675, 2890, 3122, 3488, 3758, 3839, 3840, 3841, 3842, 3843, 3844, 4072, 4156, 4224, 4225, 4226, 4227, 4228, 4229, 4230, 4231, 4232, 4233, 4234, 4302, 4507, 4512, 6215, 6217, 6219, 6221, 6223, 6225, 6227, 6229, 6231, 6233, 6235, 6237, 6239, 6241, 6243, 6245, 6247, 6249, 6251, 6253, 6255, 6257, 6259, 6261, 6263, 6265, 6267, 6269, 6271, 6273, 6275, 6277, 6279, 6524, 6889};
    public static int hats[] = {2679,2685,2682,2703,2688,2691,2691,2733,2736,2718,2730,2697,2715,2727,2724,2709,2706,2712,2721,2739,2700,2518,2524,2526,7319, 7321, 7323, 7325, 7327, 1167, 8077, 8076, 8074, 4168, 1169, 8034, 8035, 8036, 8030, 6623, 8024, 8023, 8022, 8013, 1169, 7594, 7995, 7996, 7997, 7998, 7999, 8000, 8001, 7992, 7990, 7975, 7973, 7971, 7967, 7963, 6665, 6665, 7321, 6886, 6547, 6548, 2645, 2647, 2649, 4856, 4857, 4858, 4859, 4880, 4881, 4882, 4883, 4904, 4905, 4906, 4907, 4928, 4929, 4930, 4931, 4952, 4953, 4954, 4955, 4976, 4977, 4978, 4979, 4732, 4753, 4611, 6188, 6182, 4511, 4056, 4071, 4724, 2639, 2641, 2643, 2665, 6109, 5525, 5527, 5529, 5531, 5533, 5535, 5537, 5539, 5541, 5543, 5545, 5547, 5549, 5551, 74, 579, 656, 658, 660, 662, 664, 740, 1017, 1037, 1040, 1042, 1044, 1046, 1038,1048, 1050, 1053, 1055, 1057, 1137, 1139, 1141, 1143, 1145, 1147, 1149, 1151, 1153, 1155, 1157, 1159, 1161, 1163, 1165, 1506, 1949, 2422, 2581, 2587, 2595, 2605, 2613, 2619, 2627, 2631, 2633, 2635, 2637, 2651, 2657, 2673, 2900, 2910, 2920, 2930, 2940, 2978, 2979, 2980, 2981, 2982, 2983, 2984, 2985, 2986, 2987, 2988, 2989, 2990, 2991, 2992, 2993, 2994, 2995, 3057, 3385, 3486, 3748, 3749, 3751, 3753, 3797, 4041, 4042, 4071, 4089, 3755, 4099, 4109, 4164, 4302, 4506, 4511, 4513, 4515, 4551, 4567, 4708, 4716, 4724, 4745, 4753, 4857, 4858, 4859, 4880, 4881, 4882, 4883, 4904, 4905, 4906, 4907, 4952, 4953, 4954, 4955, 4976, 4977, 4978, 4979, 5013, 5014, 5554, 5574, 6109, 6128, 6131, 6137, 6182, 6188, 6335, 6337, 6339, 6345, 6355, 6365, 6375, 6382, 6392, 6400, 6918, 6656, 2581, 7539, 7394, 7396, 7534, 5574, 6885, 6858, 6860, 6862, 6856, 6326, 6128, 6137, 7400, 7323, 7325, 7327, 7003};
    public static int amulets[] = {1654, 1656, 1658, 1660, 1662, 1664, 8081, 8033, 7968, 6585, 86, 87, 295, 421, 552, 589, 1478, 1692, 1694, 1696, 1698, 1700, 1702, 1704, 1706, 1708, 1710, 1712, 1725, 1727, 1729, 1731, 4021, 4081, 4250, 4677, 6040, 6041, 6208, 1718, 1722, 6859, 6863, 6857};
    public static int arrows[] = {11212,8052,9211,9010,9209,9208,9207,9206,9205,9203,9301, 8065, 7919, 7906, 7988, 7989, 78, 598, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 942, 2532, 2533, 2534, 2535, 2536, 2537, 2538, 2539, 2540, 2541, 2866, 4160, 4172, 4173, 4174, 4175, 4740, 5616, 5617, 5618, 5619, 5620, 5621, 5622, 5623, 5624, 5625, 5626, 5627, 6061, 6062};
    public static int rings[] = {8082, 773, 1635, 1637, 1639, 1641, 1643, 1645, 2550, 2552, 2554, 2556, 2558, 2560, 2562, 2564, 2566, 2568, 2570, 2572, 4202, 4657, 6465, 6737, 6731, 6735, 6735, 6583, 6733};
    public static int body[] = {7608,2520,430,7362, 7364, 636, 638, 640, 642, 644, 8064, 426, 1005, 1757, 7592, 8031, 8027, 6617, 8019, 8014, 8002, 7376, 544, 7372, 7370, 577, 7974, 7970, 7965, 7961, 7960, 3793, 3775, 3773, 3771, 3769, 3767, 6139, 1135, 2499, 2501, 1035, 540, 5553, 4757, 1833, 6388, 6384, 4111, 4101, 4091, 6186, 6184, 6180, 3058, 4509, 4504, 4069, 4728, 4736, 4712, 6107, 2661, 3140, 1101, 1103, 1105, 1107, 1109, 1111, 1113, 1115, 1117, 1119, 1121, 1123, 1125, 1127, 1129, 1131, 1133, 2583, 2591, 2599, 2607, 2615, 2623, 2653, 2669, 3481, 4712, 4720, 4728, 4749, 4892, 4893, 4894, 4895, 4916, 4917, 4918, 4919, 4964, 4965, 4966, 4967, 6107, 6133, 6322, 6322, 6129, 75, 6916, 6916, 4111, 6654, 6654, 75, 7399, 7390, 7374, 5575, 2503, 6341, 6351, 3387, 5030, 5032, 5034, 5030, 5032, 5034, 7392, 546};
    public static int legs[] = {7609, 19545, 19489, 2522,7378, 7380, 7382, 7368, 7366, 7388, 646, 648, 650, 652, 654, 428, 1097, 1095, 7593, 8032, 8028, 6625, 8020, 8015, 7384, 7969, 7966, 7962, 6141, 1835, 538, 1033, 5555, 4759, 6386, 6390, 2497, 2495, 2493, 1099, 4113, 4103, 4093, 6924, 6187, 6185, 6181, 3059, 4510, 4505, 4070, 6108, 538, 542, 548, 1011, 1013, 1015, 1067, 1069, 1071, 1073, 1075, 1077, 1079, 1081, 1083, 1085, 1087, 1089, 1091, 1093, 2585, 2593, 2601, 2609, 2617, 2625, 2655, 2663, 2671, 3059, 3389, 3472, 3473, 3474, 3475, 3476, 3477, 3478, 3479, 3480, 3483, 3485, 3795, 4087, 4585, 4712, 4714, 4722, 4730, 4738, 4751, 4759, 4874, 4875, 4876, 4877, 4898, 4899, 4900, 4901, 4922, 4923, 4924, 4925, 4946, 4947, 4948, 4949, 4970, 4971, 4972, 4973, 4994, 4995, 4996, 4997, 5048, 5050, 5052, 5576, 6107, 6130, 6187, 6390, 6386, 6390, 6396, 6404, 6135, 6809, 6916, 4091, 4111, 6655, 6654, 7398, 7398, 7386, 6324, 6343, 6353, 3387, 5036, 5038, 5040};
    public static int platebody[] = {19490, 19546, 13944,13911,10338,7608,2520,430,636, 638, 640, 642, 644, 426, 8031, 8027, 6617, 8019, 8014, 8002, 544, 577, 7974, 7970, 7965, 7961, 7960, 3793, 3773, 3775, 3771, 3769, 3767, 6139, 1035, 540, 5553, 4757, 1833, 1835, 6388, 6384, 4111, 4101, 4868, 4869, 4870, 4871, 4892, 4893, 4894, 4895, 4916, 4917, 4918, 4919, 4940, 4941, 4942, 4943, 4964, 4965, 4966, 4967, 4988, 4989, 4990, 0x2f9a0eb, 6186, 6184, 6180, 3058, 4509, 4504, 4069, 4728, 4736, 4712, 6107, 2661, 3140, 1115, 1117, 1119, 1121, 1123, 1125, 1127, 2583, 2591, 2599, 2607, 2615, 6322, 2623, 2653, 2669, 3481, 4720, 4728, 4749, 2661, 6129, 6916, 4091, 6654, 6133, 75, 7399, 7390, 5575, 6341, 6351, 3387, 5030, 5032, 5034, 7392};
    
	/* Fullbody is an item that covers your arms. */
    private static String[] fullbody = {"vesta's chainbody", "Ladies chainbody", "Torva platebody", "top", "shirt", "platebody", "ahrims robetop","karils leathertop"," brassard", "robe top", "robetop", "platebody (t)",
										"platebody (g)", "Owner Plate", "chestplate"," torso", "Torso", "hauberk", "dragon chainbody", "pernix", "morrigan"};
    /* Fullhat covers your head but not your beard. */
    private static String[] fullhat = {"splitbark helm", "mystic", "black mask", "highwayman mask", "mime mask",
            "facemask", "Virtus mask", "Pernix cowl", "ironman helm", "grim reaper", "Headless head", "imp mask", "mage hat", "med helm", "coif",
            "Dharok's helm", "hood", "Initiate helm", "Coif", "Helm of neitiznot", "Armadyl helmet", "Berserker helm",
            "Archer helm", "Farseer helm", "Warrior helm", "Void", "reindeer", "cowl", "Void ranger helm",
            "Blacksmith's_helm", "black mask", "kandarin headgear", "Robin hood hat",
            "pith helmet", "spiny helmet", "gold helmet", "mining helmet", "camo helmet", "crab helmet",
            "3rd age full helmet", "dwarven helmet", "kandarin headgear", "camo"};
    /* Fullmask covers your entire head. */
    private static String[] fullmask = {"Star-face","helm", "helmet_imbued", "helm_(g)", "Bronze_full_helm", "Iron_full_helm",
            "Mithril_full_helm", "helm_(t)", "full_helm(g)", "full", "heraldic", "heraldic_helm", "full_helm",
            "Verac's_helm", "Guthan's_helm", "Karil's_coif", "ween mask", "Torag's_helm", "Void", "sallet",
            "slayer helmet", "Void_ranger_helm", "Shayzien", "Graceful", "gas_mask", "Gas mask", "serpentine_helm", "magma_helm",
            "ankou", "demon", "mummy", "head", "Banshee", "Goblin mask", "Jack_lantern_mask", "h'ween",
            "slayer helmet (i)", "rogue mask", "santa mask", "antisanta mask", "Splitbark helm", "Justiciar faceguard"};
	
    public static int twohanded[] = { 11785, 10431, 7158, 1319, 3202, 6528, 15333, 15335, 15332};
    public static int isHelm[] = { 0000};
    // All other IDs are weapons
    public static int herbs[] = {
        249, 251, 253, 257, 259, 261, 263, 265, 2481, 267, 269, 3000, 2998};
    public static int allotment[] = { 1942, 1957, 1965, 1982, 5986, 5504, 5982};
    public static int flower[] = { 6010, 6014, 6012, 1793, 225};

    public static int crackers[] = { 1038, 1040, 1042, 1044, 1046, 1048};
    public static int normal_gems[] = { 1623, 1621, 1619, 1617};
    public static int shilo_gems[] = { 1623, 1621, 1619, 1617, 1625, 1627, 1629};

    public static int TinOre[] = { 438};
    public static int CopperOre[] = { 436};
    public static int IronOre[] = { 440};
    public static int CoalOre[] = { 453};
    public static int MithOre[] = { 447};
    public static int AddyOre[] = { 449};
    public static int RuneOre[] = { 451};

    /* Any Sea - ID 1*/
    public static int fishing_net[] = { 317, 321};
    public static int fishing_net_lvl[] = { 1, 15};
    public static int fishing_net_xp[] = { 10, 40};

    /* Any Sea - ID 2*/
    public static int fishing_rod1[] = { 327, 345};
    public static int fishing_rod1_lvl[] = { 5, 10};
    public static int fishing_rod1_xp[] = { 10, 30};

    /* Lumby Swamp - ID 3*/
    public static int fishing_rod2[] = { 3379, 5001};
    public static int fishing_rod2_lvl[] = { 28, 36};
    public static int fishing_rod2_xp[] = { 65, 80};

    /* Any River - ID 4*/
    public static int fishing_fly[] = { 335, 349, 331};
    public static int fishing_fly_lvl[] = { 20, 25, 30};
    public static int fishing_fly_xp[] = { 50, 60, 70};

    /* Catherby, relekka and fishing guild - ID 5*/
    public static int fishing_big_net[] = { 353, 407, 405, 401, 341, 363};
    public static int fishing_big_net_lvl[] = { 16, 16, 16, 16, 23, 46};
    public static int fishing_big_net_xp[] = { 20, 10, 10, 1, 45, 100};

    /* karamja, fishing guild, caatherby and rellekka - ID 6*/
    public static int fishing_harpoon[] = { 359, 371};
    public static int fishing_harpoon_lvl[] = { 35, 50};
    public static int fishing_harpoon_xp[] = { 80, 100};
	
    public static int smithing_frame[][][] = {
        {
            { 1205, 1, 1, 1, 1125, 1094}, { 1351, 1, 1, 1, 1126, 1091},
            { 1422, 1, 2, 1, 1129, 1093}, { 1139, 1, 3, 1, 1127, 1102},
            { 1277, 1, 3, 1, 1128, 1085}, { 819, 10, 4, 1, 1124},
            { 4819, 15, 4, 1, 13357, 13358}, { 39, 15, 5, 1, 1130, 1108},
            { 1321, 1, 5, 2, 1116, 1087}, { 1291, 1, 6, 2, 1089, 1086},
            { 1155, 1, 7, 2, 1113, 1103}, { 864, 5, 7, 1, 1131, 1106},
            { 1173, 1, 8, 2, 1114, 1104}, { 1337, 1, 9, 3, 1118, 1083},
            { 1375, 1, 10, 3, 1095, 1092}, { 1103, 1, 11, 3, 1109, 1098},
            { 1189, 1, 12, 3, 1115, 1105}, { 3095, 1, 13, 2, 8428, 8429},
            { 1307, 1, 14, 3, 1090, 1088}, { 1087, 1, 16, 3, 1111, 1100},
            { 1075, 1, 16, 3, 1110, 1099}, { 1117, 1, 18, 5, 1112, 1101}, /* Specials*/
            {
                1794,
                1, 4, 1, 1132, 1096}},
        {
            { 1203, 1, 15, 1, 1125, 1094}, { 1349, 1, 16, 1, 1126, 1091},
            { 1420, 1, 17, 1, 1129, 1093}, { 1137, 1, 18, 1, 1127, 1102},
            { 1279, 1, 19, 1, 1128, 1085}, { 820, 10, 19, 1, 1124},
            { 4820, 15, 19, 1, 13357, 13358}, { 40, 15, 20, 1, 1130, 1108},
            { 1323, 1, 20, 2, 1116, 1087}, { 1293, 1, 21, 2, 1089, 1086},
            { 1153, 1, 22, 2, 1113, 1103}, { 863, 5, 22, 1, 1131, 1106},
            { 1175, 1, 23, 2, 1114, 1104}, { 1335, 1, 24, 3, 1118, 1083},
            { 1363, 1, 25, 3, 1095, 1092}, { 1101, 1, 26, 3, 1109, 1098},
            { 1191, 1, 27, 3, 1115, 1105}, { 3096, 1, 28, 2, 8428, 8429},
            { 1309, 1, 29, 3, 1090, 1088}, { 1081, 1, 31, 3, 1111, 1100},
            { 1067, 1, 31, 3, 1110, 1099}, { 1115, 1, 33, 5, 1112, 1101}, /* Specials*/
            {
                4540,
                1, 26, 1, 11459, 11461}},
        {
            { 1207, 1, 30, 1, 1125, 1094}, { 1353, 1, 31, 1, 1126, 1091},
            { 1424, 1, 32, 1, 1129, 1093}, { 1141, 1, 33, 1, 1127, 1102},
            { 1281, 1, 34, 1, 1128, 1085}, { 821, 10, 34, 1, 1124},
            { 1539, 15, 34, 1, 13357, 13358}, { 41, 15, 35, 1, 1130, 1108},
            { 1325, 1, 35, 2, 1116, 1087}, { 1295, 1, 36, 2, 1089, 1086},
            { 1157, 1, 37, 2, 1113, 1103}, { 865, 5, 37, 1, 1131, 1106},
            { 1177, 1, 38, 2, 1114, 1104}, { 1339, 1, 39, 3, 1118, 1083},
            { 1365, 1, 40, 3, 1095, 1092}, { 1105, 1, 41, 3, 1109, 1098},
            { 1193, 1, 42, 3, 1115, 1105}, { 3097, 1, 43, 2, 8428, 8429},
            { 1311, 1, 44, 3, 1090, 1088}, { 1083, 1, 46, 3, 1111, 1100},
            { 1069, 1, 46, 3, 1110, 1099}, { 1119, 1, 48, 5, 1112, 1101}, /* Specials*/
            {
                4544,
                1, 49, 1, 11459, 11461},
            { 2370, 1, 36, 1, 1135, 1134}},
        {
            { 1209, 1, 50, 1, 1125, 1094}, { 1355, 1, 51, 1, 1126, 1091},
            { 1428, 1, 52, 1, 1129, 1093}, { 1143, 1, 53, 1, 1127, 1102},
            { 1285, 1, 53, 1, 1128, 1085}, { 822, 10, 54, 1, 1124},
            { 4822, 15, 54, 1, 13357, 13358}, { 42, 15, 55, 1, 1130, 1108},
            { 1329, 1, 55, 2, 1116, 1087}, { 1299, 1, 56, 2, 1089, 1086},
            { 1159, 1, 57, 2, 1113, 1103}, { 866, 5, 57, 1, 1131, 1106},
            { 1181, 1, 58, 2, 1114, 1104}, { 1343, 1, 59, 3, 1118, 1083},
            { 1369, 1, 60, 3, 1095, 1092}, { 1109, 1, 61, 3, 1109, 1098},
            { 1197, 1, 62, 3, 1115, 1105}, { 3099, 1, 63, 2, 8428, 8429},
            { 1315, 1, 64, 3, 1090, 1088}, { 1085, 1, 66, 3, 1111, 1100},
            { 1071, 1, 66, 3, 1110, 1099}, { 1121, 1, 68, 5, 1112, 1101}},
        {
            { 1211, 1, 70, 1, 1125, 1094}, { 1357, 1, 71, 1, 1126, 1091},
            { 1430, 1, 72, 1, 1129, 1093}, { 1145, 1, 73, 1, 1127, 1102},
            { 1287, 1, 74, 1, 1128, 1085}, { 823, 10, 74, 1, 1124},
            { 4823, 15, 74, 1, 13357, 13358}, { 43, 15, 75, 1, 1130, 1108},
            { 1331, 1, 75, 2, 1116, 1087}, { 1301, 1, 76, 2, 1089, 1086},
            { 1161, 1, 77, 2, 1113, 1103}, { 867, 5, 77, 1, 1131, 1106},
            { 1183, 1, 78, 2, 1114, 1104}, { 1345, 1, 79, 3, 1118, 1083},
            { 1371, 1, 80, 3, 1095, 1092}, { 1111, 1, 81, 3, 1109, 1098},
            { 1199, 1, 82, 3, 1115, 1105}, { 3100, 1, 83, 2, 8428, 8429},
            { 1317, 1, 84, 3, 1090, 1088}, { 1091, 1, 86, 3, 1111, 1100},
            { 1073, 1, 86, 3, 1110, 1099}, { 1123, 1, 88, 5, 1112, 1101}},
        {
            { 1213, 1, 85, 1, 1125, 1094}, { 1359, 1, 86, 1, 1126, 1091},
            { 1432, 1, 87, 1, 1129, 1093}, { 1147, 1, 88, 1, 1127, 1102},
            { 1289, 1, 89, 1, 1128, 1085}, { 824, 10, 89, 1, 1124},
            { 4824, 15, 89, 1, 13357, 13358}, { 44, 15, 90, 1, 1130, 1108},
            { 1333, 1, 90, 2, 1116, 1087}, { 1303, 1, 91, 2, 1089, 1086},
            { 1163, 1, 92, 2, 1113, 1103}, { 868, 5, 92, 1, 1131, 1106},
            { 1185, 1, 93, 2, 1114, 1104}, { 1347, 1, 94, 3, 1118, 1083},
            { 1373, 1, 95, 3, 1095, 1092}, { 1113, 1, 96, 3, 1109, 1098},
            { 1201, 1, 97, 3, 1115, 1105}, { 3101, 1, 98, 2, 8428, 8429},
            { 1319, 1, 99, 3, 1090, 1088}, { 1093, 1, 99, 3, 1111, 1100},
            { 1079, 1, 99, 3, 1110, 1099}, { 1127, 1, 99, 5, 1112, 1101}}
        // 0			1			2			3			4			5			6				7			8			9			10			11			12			13			14			15			16		17				18			19			20			21				22			23
        // dagger			axe			mace			medium			sword			dart tips		nails				arrow heads		scimitar		long sword		full helmet		knives			square			warhammer		battle axe		chain			kite		claws				2-handed		skirt			legs			body				lantern/wire		studs
    };
    public static int SmithingItems[][] = new int[5][5];

    public static boolean[] itemStackable = new boolean[Config.MAX_ITEMS];
    public static boolean[] itemIsNote = new boolean[Config.MAX_ITEMS];
    public static boolean[] itemTwoHanded = new boolean[Config.MAX_ITEMS];
    public static boolean[] itemTradeable = new boolean[Config.MAX_ITEMS];
    public static boolean[] itemSellable = new boolean[Config.MAX_ITEMS];
    static {
        int counter = 0;
        int c;

        try {
            FileInputStream dataIn = new FileInputStream(
                    new File("./Data/data/stackable.dat"));

            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemStackable[counter] = true;
                } else {
                    itemStackable[counter] = false;
                }
                counter++;
            }
            dataIn.close();

itemStackable[12163] = true;
itemStackable[12159] = true;
        } catch (IOException e) {
            System.out.println(
                    "Critical error while loading stackabledata! Trace:");
            e.printStackTrace();
        }

        counter = 0;
        try {
            FileInputStream dataIn = new FileInputStream(
                    new File("./Data/data/notes.dat"));

            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemIsNote[counter] = true;
                } else {
                    itemIsNote[counter] = false;
                }
                counter++;
            }
            dataIn.close();
            itemIsNote[ItemIDs.BRONZE_PICKAXE] = false;
            itemIsNote[ItemIDs.IRON_PICKAXE] = false;
            itemIsNote[ItemIDs.STEEL_PICKAXE] = false;
            itemIsNote[ItemIDs.MITHRIL_PICKAXE] = false;
            itemIsNote[ItemIDs.ADAMANT_PICKAXE] = false;
            itemIsNote[ItemIDs.RUNE_PICKAXE] = false;
            itemIsNote[ItemIDs.DRAGON_PICKAXE] = false;
        } catch (IOException e) {
            System.out.println("Critical error while loading notedata! Trace:");
            e.printStackTrace();
        }

        counter = 0;
        try {
            FileInputStream dataIn = new FileInputStream(
                    new File("./Data/data/twohanded.dat"));

            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemTwoHanded[counter] = false;
                } else {
                    itemTwoHanded[counter] = true;
                }
                counter++;
            }
            dataIn.close();
            itemTwoHanded[ItemIDs.ARMADYL_GODSWORD_2] = true;
            itemTwoHanded[ItemIDs.SARADOMIN_GODSWORD] = true;
            itemTwoHanded[ItemIDs.ZAMORAK_GODSWORD] = true;
            itemTwoHanded[ItemIDs.BANDOS_GODSWORD_] = true;
        } catch (IOException e) {
            System.out.println("Critical error while loading twohanded! Trace:");
            e.printStackTrace();
        }

        counter = 0;		
        try {
            FileInputStream dataIn = new FileInputStream(
                    new File("./Data/data/tradeable.dat"));

            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemTradeable[counter] = false;
                } else {
                    itemTradeable[counter] = true;
                }
                counter++;
            }
            dataIn.close();
        } catch (IOException e) {
            System.out.println("Critical error while loading tradeable! Trace:");
            e.printStackTrace();
        }

        counter = 0;		
        try {
            FileInputStream dataIn = new FileInputStream(
                    new File("./Data/data/sellable.dat"));

            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemSellable[counter] = true;
                } else {
                    itemSellable[counter] = false;
                }
                counter++;
            }
            dataIn.close();
itemSellable[15195] = true;
itemSellable[15334] = true;
itemSellable[15333] = true;
itemSellable[15335] = true;
itemSellable[15336] = true;
itemSellable[15351] = true;
itemSellable[15344] = true;
itemSellable[15352] = true;
itemSellable[15345] = true;
itemSellable[15346] = true;
itemSellable[15347] = true;
itemSellable[1107] = true;
itemSellable[15349] = true;
itemSellable[7612] = true;
itemSellable[14511] = true;
itemSellable[14512] = true;
itemSellable[14513] = true;
itemSellable[14514] = true;
itemSellable[14519] = true;
itemSellable[14520] = true;
itemSellable[14521] = true;
itemSellable[14509] = true;
itemSellable[14508] = true;
itemSellable[14507] = true;
itemSellable[14503] = true;
itemSellable[14504] = true;
itemSellable[14505] = true;
itemSellable[14506] = true;
itemSellable[14558] = true;
itemSellable[14559] = true;
itemSellable[14560] = true;
itemSellable[14561] = true;
itemSellable[14563] = true;
itemSellable[14564] = true;
itemSellable[14565] = true;
itemSellable[14566] = true;
itemSellable[14567] = true;
itemSellable[14568] = true;
itemSellable[14569] = true;
itemSellable[14570] = true;
itemSellable[14571] = true;
itemSellable[14572] = true;
itemSellable[14573] = true;
itemSellable[14574] = true;
itemSellable[14579] = true;
itemSellable[11967] = true;
itemSellable[11968] = true;
itemSellable[11969] = true;
itemSellable[12435] = true;
itemSellable[12434] = true;
itemSellable[12433] = true;
itemSellable[12432] = true;
itemSellable[12431] = true;
itemSellable[12430] = true;
itemSellable[12429] = true;
itemSellable[12428] = true;
itemSellable[12427] = true;
itemSellable[12426] = true;
itemSellable[14538] = true;
itemSellable[14539] = true;
itemSellable[14540] = true;
itemSellable[14541] = true;
itemSellable[14542] = true;
itemSellable[14543] = true;
itemSellable[14544] = true;
itemSellable[14545] = true;
itemSellable[14546] = true;
itemSellable[14547] = true;
itemSellable[14548] = true;
itemSellable[14549] = true;
itemSellable[14550] = true;
itemSellable[14551] = true;
itemSellable[14552] = true;
itemSellable[14553] = true;
itemSellable[14554] = true;
itemSellable[14555] = true;
itemSellable[14556] = true;
itemSellable[14557] = true;
itemSellable[14316] = true;
itemSellable[14478] = true;
itemSellable[14522] = true;
itemSellable[14523] = true;
itemSellable[14524] = true;
itemSellable[14525] = true;
itemSellable[14526] = true;
itemSellable[14527] = true;
itemSellable[14528] = true;
itemSellable[14529] = true;
itemSellable[14530] = true;
itemSellable[14531] = true;
itemSellable[14532] = true;
itemSellable[14533] = true;
itemSellable[13800] = true;
itemSellable[13603] = true;
itemSellable[13611] = true;
itemSellable[13606] = true;
itemSellable[13733] = true;
itemSellable[13749] = true;
itemSellable[15320] = true;
itemSellable[15321] = true;
itemSellable[15322] = true;
itemSellable[14535] = true;
itemSellable[14536] = true;
itemSellable[13994] = true;
itemSellable[13995] = true;
itemSellable[13996] = true;
itemSellable[14868] = true;
itemSellable[14869] = true;
itemSellable[14870] = true;
itemSellable[14871] = true;
itemSellable[13591] = true;
itemSellable[13592] = true;
itemSellable[13593] = true;
itemSellable[13594] = true;
itemSellable[13662] = true;
itemSellable[13663] = true;
itemSellable[8486] = true;
itemSellable[13676] = true;
itemSellable[13669] = true;
itemSellable[13700] = true;
itemSellable[13600] = true;
itemSellable[13601] = true;
itemSellable[14945] = true;
itemSellable[14946] = true;
itemSellable[14947] = true;
itemSellable[15368] = true;
itemSellable[15369] = true;
itemSellable[15370] = true;
itemSellable[13776] = true;
itemSellable[13777] = true;
itemSellable[13778] = true;
itemSellable[13779] = true;
itemSellable[13780] = true;
itemSellable[13781] = true;
itemSellable[13782] = true;
itemSellable[13784] = true;
itemSellable[13764] = true;
itemSellable[15185] = true;
itemSellable[15180] = true;
itemSellable[15181] = true;
itemSellable[15337] = true;
itemSellable[15338] = true;
itemSellable[15339] = true;
itemSellable[15340] = true;
itemSellable[15341] = true;
itemSellable[15342] = true;
itemSellable[15343] = true;
itemSellable[15226] = true;
itemSellable[15227] = true;
itemSellable[15228] = true;
itemSellable[15229] = true;
itemSellable[15230] = true;
itemSellable[15231] = true;
itemSellable[13889] = true;
itemSellable[3753] = true;
itemSellable[14634] = true;
itemSellable[14635] = true;
itemSellable[14636] = true;
itemSellable[14637] = true;
itemSellable[14638] = true;
itemSellable[14639] = true;
itemSellable[14640] = true;
itemSellable[14641] = true;
itemSellable[14642] = true;
        } catch (IOException e) {
            System.out.println("Critical error while loading sellable! Trace:");
            e.printStackTrace();
        }
    }

    public static int randomCape() {
        return capes[(int) (Math.random() * capes.length)];
    }

    public static int randomBoots() {
        return boots[(int) (Math.random() * boots.length)];
    }

    public static int randomGloves() {
        return gloves[(int) (Math.random() * gloves.length)];
    }

    public static int randomShield() {
        return shields[(int) (Math.random() * shields.length)];
    }

    public static int randomHat() {
        return hats[(int) (Math.random() * hats.length)];
    }

    public static int randomAmulet() {
        return amulets[(int) (Math.random() * amulets.length)];
    }

    public static int randomArrows() {
        return arrows[(int) (Math.random() * arrows.length)];
    }

    public static int randomRing() {
        return rings[(int) (Math.random() * rings.length)];
    }

    public static int randomBody() {
        return body[(int) (Math.random() * body.length)];
    }

    public static int randomLegs() {
        return legs[(int) (Math.random() * legs.length)];
    }

    public static int randomPHat() {
        return crackers[(int) (Math.random() * crackers.length)];
    }

    public static int randomNGems() {
        return normal_gems[(int) (Math.random() * normal_gems.length)];
    }

    public static int randomSGems() {
        return shilo_gems[(int) (Math.random() * shilo_gems.length)];
    }

    public static int randomTinOre() {
        return TinOre[(int) (Math.random() * TinOre.length)];
    }

    public static int randomCopperOre() {
        return CopperOre[(int) (Math.random() * CopperOre.length)];
    }

    public static int randomIronOre() {
        return IronOre[(int) (Math.random() * IronOre.length)];
    }

    public static int randomCoalOre() {
        return CoalOre[(int) (Math.random() * CoalOre.length)];
    }

    public static int randomMithOre() {
        return MithOre[(int) (Math.random() * MithOre.length)];
    }

    public static int randomAddyOre() {
        return AddyOre[(int) (Math.random() * AddyOre.length)];
    }

    public static int randomRuneOre() {
        return RuneOre[(int) (Math.random() * RuneOre.length)];
    }

    public static int gems[] = { 1623, 1619, 1621, 1617};

    public static int randomGem() {
        return gems[(int) (Math.random() * gems.length)];
    }

    public static int spiceitems[] = { 1052};

    public static int randomSpiceitem() {
        return spiceitems[(int) (Math.random() * spiceitems.length)];
    }

    public static int slayer135items[] = {
        1052, 4708, 4712, 4714, 6110, 6109, 6108, 6107, 6106, 6111, 4087, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        6110, 6109, 6108, 6107, 6106, 6111, 4834, 4834, 4834, 4675};
    public static int randomSlayer135item() {
        return slayer135items[(int) (Math.random() * slayer135items.length)];
    }

    public static int slayer120items[] = {
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 2653, 2655,
        4834, 4834, 2583, 2587, 2589, 2591, 2593, 2595, 4834, 4834, 4834, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 2587, 2587,
        3054, 4834, 4834};
    public static int randomSlayer120item() {
        return slayer120items[(int) (Math.random() * slayer120items.length)];
    }

    public static int slayer99items[] = {
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 2653, 2655,
        4834, 4834, 2597, 2593, 2595, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 2587, 2587, 3054, 4834, 4834,
        2651, 2577, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834, 4834,
        4834};
    public static int randomSlayer99item() {
        return slayer99items[(int) (Math.random() * slayer99items.length)];
    }

    public static int silvers[] = {
        442, 442, 442, 442, 442, 442, 442, 442, 442, 442, 442, 442, 442, 442,
        442, 442, 2355, 2355, 2355, 2355, 2355, 2355, 2355, 1718, 1718, 1718,
        1718, 1718, 1718, 1718, 1718, 1718, 1718, 442, 442, 442, 442, 442, 442,
        442, 442, 442, 442, 2355, 2355, 2355, 2355, 2355, 2355, 2355, 442, 442,
        442, 442, 442, 442, 442, 442, 442, 442, 2355, 2355, 2355, 2355, 2355,
        2355, 2355, 442, 442, 442, 442, 442, 442, 442, 442, 442, 442, 2355, 2355,
        2355, 2355, 2355, 2355, 2355, 442, 442, 442, 442, 442, 442, 442, 442,
        442, 442, 2355, 2355, 2355, 2355, 2355, 2355, 2355, 442, 442, 442, 442,
        442, 442, 442, 442, 442, 442, 2355, 2355, 2355, 2355, 2355, 2355, 2355,
        442, 442, 442, 442, 442, 442, 442, 442, 442, 442, 2355, 2355, 2355, 2355,
        2355, 2355, 2355};

    public static int randomSilver() {
        return silvers[(int) (Math.random() * silvers.length)];
    }
    public static int slayeritems75[] = {
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 2682, 2682, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4153, 4153, 4153, 4153,
        4153, 4153, 4153, 4153, 4153, 4153, 6524, 6527, 6527, 6527, 6527, 1187,
        4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131,
        4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131, 4131, 2663, 2663, 2663,
        2663, 2663, 2669, 2643, 2643, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352, 2352,
        2352, 2352, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360,
        2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360,
        2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360,
        2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 2360, 1127, 1127, 1127,
        1127, 1127, 1127, 1127, 1127, 65, 1165, 1165, 1165, 1165, 1165, 1165,
        1165, 1165, 1165, 1165, 1165, 987, 987, 987, 987, 987, 987, 987, 987,
        987, 987, 987, 987, 987, 987, 987, 987, 987, 987, 987, 985, 985, 985,
        985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985,
        985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985, 985,
        985, 985, 985, 985, 985, 985, 985, 985, 985, 1149, 1149, 1149, 1149,
        1149, 4755, 4755, 4751, 4751, 4751, 4751, 4751, 4757, 4757, 4087, 4087,
        4722, 4722, 4720, 4506, 4506, 4506, 4506, 4506, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 1450,
        1450, 1450, 1450, 1450, 1450, 1450, 1450, 1450, 1450, 1450, 1450, 1450,
        1450, 1450, 1456, 1456, 1456, 1456, 4714};

    public static int randomSlayeritem75() {
        return slayeritems75[(int) (Math.random() * slayeritems75.length)];
    }

    public static int slayeritems65[] = {
        4830, 4830, 4830, 4830, 2682, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187, 3187,
        3187, 3187, 4716, 4716, 4732, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830, 4830,
        4830, 4830, 4732};

    public static int randomSlayeritem65() {
        return slayeritems65[(int) (Math.random() * slayeritems65.length)];
    }

    public static int goditems[] = { 2412, 2413, 2414};
    public static int randomGoditem() {
        return goditems[(int) (Math.random() * goditems.length)];
    }

    public static int phats[] = { 9999};

    public static int randomPhat() {
        return phats[(int) (Math.random() * phats.length)];
    }

    public static int partyhats[] = { 9999};
    public static int randomPartyHat() {
        return partyhats[(int) (Math.random() * partyhats.length)];
    }

    public static int randarmour[] = {
        6959, 6111, 6570, 6568, 1007, 1019, 1021, 1023, 1027, 1029, 1031, 1052,
        2412, 2413, 2414, 4304, 4315, 4317, 4319, 4321, 4323, 4325, 4327, 4329,
        4331, 4333, 4335, 4337, 4339, 4341, 4343, 4345, 4347, 4349, 4351, 4353,
        4355, 4357, 4359, 4361, 4363, 4365, 4367, 4369, 4371, 4373, 4375, 4377,
        4379, 4381, 4383, 4385, 4387, 4389, 4391, 4393, 4395, 4397, 4399, 4401,
        4403, 4405, 4407, 4409, 4411, 4413, 4514, 4516, 6070, 6568, 6570, 6619,
        3393, 4084, 6920, 6061, 6106, 88, 89, 626, 628, 630, 632, 634, 1061,
        1837, 1846, 2577, 2579, 2894, 2904, 2914, 2924, 2934, 3061, 3105, 3107,
        3791, 4097, 4107, 4117, 4119, 4121, 4123, 4125, 4127, 4129, 4131, 4310,
        5064, 5345, 5557, 6069, 6106, 6143, 6145, 6147, 6328, 7457, 6629, 7462,
        6922, 2491, 1065, 2487, 2489, 3060, 1495, 775, 777, 778, 6708, 1059,
        1063, 1065, 1580, 2487, 2489, 2491, 2902, 2912, 2922, 2932, 2942, 3060,
        3799, 4095, 4105, 4115, 4308, 5556, 6068, 6110, 6149, 6151, 6153, 6631,
        6633, 6889, 7336, 7332, 7334, 1171, 1173, 1175, 1177, 1179, 1181, 1183,
        1185, 1187, 1189, 1191, 1193, 1195, 1197, 1199, 1201, 1540, 2589, 2597,
        2603, 2611, 2621, 2629, 2659, 2667, 2675, 2890, 3122, 3488, 3758, 3839,
        3840, 3841, 3842, 3843, 3844, 4072, 4156, 4224, 4225, 4226, 4227, 4228,
        4229, 4230, 4231, 4232, 4233, 4234, 4302, 4507, 4512, 6215, 6217, 6219,
        6221, 6223, 6225, 6227, 6229, 6231, 6233, 6235, 6237, 6239, 6241, 6243,
        6245, 6247, 6249, 6251, 6253, 6255, 6257, 6259, 6261, 6263, 6265, 6267,
        6269, 6271, 6273, 6275, 6277, 6279, 6524, 6621, 6623, 6858, 6860, 6862,
        6856, 6918, 6656, 7400, 7321, 7323, 7219, 7325, 7327, 7396, 7394, 4732,
        4753, 4611, 6188, 6182, 4511, 4056, 4071, 4724, 2639, 2641, 2643, 2665,
        6109, 5525, 5527, 5529, 5531, 5533, 5535, 5537, 5539, 5541, 5543, 5545,
        5547, 5549, 5551, 74, 579, 656, 658, 660, 662, 664, 740, 1017, 1037,
        1038, 1040, 1042, 1044, 1046, 1048, 1050, 1053, 1055, 1057, 1137, 1139,
        1141, 1143, 1145, 1147, 1149, 1151, 1153, 1155, 1157, 1159, 1161, 1163,
        1165, 1506, 1949, 2422, 2581, 2587, 2595, 2605, 2613, 2619, 2627, 2631,
        2633, 2635, 2637, 2651, 2657, 2673, 2900, 2910, 2920, 2930, 2940, 2978,
        2979, 2980, 2981, 2982, 2983, 2984, 2985, 2986, 2987, 2988, 2989, 2990,
        2991, 2992, 2993, 2994, 2995, 3057, 3385, 3486, 3748, 3749, 3751, 3753,
        3755, 3797, 4041, 4042, 4071, 4089, 4099, 4109, 4164, 4302, 4506, 4511,
        4513, 4515, 4551, 4567, 4708, 4716, 4724, 4745, 4753, 4856, 4857, 4858,
        4859, 4880, 4881, 4882, 4883, 4904, 4905, 4906, 4907, 4952, 4953, 4954,
        4955, 4976, 4977, 4978, 4979, 5013, 5014, 5554, 6109, 6128, 6131, 6137,
        6182, 6188, 6335, 6337, 6339, 6345, 6355, 6365, 6375, 6382, 6392, 6400,
        6577, 6581, 6857, 6859, 6861, 6863, 6585, 86, 87, 295, 421, 552, 589,
        1478, 1692, 1694, 1696, 1698, 1700, 1702, 1704, 1706, 1708, 1710, 1712,
        1725, 1727, 1729, 1731, 4021, 4081, 4250, 4677, 6040, 6041, 6208, 6577,
        6583, 6675, 6731, 6733, 6735, 6737, 773, 1635, 1637, 1639, 1641, 1643,
        1645, 2550, 2552, 2554, 2556, 2558, 2560, 2562, 2564, 2566, 2568, 2570,
        2572, 4202, 4657, 6465, 6615, 6617, 577, 2503, 3793, 636, 637, 640, 642,
        644, 2896, 6916, 6654, 7390, 7392, 7362, 7364, 7399, 7374, 7376, 7372,
        7370, 1035, 540, 5553, 4757, 1833, 6388, 6384, 2501, 2499, 4111, 4101,
        4091, 6186, 6184, 6180, 3058, 4509, 4504, 4069, 4728, 4736, 4712, 6107,
        2661, 3140, 1101, 1103, 1105, 1109, 1111, 1113, 1115, 1117, 1119, 1121,
        1123, 1125, 1127, 1129, 1131, 1133, 1135, 2499, 2501, 2503, 2583, 2591,
        2599, 2607, 2615, 2623, 2653, 2669, 3387, 3481, 4712, 4720, 4728, 4749,
        4892, 4893, 4894, 4895, 4916, 4917, 4918, 4919, 4964, 4965, 4966, 4967,
        6107, 6133, 6322, 577, 6625, 6627, 3795, 646, 648, 650, 652, 654, 2898,
        6343, 6353, 6363, 6373, 6924, 6655, 7386, 7388, 7366, 7368, 7398, 7382,
        7384, 7380, 7378, 426, 1835, 538, 1033, 5555, 4759, 6386, 6390, 2503,
        2497, 2495, 2493, 1099, 4113, 4103, 4093, 6187, 6185, 6181, 3059, 4510,
        4505, 4070, 6108, 538, 542, 548, 1011, 1013, 1015, 1067, 1069, 1071,
        1073, 1075, 1077, 1079, 1081, 1083, 1085, 1087, 1089, 1091, 1093, 2585,
        2593, 2601, 2609, 2617, 2625, 2655, 2663, 2671, 3059, 3389, 3472, 3473,
        3474, 3475, 3476, 3477, 3478, 3479, 3480, 3483, 3485, 3795, 4087, 4585,
        4712, 4714, 4722, 4730, 4738, 4751, 4759, 4874, 4875, 4876, 4877, 4898,
        4899, 4900, 4901, 4922, 4923, 4924, 4925, 4946, 4947, 4948, 4949, 4970,
        4971, 4972, 4973, 4994, 4995, 4996, 4997, 5048, 5050, 5052, 5576, 6107,
        6130, 6187, 6390, 6386, 6390, 6396, 6404, 6615, 6617, 1035, 540, 5553,
        4757, 1833, 1835, 6388, 6384, 2501, 2499, 1355, 4111, 4101, 4091, 6186,
        6184, 6180, 3058, 4509, 4504, 4069, 4728, 4736, 4712, 6107, 2661, 3140,
        1115, 1117, 1119, 1121, 1123, 1125, 1127, 2583, 2591, 2599, 2607, 2615,
        2623, 2653, 2669, 3481, 4720, 4728, 4749, 2661, 6621, 6623, 4732, 4753,
        6188, 4511, 4056, 4071, 4724, 6109, 2665, 1153, 1155, 1157, 1159, 1161,
        1163, 1165, 2587, 2595, 2605, 2613, 2619, 2627, 2657, 2673, 3486, 6402,
        6394, 4732, 5554, 4753, 4611, 6188, 3507, 4511, 4056, 4071, 4724, 2665,
        6109, 1053, 1055, 1057};
    public static int randomarmour() {
        return randarmour[(int) (Math.random() * randarmour.length)];
    }
    public static int barrowsitem[] = {
        4708, 4710, 4712, 4714, 4716, 4718, 4720, 4722, 4724, 4726, 4728, 4730,
        4732, 4734, 4736, 4738, 4745, 4747, 4749, 4751, 4753, 4755, 4757, 4759};

    public static int randomBarrowsitem() {
        return barrowsitem[(int) (Math.random() * barrowsitem.length)];
    }
    public static int randpot[] = {
        113, 2428, 2430, 2432, 2434, 2436, 2438, 2440, 2442, 2444, 2446, 2448,
        2450, 2552, 3008, 3016, 3024, 3032, 3040, 6685};
    public static int randompot() {
        return randpot[(int) (Math.random() * randpot.length)];
    }

	public static boolean isPlate(int itemId) {
        String weapon = getItemName(itemId);
		if (weapon == null)
			return false;
        for (int i = 0; i < fullbody.length; i++) {
            if (weapon.toLowerCase().contains(fullbody[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullHat(int itemId) {
        String weapon = getItemName(itemId);
		if (weapon == null)
			return false;
        for (int i = 0; i < fullhat.length; i++) {
            if (weapon.toLowerCase().contains(fullhat[i]) && !weapon.contains("hood hat")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullMask(int itemId) {
        String weapon = getItemName(itemId);
		if (weapon == null)
			return true;
        for (int i = 0; i < fullmask.length; i++) {
            if (weapon.toLowerCase().contains(fullmask[i]) && !weapon.contains("hood hat") && !weapon.equalsIgnoreCase("Cavalier and mask")) {
                return false;
            }
        }
        return true;
    }
	
    
    public static boolean playerCape(int itemId) {
		String[] data = { "cloak", "cape", "Butterfly Wings", "Cape", "ava's", "accumulator", "tokhaar" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerBoots(int itemId) {
		String[] data = { "Shoes", "shoes", "boots", "Boots", "flippers",
				"Flippers", "Ragefire boots",
				"Steadfast boots", "Glaiven boots" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}
	
public static int[] targetSlots = new int[Config.MAX_ITEMS];

	public static boolean playerGloves(int itemId) {
		String[] data = { "Gloves", "gloves", "glove", "Glove", "gauntlets",
				"Gauntlets", "vambraces", "vamb", "v'brace" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerShield(int itemId) {
		String[] data = { "kiteshield", "Lit bug lantern", "Unlit bug lantern", "book", "Kiteshield", "shield",
				"Shield", "Kite", "kite", "defender", "ket-xil", "Book", "Off-hand" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerAmulet(int itemId) {
		String[] data = { "amulet", "Amulet", "necklace", "Necklace",
				"Pendant", "pendant", "Symbol", "symbol", "scarf", "Scarf",
				"scarve", "Scarve", "stole", "Stole" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerArrows(int itemId) {
		String[] data = { "Arrows", "arrows", "Arrow", "arrow", "Bolts",
				"bolts", "Bolt", "bolt" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerRings(int itemId) {
		String[] data = { "ring", "rings", "Ring", "Rings", };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerHats(int itemId) {
		String[] data = { "boater", "Light Helmet", "cowl", "peg", "coif", "helm", "Coif",
				"mask", "Mask", "hat", "headband", "hood", "Hood", "disguise",
				"cavalier", "full helm", "tiara", "helmet", "Hat", "ears",
				"partyhat", "helm(t)", "helm(g)", "beret", "facemask",
				"sallet", "hat(g)", "hat(t)", "bandana", "Helm", "mitre",
				"Mitre", "afro", "skull", "Crown"};
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if ((item.endsWith(element) || item.contains(element))
					&& itemId != 4214) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerLegs(int itemId) {
		String[] data = { "tassets", "Seth Chaps", "Light Legs", "Owner Legs", "chaps", "bottoms", "gown", "trousers",
				"platelegs", "robe", "plateskirt", "legs", "leggings",
				"shorts", "Shorts", "Skirt", "Knightmare legs", "Torva Platelegs", "Priml Platelegs", "skirt", "cuisse", "Trousers", };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if ((item.endsWith(element) || item.contains(element))
					&& !item.contains("top") && !item.contains("robe (g)")
					&& !item.contains("robe (t)")) {
				item1 = true;
			}
		}
		return item1;
	}

	public static boolean playerBody(int itemId) {
		String[] data = { "body", "Demon Plate", "Torva Platebody", "Light Plate", "top", "Owner Plate", "Priest gown", "apron", "shirt",
				"platebody", "robetop", "body(g)", "body(t)",
				"Wizard robe (t)", "body", "Body", "brassard", "blouse",
				"tunic", "leathertop", "Saradomin plate", "chainbody",
				"Platebody", "Chainbody", "Robe Top", "Robe top", "hauberk",
				"Shirt", "torso", "Torso", "chestplate", "Wizard robe (g)",
				"Snakeskin body", "Morrigan's Body" };
		String item = getItemName(itemId);
		if (item == null) {
			return false;
		}
		boolean item1 = false;
		for (String element : data) {
			if (item.endsWith(element) || item.contains(element)) {
				item1 = true;
			}
		}
		return item1;
	}

    public static String getItemName (int ItemID) {
        for (int i = 0; i < ItemHandler.MaxListedItems; i++) {
            if (server.itemHandler.ItemList[i] != null) {
                if (server.itemHandler.ItemList[i].itemId == ItemID) {
                    return server.itemHandler.ItemList[i].itemName;
                }
                if (ItemID == -1) {
                    return "Unarmed";
                }
            }
        }
        return "!! NOT EXISTING ITEM !!! - ID:" + ItemID;
    }
    public static int castlew[] = { 391, 391, 391, 391};
    public static int randomcastlew() {
        return castlew[(int) (Math.random() * castlew.length)];
    }				
}
