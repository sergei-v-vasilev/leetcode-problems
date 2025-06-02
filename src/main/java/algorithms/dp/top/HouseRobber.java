package algorithms.dp.top;

/**
 * 198. House Robber
 * Time: O(n)
 * Space: O(n)
 * <p>
 * 
 */
public class HouseRobber {

    public int rob(int[] nums) {
        return rob(0, nums, new Integer[nums.length]);
    }

    private int rob(int i, int[] nums, Integer[] memo) {
        if (i > nums.length - 1) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        memo[i] = Math.max(nums[i] + rob(i + 2, nums, memo), nums[i + 1] + rob(i + 3, nums, memo));
        return memo[i];
    }
}
