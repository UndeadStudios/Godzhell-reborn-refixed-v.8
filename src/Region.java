import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class Region {

    private static Region[] regionArray;
    private static final ArrayList<Integer> loadedRegions = new ArrayList<Integer>();
    public static class RegionData {
        private final int regionHash;
        private final int landscape;
        private final int objects;

        public int getRegionHash() {
            return regionHash;
        }

        public int getLandscape() {
            return landscape;
        }

        public int getObjects() {
            return objects;
        }

        public RegionData(int regionHash, int landscape, int objects) {
            this.regionHash = regionHash;
            this.landscape = landscape;
            this.objects = objects;
        }

    }


    private int[][][] shootable = new int[4][][];
    private RegionData regionData;

    public Region(int id, int map, int mapObj) {
        this.id = id;
        regionData = new RegionData(id, map, mapObj);
    }

    public int getId() {
        return id;
    }

    public void addClip(int x, int y, int height, int shift) {
        int regionAbsX = (id >> 8) * 64;
        int regionAbsY = (id & 0xff) * 64;
        if (height < 0 || height >= 4)
            height = 0;
        //loadRegion(x, y);
        if (clips[height] == null) {
            clips[height] = new int[64][64];
        }
        clips[height][x - regionAbsX][y - regionAbsY] |= shift;
    }
    private static final WorldObject2[] EXISTANT_OBJECTS = {
            new WorldObject2(2213, 3114, 9850, 0, 10, 0),
            new WorldObject2(2213, 3115, 9850, 0, 10, 0),
            new WorldObject2(2213, 3116, 9850, 0, 10, 0),
            new WorldObject2(2213, 3117, 9850, 0, 10, 0),
            new WorldObject2(2213, 3118, 9850, 0, 10, 0),
            new WorldObject2(2213, 3119, 9850, 0, 10, 0),
            new WorldObject2(2213, 3120, 9850, 0, 10, 0),
            new WorldObject2(2213, 3121, 9850, 0, 10, 0),
            new WorldObject2(2213, 3116, 9846, 0, 10, 0),
            new WorldObject2(2513, 3121, 9838, 0, 10, 0),
            new WorldObject2(61, 3114, 9836, 0, 10, 0),
            new WorldObject2(2187, 3123, 9848, 0, 10, 1),
            new WorldObject2(2213, 3284, 2777, 0, 10, 0),
            new WorldObject2(2213, 3283, 2777, 0, 10, 0),
            new WorldObject2(2213, 3282, 2777, 0, 10, 0),
            new WorldObject2(2213, 3281, 2777, 0, 10, 0),
            new WorldObject2(2213, 3280, 2777, 0, 10, 0),
            new WorldObject2(2213, 3279, 2777, 0, 10, 0),
            new WorldObject2(2213, 3278, 2777, 0, 10, 0),
            new WorldObject2(1032, 3281, 2764, 0, 10, 0),
            new WorldObject2(2472, 2864, 3599, 0, 10, 0),
            new WorldObject2(10687, 3285, 2770, 0, 10, -1),
            new WorldObject2(2213, 2465, 3189, 0, 10, 1),
            new WorldObject2(2213, 2465, 3188, 0, 10, 1),
            new WorldObject2(2213, 2465, 3187, 0, 10, 1),
            new WorldObject2(6552, 2467, 3176, 0, 10, 0),
            new WorldObject2(410, 2467, 3179, 0, 10, 0),
            new WorldObject2(409, 2469, 3182, 0, 10, 0),
            new WorldObject2(2213, 3193, 6874, 0, 10, 1),
            new WorldObject2(2213, 3193, 6875, 0, 10, 1),
            new WorldObject2(2213, 3193, 6872, 0, 10, 1),
            new WorldObject2(2213, 3193, 6871, 0, 10, 1),
            new WorldObject2(2783, 3188, 6873, 0, 10, 0),
            new WorldObject2(2783, 3188, 6875, 0, 10, 0),
            new WorldObject2(2728, 3192, 6877, 0, 10, 0),
            new WorldObject2(2728, 3190, 6877, 0, 10, 0),
            new WorldObject2(2380, 3192, 6869, 0, 10, -1),
            new WorldObject2(2513, 3192, 6867, 0, 10, -1),
            new WorldObject2(8151, 2603, 4774, 0, 10, 0),
            new WorldObject2(8151, 2605, 4774, 0, 10, 0),
            new WorldObject2(8151, 2599, 4774, 0, 10, 0),
            new WorldObject2(8151, 2597, 4774, 0, 10, 0),
            new WorldObject2(7409, 3044, 3741, 0, 10, 0),
            new WorldObject2(7409, 3045, 3741, 0, 10, 0),
            new WorldObject2(7409, 3046, 3741, 0, 10, 0),
            new WorldObject2(7409, 3047, 3741, 0, 10, 0),
            new WorldObject2(7409, 3048, 3741, 0, 10, 0),
            new WorldObject2(7409, 3044, 3742, 0, 10, 0),
            new WorldObject2(7409, 3044, 3743, 0, 10, 0),
            new WorldObject2(7409, 3044, 3744, 0, 10, 0),
            new WorldObject2(7409, 3044, 3745, 0, 10, 0),
            new WorldObject2(7409, 3044, 3746, 0, 10, 0),
            new WorldObject2(7409, 3044, 3747, 0, 10, 0),
            new WorldObject2(7409, 3044, 3748, 0, 10, 0),
            new WorldObject2(7409, 3044, 3749, 0, 10, 0),
            new WorldObject2(7409, 3044, 3750, 0, 10, 0),
            new WorldObject2(7409, 3044, 3751, 0, 10, 0),
            new WorldObject2(7409, 3044, 3752, 0, 10, 0),
            new WorldObject2(7409, 3048, 3742, 0, 10, 0),
            new WorldObject2(7409, 3048, 3743, 0, 10, 0),
            new WorldObject2(7409, 3048, 3744, 0, 10, 0),
            new WorldObject2(7409, 3048, 3745, 0, 10, 0),
            new WorldObject2(7409, 3048, 3746, 0, 10, 0),
            new WorldObject2(7409, 3048, 3747, 0, 10, 0),
            new WorldObject2(7409, 3048, 3748, 0, 10, 0),
            new WorldObject2(7409, 3048, 3749, 0, 10, 0),
            new WorldObject2(7409, 3047, 3749, 0, 10, 0),
            new WorldObject2(7409, 3046, 3749, 0, 10, 0),
            new WorldObject2(7409, 3045, 3749, 0, 10, 0),
            new WorldObject2(7409, 3046, 3750, 0, 10, 0),
            new WorldObject2(7409, 3046, 3751, 0, 10, 0),
            new WorldObject2(7409, 3046, 3752, 0, 10, 0),
            new WorldObject2(7409, 3045, 3752, 0, 10, 0),
            new WorldObject2(4128, 3045, 3750, 0, 10, 0),
            new WorldObject2(4123, 3078, 3491, 0, 10, 0),
            new WorldObject2(4876, 2969, 3384, 0, 10, 0),
            new WorldObject2(4878, 2969, 3381, 0, 10, 0),
            new WorldObject2(4877, 2961, 3383, 0, 10, 0),
            new WorldObject2(2562, 2961, 3380, 0, 10, 1),
            new WorldObject2(2560, 2965, 3376, 0, 10, 0),
            new WorldObject2(2213, 3353, 3332, 0, 10, 0),
            new WorldObject2(2213, 3352, 3332, 0, 10, 0),
            new WorldObject2(2213, 3351, 3332, 0, 10, 0),
            new WorldObject2(2213, 3350, 3332, 0, 10, 0),
            new WorldObject2(7353, 2468, 3178, 0, 10, -1),
            new WorldObject2(8987, 2469, 3178, 0, 10, -1),
            new WorldObject2(2474, 2471, 3179, 0, 10, -1),
            new WorldObject2(8972, 2470, 3176, 0, 10, 0),
            new WorldObject2(16050, 2471, 3176, 0, 10, 0),
            new WorldObject2(2213, 2385, 3485, 0, 10, 1),
            new WorldObject2(2213, 2385, 3486, 0, 10, 1),
            new WorldObject2(2213, 2385, 3487, 0, 10, 1),
            new WorldObject2(2213, 2385, 3488, 0, 10, 1),
            new WorldObject2(2213, 2385, 3489, 0, 10, 1),
            new WorldObject2(2213, 2385, 3490, 0, 10, 1),
            new WorldObject2(2213, 2385, 3491, 0, 10, 1),
            new WorldObject2(7409, 2389, 3489, 0, 10, 0),
            new WorldObject2(7409, 2389, 3490, 0, 10, 0),
            new WorldObject2(7409, 2389, 3491, 0, 10, 0),
            new WorldObject2(7409, 2389, 3492, 0, 10, 0),
            new WorldObject2(7409, 2389, 3493, 0, 10, 0),
            new WorldObject2(7409, 2389, 3494, 0, 10, 0),
            new WorldObject2(7409, 2389, 3495, 0, 10, 0),
            new WorldObject2(7409, 2389, 3486, 0, 10, 0),
            new WorldObject2(7409, 2389, 3485, 0, 10, 0),
            new WorldObject2(7409, 2389, 3484, 0, 10, 0),
            new WorldObject2(7409, 2389, 3483, 0, 10, 0),
            new WorldObject2(7409, 2389, 3482, 0, 10, 0),
            new WorldObject2(7409, 2389, 3481, 0, 10, 0),
            new WorldObject2(1306, 2474, 3192, 0, 10, -1),
            new WorldObject2(2106, 2462, 3187, 0, 10, -1),
            new WorldObject2(2098, 2462, 3186, 0, 10, -1),
            new WorldObject2(2091, 2462, 3185, 0, 10, -1),
            new WorldObject2(2096, 2462, 3184, 0, 10, -1),
            new WorldObject2(2213, 2862, 3756, 0, 10, 0),
            new WorldObject2(2213, 3045, 9778, 0, 10, 1),
            new WorldObject2(2472, 2466, 3167, 0, 10, 1),
            new WorldObject2(2213, 3270, 3347, 0, 10, 1),
            new WorldObject2(2213, 3270, 3348, 0, 10, 1),
            new WorldObject2(2213, 3270, 3349, 0, 10, 1),
            new WorldObject2(2213, 3270, 3350, 0, 10, 1),
            new WorldObject2(2213, 3270, 3351, 0, 10, 1),
            new WorldObject2(2783, 3265, 3346, 0, 10, 2),
            new WorldObject2(2783, 3263, 3346, 0, 10, 2),
            new WorldObject2(2213, 2348, 3171, 0, 10, 1),
            new WorldObject2(2213, 2348, 3172, 0, 10, 1),
            new WorldObject2(1306, 2345, 3174, 0, 10, -1),
            new WorldObject2(1306, 2345, 3168, 0, 10, -1),
            new WorldObject2(1306, 2332, 3174, 0, 10, -1),
            new WorldObject2(1306, 2332, 3168, 0, 10, -1),
            new WorldObject2(2380, 2340, 3168, 0, 10, 0),
            new WorldObject2(2213, 2895, 3531, 0, 10, 0),
            new WorldObject2(2213, 2896, 3531, 0, 10, 0),
            new WorldObject2(2213, 2890, 3531, 0, 10, 0),
            new WorldObject2(28779, 2894, 3538, 0, 10, 0),
            new WorldObject2(28780, 2893, 3538, 0, 10, 0),
            new WorldObject2(28781, 2892, 3538, 0, 10, 0),
            new WorldObject2(2468, 2889, 3538, 0, 10, 0),
            new WorldObject2(2465, 2888, 3538, 0, 10, 0),
            new WorldObject2(2213, 2273, 4696, 0, 10, 0),
            new WorldObject2(2478, 2260, 4702, 0, 10, 0),
            new WorldObject2(2480, 2267, 4704, 0, 10, 0),
            new WorldObject2(2481, 2272, 4704, 0, 10, 0),
            new WorldObject2(2482, 2277, 4705, 0, 10, 0),
            new WorldObject2(2483, 2280, 4705, 0, 10, 0),
            new WorldObject2(2484, 2283, 4687, 0, 10, 0),
            new WorldObject2(2487, 2272, 4686, 0, 10, 0),
            new WorldObject2(2486, 2267, 4686, 0, 10, 0),
            new WorldObject2(2485, 2260, 4686, 0, 10, 0),
            new WorldObject2(2479, 2261, 4697, 0, 10, 0),
            new WorldObject2(2488, 2281, 4697, 0, 10, 0),
            new WorldObject2(2489, 2282, 4694, 0, 10, 0),
            new WorldObject2(2490, 2262, 4693, 0, 10, 0),
            new WorldObject2(2213, 3300, 3306, 0, 10, 0),
            new WorldObject2(2213, 3301, 3306, 0, 10, 0),
            new WorldObject2(2213, 3302, 3306, 0, 10, 0),
            new WorldObject2(2213, 3303, 3306, 0, 10, 0),
            new WorldObject2(362, 3306, 3303, 0, 10, 0),
            new WorldObject2(362, 3305, 3303, 0, 10, 0),
            new WorldObject2(362, 3304, 3303, 0, 10, 0),
            new WorldObject2(362, 3303, 3303, 0, 10, 0),
            new WorldObject2(362, 3300, 3303, 0, 10, 0),
            new WorldObject2(362, 3299, 3303, 0, 10, 0),
            new WorldObject2(362, 3298, 3303, 0, 10, 0),
            new WorldObject2(362, 3297, 3303, 0, 10, 0),
            new WorldObject2(362, 3296, 3303, 0, 10, 0),
            new WorldObject2(362, 3295, 3303, 0, 10, 0),
            new WorldObject2(362, 3301, 3296, 0, 10, 0),
            new WorldObject2(362, 3302, 3296, 0, 10, 0),
            new WorldObject2(362, 3296, 3296, 0, 10, 0),
            new WorldObject2(362, 3295, 3296, 0, 10, 0),
            new WorldObject2(362, 3294, 3296, 0, 10, 0),
            new WorldObject2(362, 3293, 3296, 0, 10, 0),
            new WorldObject2(362, 3298, 3309, 0, 10, 0),
            new WorldObject2(362, 3301, 3309, 0, 10, 0),
            new WorldObject2(362, 3302, 3309, 0, 10, 0),
            new WorldObject2(7319, 3092, 3503, 0, 10, 0),
            new WorldObject2(11666, 3047, 9791, 0, 10, 2),
            new WorldObject2(404, 3170, 6793, 0, 10, -3),
            new WorldObject2(404, 3171, 6793, 0, 10, -3),
            new WorldObject2(404, 3172, 6793, 0, 10, -3),
            new WorldObject2(404, 3173, 6793, 0, 10, -3),
            new WorldObject2(4113, 3142, 6806, 0, 10, -3),
            new WorldObject2(5259, 3173, 6785, 0, 10, -2),
            new WorldObject2(1308, 3301, 3486, 0, 10, -1),
            new WorldObject2(1306, 3295, 3481, 0, 10, -1),
            new WorldObject2(2213, 3094, 3499, 0, 10, 1),
            new WorldObject2(2213, 3094, 3498, 0, 10, 1),
            new WorldObject2(2213, 3094, 3497, 0, 10, 1),
            new WorldObject2(2213, 3095, 3496, 0, 10, 0),
            new WorldObject2(2213, 3096, 3496, 0, 10, 0),
            new WorldObject2(2213, 3097, 3496, 0, 10, 1),
            new WorldObject2(2213, 3097, 3495, 0, 10, 1),
            new WorldObject2(2213, 3097, 3494, 0, 10, 1),
            new WorldObject2(2213, 3097, 3493, 0, 10, 1),
            new WorldObject2(2213, 3097, 3492, 0, 10, 1),
            new WorldObject2(2213, 3097, 3491, 0, 10, 1),
            new WorldObject2(2213, 3096, 3491, 0, 10, 0),
            new WorldObject2(2213, 3095, 3491, 0, 10, 0),
            new WorldObject2(2213, 3094, 3490, 0, 10, 1),
            new WorldObject2(2213, 3094, 3489, 0, 10, 1),
            new WorldObject2(2213, 3094, 3488, 0, 10, 1),
            new WorldObject2(564, 3094, 3493, 0, 10, 1),
            new WorldObject2(563, 3095, 3493, 0, 10, -1),
            new WorldObject2(562, 3094, 3494, 0, 10, 1),
            new WorldObject2(566, 3095, 3494, 0, 10, -1),
            new WorldObject2(10, 3092, 3492, 0, 10, 1),
            new WorldObject2(4078, 3094, 3500, 0, 10, 1),
            new WorldObject2(4078, 3095, 3500, 0, 10, 1),
            new WorldObject2(4078, 3096, 3500, 0, 10, 1),
            new WorldObject2(4078, 3097, 3500, 0, 10, 1),
            new WorldObject2(4078, 3098, 3500, 0, 10, 1),
            new WorldObject2(4089, 3099, 3500, 0, 10, 1),
            new WorldObject2(4078, 3099, 3499, 0, 10, 2),
            new WorldObject2(4078, 3099, 3498, 0, 10, 2),
            new WorldObject2(4078, 3099, 3497, 0, 10, 2),
            new WorldObject2(4078, 3099, 3496, 0, 10, 2),
            new WorldObject2(4078, 3099, 3495, 0, 10, 2),
            new WorldObject2(4078, 3099, 3494, 0, 10, 2),
            new WorldObject2(4078, 3099, 3493, 0, 10, 2),
            new WorldObject2(4078, 3099, 3492, 0, 10, 2),
            new WorldObject2(4078, 3099, 3491, 0, 10, 2),
            new WorldObject2(4078, 3099, 3490, 0, 10, 2),
            new WorldObject2(4078, 3099, 3489, 0, 10, 2),
            new WorldObject2(4078, 3099, 3488, 0, 10, 2),
            new WorldObject2(4089, 3099, 3487, 0, 10, 2),
            new WorldObject2(4078, 3098, 3487, 0, 10, -1),
            new WorldObject2(4078, 3097, 3487, 0, 10, -1),
            new WorldObject2(4078, 3096, 3487, 0, 10, -1),
            new WorldObject2(4078, 3095, 3487, 0, 10, -1),
            new WorldObject2(4078, 3094, 3487, 0, 10, -1),
            new WorldObject2(4078, 3093, 3487, 0, 10, -1),
            new WorldObject2(4078, 3092, 3487, 0, 10, -1),
            new WorldObject2(4078, 3091, 3487, 0, 10, -1),
            new WorldObject2(4089, 3090, 3487, 0, 10, -1),
            new WorldObject2(4078, 3090, 3488, 0, 10, 0),
            new WorldObject2(4089, 3090, 3489, 0, 10, 0),
            new WorldObject2(4089, 3090, 3492, 0, 10, -1),
            new WorldObject2(4078, 3090, 3493, 0, 10, 0),
            new WorldObject2(4078, 3090, 3497, 0, 10, 0),
            new WorldObject2(4078, 3090, 3498, 0, 10, 0),
            new WorldObject2(4078, 3090, 3499, 0, 10, 0),
            new WorldObject2(4089, 3090, 3500, 0, 10, 0),
            new WorldObject2(4078, 3091, 3500, 0, 10, 1),
            new WorldObject2(2213, 3492, 9938, 0, 10, 1),
            new WorldObject2(2213, 3492, 9937, 0, 10, 1),
            new WorldObject2(2098, 3491, 9942, 0, 10, 1),
            new WorldObject2(2106, 3491, 9943, 0, 10, 1),
            new WorldObject2(2098, 3485, 9946, 0, 10, 1),
            new WorldObject2(2106, 3484, 9946, 0, 10, 1),
            new WorldObject2(2098, 3480, 9939, 0, 10, 1),
            new WorldObject2(2106, 3480, 9938, 0, 10, 1),
            new WorldObject2(2106, 3484, 9941, 0, 10, 1),
            new WorldObject2(2106, 3488, 9933, 0, 10, 1),
            new WorldObject2(2106, 3483, 9939, 0, 10, 1),
            new WorldObject2(2106, 3486, 9937, 0, 10, 1),
            new WorldObject2(2106, 3488, 9944, 0, 10, 1),
            new WorldObject2(2098, 3481, 9943, 0, 10, 1),
            new WorldObject2(2098, 3487, 9940, 0, 10, 1),
            new WorldObject2(2098, 3486, 9934, 0, 10, 1),
            new WorldObject2(2098, 3481, 9943, 0, 10, 1),
            new WorldObject2(2098, 3480, 9935, 0, 10, 1),
            new WorldObject2(10687, 2854, 5081, 0, 10, 1),
            new WorldObject2(10687, 2841, 5082, 0, 10, 1),
            new WorldObject2(2213, 2847, 5064, 0, 10, 0),
            new WorldObject2(2213, 2848, 5064, 0, 10, 0),
            new WorldObject2(2213, 2847, 5094, 0, 10, 0),
            new WorldObject2(2213, 2848, 5094, 0, 10, 0),
            new WorldObject2(2213, 2387, 4693, 0, 10, 0),
            new WorldObject2(2213, 2388, 4693, 0, 10, 0),
            new WorldObject2(2213, 2389, 4693, 0, 10, 0),
            new WorldObject2(2213, 2390, 4693, 0, 10, 0),
            new WorldObject2(1766, 2381, 4679, 0, 10, 1),
            new WorldObject2(1767, 2526, 4635, 0, 10, -1),
            new WorldObject2(1765, 2532, 4644, 0, 10, -1),
            new WorldObject2(1768, 2318, 9809, 0, 10, 0),
            new WorldObject2(2213, 2315, 9799, 0, 10, 0),
            new WorldObject2(2213, 2314, 9799, 0, 10, 0),
            new WorldObject2(2213, 2313, 9799, 0, 10, 0),
            new WorldObject2(2213, 2312, 9799, 0, 10, 0),
            new WorldObject2(2213, 2311, 9799, 0, 10, 0),
            new WorldObject2(2213, 2310, 9799, 0, 10, 0),
            new WorldObject2(9398, 2312, 9802, 0, 10, -1),
            new WorldObject2(2565, 2787, 2778, 0, 10, 1),
            new WorldObject2(2417, 3001, 3931, 0, 10, 0),
            new WorldObject2(13568, 3240, 9797, 0, 10, 2),
            new WorldObject2(13569, 3239, 9797, 0, 10, 2),
            new WorldObject2(13570, 3238, 9797, 0, 10, 2),
            new WorldObject2(13571, 3237, 9797, 0, 10, 2),
            new WorldObject2(13572, 3236, 9797, 0, 10, 2),
            new WorldObject2(13573, 3235, 9797, 0, 10, 2),
            new WorldObject2(2213, 3084, 3520, 0, 10, 0),
            new WorldObject2(2213, 3088, 3520, 0, 10, 0),
            new WorldObject2(9398, 2599, 3425, 0, 10, -1),
            new WorldObject2(9398, 2605, 3411, 0, 10, -1),
            new WorldObject2(2213, 3357, 3215, 0, 10, 1),
            new WorldObject2(2213, 3357, 3214, 0, 10, 1),
            new WorldObject2(2213, 3357, 3213, 0, 10, 1),
            new WorldObject2(2213, 3357, 3212, 0, 10, 1),
            new WorldObject2(2213, 3357, 3211, 0, 10, 1),
            new WorldObject2(3192, 3079, 3518, 0, 10, -3),
            new WorldObject2(2213, 3222, 3217, 0, 10, 0),
            new WorldObject2(2213, 3221, 3217, 0, 10, 0),
            new WorldObject2(2213, 3222, 3220, 0, 10, 0),
            new WorldObject2(2213, 3221, 3220, 0, 10, 0),
            new WorldObject2(23095, 2895, 3538, 0, 10, 0),
            new WorldObject2(1330, 2857, 3755, 0, 10, 0),
            new WorldObject2(1332, 2864, 3755, 0, 10, 0),
            new WorldObject2(1331, 2872, 3763, 0, 10, 0),
            new WorldObject2(1332, 2871, 3769, 0, 10, 0),
            new WorldObject2(1331, 2863, 3769, 0, 10, 0),
            new WorldObject2(1330, 2863, 3761, 0, 10, 0),
            new WorldObject2(63, 3132, 3204, 0, 10, 0),
            new WorldObject2(63, 3132, 3205, 0, 10, 0),
            new WorldObject2(63, 3134, 3206, 0, 10, 0),
            new WorldObject2(63, 3135, 3206, 0, 10, 0),
            new WorldObject2(63, 3135, 3207, 0, 10, 0),
            new WorldObject2(63, 3136, 3208, 0, 10, 0),
            new WorldObject2(63, 3137, 3209, 0, 10, 0),
            new WorldObject2(63, 3138, 3210, 0, 10, 0),
            new WorldObject2(63, 3139, 3211, 0, 10, 0),
            new WorldObject2(63, 3145, 3215, 0, 10, 0),
            new WorldObject2(63, 3144, 3215, 0, 10, 0),
            new WorldObject2(63, 3143, 3215, 0, 10, 0),
            new WorldObject2(2213, 3141, 3204, 0, 10, 0),
            new WorldObject2(3769, 3420, 4776, 0, 10, 0),
            new WorldObject2(8576, 2602, 4779, 0, 10, -1),
            new WorldObject2(8576, 2603, 4779, 0, 10, -1),
            new WorldObject2(8576, 2602, 4780, 0, 10, -1),
            new WorldObject2(8576, 2603, 4780, 0, 10, -1),
            new WorldObject2(2213, 3022, 3454, 0, 10, 1),
            new WorldObject2(2213, 3022, 3453, 0, 10, 1),
            new WorldObject2(2213, 3022, 3452, 0, 10, 1),
            new WorldObject2(2213, 3022, 3451, 0, 10, 1),
            new WorldObject2(2213, 3022, 3450, 0, 10, 1),
            new WorldObject2(2213, 3022, 3449, 0, 10, 1),
            new WorldObject2(1306, 3016, 3461, 0, 10, -1),
            new WorldObject2(2213, 2807, 2787, 1, 10, 1),
            new WorldObject2(2213, 2807, 2786, 1, 10, 1),
            new WorldObject2(2213, 2807, 2785, 1, 10, 1),
            new WorldObject2(2213, 2807, 2784, 1, 10, 1),
            new WorldObject2(2213, 2807, 2783, 1, 10, 1)
    };

    /**
     * A map containing each region as the key, and a Collection of real world
     * objects as the value.
     */
    private static HashMap<Integer, ArrayList<WorldObject2>> worldObjects = new HashMap<>();

    /**
     * Determines if an object is real or not. If the Collection of regions and
     * real objects contains the properties passed in the parameters then the
     * object will be determined real
     *
     * @param id
     *            the id of the object
     * @param x
     *            the x coordinate of the object
     * @param y
     *            the y coordinate of the object
     * @param height
     *            the height of the object
     * @return
     */
    public static boolean isWorldObject(int id, int x, int y, int height) {
        Region region = getRegion(x, y);
        if (region == null) {
            return true;
        }
        Collection<WorldObject2> regionObjects = worldObjects.get(region.id);
        if (regionObjects == null) {
            return true;
        }
        Optional<WorldObject2> exists = regionObjects.stream()
                .filter(object -> object.id == id && object.x == x && object.y == y && object.height == height)
                .findFirst();
        return exists.isPresent();
    }

    public static Optional<WorldObject2> getWorldObject(int id, int x, int y, int height) {
        Region region = getRegion(x, y);
        if (region == null) {
            return Optional.empty();
        }
        Collection<WorldObject2> regionObjects = worldObjects.get(region.id);
        if (regionObjects == null) {
            return Optional.empty();
        }
        Optional<WorldObject2> exists = regionObjects.stream()
                .filter(object -> object.id == id && object.x == x && object.y == y && object.height == height)
                .findFirst();
        return exists;
    }

    /**
     * Adds a {@link WorldObject2} to the {@link worldObjects2} map based on the
     * x, y, height, and identification of the object.
     *
     * @param id
     *            the id of the object
     * @param x
     *            the x position of the object
     * @param y
     *            the y position of the object
     * @param height
     *            the height of the object
     */
    public static void addWorldObject(int id, int x, int y, int height, int face) {
        Region region = getRegion(x, y);
        if (region == null) {
            return;
        }
        int regionId = region.id;
        if (worldObjects.containsKey(regionId)) {
            if (objectExists(regionId, id, x, y, height)) {
                return;
            }
            worldObjects.get(regionId).add(new WorldObject2(id, x, y, height, face));
        } else {
            ArrayList<WorldObject2> object = new ArrayList<>(1);
            object.add(new WorldObject2(id, x, y, height, face));
            worldObjects.put(regionId, object);
        }
    }

    private static boolean objectExists(int region, int id, int x, int y, int height) {
        List<WorldObject2> objects = worldObjects.get(region);
        for (WorldObject2 object : objects) {
            if (object == null) {
                continue;
            }
            if (object.getId() == id && object.getX() == x && object.getY() == y && object.getHeight() == height) {
                return true;
            }
        }
        return false;
    }


    public static void removeWorldObject(int id, int x, int y, int height) {
        Region region = getRegion(x, y);
        if (region == null) {
            return;
        }
        int regionId = region.id;
        if (worldObjects.containsKey(regionId)) {
            List<WorldObject2> objects = worldObjects.get(regionId);
            for (WorldObject2 object : objects) {
                if (object == null) {
                    continue;
                }
                if (object.getId() == id && object.getX() == x && object.getY() == y && object.getHeight() == height) {
                    objects.remove(object);
                    if (objects.isEmpty()) {
                        worldObjects.remove(regionId);
                    }
                }
            }
        }
    }

    /**
     * A convenience method for lamda expressions
     *
     * @param object
     *            the world object being added
     */
    private static void addWorldObject(WorldObject2 object) {
        addWorldObject(object.getId(), object.getX(), object.getY(), object.getHeight(), object.getFace());
    }


    private int getClip(int x, int y, int height) {
        // height %= 4;
        int regionAbsX = (id >> 8) * 64;
        int regionAbsY = (id & 0xff) * 64;
        //loadRegion(x, y);
        if (clips[height] == null) {
            clips[height] = new int[64][64];
        }
        return clips[height][x - regionAbsX][y - regionAbsY];
    }
    public static boolean isBlockedPath(int sourceX, int sourceY, int destX, int destY, int z) {
        if (sourceX > destX) {
            if (sourceY > destY) {
                return blockedNorthEast(destX, destY, z);
            } else if (sourceY < destY) {
                return blockedSouthEast(destX, destY, z);
            }
            return blockedEast(destX, destY, z);
        } else if (sourceX < destX) {
            if (sourceY > destY) {
                return blockedNorthWest(destX, destY, z);
            } else if (sourceY < destY) {
                return blockedSouthWest(destX, destY, z);
            }
            return blockedWest(destX, destY, z);
        } else {
            if (sourceY > destY) {
                return blockedNorth(destX, destY, z);
            } else if (sourceY < destY) {
                return blockedSouth(destX, destY, z);
            }
        }
        return false;
    }


    public static boolean blockedNorth(int x, int y, int z) {
        return (getClipping(x, y + 1, z) & 0x12c0120) != 0;
    }

    public static boolean blockedEast(int x, int y, int z) {
        return (getClipping(x + 1, y, z) & 0x12c0180) != 0;
    }

    public static boolean blockedSouth(int x, int y, int z) {
        return (getClipping(x, y - 1, z) & 0x12c0108) != 0;
    }

    public static boolean blockedWest(int x, int y, int z) {
        return (getClipping(x - 1, y, z) & 0x12c0120) != 0;
    }

    public static boolean blockedNorthEast(int x, int y, int z) {
        return (getClipping(x + 1, y + 1, z) & 0x12801e0) != 0;
    }

    public static boolean blockedNorthWest(int x, int y, int z) {
        return (getClipping(x - 1, y + 1, z) & 0x1280138) != 0;
    }

    public static boolean blockedSouthEast(int x, int y, int z) {
        return (getClipping(x + 1, y - 1, z) & 0x1280183) != 0;
    }

    public static boolean blockedSouthWest(int x, int y, int z) {
        return (getClipping(x - 1, y - 1, z) & 0x12c0120) != 0;
    }
    public static void addClipping(int x, int y, int height, int shift) {
        // System.out.println("Added clip at "+x+" and "+y+"");
        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = (regionX / 8 << 8) + regionY / 8;
        Region r = get(regionId);
        if (r != null) {
            r.addClip(x, y, height, shift);
        }
    }
    private static Region[] regions;
    private int id;
    private int[][][] clips = new int[4][][];
    private boolean members = false;

    public Region(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    public boolean members()
    {
        return members;
    }

    public static boolean isMembers(int x, int y, int height)
    {
        if(x >= 3272 && x <= 3320 && y >= 2752 && y <= 2809)
            return false;
        if(x >= 2640 && x <= 2677 && y >= 2638 && y <= 2679)
            return false;
        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = ((regionX / 8) << 8) + (regionY / 8);
        for (Region r : regions) {
            if (r.id() == regionId) {
                return r.members();
            }
        }
        return false;
    }
    public void setClipToZero(int x, int y, int height) {
        height = height % 4;
        int regionAbsX = (id >> 8) * 64;
        int regionAbsY = (id & 255) * 64;
        if (clips[height] == null) {
            clips[height] = new int[64][64];
        }
        clips[height][x - regionAbsX][y - regionAbsY] = 0;
    }
    private static void addWall(int x, int y, int height, int type, int direction, boolean solid, boolean unknown) {
        if (type == 0) {
            if (direction == 0) {
                addClipping(x, y, height, 128);
                addClipping(x - 1, y, height, 8);
            } else if (direction == 1) {
                addClipping(x, y, height, 2);
                addClipping(x, y + 1, height, 32);
            } else if (direction == 2) {
                addClipping(x, y, height, 8);
                addClipping(x + 1, y, height, 128);
            } else if (direction == 3) {
                addClipping(x, y, height, 32);
                addClipping(x, y - 1, height, 2);
            }
        } else if (type == 1 || type == 3) {
            if (direction == 0) {
                addClipping(x, y, height, 1);
                addClipping(x - 1, y, height, 16);
            } else if (direction == 1) {
                addClipping(x, y, height, 4);
                addClipping(x + 1, y + 1, height, 64);
            } else if (direction == 2) {
                addClipping(x, y, height, 16);
                addClipping(x + 1, y - 1, height, 1);
            } else if (direction == 3) {
                addClipping(x, y, height, 64);
                addClipping(x - 1, y - 1, height, 4);
            }
        } else if (type == 2) {
            if (direction == 0) {
                addClipping(x, y, height, 130);
                addClipping(x - 1, y, height, 8);
                addClipping(x, y + 1, height, 32);
            } else if (direction == 1) {
                addClipping(x, y, height, 10);
                addClipping(x, y + 1, height, 32);
                addClipping(x + 1, y, height, 128);
            } else if (direction == 2) {
                addClipping(x, y, height, 40);
                addClipping(x + 1, y, height, 128);
                addClipping(x, y - 1, height, 2);
            } else if (direction == 3) {
                addClipping(x, y, height, 160);
                addClipping(x, y - 1, height, 2);
                addClipping(x - 1, y, height, 8);
            }
        }
        if (solid) {
            if (type == 0) {
                if (direction == 0) {
                    addClipping(x, y, height, 0x10000);
                    addClipping(x - 1, y, height, 4096);
                } else if (direction == 1) {
                    addClipping(x, y, height, 1024);
                    addClipping(x, y + 1, height, 16384);
                } else if (direction == 2) {
                    addClipping(x, y, height, 4096);
                    addClipping(x + 1, y, height, 0x10000);
                } else if (direction == 3) {
                    addClipping(x, y, height, 16384);
                    addClipping(x, y - 1, height, 1024);
                }
            }
            if (type == 1 || type == 3) {
                if (direction == 0) {
                    addClipping(x, y, height, 512);
                    addClipping(x - 1, y + 1, height, 8192);
                } else if (direction == 1) {
                    addClipping(x, y, height, 2048);
                    addClipping(x + 1, y + 1, height, 32768);
                } else if (direction == 2) {
                    addClipping(x, y, height, 8192);
                    addClipping(x + 1, y + 1, height, 512);
                } else if (direction == 3) {
                    addClipping(x, y, height, 32768);
                    addClipping(x - 1, y - 1, height, 2048);
                }
            } else if (type == 2) {
                if (direction == 0) {
                    addClipping(x, y, height, 0x10400);
                    addClipping(x - 1, y, height, 4096);
                    addClipping(x, y + 1, height, 16384);
                } else if (direction == 1) {
                    addClipping(x, y, height, 5120);
                    addClipping(x, y + 1, height, 16384);
                    addClipping(x + 1, y, height, 65536);
                } else if (direction == 2) {
                    addClipping(x, y, height, 20480);
                    addClipping(x + 1, y, height, 65536);
                    addClipping(x, y - 1, height, 1024);
                } else if (direction == 3) {
                    addClipping(x, y, height, 0x14000);
                    addClipping(x, y - 1, height, 1024);
                    addClipping(x - 1, y, height, 4096);
                }
            }
        }
        if (unknown) {
            if (type == 0) {
                if (direction == 0) {
                    addClipping(x, y, height,0x20000000);
                    addClipping(x - 1, y,height, 0x2000000);
                }
                if (direction == 1) {
                    addClipping(x, y, height,0x800000);
                    addClipping(x, y + 1,height, 0x8000000);
                }
                if (direction == 2) {
                    addClipping(x, y,height, 0x2000000);
                    addClipping(x + 1, y,height, 0x20000000);
                }
                if (direction == 3) {
                    addClipping(x, y,height, 0x8000000);
                    addClipping(x, y - 1,height, 0x800000);
                }
            }
            if (type == 1 || type == 3) {
                if (direction == 0) {
                    addClipping(x, y, height,0x400000);
                    addClipping(x - 1, y + 1 ,height, 0x4000000);
                }
                if (direction == 1) {
                    addClipping(x, y,height, 0x1000000);
                    addClipping(1 + x, 1 + y,height, 0x10000000);
                }
                if (direction == 2) {
                    addClipping(x, y,height, 0x4000000);
                    addClipping(x + 1, -1 + y,height, 0x400000);
                }
                if (direction == 3) {
                    addClipping(x, y,height, 0x10000000);
                    addClipping(-1 + x, y - 1,height, 0x1000000);
                }
            }
            if (type == 2) {
                if (direction == 0) {
                    addClipping(x, y, height,0x20800000);
                    addClipping(-1 + x, y, height,0x2000000);
                    addClipping(x, 1 + y,height, 0x8000000);
                }
                if (direction == 1) {
                    addClipping(x, y,height, 0x2800000);
                    addClipping(x, 1 + y,height, 0x8000000);
                    addClipping(x + 1, y,height, 0x20000000);
                }
                if (direction == 2) {
                    addClipping(x, y, height,0xa000000);
                    addClipping(1 + x, y,height, 0x20000000);
                    addClipping(x, y - 1,height, 0x800000);
                }
                if (direction == 3) {
                    addClipping(x, y,height, 0x28000000);
                    addClipping(x, y - 1,height, 0x800000);
                    addClipping(-1 + x, y,height, 0x2000000);
                }
            }
        }
    }
    private static void removeClippingForVariableObject(int x, int y, int height, int type, int direction, boolean flag) {
        if (type == 0) {
            if (direction == 0) {
                addClipping(x, y, height, -128);
                addClipping(x - 1, y, height, -8);
            } else if (direction == 1) {
                addClipping(x, y, height, -2);
                addClipping(x, y + 1, height, -32);
            } else if (direction == 2) {
                addClipping(x, y, height, -8);
                addClipping(x + 1, y, height, -128);
            } else if (direction == 3) {
                addClipping(x, y, height, -32);
                addClipping(x, y - 1, height, -2);
            }
        } else if (type == 1 || type == 3) {
            if (direction == 0) {
                addClipping(x, y, height, -1);
                addClipping(x - 1, y, height, -16);
            } else if (direction == 1) {
                addClipping(x, y, height, 4);
                addClipping(x + 1, y + 1, height, -64);
            } else if (direction == 2) {
                addClipping(x, y, height, -16);
                addClipping(x + 1, y - 1, height, -1);
            } else if (direction == 3) {
                addClipping(x, y, height, 64);
                addClipping(x - 1, y - 1, height, -4);
            }
        } else if (type == 2) {
            if (direction == 0) {
                addClipping(x, y, height, -130);
                addClipping(x - 1, y, height, -8);
                addClipping(x, y + 1, height, -32);
            } else if (direction == 1) {
                addClipping(x, y, height, -10);
                addClipping(x, y + 1, height, -32);
                addClipping(x + 1, y, height, -128);
            } else if (direction == 2) {
                addClipping(x, y, height, -40);
                addClipping(x + 1, y, height, -128);
                addClipping(x, y - 1, height, -2);
            } else if (direction == 3) {
                addClipping(x, y, height, -160);
                addClipping(x, y - 1, height, -2);
                addClipping(x - 1, y, height, -8);
            }
        }
        if (flag) {
            if (type == 0) {
                if (direction == 0) {
                    addClipping(x, y, height, -65536);
                    addClipping(x - 1, y, height, -4096);
                } else if (direction == 1) {
                    addClipping(x, y, height, -1024);
                    addClipping(x, y + 1, height, -16384);
                } else if (direction == 2) {
                    addClipping(x, y, height, -4096);
                    addClipping(x + 1, y, height, -65536);
                } else if (direction == 3) {
                    addClipping(x, y, height, -16384);
                    addClipping(x, y - 1, height, -1024);
                }
            }
            if (type == 1 || type == 3) {
                if (direction == 0) {
                    addClipping(x, y, height, -512);
                    addClipping(x - 1, y + 1, height, -8192);
                } else if (direction == 1) {
                    addClipping(x, y, height, -2048);
                    addClipping(x + 1, y + 1, height, -32768);
                } else if (direction == 2) {
                    addClipping(x, y, height, -8192);
                    addClipping(x + 1, y + 1, height, -512);
                } else if (direction == 3) {
                    addClipping(x, y, height, -32768);
                    addClipping(x - 1, y - 1, height, -2048);
                }
            } else if (type == 2) {
                if (direction == 0) {
                    addClipping(x, y, height, -66560);
                    addClipping(x - 1, y, height, -4096);
                    addClipping(x, y + 1, height, -16384);
                } else if (direction == 1) {
                    addClipping(x, y, height, -5120);
                    addClipping(x, y + 1, height, -16384);
                    addClipping(x + 1, y, height, -65536);
                } else if (direction == 2) {
                    addClipping(x, y, height, -20480);
                    addClipping(x + 1, y, height, -65536);
                    addClipping(x, y - 1, height, -1024);
                } else if (direction == 3) {
                    addClipping(x, y, height, -81920);
                    addClipping(x, y - 1, height, -1024);
                    addClipping(x - 1, y, height, -4096);
                }
            }
        }
    }
    private static void addClippingForSolidObject(int x, int y, int height, int xLength, int yLength, boolean flag, boolean b) {
        int clipping = 256;
        if (flag)
            clipping += 131072;
        if (b)
            clipping += 1073741824;
        for (int i = x; i < x + xLength; i++) {
            for (int i2 = y; i2 < y + yLength; i2++) {
                addClipping(i, i2, height, clipping);
            }
        }
    }
    private static void removeClippingForSolidObject(int x, int y, int height, int xLength, int yLength, boolean flag, boolean b) {
        int clipping = 256;
        if (flag)
            clipping += 131072;
        if (b)
            clipping += 1073741824;
        for (int i = x; i < x + xLength; i++) {
            for (int i2 = y; i2 < y + yLength; i2++) {
                addClipping(i, i2, height, clipping);
            }
        }
    }
    public void removeObject(int objectId, int x, int y, int height, int type, int direction) {
        ObjectDef def = ObjectDef.getObjectDef(objectId);
        if (def == null) {
            return;
        }
        int xLength;
        int yLength;
        if (direction != 1 && direction != 3) {
            xLength = def.xLength();
            yLength = def.yLength();
        } else {
            xLength = def.yLength();
            yLength = def.xLength();
        }
        if (type == 22) {
            if (def.isProjectileCliped() && def.hasActions()) {
                addClipping(x, y, height, -2097152);
            }
        } else if (type >= 9) {
            if (def.isProjectileCliped()) {
                removeClippingForSolidObject(x, y, height, xLength, yLength, false, true);

            }
        } else if (type >= 0 && type <= 3) {
            if (def.isProjectileCliped()) {
                removeClippingForVariableObject(x, y, height, type, direction, false);
            }
        }
    }

    public static void addObject(int objectId, int x, int y, int height, int type, int direction) {
        ObjectDef def = ObjectDef.getObjectDef(objectId);
        if (def == null) {
            return;
        }

        switch (objectId) {
            case 14233: // pest control gates
            case 14235: // pest control gates
            case 782:
                return;
        }
        if (objectId == -1) {
            removeClipping(x, y, height, 0x000000);
            return;
        }
        if (type == 22 ? def.aBoolean757 != false : def
                .aBoolean757 == false) {

            return;
        } else if (type >= 0 && type <= 3) {
            addWall(x, y, height, type, direction, def.projectileCliped, true);
            if(def.isProjectileCliped())
            {
                addWall(x, y, height, type, direction, def.projectileCliped, true);
            }
        } else if (type >= 9 && type <= 21) {
            int xLength;
            int yLength;
            if (direction == 1 || direction == 3) {
                xLength = def.yLength();
                yLength = def.xLength();
            } else {
                xLength = def.xLength();
                yLength = def.yLength();
            }
            addClippingForSolidObject(x, y, height, xLength, yLength, def.projectileCliped, true);
            if (def.isProjectileCliped()) {
                addClippingForSolidObject(x, y, height, xLength, yLength, def.projectileCliped, true);
            }
        }
        if ((def != null ? def.name : null) != null && def.name.equalsIgnoreCase("door") && def.actions[0].equalsIgnoreCase("open")) {
            dumpDoorobject(objectId, x, y, direction, height, type);
        }
    }

    public static void removeClipping(int x, int y, int height, int shift) {

        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = (regionX / 8 << 8) + regionY / 8;

        Region r = get(regionId);
        if (r != null) {
            r.removeClip(x, y, height, shift);
        }
    }

    public void removeClip(int x, int y, int height, int shift) {
        int regionAbsX = (id >> 8) * 64;
        int regionAbsY = (id & 0xff) * 64;
        if (height < 0 || height >= 4)
            height = 0;

        if (clips[height] == null) {
            clips[height] = new int[64][64];
        }
        clips[height][x - regionAbsX][y - regionAbsY] = /* 16777215 - shift */0;
    }

    public static int getClipping(int x, int y, int height) {
        //loadRegion(x, y);
        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = ((regionX / 8) << 8) + (regionY / 8);
        if (height >= 4)
            height = 0;
        else if (height == -1)// || Location.inLocation(x, y, Location.PURO_PURO))
            return 0;
        Region r = get(regionId);
        if (r != null) {
            return r.getClip(x, y, height);
        }
        return 0;
    }

    public static boolean getClipping(int x, int y, int height, int moveTypeX, int moveTypeY) {
        try {
            if (height > 3)
                height = 0;
            int checkX = (x + moveTypeX);
            int checkY = (y + moveTypeY);
            if (moveTypeX == -1 && moveTypeY == 0)
                return (getClipping(x, y, height) & 0x1280108) == 0;
            else if (moveTypeX == 1 && moveTypeY == 0)
                return (getClipping(x, y, height) & 0x1280180) == 0;
            else if (moveTypeX == 0 && moveTypeY == -1)
                return (getClipping(x, y, height) & 0x1280102) == 0;
            else if (moveTypeX == 0 && moveTypeY == 1)
                return (getClipping(x, y, height) & 0x1280120) == 0;
            else if (moveTypeX == -1 && moveTypeY == -1)
                return ((getClipping(x, y, height) & 0x128010e) == 0 && (getClipping(checkX - 1, checkY, height) & 0x1280108) == 0
                        && (getClipping(checkX - 1, checkY, height) & 0x1280102) == 0);
            else if (moveTypeX == 1 && moveTypeY == -1)
                return ((getClipping(x, y, height) & 0x1280183) == 0 && (getClipping(checkX + 1, checkY, height) & 0x1280180) == 0
                        && (getClipping(checkX, checkY - 1, height) & 0x1280102) == 0);
            else if (moveTypeX == -1 && moveTypeY == 1)
                return ((getClipping(x, y, height) & 0x1280138) == 0 && (getClipping(checkX - 1, checkY, height) & 0x1280108) == 0
                        && (getClipping(checkX, checkY + 1, height) & 0x1280120) == 0);
            else if (moveTypeX == 1 && moveTypeY == 1)
                return ((getClipping(x, y, height) & 0x12801e0) == 0 && (getClipping(checkX + 1, checkY, height) & 0x1280180) == 0
                        && (getClipping(checkX, checkY + 1, height) & 0x1280120) == 0);
            else {
                // System.out.println("[FATAL ERROR]: At getClipping: " + x + ", "
                // + y + ", " + height + ", " + moveTypeX + ", "
                // + moveTypeY);
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }

    public static void init() {
        try {
            ObjectDef.loadConfig();
            final File file = new File("./Data/world/525map_index");
            final byte[] buffer = new byte[(int) file.length()];
            final DataInputStream input = new DataInputStream(
                    new FileInputStream(file));
            input.readFully(buffer);
            input.close();
            final ByteStream stream = new ByteStream(buffer);
            int size = stream.getUShort();
            int[] regionIds = new int[size];
            int[] mapGroundFileIds = new int[size];
            int[] mapObjectsFileIds = new int[size];
            RegionData[] data = new RegionData[size];
            regionArray = new Region[size];
            for (int i = 0; i < size; i++) {
                regionIds[i] = stream.getUShort();
                mapGroundFileIds[i] = stream.getUShort();
                mapObjectsFileIds[i] = stream.getUShort();
                data[i] = new RegionData(regionIds[i], mapGroundFileIds[i], mapObjectsFileIds[i]);
                regionArray[i] = new Region(regionIds[i],
                        mapGroundFileIds[i], mapObjectsFileIds[i]);
            }

            Arrays.stream(data).forEach(Region::loadMap);
            Arrays.asList(EXISTANT_OBJECTS).forEach(o -> addWorldObject(o));
            System.out.println("Loaded " + size + " region maps.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        get(11051).setClipToZero(2804, 2786, 1);
        get(11051).setClipToZero(2804, 2784, 1);
        get(11051).setClipToZero(2803, 2786, 1);
        get(11051).setClipToZero(2803, 2784, 1);
        get(12650).setClipToZero(3170, 6791, 0);
        get(12650).setClipToZero(3169, 6791, 0);
        get(12649).setClipToZero(3171, 6783, 0);
        get(12649).setClipToZero(3171, 6782, 0);
        get(12649).setClipToZero(3180, 6779, 0);
        get(12649).setClipToZero(3180, 6780, 0);
        get(12649).setClipToZero(3180, 6781, 0);
        get(12849).setClipToZero(3244, 3196, 0);
        get(12849).setClipToZero(3244, 3197, 0);
        get(12849).setClipToZero(3244, 3195, 0);
        get(12849).setClipToZero(3244, 3198, 0);
        get(12849).setClipToZero(3244, 3194, 0);
    }

    public static Region get(int regionId) {
        for (Region r : regionArray) {
            if (r.id == regionId) {
                return r;
            }
        }
        return null;
    }
    private static void loadMap(RegionData regionData) {
        try {
            byte[] file1 = getBuffer(new File("./Data/world/map/" + regionData.getObjects() + ".Gz"));
            byte[] file2 = getBuffer(new File("./Data/world/map/" + regionData.getLandscape() + ".Gz"));
            if (file1 == null || file2 == null) {
                return;
            }
            loadMaps(regionData.getRegionHash(), new ByteStream(file1), new ByteStream(file2));
            // loadMapsold(regionData.getRegionHash(), new ByteStream(file1), new ByteStream(file2));
        } catch (Exception e) {
            System.out.println("Error loading map region: " + regionData.getRegionHash() + ", objectFile: " + regionData.getObjects() + ", floorFile: " + regionData.getLandscape());
            e.printStackTrace();
        }
        //System.out.println("Error loading map region: " + regionData.getRegionHash() + ", objectFile: " + regionData.getObjects() + ", floorFile: " + regionData.getLandscape());
        //e.printStackTrace();
    }
    public static void dumpDoorobject(int objectId, int x, int y, int face, int h, int type) {
        //x	y	height	walk	maxhit	attack	defence	desc
        //Server.npcHandler.spawnNpc(c, npcType, absX, absY, heightLevel, 1, 120, 7, 70, 70, false, false);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(".//Data/Doordump.cfg", true));
            try {
                out.write(objectId+" "+x+" "+y+" "+face+" "+h+" "+type);
                out.newLine();
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void dumpDoorobject2(int objectId, int x, int y, int face, int h, int type) {
        //x	y	height	walk	maxhit	attack	defence	desc
        //Server.npcHandler.spawnNpc(c, npcType, absX, absY, heightLevel, 1, 120, 7, 70, 70, false, false);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("./Data/Doordump.cfg", true));
            try {
                out.write(objectId+" "+x+" "+y+" "+h+" "+face);
                out.newLine();
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static byte[] getBuffer(File f) throws Exception
    {
        if(!f.exists())
            return null;
        byte[] buffer = new byte[(int) f.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(f));
        dis.readFully(buffer);
        dis.close();
        byte[] gzipInputBuffer = new byte[999999];
        int bufferlength = 0;
        GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(buffer));
        do {
            if(bufferlength == gzipInputBuffer.length)
            {
                System.out.println("Error inflating data.\nGZIP buffer overflow.");
                break;
            }
            int readByte = gzip.read(gzipInputBuffer, bufferlength, gzipInputBuffer.length - bufferlength);
            if(readByte == -1)
                break;
            bufferlength += readByte;
        } while(true);
        byte[] inflated = new byte[bufferlength];
        System.arraycopy(gzipInputBuffer, 0, inflated, 0, bufferlength);
        buffer = inflated;
        if(buffer.length < 10)
            return null;
        return buffer;
    }
    private static void loadMaps(int regionId, ByteStream str1, ByteStream str2) {
        int absX = (regionId >> 8) * 64;
        int absY = (regionId & 0xff) * 64;
        int[][][] someArray = new int[4][64][64];
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 64; i2++) {
                for (int i3 = 0; i3 < 64; i3++) {
                    while (true) {
                        int v = str2.getUByte();
                        if (v == 0) {
                            break;
                        } else if (v == 1) {
                            str2.skip(1);
                            break;
                        } else if (v <= 49) {
                            str2.skip(1);
                        } else if (v <= 81) {
                            someArray[i][i2][i3] = v - 49;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 64; i2++) {
                for (int i3 = 0; i3 < 64; i3++) {
                    if ((someArray[i][i2][i3] & 1) == 1) {
                        int height = i;
                        if ((someArray[1][i2][i3] & 2) == 2) {
                            height--;
                        }
                        if (height >= 0 && height <= 4) {
                            addClipping(absX + i2, absY + i3, height, 2097152);
                        }
                    }
                }
            }
        }
        int objectId = -1;
        int incr;
        while ((incr = str1.method1606()) != 0) {
            objectId += incr;
            int location = 0;
            int incr2;
            while ((incr2 = str1.readUShortSmart()) != 0) {
                location += -1 + incr2;
                int localX = (location >> 6 & 0x3f);
                int localY = (location & 0x3f);
                int height = location >> 12;
                int objectData = str1.getUByte();
                int type = objectData >> 2;
                int direction = objectData & 0x3;
                if (localX < 0 || localX >= 64 || localY < 0 || localY >= 64) {
                    continue;
                }
                int objectPlane = height;
                if ((someArray[1][localX][localY] & 2) == 2) {
                    objectPlane--;
                }
                if (objectPlane < 0 || objectPlane >= 4 || height < 0 || height <= 4) {
                    //System.out.println("Adding "+objectId+" at "+ absX + localX);
                    addObject(objectId, absX + localX, absY + localY, objectPlane, type, direction);
                    addWorldObject(objectId, absX + localX, absY + localY, objectPlane, direction);
                }
            }
        }
    }
    public static boolean canShoot(int x, int y, int z, int direction) {
        if (direction == 0) {
            return !projectileBlockedNorthWest(x, y, z) && !projectileBlockedNorth(x, y, z)
                    && !projectileBlockedWest(x, y, z);
        } else if (direction == 1) {
            return !projectileBlockedNorth(x, y, z);
        } else if (direction == 2) {
            return !projectileBlockedNorthEast(x, y, z) && !projectileBlockedNorth(x, y, z)
                    && !projectileBlockedEast(x, y, z);
        } else if (direction == 3) {
            return !projectileBlockedWest(x, y, z);
        } else if (direction == 4) {
            return !projectileBlockedEast(x, y, z);
        } else if (direction == 5) {
            return !projectileBlockedSouthWest(x, y, z) && !projectileBlockedSouth(x, y, z)
                    && !projectileBlockedWest(x, y, z);
        } else if (direction == 6) {
            return !projectileBlockedSouth(x, y, z);
        } else if (direction == 7) {
            return !projectileBlockedSouthEast(x, y, z) && !projectileBlockedSouth(x, y, z)
                    && !projectileBlockedEast(x, y, z);
        }
        return false;
    }
    public static int getProjectileClipping(int x, int y, int height) {
        if (height > 3)
            height = 0;
        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = ((regionX / 8) << 8) + (regionY / 8);
        Region r = get(regionId);
        if (r.id() == regionId) {
            return r.getProjectileClip(x, y, height);
        }
        return 0;
    }
    private int getProjectileClip(int x, int y, int height) {
        if (height > 3)
            height = height % 4;
        int regionAbsX = (id >> 8) * 64;
        int regionAbsY = (id & 0xff) * 64;
        if (shootable[height] == null) {
            return 0;
        }
        return shootable[height][x - regionAbsX][y - regionAbsY];
    }
    public static boolean blockedNorthNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x + i, y + size + 1, z) != 0);
                if (clipped) {
                    return true;
                }
            }
        }
        return (getClipping(x, y + 1, z) != 0);
    }

    public static boolean blockedEastNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x + size + 1, y + i, z) != 0);
                if (clipped) {
                    return true;
                }
            }
        }
        return (getClipping(x + 1, y, z) != 0);
    }

    public static boolean blockedSouthNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x + i, y - 1, z) != 0);
                if (clipped) {
                    return true;
                }
            }
        }
        return (getClipping(x, y - 1, z) != 0);
    }

    public static boolean blockedWestNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x - 1, y + i, z) != 0);
                if (clipped) {
                    return true;
                }
            }
        }
        return (getClipping(x - 1, y, z) != 0);
    }

    public static boolean blockedNorthEastNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x + size + 1, y + i + 1, z) != 0);
                boolean clipped2 = (getClipping(x + i + 1, y + size + 1, z) != 0);
                if (clipped || clipped2) {
                    return true;
                }
            }
        }
        return (getClipping(x + 1, y + 1, z) != 0);
    }

    public static boolean blockedNorthWestNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x - 1, y + i + 1, z) != 0);
                boolean clipped2 = (getClipping(x + i - 1, y + size + 1, z) != 0);
                if (clipped || clipped2) {
                    return true;
                }
            }
        }
        return (getClipping(x - 1, y + 1, z) != 0);
    }

    public static boolean blockedSouthEastNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x + size + 1, y + i - 1, z) != 0);
                boolean clipped2 = (getClipping(x + i + 1, y - 1, z) != 0);
                if (clipped || clipped2) {
                    return true;
                }
            }
        }
        return (getClipping(x + 1, y - 1, z) != 0);
    }

    public static boolean blockedSouthWestNPC(int x, int y, int z, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                boolean clipped = (getClipping(x - 1, y + i - 1, z) != 0);
                boolean clipped2 = (getClipping(x + i - 1, y - 1, z) != 0);
                if (clipped || clipped2) {
                    return true;
                }
            }
        }
        return (getClipping(x - 1, y - 1, z) != 0);
    }

    public static boolean projectileBlockedNorth(int x, int y, int z) {
        return (getProjectileClipping(x, y + 1, z) & 0x12c0120) != 0;
    }

    public static boolean projectileBlockedEast(int x, int y, int z) {
        return (getProjectileClipping(x + 1, y, z) & 0x12c0180) != 0;
    }

    public static boolean projectileBlockedSouth(int x, int y, int z) {
        return (getProjectileClipping(x, y - 1, z) & 0x12c0108) != 0;
    }

    public static boolean projectileBlockedWest(int x, int y, int z) {
        return (getProjectileClipping(x - 1, y, z) & 0x12c0120) != 0;
    }

    public static boolean projectileBlockedNorthEast(int x, int y, int z) {
        return (getProjectileClipping(x + 1, y + 1, z) & 0x12801e0) != 0;
    }

    public static boolean projectileBlockedNorthWest(int x, int y, int z) {
        return (getProjectileClipping(x - 1, y + 1, z) & 0x1280138) != 0;
    }

    public static boolean projectileBlockedSouthEast(int x, int y, int z) {
        return (getProjectileClipping(x + 1, y - 1, z) & 0x1280183) != 0;
    }

    public static boolean projectileBlockedSouthWest(int x, int y, int z) {
        return (getProjectileClipping(x - 1, y - 1, z) & 0x12c0120) != 0;
    }
    public static int[] getNextStep(int baseX, int baseY, int toX, int toY, int height, int xLength, int yLength) {
        int moveX = 0;
        int moveY = 0;
        if (baseX - toX > 0) {
            moveX--;
        } else if (baseX - toX < 0) {
            moveX++;
        }
        if (baseY - toY > 0) {
            moveY--;
        } else if (baseY - toY < 0) {
            moveY++;
        }
        if (canMove(baseX, baseY, baseX + moveX, baseY + moveY, height, xLength, yLength)) {
            return new int[] { baseX + moveX, baseY + moveY };
        } else if (moveX != 0 && canMove(baseX, baseY, baseX + moveX, baseY, height, xLength, yLength)) {
            return new int[] { baseX + moveX, baseY };
        } else if (moveY != 0 && canMove(baseX, baseY, baseX, baseY + moveY, height, xLength, yLength)) {
            return new int[] { baseX, baseY + moveY };
        }
        return new int[] { baseX, baseY };
    }

    public static boolean canMove(int startX, int startY, int endX, int endY,
                                  int height, int xLength, int yLength) {
        int diffX = endX - startX;
        int diffY = endY - startY;
        int max = Math.max(Math.abs(diffX), Math.abs(diffY));
        for (int ii = 0; ii < max; ii++) {
            int currentX = endX - diffX;
            int currentY = endY - diffY;
            for (int i = 0; i < xLength; i++) {
                for (int i2 = 0; i2 < yLength; i2++)
                    if (diffX < 0 && diffY < 0) {
                        if ((getClipping((currentX + i) - 1,
                                (currentY + i2) - 1, height) & 0x12c0120) != 0
                                || (getClipping((currentX + i) - 1, currentY
                                + i2, height) & 0x12c0120) != 0
                                || (getClipping(currentX + i,
                                (currentY + i2) - 1, height) & 0x12c0108) != 0)
                            return false;
                    } else if (diffX > 0 && diffY > 0) {
                        if ((getClipping(currentX + i + 1, currentY + i2 + 1,
                                height) & 0x12801e0) != 0
                                || (getClipping(currentX + i + 1,
                                currentY + i2, height) & 0x12c0180) != 0
                                || (getClipping(currentX + i,
                                currentY + i2 + 1, height) & 0x12c0120) != 0)
                            return false;
                    } else if (diffX < 0 && diffY > 0) {
                        if ((getClipping((currentX + i) - 1, currentY + i2 + 1,
                                height) & 0x1280138) != 0
                                || (getClipping((currentX + i) - 1, currentY
                                + i2, height) & 0x12c0120) != 0
                                || (getClipping(currentX + i,
                                currentY + i2 + 1, height) & 0x12c0120) != 0)
                            return false;
                    } else if (diffX > 0 && diffY < 0) {
                        if ((getClipping(currentX + i + 1, (currentY + i2) - 1,
                                height) & 0x1280183) != 0
                                || (getClipping(currentX + i + 1,
                                currentY + i2, height) & 0x12c0180) != 0
                                || (getClipping(currentX + i,
                                (currentY + i2) - 1, height) & 0x12c0108) != 0)
                            return false;
                    } else if (diffX > 0 && diffY == 0) {
                        if ((getClipping(currentX + i + 1, currentY + i2,
                                height) & 0x12c0180) != 0)
                            return false;
                    } else if (diffX < 0 && diffY == 0) {
                        if ((getClipping((currentX + i) - 1, currentY + i2,
                                height) & 0x12c0120) != 0)
                            return false;
                    } else if (diffX == 0 && diffY > 0) {
                        if ((getClipping(currentX + i, currentY + i2 + 1,
                                height) & 0x12c0120) != 0)
                            return false;
                    } else if (diffX == 0
                            && diffY < 0
                            && (getClipping(currentX + i, (currentY + i2) - 1,
                            height) & 0x12c0108) != 0)
                        return false;

            }

            if (diffX < 0)
                diffX++;
            else if (diffX > 0)
                diffX--;
            if (diffY < 0)
                diffY++;
            else if (diffY > 0)
                diffY--;
        }

        return true;
    }

    public static Region getRegion(int x, int y) {
        int regionX = x >> 3;
        int regionY = y >> 3;
        int regionId = (regionX / 8 << 8) + regionY / 8;
        Region r = get(regionId);
        if (r != null) {
            return r;
        }
        return null;
    }

    public boolean canMove(int x, int y, int z, int direction) {
        if (direction == 0) {
            return !blockedNorthWest(x, y, z) && !blockedNorth(x, y, z) && !blockedWest(x, y, z);
        } else if (direction == 1) {
            return !blockedNorth(x, y, z);
        } else if (direction == 2) {
            return !blockedNorthEast(x, y, z) && !blockedNorth(x, y, z) && !blockedEast(x, y, z);
        } else if (direction == 3) {
            return !blockedWest(x, y, z);
        } else if (direction == 4) {
            return !blockedEast(x, y, z);
        } else if (direction == 5) {
            return !blockedSouthWest(x, y, z) && !blockedSouth(x, y, z) && !blockedWest(x, y, z);
        } else if (direction == 6) {
            return !blockedSouth(x, y, z);
        } else if (direction == 7) {
            return !blockedSouthEast(x, y, z) && !blockedSouth(x, y, z) && !blockedEast(x, y, z);
        }
        return false;
    }



}