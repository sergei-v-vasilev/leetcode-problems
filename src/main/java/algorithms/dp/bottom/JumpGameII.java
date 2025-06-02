package algorithms.dp.bottom;

/**
 * 45. Jump Game II
 * Time: O(n * max(nums[i]))
 * Space: O(n)
 *
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int[] localMinimums = new int[nums.length];
        localMinimums[nums.length - 1] = 0;
        int localMin;
        for (int i = nums.length - 2; i >= 0; i--) {
            localMin = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (localMinimums[j] >= 0) localMin = Math.min(localMin, localMinimums[j] + 1);
            }
            localMinimums[i] = localMin == Integer.MAX_VALUE ? -1 : localMin;
        }
        return localMinimums[0];
    }

}
