/**
 * A timer implementation that uses game ticks.
 * @author Michael Sasse (https://github.com/mikeysasse/)
 */
public class TickTimer {

    /**
     * The starting tick of this timer
     */
    private long startTick;

    /**
     * The duration that the timer should last for
     */
    private int duration;

    /**
     * Creates a new timer that will implement check elsewhere
     */
    public TickTimer() {
        this(0);
    }

    /**
     * Creates a new timer that lasts for x amount of time
     * @param duration The amount of time the timer should last for
     */
    public TickTimer(int duration) {
        reset();
    }

    /**
     * Reset the timer.
     */
    public void reset() {
        startTick = server.getTickCount();
    }

    /**
     * Sets the duration in ticks for this timer
     * @param duration The amount of time in ticks this timer should run for
     */
    public void setDuration(int duration) {
        this.duration = duration;
        reset();
    }

    /**
     * Gets the amount of ticks elapsed since instantiation or {@link TickTimer#reset()}.
     * @return the ticks elapsed
     */
    public long elapsed() {
        return server.getTickCount() - startTick;
    }

    /**
     * Determines if the duration in ticks has elapsed with this timer
     * This method should only be used when the duration is set.
     * @return True if the timer is finished
     */
    public boolean isFinished() {
        return elapsed() > duration;
    }

}
