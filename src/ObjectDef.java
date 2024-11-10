public final class ObjectDef
{

    public static ObjectDef getObjectDef(int i)
    {
        if (i > streamIndices667.length)
            i = streamIndices667.length - 1;
        for(int j = 0; j < 20; j++)
            if(cache[j].type == i)
                return cache[j];

        cacheIndex = (cacheIndex + 1) % 20;
        ObjectDef class46 = cache[cacheIndex];
        if (i > streamIndices667.length - 1 || i < 0) {
            return null;
        }
        dataBuffer667.currentOffset = streamIndices667[i];
        class46.type = i;
        class46.setDefaults();

            class46.readValues(dataBuffer667);

        return class46;
    }

    private void setDefaults()
    {
        anIntArray773 = null;
        anIntArray776 = null;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        anInt744 = 1;
        anInt761 = 1;
        projectileCliped = true;
        aBoolean757 = true;
        hasActions = false;
        aBoolean762 = false;
        aBoolean764 = false;
        anInt781 = -1;
        anInt775 = 16;
        actions = null;
        anInt746 = -1;
        anInt758 = -1;
        aBoolean751 = false;
        aBoolean779 = true;
        anInt768 = 0;
        aBoolean736 = false;
        aBoolean766 = false;
        anInt760 = -1;
        anInt774 = -1;
        anInt749 = -1;
        childrenIDs = null;
    }

    public static void loadConfig()
    {
        dataBuffer667 = new ByteStreamExt(getBuffer("loc.dat"));
        ByteStreamExt idxBuffer667 = new ByteStreamExt(getBuffer("loc.idx"));

        totalObjects667 = idxBuffer667.readUnsignedWord();

        streamIndices667 = new int[totalObjects667];
        System.out.println("525 Object Amount: " +totalObjects667);
        int i = 2;
        for (int j = 0; j < totalObjects667; j++) {
            streamIndices667[j] = i;
            i += idxBuffer667.readUnsignedWord();
        }
        cache = new ObjectDef[20];
        for(int k = 0; k < 20; k++)
            cache[k] = new ObjectDef();
    }

    public static byte[] getBuffer(String s) {
        try {
            java.io.File f = new java.io.File("./Data/world/object/" + s);
            if (!f.exists())
                return null;
            byte[] buffer = new byte[(int) f.length()];
            try (java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.FileInputStream(f))) {
                dis.readFully(buffer);
                dis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return buffer;
        } catch (Exception e) {
        }
        return null;
    }


    private void readValues(ByteStreamExt stream)
    {
        int flag = -1;
        while (true) {
            int j = stream.readUnsignedByte();
            if (j == 0)
                break;
            if (j == 1) {
                int len = stream.readUnsignedByte();
                if (len > 0) {
                    if (anIntArray773 == null || lowMem) {
                        anIntArray776 = new int[len];
                        anIntArray773 = new int[len];
                        for (int k1 = 0; k1 < len; k1++) {
                            anIntArray773[k1] = stream.readUnsignedWord();
                            anIntArray776[k1] = stream.readUnsignedByte();
                        }
                    } else {
                        stream.currentOffset += len * 3;
                    }
                }
            } else if (j == 2) {
                name = stream.readNewString();
            } else if (j == 5) {
                int len = stream.readUnsignedByte();
                if (len > 0) {
                    if (anIntArray773 == null || lowMem) {
                        anIntArray776 = null;
                        anIntArray773 = new int[len];
                        for (int l1 = 0; l1 < len; l1++)
                            anIntArray773[l1] = stream.readUnsignedWord();
                    } else {
                        stream.currentOffset += len * 2;
                    }
                }
            } else if (j == 14) {
                anInt744 = stream.readUnsignedByte();
            } else if (j == 15) {
                anInt761 = stream.readUnsignedByte();
            } else if (j == 17) {
                projectileCliped = false;
                aBoolean757 = false;
            } else if (j == 18) {
                aBoolean757 = false;
            } else if (j == 19) {
                hasActions = (stream.readUnsignedByte() == 1);
            } else if (j == 21) {
                aBoolean762 = true;
            } else if (j == 22) {
                //aBoolean769 = false; // change to false to fix gowwars waterfalls??
            } else if (j == 23) {
                aBoolean764 = true;
            } else if (j == 24) {
                anInt781 = stream.readUnsignedWord();
                if (anInt781 == 65535)
                    anInt781 = -1;
            } else if (j == 27){
                aBoolean757 = true;
            } else if (j == 28) {
                anInt775 = stream.readUnsignedByte();
            } else if (j == 29) {
                stream.readSignedByte();
            } else if (j == 39) {
                stream.readSignedByte();
            } else if (j >= 30 && j < 35) {
                if (actions == null)
                    actions = new String[10];
                actions[j - 30] = stream.readNewString();
                hasActions = true;
                if (actions[j - 30].equalsIgnoreCase("hidden"))
                    actions[j - 30] = null;
            } else if (j == 40) {
                int i1 = stream.readUnsignedByte();
                modifiedModelColors = new int[i1];
                originalModelColors = new int[i1];
                for (int i2 = 0; i2 < i1; i2++) {
                    modifiedModelColors[i2] = stream.readUnsignedWord();
                    originalModelColors[i2] = stream.readUnsignedWord();
                }
            } else if (j == 41) {
                int count = stream.readUnsignedByte();
                this.retex_d = new short[count];
                this.retex_s = new short[count];
                for (int len = 0; len < count; len++) {
                    this.retex_s[len] = (short) stream.readUnsignedWord();
                    this.retex_d[len] = (short) stream.readUnsignedWord();
                }
            } else if (j == 42) {
                int count = stream.readUnsignedByte();
                this.recol_p = new byte[count];
                for (int len = 0; len < count; len++) {
                    this.recol_p[len] = stream.readSignedByte();
                }
            } else if (j == 60) {
                anInt746 = stream.readUnsignedWord();
            } else if (j == 62) {
                aBoolean751 = true;
            } else if (j == 64) {
                aBoolean779 = false;
            } else if (j == 65) {
                stream.readUnsignedWord();
            } else if (j == 66) {
                stream.readUnsignedWord();
            } else if (j == 67) {
                stream.readUnsignedWord();
            } else if (j == 68) {
                anInt758 = stream.readUnsignedWord();
            } else if (j == 69) {
                anInt768 = stream.readUnsignedByte();
            } else if (j == 70) {
                stream.readSignedWord();
            } else if (j == 71) {
                stream.readSignedWord();
            } else if (j == 72) {
                stream.readSignedWord();
            } else if (j == 73) {
                aBoolean736 = true;
            } else if (j == 74) {
                aBoolean766 = true;
            } else if (j == 75)
                anInt760 = stream.readUnsignedByte();
            else if (j == 77 || j == 92) {
                anInt774 = stream.readUnsignedWord();
                if (anInt774 == 65535)
                    anInt774 = -1;
                anInt749 = stream.readUnsignedWord();
                if (anInt749 == 65535)
                    anInt749 = -1;
                int endChild = -1;
                if (j == 92) {
                    endChild = stream.readUnsignedWord();
                    if (endChild == 65535)
                        endChild = -1;
                }
                int j1 = stream.readUnsignedByte();
                childrenIDs = new int[j1 + 2];
                for (int j2 = 0; j2 <= j1; j2++) {
                    childrenIDs[j2] = stream.readUnsignedWord();
                    if (childrenIDs[j2] == 65535)
                        childrenIDs[j2] = -1;
                }
                childrenIDs[j1 + 1] = endChild;
            } else if (j == 78) {
                this.bgsound = stream.readUnsignedWord();
                this.bgsoundrange = stream.readUnsignedByte();
            } else if (j == 79) {
                this.bgsoundmin = stream.readUnsignedWord(); // interval
                this.bgsoundmax = stream.readUnsignedWord(); // interval
                this.bgsoundrange = stream.readUnsignedByte();

                int count = stream.readUnsignedByte();
                this.bgsounds = new int[count];
                for (int len = 0; len < count; len++) {
                    this.bgsounds[len] = stream.readUnsignedWord();
                }
            } else if (j == 81) {
                this.hillskewType = 2;
                this.hillskewAmount = (short) (stream.readUnsignedByte() * 256);
            } else if (j == 82) {
                this.render = true;
            } else if (j == 88) {
                this.castshadow = false;
            } else if (j == 89) {
                this.allowrandomizedanimation = false;
            } else if (j == 90) {
                this.aBoolean211 = true;
            } else if (j == 91) {
                this.members = true;
            } else if (j == 93) {
                this.hillskewType = 3;
                this.hillskewAmount = (short) stream.readUnsignedWord();
            } else if (j == 94) {
                this.hillskewType = 4;
            } else if (j == 95) {
                this.hillskewType = 5;
            } else if (j == 96) {
                this.hasanimation = true;
            } else if (j == 97) {
                this.mapSceneRotated = true;
            } else if (j == 98) {
                this.aBoolean214 = true;
            } else if (j == 99) {
                this.cursor1Op = stream.readUnsignedByte();
                this.cursor1 = stream.readUnsignedWord();
            } else if (j == 100) {
                stream.readUnsignedByte();
                stream.readUnsignedWord();
            } else if (j == 101) {
                stream.readUnsignedByte();
            } else if (j == 102) {
                stream.readUnsignedWord();
            }

        }
        if (flag == -1 && name != "null" && name != null) {
            hasActions = anIntArray773 != null && (anIntArray776 == null || anIntArray776[0] == 10);
            if (actions != null)
                hasActions = true;
        }
        if (aBoolean766) {
            projectileCliped = false;
            aBoolean757 = false;
        }
        if (anInt760 == -1)
            anInt760 = projectileCliped ? 1 : 0;
        }

    private ObjectDef()
    {
        type = -1;
    }

    public boolean hasActions()
    {
        return hasActions;
    }

    public boolean hasName()
    {
        return name != null && name.length() > 1;
    }

    public boolean solid()
    {
        return aBoolean779;
    }

    public int xLength()
    {
        return anInt744;
    }

    public int yLength()
    {
        return anInt761;
    }

    public boolean isProjectileCliped()
    {
        return projectileCliped;
    }

    public boolean aBoolean736;
    public String name;
    public int anInt744;
    private int[] bgsounds;
    private int hillskewType = 0;
    private short hillskewAmount = -1;
    private int bgsound = -1;
    private int bgsoundrange = 0;
    private int bgsoundmin= 0;
    private boolean render = false;
    private int bgsoundmax = 0;
    private boolean hasanimation = false;
    private boolean mapSceneRotated = false;
    private boolean aBoolean211 = false;
    private boolean castshadow = true;
    private boolean allowrandomizedanimation = true;
    public int anInt746;
    private int[] originalModelColors;
    public int anInt749;
    public static boolean lowMem;
    public int type;
    public boolean aBoolean757;
    public int anInt758;
    public int childrenIDs[];
    public int anInt761;
    public boolean aBoolean762;
    public boolean aBoolean764;
    public boolean projectileCliped;
    public int anInt768;
    private static int cacheIndex;
    private int[] anIntArray773;
    public int anInt774;
    public int anInt775;
    private byte[] recol_p;
    private boolean members = false;
    private boolean aBoolean214 = false;
    private int cursor1Op = -1;
    private int cursor1 = -1;
    private int[] anIntArray776;
    public byte description[];
    public boolean hasActions;
    public boolean aBoolean779;
    public int anInt781;
    private static ObjectDef[] cache;
    private static ByteStreamExt dataBuffer667;

    public static int totalObjects667;
    public static int[] streamIndices667;
    private boolean aBoolean766;
    public int anInt760;
    private short[] retex_d;
    private short[] retex_s;
    public boolean aBoolean751;
    private int[] modifiedModelColors;
    public String actions[];
    private static MemoryArchive archive;

}
