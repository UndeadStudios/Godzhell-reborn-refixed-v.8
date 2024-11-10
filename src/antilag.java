// This resets server every 30 mins to stop lag - xerozcheez
import java.io.*;


public class antilag {

    public int ResetTimer = 0;

    public void resetserver() {
        misc.println("RESETING SERVER!!!");
        misc.println("Saving all games...");
        PlayerHandler.kickAllPlayers = true;
        misc.println("GAME SUCCESSFULLY SAVED FOR ALL PLAYERS");
        ResetTimer = 0;
        closeListener();
        runserver();
    }

    public void process() {
        ResetTimer += 1;
        if (ResetTimer >= 9999999) {
            resetserver();
        }
    }

    public void runserver() {
        try {
            String run = "runserver.bat";
            String xstr = "./" + run;

            Runtime.getRuntime().exec(xstr);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
    }

    public void closeListener() {
        try {
            server.shutdownClientHandler = true;
            if (server.clientListener != null) {
                server.clientListener.close();
            }
            server.clientListener = null;
        } catch (java.lang.Exception __ex) {
            __ex.printStackTrace();
        }
    }
}
