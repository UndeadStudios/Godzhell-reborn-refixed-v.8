import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GlobalDrops
{
  private int timer = 10;

  public void process()
  {
    if (this.timer == 0) {
      loadDrops();
      this.timer = 100;
    }
    else if (this.timer > 0) {
      this.timer -= 1;
      //ItemHandler.removeItem(paramInt1, itemX, itemY, itemAmount);
    }
  }

  private void createGlobalDrop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    ItemHandler.addItem(paramInt1, paramInt2, paramInt3, paramInt4, ItemHandler.globalItemController[i], false);
  }

  private boolean loadDrops()
  {
    String str1 = ""; String str2 = ""; String str3 = ""; String str4 = "";
    String[] arrayOfString = new String[10];
    String str5 = "./Data/cfg/globaldrops.cfg";
    int i = 0;
    BufferedReader localBufferedReader = null;
    try {
      localBufferedReader = new BufferedReader(new FileReader(str5));
    } catch (FileNotFoundException localFileNotFoundException) {
      System.out.println("INFO: drops.cfg not found in the directory:" + str5);
      return false;
    }
    try {
      str1 = localBufferedReader.readLine();
    } catch (IOException localIOException1) {
      System.out.println("INFO: An error occurred while loading drops.cfg");
      return false;
    }
    while ((i == 0) && (str1 != null)) {
      str1 = str1.trim();
      int j = str1.indexOf("=");
      if (j > -1) {
        str2 = str1.substring(0, j);
        str2 = str2.trim();
        str3 = str1.substring(j + 1);
        str3 = str3.trim();
        str4 = str3.replaceAll("\t\t", "\t");
        str4 = str4.replaceAll("\t\t", "\t");
        str4 = str4.replaceAll("\t\t", "\t");
        str4 = str4.replaceAll("\t\t", "\t");
        str4 = str4.replaceAll("\t\t", "\t");
        arrayOfString = str4.split("\t");
        if (str2.equals("drop")) {
          int k = Integer.parseInt(arrayOfString[0]);
          int m = Integer.parseInt(arrayOfString[1]);
          int n = Integer.parseInt(arrayOfString[2]);
          int i1 = Integer.parseInt(arrayOfString[3]);
          createGlobalDrop(k, m, n, i1);
        }
      }
      else if (str1.equals("[ENDOFDROPLIST]")) {
        try {
          localBufferedReader.close();
        } catch (IOException localIOException3) {
        }
        return true;
      }
      try
      {
        str1 = localBufferedReader.readLine();
      } catch (IOException localIOException4) {
        i = 1;
      }
    }
    try {
      localBufferedReader.close();
    } catch (IOException localIOException2) {
    }
    return false;
  }
}