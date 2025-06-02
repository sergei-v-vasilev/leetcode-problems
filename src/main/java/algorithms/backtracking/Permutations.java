package algorithms.backtracking;

import java.util.*;

/**
 * 46. Permutations
 * Time: O(n!)
 * Space: O(n)
 * 
 * Backtracking
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>(nums.length);
        List<List<Integer>> result = new LinkedList<>();
        permute(nums, linkedSet, result);
        return result;
    }

    private void permute(int[] nums, LinkedHashSet<Integer> linkedSet, List<List<Integer>> result) {
        if (linkedSet.size() == nums.length) {
            result.add(new ArrayList<>(linkedSet));
        } else {
            for (int num : nums) {
                if (!linkedSet.contains(num)) {
                    linkedSet.add(num);
                    permute(nums, linkedSet, result);
                    linkedSet.remove(num);
                }
            }
        }
    }
}
