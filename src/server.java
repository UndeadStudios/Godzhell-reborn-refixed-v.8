import com.Ghreborn.jagcached.FileServer;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
//import org.Vote.*;


public class server implements Runnable {

    public static final int cycleTime = 600;
    static long tickCount = 0;
    public static final String ObjectManager = null;
    public static lottery lottery = new lottery();
    public static GlobalObjects globalObjects = new GlobalObjects();
    public static ControlPanel panel = new ControlPanel(true); // false if you want it off
    /*Highscores*/
    /*For more highscores to be recorded, change the #s in [] to the number you want kept, +1*/
    /*For example, if you want the top 20, put 21 in the [] ([21])*/
    public static int[] ranks = new int[11];
    public static String[] rankPpl = new String[11];
    public static boolean updateServer = false;
    public static boolean loginServerConnected = true;
    public static boolean enforceClient = false;
    public static int Rocks = 0;
    public static DoorHandler doorHandler;
    public static NPCDrops npcDrops = new NPCDrops();
    public static Fishing fishing = new Fishing();
    public static int[] ROCKX = new int[9999];
    public static int[] ROCKY = new int[9999];
    public static int[] ROCKFACE = new int[9999];
    public static int[] ROCKSPAWN = new int[9999];
    public static int[] ORELEFT = new int[9999];
    public static int[] ORE = new int[9999];
    public static int[] ROCKID = new int[9999];
    public static int[] ROCKSTUMP = new int[9999];
    public static int updateSeconds = 180; //180 because it doesnt make the time jump at the start :P
    public static long startTime;
    public static server clientHandler = null;            // handles all the clients
    public static ServerSocket clientListener = null;
    public static ServerSocket clientListener2 = null;
    public static boolean shutdownServer = false;        // set this to true in order to shut down and kill the server
    public static boolean shutdownClientHandler;            // signals ClientHandler to shut down
    public static int serverlistenerPort = 29432; //29432=default
    public static PlayerHandler playerHandler = null;
    public static potions potions = null;
    public static clickingMost clickingMost = null;
    public static NPCHandler npcHandler = null;
    public static GarbageCollectorManager garbageCollectorManager = null;
    public static PickableObjects PickableObjects = null;
    public static Discord discordBot = null;
    public static TextHandler textHandler = null;
    //public static int serverlistenerPort2 = 43594; // 5555=default
    public static ItemHandler itemHandler = null;
    public static ObjectManager objectManager = null;
    public static ShopHandler shopHandler = null;
    public static GlobalDrops GlobalDrops = null;
    public static Fishing Fishing = null;
    public static antilag antilag = null;
    public static itemspawnpoints itemspawnpoints = null;
    public static GraphicsHandler GraphicsHandler = null;
    public static ObjectHandler objectHandler = null;
    public static int EnergyRegian = 0;
    public static int MaxConnections = 100000;
    public static String[] Connections = new String[MaxConnections];
    public static int[] ConnectionCount = new int[MaxConnections];
    public static boolean ShutDown = false;
    public static int ShutDownCounter = 0;
    public static ClanManager clanManager = null;
    private static int waitFails;
    public static long minutesCounter;
    // TODO: yet to figure out proper value for timing, but 500 seems good
    BufferedReader reader;
    BufferedWriter bw = null;
    String connectingIP = null;

    /**
     * The task scheduler.
     */
    private static final TaskScheduler scheduler = new TaskScheduler();

    /**
     * Gets the task scheduler.
     * @return The task scheduler.
     */
    public static TaskScheduler getTaskScheduler() {
        return scheduler;
    }
    //public static MainLoader vote = new MainLoader("127.0.0.1", "admin", "q2L65yAjhS3FeyAP", "vote");
    public server() {
        // the current way of controlling the server at runtime and a great debugging/testing tool
        //jserv js = new jserv(this);
       // js.start();

    }

    public static long getTickCount() {
        return tickCount;
    }

    /**
     * Starts the minute counter
     */
    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        EventManager.initialise();

