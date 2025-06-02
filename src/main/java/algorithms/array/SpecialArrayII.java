package algorithms.array;

import java.util.TreeSet;

/**
 * 3152. Special Array II
 */
public class SpecialArrayII {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        //indexes for which the next one is violation
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < nums.length - 1) {
                if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) {
                    set.add(i);
                } else if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0) {
                    set.add(i);
                }
            }
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer nextViolationIndex = set.ceiling(queries[i][0]);
            if (nextViolationIndex != null) {
                result[i] = queries[i][1] < nextViolationIndex + 1;
            } else {
                result[i] = true;
            }
        }
        return result;
    }

}
