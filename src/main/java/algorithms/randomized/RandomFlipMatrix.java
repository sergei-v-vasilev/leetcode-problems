package algorithms.randomized;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 519. Random Flip Matrix
 * Time: O(1)
 * Space: O(n)
 *
 */
public class RandomFlipMatrix {

    private int n;
    private int m;
    private Map<Integer, Integer> stored;
    private Random random;
    private int size;

    public RandomFlipMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        stored = new HashMap<>();
        random = new Random();
        size = m * n;
    }

    /**
     * [0,1,2,3,4,5,6,7,8,9] - pick(5) -> [0,1,2,3,4,5,6,7,8][9], 5 -> 9
     */
    public int[] flip() {
        int value = random.nextInt(size);
        int actualValue = stored.getOrDefault(value, value);
        int[] indices = new int[]{actualValue / n, actualValue % n};
        size--;
        stored.put(value, stored.getOrDefault(size, size));
        return indices;
    }

    public void reset() {
        stored.clear();
        size = m * n;
    }
}
