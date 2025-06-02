package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 * Time: O(n^2)
 * Space: O(n)
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        fill(0, candidates, target, list, result);
        return result;
    }

    private void fill(int i, int[] nums, int target, LinkedList<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        if (i == nums.length) {
            return;
        }
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        for (int j = i; j < nums.length && nums[j] <= target; j++) {
            list.addLast(nums[j]);
            fill(j, nums, target - nums[j], list, result);
            list.removeLast();
        }
    }
}