        NPCCacheDefinition.unpackConfig();
        AnimationLength.startup();
        lottery.loadLists();

       // server.lottery.loadLists();
        Region.init();
        textHandler = new TextHandler();
        clanManager = new ClanManager();

        npcHandler = new NPCHandler();
        // discordBot.init();
        itemHandler = new ItemHandler();
        //WalkingCheck.check();
        doorHandler = new DoorHandler();
        potions = new potions();
        objectManager = new ObjectManager();
        shopHandler = new ShopHandler();
        PickableObjects = new PickableObjects();
        garbageCollectorManager = new GarbageCollectorManager();
        clickingMost = new clickingMost();
        fishing = new Fishing();
        antilag = new antilag();
        itemspawnpoints = new itemspawnpoints();
        GraphicsHandler = new GraphicsHandler();
        objectHandler = new ObjectHandler();
        GlobalDrops = new GlobalDrops();
        npcDrops = new NPCDrops();
        discordBot = new Discord();

        clientHandler = new server();
        (new Thread(clientHandler)).start();
        playerHandler = new PlayerHandler();
        ConnectionList.getInstance();


        scheduler.schedule(new Task() {
            @Override
            protected void execute() {
            // could do game updating stuff in here...
            // maybe do all the major stuff here in a big loop and just do the packet
            // sending/receiving in the client subthreads. The actual packet forming code
            // will reside within here and all created packets are then relayed by the subthreads.
            // This way we avoid all the sync'in issues
            // The rough outline could look like:
                tickCount++;
            playerHandler.process();            // updates all player related stuff
            npcHandler.process();
            itemHandler.process();
            garbageCollectorManager.process();
            shopHandler.process();
             lottery.process();
                globalObjects.pulse();
            objectManager.process();
            antilag.process();
            //GlobalDrops.process();
            itemspawnpoints.process();
            objectHandler.process();
            objectHandler.firemaking_process();
           // discordBot.init();
            System.gc();
            // doNpcs()		// all npc related stuff
            // doObjects()
            // doWhatever()
            }
        });
    }

    public static void calcTime() {
        long curTime = System.currentTimeMillis();
        updateSeconds = 180 - ((int) (curTime - startTime) / 1000);
        if (updateSeconds == 0) {
            shutdownServer = true;
        }
    }

    public static boolean playerInWorld(String name) {
        File file;
        file = new File("./Data/world/" + name + ".world");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioe) {
            }
            return false;
        }
        return true;
    }

    public static void resetWorlds() {
        if (checkStatus(29433)) {
            File loc = new File("./Data/world/");
            if (loc.exists()) {
                try {
                    File[] files = loc.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        File load = files[i];
                        if (load.getName().endsWith(".world1")) {
                            load.delete();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (checkStatus(29434)) {
            File loc = new File("./data/world/");
            if (loc.exists()) {
                try {
                    File[] files = loc.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        File load = files[i];
                        if (load.getName().endsWith(".world2")) {
                            load.delete();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteFromWorld(String name) {

        File file = new File("./Data/world/" + name + ".world");
        if (!file.exists()) return;

        boolean delete = file.delete();

        if (!delete)
            System.out.println("Failed to delete .world file: " + name);
    }

    public static boolean checkStatus(int world) {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(world);
        } catch (IOException e) {
            return false;
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }

    public static void logError(String message) {
        misc.println(message);
    }

    public static void addUidToFile(String UUID) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("./Data/bans/UUIDBans.txt", true));
            try {
                out.newLine();
                out.write(UUID);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setMinutesCounter(long minutesCounter) {
        server.minutesCounter = minutesCounter;
        try {
            BufferedWriter minuteCounter = new BufferedWriter(new FileWriter("./Data/minutes.log"));
            minuteCounter.write(Long.toString(getMinutesCounter()));
            minuteCounter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static long getMinutesCounter() {
        return minutesCounter;
    }

    public static boolean isPublic() {
        return true;
    }

    public Socket acceptSocketSafe(ServerSocket serverSocket) {
        while (true) { // Loop until a valid socket is accepted
            Socket socket = null; // Initialize socket

            try {
                socket = serverSocket.accept(); // Blocking call; waits for a connection
                String connectingIP = socket.getInetAddress().getHostAddress();
                int readByte = socket.getInputStream().read(); // Read input

                System.out.println("Received connection attempt from IP: " + connectingIP + " with byte: " + readByte);

                // Validate the incoming socket
                if ((readByte & 0xFF) == 14 &&
                        !isIpBanned(connectingIP) &&
                        !isVpnIp(connectingIP)) { // Check for VPN IP
                    System.out.println("Accepted connection from IP: " + connectingIP);
                    return socket; // Return the valid socket
                } else {
                    System.out.println("Connection rejected from IP: " + connectingIP +
                            " (Banned: " + isIpBanned(connectingIP) +
                            ", VPN: " + isVpnIp(connectingIP) + ")");
                    if (socket != null) {
                        socket.close(); // Close the socket if it's invalid
                    }
                }
            } catch (SocketException se) {
                if (shutdownClientHandler) {
                    System.out.println("Server is shutting down, stopping acceptance of new connections.");
                    break; // Exit if the server is shutting down
                }
                se.printStackTrace(); // Log other socket exceptions
            } catch (IOException e) {
                e.printStackTrace(); // General IOException handling
                if (socket != null && !socket.isClosed()) {
                    try {
                        socket.close(); // Ensure the socket is closed on error
                    } catch (IOException closeException) {
                        closeException.printStackTrace();
                    }
                }
            }
        }

        return null; // Return null if no valid socket was accepted
    }


    // HashSet to store VPN IPs for quick lookup
    private static HashSet<String> vpnIpSet = new HashSet<>();

    static {
        String folderPath = "./Data/zones";  // Modify this to your folder path

        // Load the VPN IP ranges from all .zone files in the folder
        loadVpnIpsFromFolder(folderPath);
    }



    // Method to load the list of VPN IPs from a folder containing .zone files
    public static void loadVpnIpsFromFolder(String folderPath) {
        File folder = new File(folderPath);

        // Get all .zone files in the folder
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".zone"));
        if (files != null) {
            for (File file : files) {
                loadVpnIpsFromFile(file);
            }
            System.out.println("Loaded IP ranges from " + files.length + " zone files.");
        } else {
            System.out.println("No .zone files found in folder: " + folderPath);
        }
    }

    // Method to load VPN IP ranges from a specific .zone file
    public static void loadVpnIpsFromFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                vpnIpSet.add(line.trim());  // Add each IP range to the list
            }
            System.out.println("Loaded " + vpnIpSet.size() + " VPN IP ranges from " + file.getName());
        } catch (IOException e) {
            System.err.println("Error loading VPN IPs from file " + file.getName() + ": " + e.getMessage());
        }
    }

    // Method to check if a given IP belongs to any of the VPN IP ranges (CIDR format)
    public static boolean isVpnIp(String ip) {
        for (String range : vpnIpSet) {
            if (isInRange(ip, range)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if an IP is in a specific CIDR range
    public static boolean isInRange(String ip, String cidr) {
        try {
            String[] parts = cidr.split("/");
            String ipRange = parts[0];
            int prefixLength = Integer.parseInt(parts[1]);

            InetAddress targetAddress = InetAddress.getByName(ip);
            InetAddress rangeAddress = InetAddress.getByName(ipRange);

            byte[] targetBytes = targetAddress.getAddress();
            byte[] rangeBytes = rangeAddress.getAddress();

            int byteCount = prefixLength / 8;
            int bitCount = prefixLength % 8;

            // Compare full byte blocks
            for (int i = 0; i < byteCount; i++) {
                if (targetBytes[i] != rangeBytes[i]) {
                    return false;
                }
            }

            // Compare remaining bits
            if (bitCount > 0) {
                int mask = 0xFF << (8 - bitCount);
                if ((targetBytes[byteCount] & mask) != (rangeBytes[byteCount] & mask)) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void run() {
        try {
            shutdownClientHandler = false;
            clientListener = new ServerSocket(serverlistenerPort, 1, null);
            System.out.println("- Godzhell Reborn and Remastered is Online at port " + clientListener.getLocalPort());

            // Continue accepting connections until shutdownClientHandler is true
            while (!shutdownClientHandler) {
                Socket s = acceptSocketSafe(clientListener); // Attempt to accept a new socket
                if (s != null) { // Check if the socket is valid
                    s.setTcpNoDelay(true); // Configure the accepted socket

                    String connectingHost = s.getInetAddress().getHostName();
                    System.out.println("Connection established with: " + connectingHost);

                    // Connection filtering logic
                    if (ConnectionList.getInstance().filter(s.getInetAddress())) {
                        playerHandler.newPlayerClient(s, connectingHost);
                        ConnectionList.getInstance().addConnection(s.getInetAddress());
                    } else {
                        System.out.println("Connection blocked for: " + connectingHost);
                        s.close(); // Close the socket if not allowed
                    }
                } else {
                    System.out.println("Failed to accept a valid socket.");
                }

                // Check if the reboot flag is set, then initiate shutdown.
                if (shutdownServer) {
                    killServer();  // Trigger server shutdown or reboot
                    break;         // Exit the loop to stop accepting new connections
                }
            }

        } catch (IOException ioe) {
            if (shutdownClientHandler) {
                System.out.println("ClientHandler was shut down.");
            } else {
                System.out.println("Error: Unable to start listener on " + serverlistenerPort + " - port already in use?");
            }
        }
    }




    boolean isIpBanned(String ip) {
        String line = null;
        try {
            reader = new BufferedReader(new FileReader("data/bannedips.txt"));
            while ((line = reader.readLine()) != null) {
                if (line.equals(ip)) {
                    System.out.println("Client rejected from " + ip);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    private static boolean shuttingDown = false;

    public static boolean isShuttingDown() {
        return shuttingDown;
    }
    public static boolean hasActiveConnections() {
        return playerHandler.getPlayerCount() > 0;  // Assuming playerHandler tracks connected players
    }
    public static boolean hasRunningThreads() {
        int activeThreads = Thread.activeCount();
        System.out.println("Active threads: " + activeThreads);
        return activeThreads > 1; // Assuming 1 thread is the main thread
    }

    public void killServer() {
        try {
            shuttingDown = true; // Mark that the server is shutting down

            if (!hasActiveConnections() && !hasRunningThreads()) {
                shutdownClientHandler = true; // Signal to stop accepting new connections

                // Close the main listener socket if it's not null
                if (clientListener != null && !clientListener.isClosed()) {
                    clientListener.close();
                    clientListener = null;
                    scheduler.terminate(); // Terminate any scheduled tasks
                    System.out.println("Server listener socket closed.");
                }

                EventManager.getSingleton().shutdown(); // Shutdown any event handling
                System.out.println("Server events shutdown.");

                // Don't interrupt the thread until shutdown is fully done
            } else {
                System.out.println("Waiting for all connections and threads to finish...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            shuttingDown = false;
        }
    }

    public void restartServer() {
        try {
            System.out.println("Restarting the server...");

            // Shutdown server processes and clean up
            killServer();

            // Wait for a moment to ensure everything shuts down
            Thread.sleep(5000); // Wait for 5 seconds before restarting

            // Check if shutdown is complete
            if (!isShuttingDown() && !hasActiveConnections() && !hasRunningThreads()) {
                // Reinitialize server components after shutdown
                startServer();
                System.out.println("Server has been restarted.");
            } else {
                System.out.println("Reboot delayed: Server is still shutting down or has active connections/threads.");
            }
        } catch (InterruptedException e) {
            System.err.println("Reboot process interrupted: " + e.getMessage());
            // Optionally re-interrupt the current thread, if necessary
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Error during server reboot: " + e.getMessage());
            e.printStackTrace();
        }
    }




    public static GlobalObjects getGlobalObjects() {
        return globalObjects;
    }

}
