import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class RebootSystem {

    private static final long REBOOT_INTERVAL = 48 * 60 * 60 * 1000; // 12 hours in milliseconds
    private static final int[] WARNING_TIMES = {
            35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25,
            24, 23, 22, 21, 20, 19, 18, 17, 16, 15,
            14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    }; // Countdown from 35 to 1 minutes

    private static Timer timer = new Timer();
    private static server server = new server(); // Assuming server.java has a no-arg constructor

    public static void main(String[] args) {
        // Start the server
        server.startServer();

        // Start a thread to listen for commands
        new Thread(RebootSystem::commandListener).start();

        // Schedule countdown messages and reboot
        for (int time : WARNING_TIMES) {
            timer.schedule(new CountdownTask(time, server), REBOOT_INTERVAL - time * 60 * 1000);
        }

        // Schedule the actual reboot after the full interval
        timer.schedule(new RebootTask(server), REBOOT_INTERVAL);
    }

    private static void commandListener() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Type 'reboot' to trigger a reboot now:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("reboot")) {
                // Trigger reboot immediately
                new RebootTask(server).run();
                break;
            }
        }
    }

    static class RebootTask extends TimerTask {
        private final server server;

        public RebootTask(server server) {
            this.server = server;
        }

        @Override
        public void run() {
            synchronized (server) { // Ensure thread safety during reboot
                try {
                    // Print reboot message to console
                    System.out.println("Rebooting now!");

                    // Shutdown the server gracefully
                    shutdownServerGracefully();

                    // Wait for a moment to ensure the server is fully shut down before restarting
                    Thread.sleep(10000); // Adjust this delay if needed

                    // Restart the server
                    server.startServer();
                    System.out.println("Server restarted successfully.");
                } catch (InterruptedException e) {
                    System.out.println("Reboot task interrupted! Aborting the reboot.");
                    Thread.currentThread().interrupt(); // Preserve the interrupted status
                }
            }
        }

        // Gracefully shutdown the server
        private void shutdownServerGracefully() {
            // Check if server is already shutting down
            if (server.isShuttingDown()) {
                System.out.println("Server is already shutting down. Aborting reboot.");
                return;
            }

            // Start the shutdown process
            System.out.println("Server is shutting down...");
            server.killServer();

            // Wait until all connections and threads are properly closed
            while (server.hasActiveConnections() || server.hasRunningThreads()) {
                System.out.println("Waiting for active connections and threads to finish...");
                try {
                    Thread.sleep(1000); // Wait a bit before checking again
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while waiting for server shutdown.");
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Server has shut down completely.");
        }
    }

    // Task to send countdown warnings
    static class CountdownTask extends TimerTask {
        private final int time;
        private final server server;

        public CountdownTask(int time, server server) {
            this.time = time;
            this.server = server;
        }

        @Override
        public void run() {
            synchronized (server) { // Ensure thread safety
                // Print countdown message to console
                System.out.println("* * * Server Rebooting in " + time + " minutes * * * ");
                // Optionally, send message to all players if needed
                PlayerHandler.messageToAll = "@blu@* * * Server Rebooting in " + time + " minutes * * * ";
            }
        }
    }
}
