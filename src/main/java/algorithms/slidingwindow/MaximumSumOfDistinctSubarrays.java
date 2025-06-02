package algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 */
public class MaximumSumOfDistinctSubarrays {
    public long maximumSubarraySum(int[] nums, int k) {
        int duplicatesInWindow = 0;
        Map<Integer, Integer> numberMap = new HashMap<>();
        long sumWindow = 0;
        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            sumWindow += nums[i];
            if (numberMap.getOrDefault(nums[i], 0) >= 1) {
                duplicatesInWindow++;
            }
            numberMap.put(nums[i], numberMap.getOrDefault(nums[i], 0) + 1);
        }
        if (duplicatesInWindow == 0) {
            maxSum = sumWindow;
        }
        for (int i = k; i < nums.length; i++) {
            if (numberMap.getOrDefault(nums[i - k], 0) >= 2) {
                duplicatesInWindow--;
            }
            numberMap.put(nums[i - k], numberMap.getOrDefault(nums[i - k], 0) - 1);
            if (numberMap.getOrDefault(nums[i], 0) >= 1) {
                duplicatesInWindow++;
            }
            numberMap.put(nums[i], numberMap.getOrDefault(nums[i], 0) + 1);
            sumWindow -= nums[i - k];
            sumWindow += nums[i];
            if (duplicatesInWindow == 0) {
                maxSum = Math.max(maxSum, sumWindow);
            }
        }
        return maxSum;
    }
}
