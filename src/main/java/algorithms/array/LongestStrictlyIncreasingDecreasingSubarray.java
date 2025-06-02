package algorithms.array;

/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 */
public class LongestStrictlyIncreasingDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longestIncreasing = 1;
        int longestDecreasing = 1;
        int currentIncreasing = 1;
        int currentDecreasing = 1;
        for (int i = 1; i < nums.length; i++) {
            longestDecreasing = Math.max(currentDecreasing, longestDecreasing);
            longestIncreasing = Math.max(currentIncreasing, longestIncreasing);
            if (nums[i] > nums[i - 1]) {
                currentDecreasing = 1;
                currentIncreasing++;
            } else if (nums[i] < nums[i - 1]) {
                currentIncreasing = 1;
                currentDecreasing++;
            } else {
                currentDecreasing = 1;
                currentIncreasing = 1;
            }
        }
        longestDecreasing = Math.max(currentDecreasing, longestDecreasing);
        longestIncreasing = Math.max(currentIncreasing, longestIncreasing);
        return Math.max(longestIncreasing, longestDecreasing);
    }
}
