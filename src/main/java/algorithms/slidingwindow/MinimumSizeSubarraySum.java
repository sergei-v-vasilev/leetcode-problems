package algorithms.slidingwindow;

/**
 * 209. Minimum Size Subarray Sum
 * Time: O(n)
 * Space: O(1)
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 1;
        int sum = nums[0];
        while (end < nums.length && sum < target) {
            sum += nums[end];
            end++;
        }
        if (sum < target) return 0;
        int min = end - start;
        while (start <= end && sum - nums[start] >= target) {
            sum -= nums[start];
            start++;
        }
        min = Math.min(min, end - start);
        while (end < nums.length) {
            sum += nums[end];
            sum -= nums[start];
            start++;
            while (start <= end && sum - nums[start] >= target) {
                sum -= nums[start];
                start++;
            }
            end++;
        }
        min = Math.min(min, end - start);
        return min;
    }
}
