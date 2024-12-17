/**
 * @author tj007razor
 * @version 1.5 1/27/2009
 * @name Timer.java
 */

public class Timer {
    private int timeToRun; // time to run (in seconds)
    private long startTime; // the time the timer started at
    private boolean activeTimer; // is the timer currently active?

    /**
     * @param timeToRun The amout of time for the timer to run for (in seconds)
     * @method constructor sets up the amount of time to run and converts input from seconds to ms, gets the starting time of the timer, and sets the timer as active
     **/
    public Timer(int timeToRun) {
        this.timeToRun = timeToRun * 1000;
        startTime = getStartTime();
        activeTimer = true;
    }

    /**
     * @method default constructor which initializes the variables to 0 and false(for the boolean)
     **/
    public Timer() {
        timeToRun = 0;
        startTime = 0;
        activeTimer = false;
    }

    /**
     * @return the starting time of the timer
     * @method determines the starting time of the timer
     **/
    private long getStartTime() {
        return System.currentTimeMillis();
    }

    /**
     * @return the amout of time has passed since the timer started
     * @method calculates the amount of time that has passed since the start of the timer
     **/
    private long timeSinceStart() {
        return System.currentTimeMillis() - startTime;
    }

    /**
     * @return whether the timer is active or not
     * @method returns whether the timer is active or not
     **/
    public boolean isActive() {
        return activeTimer;
    }

    /**
     * @param activeTimer is the timer active?
     * @method set whether the timer is active or not
     **/
    public void setActive(boolean activeTimer) {
        this.activeTimer = activeTimer;
    }

    /**
     * @param timeToRun The amout of time for the timer to run for (in seconds)
     * @method set the amount of time for the timer to run and gets the starting time of the timer
     **/
    public void setTimeToRun(int timeToRun) {
        this.timeToRun = timeToRun * 1000;
        startTime = getStartTime();
    }

    /**
     * @return if the timer is finished running
     * @method determines whether or not the timer is finished running
     **/
    public boolean stop() {
		return timeSinceStart() >= timeToRun;
	}
}