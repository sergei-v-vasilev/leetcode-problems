package algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Time: O(n^2)
 * Space: O(1)
 */
public class IIISum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(nums.length);
        int left;
        int right;
        int sum;
        List<Integer> list;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            right = nums.length - 1;
            while (left < right) {
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
