package algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. Binary Subarrays With Sum
 * Time: O(n)
 * Space: O(n)
 *
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sums = new int[nums.length];
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - goal)) {
                result += map.get(sum - goal);
            }
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
        }
        if (map.containsKey(goal)) {
            result += map.get(goal);
        }
        return result;
    }
}
