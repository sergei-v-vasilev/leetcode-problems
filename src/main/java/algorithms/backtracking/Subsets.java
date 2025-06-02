package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            result = fill(i, nums, new ArrayList<>(), result);
        }
        return result;
    }

    private List<List<Integer>> fill(int i, int[] nums, List<Integer> list, List<List<Integer>> result) {
        list.add(nums[i]);
        result.add(list);
        for (int j = i + 1; j < nums.length; j++) {
            result = fill(j, nums, new ArrayList<>(list), result);
        }
        return result;
    }
}
