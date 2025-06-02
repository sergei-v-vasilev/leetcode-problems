package algorithms.dp.bottom;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Time: O(n * k)
 * Space: O(n * k)
 * 
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int subsetSum = totalSum / 2;
        boolean dp[][] = new boolean[nums.length + 1][subsetSum + 1];
        Arrays.fill(dp[0], true);
        for (int j = 1; j <= subsetSum; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= subsetSum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][subsetSum];
    }

}
