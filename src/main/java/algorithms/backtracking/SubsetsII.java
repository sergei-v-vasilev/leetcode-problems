package algorithms.backtracking;

import java.util.*;

/**
 * 90. Subsets II
 * Time: O(2^n)
 * Space: O(2^n)
 *
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int j = 0; j < nums.length; j++) {
            if (j > 0 && nums[j] != nums[j - 1] || j == 0) {
                subsetsWithDup(j, nums, new LinkedList<>(), result);
            }
        }
        return result;
    }

    private void subsetsWithDup(int i, int[] nums, LinkedList<Integer> list, List<List<Integer>> result) {
        result.add(list);
        if (i == nums.length) return;
        list.add(nums[i]);
        for (int j = i + 1; j < nums.length; j++) {
            if (j > i + 1 && nums[j] != nums[j - 1] || j == i + 1) {
                subsetsWithDup(j, nums, new LinkedList<>(list), result);
            }
        }
    }

}
