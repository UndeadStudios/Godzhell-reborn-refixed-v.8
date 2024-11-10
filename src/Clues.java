


public class Clues {
    public static int clue1[] = {
        2587, 2587, 2587, 2585, 2585, 2583, 2583, 2583, 2589, 2589, 2589, 2595,
        2595, 2595, 2593, 2593, 2593, 2591, 2591, 2597, 2597, 2597, 7332, 7390,
        7386, 7394, 7392, 7388, 7388, 7396, 7396, 7396, 7362, 7366, 7366, 7364,
        7368, 7368, 7364};
    public static int randomClue1() {
        return clue1[(int) (Math.random() * clue1.length)];
    }	

    public static int clue2[] = {
        2605, 2605, 2605, 2601, 2601, 2599, 2599, 2599, 2603, 2603, 2613, 2613,
        2609, 2609, 2607, 2607, 2611, 2611, 7334, 7327, 7319, 7323, 7321, 7370,
        7378, 7372, 7380};

    public static int randomClue2() {
        return clue2[(int) (Math.random() * clue2.length)];
    }	

    public static int clue3[] = {
        2619, 2619, 2619, 2627, 2627, 2627, 2621, 2621, 2629, 2639, 2615, 2623,
        2623, 2615, 2623, 2617, 2617, 2625, 2625, 3476, 3476, 3476, 3477, 2657,
        2657, 2657, 2657, 2659, 2659, 2659, 2659, 2653, 2655, 2655, 2655, 3478,
        3478, 3478, 3478, 2667, 2661, 2663, 2661, 2667, 2667, 2661, 2663, 2673,
        3479, 3479, 2673, 2675, 2675, 2675, 2675, 2669, 2669, 2669, 2671, 2671,
        2671, 2671, 3480, 3480, 3480, 3480, 3486, 3486, 3486, 3486, 3488, 3488,
        3488, 3488, 3481, 3481, 3483, 3483, 3483, 3485, 3485, 7400, 7398, 7399,
        7374, 7376, 7382, 7384};

    public static int randomClue3() {
        return clue3[(int) (Math.random() * clue3.length)];
    }	

    public static int nonclue1[] = {
        1165, 1165, 1165, 1077, 1077, 1125, 1195, 1195, 61, 61, 61, 61, 59, 59,
        59, 1147, 1147};

    public static int randomNonClue1() {
        return nonclue1[(int) (Math.random() * nonclue1.length)];
    }	

    public static int nonclue2[] = {
        1161, 1073, 1123, 1199, 857, 857, 857, 855, 855, 2503, 1147, 1147};

    public static int randomNonClue2() {
        return nonclue2[(int) (Math.random() * nonclue2.length)];
    }	

    public static int nonclue3[] = {
        1163, 1079, 1127, 1201, 861, 861, 859, 859, 2503, 2503, 2503};

    public static int randomNonClue3() {
        return nonclue3[(int) (Math.random() * nonclue3.length)];
    }	

    public static int runes1[] = { 554, 555, 556, 557, 558};

    public static int randomRunes1() {
        return runes1[(int) (Math.random() * runes1.length)];
    }	

    public static int runes2[] = { 554, 555, 556, 557, 558, 562, 560};

    public static int randomRunes2() {
        return runes2[(int) (Math.random() * runes2.length)];
    }	

    public static int runes3[] = { 554, 555, 556, 557, 558, 562, 560, 565, 566};

    public static int randomRunes3() {
        return runes3[(int) (Math.random() * runes3.length)];
    }	
}
