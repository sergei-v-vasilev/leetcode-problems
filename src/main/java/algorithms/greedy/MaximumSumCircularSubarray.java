package algorithms.greedy;

/**
 * 918. Maximum Sum Circular Subarray
 */
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int maxElement = nums[0];
        boolean hasPositive = false;
        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            if (nums[i] > 0) {
                hasPositive = true;
            }
            sum += nums[i];
        }
        if (!hasPositive) {
            return maxElement;
        }
        int maxSubarraySum = Integer.MIN_VALUE;
        int currentSubarrayMaxSum = 0;
        int minSubarraySum = Integer.MAX_VALUE;
        int currentSubarrayMinSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSubarrayMaxSum = nums[i] + Math.max(0, currentSubarrayMaxSum);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarrayMaxSum);

            currentSubarrayMinSum = nums[i] + Math.min(0, currentSubarrayMinSum);
            minSubarraySum = Math.min(minSubarraySum, currentSubarrayMaxSum);
        }

        return Math.max(maxSubarraySum, sum - minSubarraySum);
    }
}
