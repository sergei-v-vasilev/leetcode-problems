package algorithms.backtracking;

import java.util.*;

/**
 * 40. Combination Sum II
 * Time: O(2^n)
 * Space: O(n)
 *
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        combinationSum2(0, target, candidates, new LinkedList<>(), result);
        return result;
    }

    private void combinationSum2(int start, int target, int[] candidates,
                                 LinkedList<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (candidate <= target) {
                    list.addLast(candidate);
                    combinationSum2(i + 1, target - candidate, candidates, list, result);
                    list.removeLast();
                }
                while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
