package algorithms.backtracking;

import java.util.*;

/**
 * 491. Non-decreasing Subsequences
 *
 */
public class NonDecreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtracking(0, nums, new LinkedList<>(), result);
        return new ArrayList<>(result);
    }

    private void backtracking(int i, int[] nums, LinkedList<Integer> sequence, Set<List<Integer>> result) {
        if (i == nums.length) {
            if (sequence.size() > 1) {
                result.add(new ArrayList<>(sequence));
            }
        } else {
            if (sequence.isEmpty() || sequence.getLast() <= nums[i]) {
                sequence.addLast(nums[i]);
                backtracking(i + 1, nums, sequence, result);
                sequence.removeLast();
            }
            backtracking(i + 1, nums, sequence, result);
        }
    }
}
