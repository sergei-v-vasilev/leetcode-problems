package algorithms.array;

/**
 * 53. Maximum Subarray
 * Time: O(n)
 * Space: O(1)
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < 0 || sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
