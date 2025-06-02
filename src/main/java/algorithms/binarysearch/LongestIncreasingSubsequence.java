package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * Time: O(n*log(n))
 * Space: O(n)
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            // return the index in the array where all previous numbers are less than current (nums[i]) in format -(index-1)
            // for example, binarySearch for 3 in [1,2,4] return 2, and for 5 in [1,2,4] return 3
            int index = Arrays.binarySearch(d, 0, maxLength, nums[i]);
            if (index < 0) {
                index = -(index + 1);
            }
            d[index] = nums[i];
            if (index == maxLength) {
                maxLength++;
            }
        }
        return maxLength;
    }
}
