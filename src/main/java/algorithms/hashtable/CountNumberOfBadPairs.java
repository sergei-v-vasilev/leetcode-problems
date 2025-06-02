package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. Count Number of Bad Pairs
 */
public class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        long count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int diff = map.getOrDefault(nums[i] - i, 0);
            count += Math.max(0, nums.length - i - 1 - diff);
            map.put(nums[i] - i, diff + 1);
        }
        return count;
    }

}
