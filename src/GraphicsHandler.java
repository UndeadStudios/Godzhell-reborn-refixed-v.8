public class GraphicsHandler {
    public static int[] GFXspot = new int[5001];
    public static int[] castID = new int[5001];
    public static int[] moveID = new int[5001];
    public static int[] endID = new int[5001];
    public static int[] gfxX = new int[5001];
    public static int[] gfxY = new int[5001];
    public static int[] offX = new int[5001];
    public static int[] offY = new int[5001];
    public static int[] gfxA = new int[5001];
    public static int[] gfxS = new int[5001];
    public static int[] gfxSH = new int[5001];
    public static int[] gfxFH = new int[5001];
    public static int[] targetX = new int[5001];
    public static int[] targetY = new int[5001];
    public static int[] lockOn = new int[5001]; // 5001

    public GraphicsHandler() {
        for (int i = 0; i <= 150; i++) {
            GFXspot[i] = 0;
            castID[i] = 0;
            moveID[i] = 0;
            endID[i] = 0;
            gfxX[i] = 0;
            gfxY[i] = 0;
            offX[i] = 0;
            offY[i] = 0;
            gfxA[i] = 0;
            gfxS[i] = 0;
            gfxSH[i] = 0;
            gfxFH[i] = 0;
            targetX[i] = 0;
            targetY[i] = 0;
            lockOn[i] = 0; // -1
        }
    }

    public static void createSpec(int castId, int casterY, int casterX, int offsetY, int offsetX, int angle, int speed, int startHeight, int endHeight, int enemyY, int enemyX, int MageAttackIndex) {
        for (Player p : PlayerHandler.players) {
            if (p != null) {
                client person = (client) p;

                if (person.playerName != null || person.playerName != "null") {
                    // if(person.distanceToPoint(enemyY, enemyX) <= 60)
                    person.specspell(castId, casterY, casterX, offsetY, offsetX,
                            angle, speed, startHeight, endHeight, enemyY, enemyX,
                            MageAttackIndex);
                }
            }
        }
    }

    public static void addSpell(int castId, int casterY, int casterX, int offsetY, int offsetX, int angle, int speed, int movegfxID, int startHeight, int endHeight, int finishID, int enemyY, int enemyX, int MageAttackIndex) {
        for (int i = 0; i <= 150; i++) {
            if (GFXspot[i] == 0) {
                GFXspot[i] = castId;
                castID[i] = castId;
                moveID[i] = movegfxID;
                endID[i] = finishID;
                gfxX[i] = casterX;
                gfxY[i] = casterY;
                offX[i] = offsetX;
                offY[i] = offsetY;
                gfxA[i] = angle;
                gfxS[i] = speed;
                gfxSH[i] = startHeight;
                gfxFH[i] = endHeight;
                targetX[i] = enemyX;
                targetY[i] = enemyY;
                lockOn[i] = MageAttackIndex;
                if (GFXspot[i] != -1) {
                    createSpell(castID[i], gfxY[i], gfxX[i], offY[i], offX[i],
                            gfxA[i], gfxS[i], moveID[i], gfxSH[i], gfxFH[i],
                            endID[i], targetY[i], targetX[i], lockOn[i]);
                }
            }
        }
    }

    public static void createSpell(int castId, int casterY, int casterX, int offsetY, int offsetX, int angle, int speed, int movegfxID, int startHeight, int endHeight, int finishID, int enemyY, int enemyX, int MageAttackIndex) {
        for (Player p : PlayerHandler.players) {
            if (p != null) {
                client person = (client) p;

                if (person.playerName != null || person.playerName != "null") {
                    // if(person.distanceToPoint(enemyY, enemyX) <= 60)
                    person.firespell(castId, casterY, casterX, offsetY, offsetX,
                            angle, speed, movegfxID, startHeight, endHeight,
                            finishID, enemyY, enemyX, MageAttackIndex);
                }
            }
        }
    }

    public static void removeGFX(int castId, int enemyX, int enemyY) {
        for (int i = 0; i <= 150; i++) {
            if (GFXspot[i] == castId && targetX[i] == enemyX
                    && targetY[i] == enemyY) {
                GFXspot[i] = 0;
                castID[i] = 0;
                moveID[i] = 0;
                endID[i] = 0;
                gfxX[i] = 0;
                gfxY[i] = 0;
                offX[i] = 0;
                offY[i] = 0;
                gfxA[i] = 0;
                gfxS[i] = 0;
                gfxSH[i] = 0;
                gfxFH[i] = 0;
                targetX[i] = 0;
                targetY[i] = 0;
                lockOn[i] = 0; // -1
            }
        }
    }

}
