package algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int currentSum = 0;
        // sum subarray [i, n] = sum of array [0,n] - sum of subarray [0,i]
        Map<Integer, Integer> sumMap = new HashMap<>(nums.length);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum == k) {
                count++;
            }
            if (sumMap.containsKey(currentSum - k)) {
                count += sumMap.get(currentSum - k);
            }
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
