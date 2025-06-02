package algorithms.dp.bottom;

/**
 * 673. Number of Longest Increasing Subsequence
 * Time: O(n^2)
 * Space: O(n)
 * <p>
 * Bottom up dynamic programming
 */
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int maxLength = 0;
        int maxCount = 0;
        //lengths of longest subsequences ends with nums[i]
        int[] lengths = new int[nums.length];
        //numbers of longest subsequences ends with nums[i]
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lengths[i] = 1;
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[i] < lengths[j] + 1) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[i] == lengths[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
            if (maxLength < lengths[i]) {
                maxLength = lengths[i];
                maxCount = counts[i];
            } else if (maxLength == lengths[i]) {
                maxCount += counts[i];
            }
        }
        return maxCount;
    }

}
