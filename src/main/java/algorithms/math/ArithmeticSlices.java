package algorithms.math;

/**
 * 413. Arithmetic Slices
 * Time: O(n)
 * Space: O(1)
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int numberOfVariants = 0;
        int numberOfArithmeticSlices = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                numberOfVariants++;
                numberOfArithmeticSlices += numberOfVariants;
            } else numberOfVariants = 0;
        }
        return numberOfArithmeticSlices;
    }
}
