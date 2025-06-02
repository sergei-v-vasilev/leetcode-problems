package algorithms.dp.top;

/**
 * 1155. Number of Dice Rolls With Target Sum
 * Time: O(n*k)
 * Space: O(n * target)
 *
 */
public class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {
        return numRollsToTarget(n, k, target, new Integer[n + 1][target + 1]);
    }

    private int numRollsToTarget(int n, int k, int target, Integer[][] memo) {
        if (n == 1) return 1 <= target && target <= k ? 1 : 0;
        if (memo[n][target] == null) return memo[n][target];
        long count = 0;
        for (int i = 1; i <= k && i <= target; i++) {
            count += numRollsToTarget(n - 1, k, target - i, memo);
        }
        memo[n][target] = (int) (count % 1000000007);
        return memo[n][target];
    }
}
