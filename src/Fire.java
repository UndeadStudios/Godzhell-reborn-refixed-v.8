import java.util.Random;

public class Fire {
    private static final Random random = new Random(System.currentTimeMillis());
    private final Timer fireTimer; // fire timer
    private final int[] coords;
    private final int controller;

    // create new fire
    public Fire(int baseTime, int maxTime, int fireX, int fireY, int controller) {
        fireTimer = new Timer(random.nextInt(maxTime) + baseTime);
        coords = new int[2];
        coords[0] = fireX;
        coords[1] = fireY;
        this.controller = controller;
    }

    // check if the fire is done
    public boolean fireDie() {
        return fireTimer.stop();
    }

    // return coords of fire
    public int[] getCoords() {
        return coords;
    }

    // return the controller of this fire
    public int getController() {
        return controller;
    }
}
