package algorithms.prefixsum;

import java.util.*;

/**
 * 523. Continuous Subarray Sum
 * Time: O(n)
 * Space: O(n)
 *
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int sum = 0;
        int modulo;
        int previous = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && previous == nums[i] && nums[i] == 0) return true;
            previous = nums[i];
            sum += nums[i];
            modulo = sum % k;
            if (i > 0 && modulo == 0) return true;
            if (map.containsKey(modulo)) {
                if (i - map.get(modulo) > 1) return true;
            } else map.put(modulo, i);
        }
        return false;
    }
}
