import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DoorHandler {
	public static int[] doorFace = new int[100];
	public static int[] doorFaceClosed = new int[100];
	public static int[] doorFaceOpen = new int[100];
	public static int[] doorHeight = new int[100];
	public static int[] doorId = new int[100];
	public static int[] doorState = new int[100];
	public static int[] doorX = new int[100];
	public static int[] doorY = new int[100];

	public DoorHandler() {
		try {
			loadDoors("./Data/cfg/doors.cfg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean loadDoors(String FileName) {
		String line = "";
		String token = "";
		String token2 = "";
		String token2_2 = "";
		String[] token3 = new String[10];
		boolean EndOfFile = false;
		int doorCount = 0;
		BufferedReader characterfile = null;
		try {
			characterfile = new BufferedReader(new FileReader("./"
					+ FileName));
		} catch (FileNotFoundException fileex) {
			misc.println(FileName + ": file not found.");
			return false;
		}
		try {
			line = characterfile.readLine();
		} catch (IOException ioexception) {
			misc.println(FileName + ": error loading file.");
			return false;
		}
		while ((EndOfFile == false) && (line != null)) {
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
				if (token.equals("door")) {
					doorX[doorCount] = Integer.parseInt(token3[0]);
					doorY[doorCount] = Integer.parseInt(token3[1]);
					doorId[doorCount] = Integer.parseInt(token3[2]);
					;
					doorFaceOpen[doorCount] = Integer.parseInt(token3[3]);
					doorFaceClosed[doorCount] = Integer.parseInt(token3[4]);
					doorFace[doorCount] = Integer.parseInt(token3[5]);
					doorState[doorCount] = Integer.parseInt(token3[6]);
					doorHeight[doorCount] = Integer.parseInt(token3[7]);
					doorCount++;
				}
			} else {
				if (line.equals("[ENDOFDOORLIST]")) {
					try {
						characterfile.close();
					} catch (IOException ioexception) {
					}
					return true;
				}
			}
			try {
				line = characterfile.readLine();
			} catch (IOException ioexception1) {
				EndOfFile = true;
			}
		}
		try {
			characterfile.close();
		} catch (IOException ioexception) {
		}
		return false;
	}
}