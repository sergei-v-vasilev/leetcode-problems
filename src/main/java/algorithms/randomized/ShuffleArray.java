package algorithms.randomized;

import java.util.Random;

/**
 * 384. Shuffle an Array
 */
public class ShuffleArray {

    private final int[] original;
    private int[] shuffledArray;

    /**
     * Time: O(1)
     * Space: O(n)
     *
     * @param nums
     */
    public ShuffleArray(int[] nums) {
        original = nums.clone();
        shuffledArray = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     * Time: O(1)
     * Space: O(n)
     */
    public int[] reset() {
        shuffledArray = original.clone();
        return shuffledArray;
    }

    /**
     * Returns a random shuffling of the array.
     * Time: O(n)
     * Space: O(n)
     */
    public int[] shuffle() {
        Random random = new Random();
        int indexForSwap;
        int temp;
        for (int i = 0; i < shuffledArray.length; i++) {
            indexForSwap = i + random.nextInt(shuffledArray.length - i);
            temp = shuffledArray[indexForSwap];
            shuffledArray[indexForSwap] = shuffledArray[i];
            shuffledArray[i] = temp;
        }
        return shuffledArray;
    }
}
