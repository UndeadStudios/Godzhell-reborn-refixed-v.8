import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnimationLength {

    private static final Map<Integer, Integer> frameLengths = new HashMap<>();

    public static void startup() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./Data/cfg/animation_lengths.cfg"))) {
            reader.lines().forEach(line -> {
                String[] split = line.split(":");
                frameLengths.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getFrameLength(int animationId) {
        if (!frameLengths.containsKey(animationId)) {
            return 4;
        } else {
            int frameLength = frameLengths.get(animationId);
            int length = (int) Math.ceil((frameLength * 20d) / 600d);
            if (length < 1) {
                length = 1;
            }
            return length;
        }
    }
}
