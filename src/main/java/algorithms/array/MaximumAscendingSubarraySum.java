package algorithms.array;

/**
 * 1800. Maximum Ascending Subarray Sum
 */
public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                maxSum = Math.max(maxSum, sum);
                sum = nums[i];
            }
        }
        return Math.max(maxSum, sum);
    }

}
