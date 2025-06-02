package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * Time: O(n)
 * Space: O(n)
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
