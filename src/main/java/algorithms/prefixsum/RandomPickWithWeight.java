package algorithms.prefixsum;

import java.util.Arrays;
import java.util.Random;

/**
 * 528. Random Pick with Weight
 * 
 */
public class RandomPickWithWeight {

    private int[] numbers;
    private Random random;

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public RandomPickWithWeight(int[] w) {
        numbers = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            numbers[i] = sum;
        }
        random = new Random();
    }

    /**
     * Time: O(log(n))
     * Space: O(1)
     */
    public int pickIndex() {
        int number = 1 + random.nextInt(numbers[numbers.length - 1]);
        int index = Arrays.binarySearch(numbers, number);
        if (index < 0) return -index - 1;
        else return index;
    }
}
