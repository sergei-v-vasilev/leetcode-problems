package algorithms.math;

/**
 * 396. Rotate Function
 * Time: O(n)
 * Space: O(1)
 *
 */
public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int lastMaxMultiplierIndex = nums.length - 1;
        int multiplier = 0;
        int sum = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += multiplier * nums[i];
            step += nums[i];
            multiplier++;
        }
        int max = sum;

        while (lastMaxMultiplierIndex > 0) {
            sum += step;
            sum -= nums[lastMaxMultiplierIndex] * nums.length;
            max = Math.max(max, sum);
            lastMaxMultiplierIndex--;
        }
        return max;
    }
}
