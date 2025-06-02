package algorithms.dp.top;

/**
 * 377. Combination Sum IV
 * Time: O(n)
 * Space: O(n)
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        return combinationSum(nums, target, new Integer[target + 1]);
    }

    private int combinationSum(int[] nums, int target, Integer[] memo) {
        if (target == 0) return 1;
        if (memo[target] != null) return memo[target];
        int combinationSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                combinationSum += combinationSum(nums, target - nums[i], memo);
            }
        }
        memo[target] = combinationSum;
        return memo[target];
    }
}
