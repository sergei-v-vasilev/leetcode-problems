package algorithms.heap;

import java.util.TreeMap;

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualLimit {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int longest = 1;
        window.put(nums[0], 1);
        //inclusive
        int start = 0;
        //exclusive
        int end = 1;
        while (end < nums.length) {
            int max = window.lastKey();
            int min = window.firstKey();
            while (end < nums.length && Math.abs(max - min) <= limit) {
                window.put(nums[end], window.getOrDefault(nums[end], 0) + 1);
                max = window.lastKey();
                min = window.firstKey();
                end++;
                if (Math.abs(max - min) <= limit) {
                    longest = Math.max(longest, end - start);
                }
            }
            while (end != nums.length && start < end && Math.abs(max - min) > limit) {
                if (window.getOrDefault(nums[start], 0) == 1) {
                    window.remove(nums[start]);
                } else {
                    window.put(nums[start], window.getOrDefault(nums[start], 0) - 1);
                }
                max = window.lastKey();
                min = window.firstKey();
                start++;
            }
        }
        return longest;
    }

}
