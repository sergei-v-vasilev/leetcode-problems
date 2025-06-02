package algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * Time: O(n)
 * Space: O(n)
 *
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (count == 0) {
                max = Math.max(max, i + 1);
            }
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }
}
