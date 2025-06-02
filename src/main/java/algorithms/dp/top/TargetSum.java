package algorithms.dp.top;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum
 * Time: O(n * target)
 * Space: O(n * target)
 *
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(0, nums, target, new HashMap<>(nums.length));
    }

    private int findTargetSumWays(int i, int[] nums, int target, Map<Integer, Map<Integer, Integer>> memo) {
        if (i == nums.length - 1) {
            if (nums[i] == 0 && 0 == target) {
                return 2;
            }
            if (nums[i] == target) {
                return 1;
            }
            if (-nums[i] == target) {
                return 1;
            }
            return 0;
        }
        if (memo.containsKey(i) && memo.get(i).containsKey(target)) {
            return memo.get(i).get(target);
        }
        int value = findTargetSumWays(i + 1, nums, target + nums[i], memo) +
                findTargetSumWays(i + 1, nums, target - nums[i], memo);
        Map<Integer, Integer> innerMemo = memo.getOrDefault(i, new HashMap<>());
        innerMemo.put(target, value);
        memo.put(i, innerMemo);
        return value;
    }
}
