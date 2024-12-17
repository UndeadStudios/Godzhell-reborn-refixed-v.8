import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GarbageCollectorManager {
    private final ScheduledExecutorService scheduler;

    public GarbageCollectorManager() {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Starting Garbage Collector Manager to run every hour on the hour...");
        long initialDelay = calculateInitialDelay();
        long period = TimeUnit.HOURS.toMillis(1);
        scheduler.scheduleAtFixedRate(this::triggerGarbageCollection, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    private void triggerGarbageCollection() {
        System.out.println("Triggering Garbage Collection...");
        System.gc(); // Suggests the JVM to perform garbage collection
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Available memory: " + runtime.freeMemory() / 1024 / 1024 + " MB");
        System.out.println("Total memory: " + runtime.totalMemory() / 1024 / 1024 + " MB");
    }

    public void process() {
   }

    private long calculateInitialDelay() {
        Calendar calendar = Calendar.getInstance();
        int currentMinutes = calendar.get(Calendar.MINUTE);
        int currentSeconds = calendar.get(Calendar.SECOND);
        int currentMilliseconds = calendar.get(Calendar.MILLISECOND);

        int delayMinutes = 60 - currentMinutes;
        int delaySeconds = 60 - currentSeconds;
        int delayMilliseconds = 1000 - currentMilliseconds;

        return TimeUnit.MINUTES.toMillis(delayMinutes) + TimeUnit.SECONDS.toMillis(delaySeconds) + delayMilliseconds;
    }

    public void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(1, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }
}
