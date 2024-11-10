import java.io.File;
import org.apache.commons.io.FileUtils;
/**
 * A class that loads & manages NPC configurations.
 *
 * <p>An <code>NPCDefinition</code> is a component of the NPC configuration file
 * that defines several aspects of the NPC (such as models, model colors, animations,
 * name, description, and combat level). We use these definitions both client and server-
 * sided in order to display information on the client and pull data when necessary
 * server-sided (i.e. - for combat formulas). </p>
 * @author Craze/Warren
 * @date Sep 20, 2015 5:13:47 PM

 */
public class NPCCacheDefinition {

    /**
     * Represents the total whole number integer of NPCs.
     */
    public static int NPC_TOTAL = 9000;

    /**
     * Returns a {@link NPCCacheDefinition} for the specified ID.
     * @param i	the id of the NPC to get the definition for
     * @return	the definition
     */
    public static final NPCCacheDefinition forID(int i) {
        for(int j = 0; j < 20; j++)
            if(cache[j].type == (long)i)
                return cache[j];

        cacheIndex = (cacheIndex + 1) % 20;
        NPCCacheDefinition npcDef = cache[cacheIndex] = new NPCCacheDefinition();
        if(i < streamIndices.length)
            npcData.currentOffset = streamIndices[i];
        npcDef.type = i;
        if(i < totalNpcs)
            npcDef.readValues(npcData);

        return npcDef;
    }

    /**
     * Unpacks the NPC configurations.
     */
    public static final void unpackConfig() {
        try {
            npcData = new stream(FileUtils.readFileToByteArray(new File("./Data/fs/npc.dat")));
            stream indexStream = new stream(FileUtils.readFileToByteArray(new File("./Data/fs/npc.idx")));
            totalNpcs = indexStream.readUnsignedWord();
            newTotalNpcs = 15505;
            streamIndices = new int[totalNpcs];
            int i = 2;
            for(int j = 0; j < totalNpcs; j++)
            {
                streamIndices[j] = i;
                i += indexStream.readUnsignedWord();
            }

            cache = new NPCCacheDefinition[20];
            for(int k = 0; k < 20; k++)
                cache[k] = new NPCCacheDefinition();
            System.out.println("Successfully loaded: " + totalNpcs + " NPC definitions.");
        } catch (Exception e) {
            System.err.println("An error has occurred whilst loading NPC definitions!");
            e.printStackTrace();
        }
    }

    /**
     * Reads opcode values from the {@link stream}.
     * @param str	the stream
     */
    private final void readValues(stream str) {
        do
        {
            int opcode = str.readUnsignedByte();
            if(opcode == 0)
                return;
            if(opcode == 1)
            {
                int j = str.readUnsignedByte();
                for (int j1 = 0; j1 < j; j1++)
                    str.readUnsignedWord();
            } else
            if(opcode == 2)
                name = str.readString();
            else
            if(opcode == 3)
                examine = str.readString();
            else
            if(opcode == 12)
                boundDim = str.readSignedByte();
            else
            if(opcode == 13)
                standIndex = str.readUnsignedWord();
            else
            if(opcode == 14)
                walkIndex = str.readUnsignedWord();
            else
            if(opcode == 17)
            {
                walkIndex = str.readUnsignedWord();
                str.readUnsignedWord();
                str.readUnsignedWord();
                str.readUnsignedWord();
            } else
            if(opcode >= 30 && opcode < 40)
            {
                if(actions == null)
                    actions = new String[10];
                try {
                    actions[opcode - 30] = str.readString();
                    if(actions[opcode - 30].equalsIgnoreCase("hidden"))
                        actions[opcode - 30] = null;
                } catch(Exception e) { }
            } else
            if(opcode == 40)
            {
                int k = str.readSignedByte();
                for(int k1 = 0; k1 < k; k1++)
                {
                    str.readUnsignedWord();
                    str.readUnsignedWord();
                }
            } else
            if(opcode == 60)
            {
                int l = str.readUnsignedByte();
                for (int l1 = 0; l1 < l; l1++)
                    str.readUnsignedWord();
            } else
            if(opcode == 90)
                str.readUnsignedWord();
            else
            if(opcode == 91)
                str.readUnsignedWord();
            else
            if(opcode == 92)
                str.readUnsignedWord();
            else
            if(opcode == 93) {
            } else
            if(opcode == 95)
                str.readUnsignedWord();
            else
            if(opcode == 97)
                str.readUnsignedWord();
            else
            if(opcode == 98)
                str.readUnsignedWord();
            else
            if(opcode == 99) {
            } else
            if(opcode == 100)
                str.readSignedByte();
            else
            if(opcode == 101)
                str.readSignedByte();
            else
            if(opcode == 102)
                str.readUnsignedWord();
            else
            if(opcode == 103)
                str.readUnsignedWord();
            else
            if(opcode == 106)
            {
                str.readUnsignedWord();
                str.readUnsignedWord();
                int i1 = str.readUnsignedByte();
                for (int i2 = 0; i2 <= i1; i2++) {
                    str.readUnsignedWord();
                }
            } else
            if(opcode == 107) {

            }
        } while(true);
    }

    NPCCacheDefinition()
    {
        boundDim = 1;
        type = -1L;
    }

    /**
     * Represents an array of {@link NPCCacheDefinition}s.
     */
    private static NPCCacheDefinition[] definitions = new NPCCacheDefinition[NPC_TOTAL];

    /**
     * Gets all definitions in the form of an array.
     * @return	definitions	the {@link NPCCacheDefinition} in array form
     */
    public static NPCCacheDefinition[] getDefinitions() {
        return definitions;
    }

    /**
     * Gets the NPC's stand index.
     * @return
     */
    public int getStandIndex() {
        return standIndex;
    }

    /**
     * Gets the NPC's walk index.
     * @return
     */
    public int getWalkIndex() {
        return walkIndex;
    }

    /**
     * Gets the size of the NPC.
     * @return	size	the size of the NPC
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the name of the NPC.
     * @return	name	the name of the NPC.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the examine string for the NPC.
     * @return	examine	the examine string
     */
    public String getExamine() {
        return examine;
    }

    /**
     * Gets the health of the NPC
     * @return	health	the NPC's health
     */
    public int getHealth() {
        return health;
    }

    private static int cacheIndex;
    private static stream npcData;
    public static int totalNpcs;
    public static int newTotalNpcs;
    private String name;
    public String actions[];
    public byte boundDim;
    private static int streamIndices[];
    public long type;
    public static NPCCacheDefinition cache[];
    private int standIndex;
    private int walkIndex;
    private int health;
    private int size = 1;
    private String examine;

}
