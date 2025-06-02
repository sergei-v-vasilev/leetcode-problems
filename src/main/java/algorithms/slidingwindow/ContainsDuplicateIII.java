package algorithms.slidingwindow;

import java.util.TreeMap;

/**
 * 220. Contains Duplicate III
 * Time: O(n * log(k))
 * Space: O(n)
 * 
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (map.isEmpty()) map.put(nums[i], i);
            else if (map.floorKey(nums[i]) != null && Math.abs(map.floorKey(nums[i]) - (long) nums[i]) <= t)
                return true;
            else if (map.ceilingKey(nums[i]) != null && Math.abs(map.ceilingKey(nums[i]) - (long) nums[i]) <= t)
                return true;
            else map.put(nums[i], i);
        }
        for (int i = k + 1; i < nums.length; i++) {
            map.remove(nums[i - k - 1]);
            if (map.isEmpty()) map.put(nums[i], i);
            else if (map.floorKey(nums[i]) != null && Math.abs(map.floorKey(nums[i]) - (long) nums[i]) <= t)
                return true;
            else if (map.ceilingKey(nums[i]) != null && Math.abs(map.ceilingKey(nums[i]) - (long) nums[i]) <= t)
                return true;
            else map.put(nums[i], i);
        }
        return false;
    }
}
