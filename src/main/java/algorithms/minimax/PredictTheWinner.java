package algorithms.minimax;

import java.util.HashMap;
import java.util.Map;

/**
 * 486. Predict the Winner
 */
public class PredictTheWinner {


    public boolean predictTheWinner(int[] nums) {
        long result = minMax(nums, 0, nums.length - 1, new HashMap<>());
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum - result <= result;
    }

    private long minMax(int[] nums, int start, int end, Map<Integer, Map<Integer, Long>> memo) {
        if (memo.containsKey(start) && memo.get(start).containsKey(end)) return memo.get(start).get(end);
        if (start == end) {
            return nums[start];
        }
        if (start > end) {
            return 0;
        }
        long minIfFirst = nums[start] + Math.min(
                minMax(nums, start + 1, end - 1, memo),
                minMax(nums, start + 2, end, memo)
        );
        long minIfSecond = nums[end] + Math.min(
                minMax(nums, start + 1, end - 1, memo),
                minMax(nums, start, end - 2, memo)
        );
        long result = Math.max(minIfFirst, minIfSecond);
        Map<Integer, Long> map = memo.getOrDefault(start, new HashMap<>());
        map.put(end, result);
        memo.put(start, map);
        return result;
    }

}
