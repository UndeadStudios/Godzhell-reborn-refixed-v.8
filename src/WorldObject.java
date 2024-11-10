/* Handles auto-spawning world objects		*/

import java.io.*;


public class WorldObject {
	
    WorldObject() {
        for (int i = 0; i < MaxWorldObjects; i++) {
            ObjectX[i] = -1;
            ObjectY[i] = -1;
            ObjectID[i] = -1;
            Orientation[i] = -1;
            TileObjectType[i] = -1;
            ObjectHeight[i] = 0;
        }
        loadObjects("WorldObjects.cfg"); /* File Location	*/
    }
	
    public int MaxWorldObjects = 100000;
    public int WorldObjectCount = 0;
	
    public int[] ObjectX = new int[MaxWorldObjects];
    public int[] ObjectY = new int[MaxWorldObjects];
    public int[] ObjectID = new int[MaxWorldObjects];
    public int[] Orientation = new int[MaxWorldObjects];
    public int[] TileObjectType = new int[MaxWorldObjects];
    public int[] ObjectHeight = new int[MaxWorldObjects];
	
    public boolean loadObjects(String FileName) {
        String line = "";
        String token = "";
        String token2 = "";
        String token2_2 = "";
        String[] token3 = new String[10];
        boolean EndOfFile = false;
        int ReadMode = 0;
        BufferedReader ObjectFile = null;

        try {
            ObjectFile = new BufferedReader(new FileReader("./" + FileName));
        } catch (FileNotFoundException fileex) {
            System.out.println(FileName + ": file not found.");
            return false;
        }
        try {
            line = ObjectFile.readLine();
        } catch (IOException ioexception) {
            System.out.println(FileName + ": error loading file.");
            return false;
        }
        while (EndOfFile == false && line != null) {
            line = line.trim();
            int spot = line.indexOf("=");

            if (spot > -1) {
                token = line.substring(0, spot);
                token = token.trim();
                token2 = line.substring(spot + 1);
                token2 = token2.trim();
                token2_2 = token2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token2_2 = token2_2.replaceAll("\t\t", "\t");
                token3 = token2_2.split("\t");
                if (token.equals("object")) {
                    ObjectX[WorldObjectCount] = Integer.parseInt(token3[0]);
                    ObjectY[WorldObjectCount] = Integer.parseInt(token3[1]);
                    ObjectID[WorldObjectCount] = Integer.parseInt(token3[2]);
                    Orientation[WorldObjectCount] = Integer.parseInt(token3[3]);
                    TileObjectType[WorldObjectCount] = Integer.parseInt(
                            token3[4]);
                    ObjectHeight[WorldObjectCount] = Integer.parseInt(token3[5]);
                    WorldObjectCount++;
                }
            } else {
                if (line.equals("[End of World Objects3]")) {
                    try {
                        ObjectFile.close();
                    } catch (IOException ioexception) {}
                    return true;
                }
            }
            try {
                line = ObjectFile.readLine();
            } catch (IOException ioexception1) {
                EndOfFile = true; 
            }
        }
        try {
            ObjectFile.close();
        } catch (IOException ioexception) {}
        return false;
    }	
}
