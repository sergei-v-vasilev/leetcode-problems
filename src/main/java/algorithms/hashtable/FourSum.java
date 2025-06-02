package algorithms.hashtable;

import java.util.*;

/**
 * 18. 4Sum
 * Time: O(n^3)
 * Space: O(n)
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    Integer index = indices.get(target - nums[i] - nums[j] - nums[k]);
                    if (index != null && index > k) {
                        List<Integer> quadruplets = new LinkedList<>();
                        quadruplets.add(nums[i]);
                        quadruplets.add(nums[j]);
                        quadruplets.add(nums[k]);
                        quadruplets.add(nums[index]);
                        result.add(quadruplets);
                    }
                }
            }
        }
        return result;
    }
}
