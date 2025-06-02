package algorithms.dp.bottom;

/**
 * 1770. Maximum Score from Performing Multiplication Operations
 * Time: O(n^2)
 * Space: O(n^2)
 */
public class MaximumScoreFromPerformingMultiplicationOperations {

    public int maximumScore(int[] nums, int[] multipliers) {
//        Integer[][] memo = new Integer[multipliers.length][nums.length];
//        return maximumScore(0, 0, nums, multipliers, memo);
        return bottomUp(nums, multipliers);
    }

    private static int bottomUp(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        for (int op = m - 1; op >= 0; op--) {
            for (int left = op; left >= 0; left--) {
                int fromLeft = multipliers[op] * nums[left] + dp[op + 1][left + 1];
                int fromRight = multipliers[op] * nums[n - 1 - (op - left)] + dp[op + 1][left];
                dp[op][left] = Math.max(fromLeft, fromRight);
            }
        }

        return dp[0][0];
    }

    //Memory limits
    private int topDown(int step, int left, int[] nums, int[] multipliers, Integer[][] memo) {
        if (step == multipliers.length) {
            return 0;
        }
        if (memo[step][left] != null) {
            return memo[step][left];
        }
        int right = nums.length - 1 - (step - left);
        int fromLeft = nums[left] * multipliers[step] + topDown(step + 1, left + 1, nums, multipliers, memo);
        int fromRight = nums[right] * multipliers[step] + topDown(step + 1, left, nums, multipliers, memo);
        memo[step][left] = Math.max(fromLeft, fromRight);
        return memo[step][left];
    }
}
