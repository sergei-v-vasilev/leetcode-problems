package algorithms.slidingwindow;

import java.util.List;

/**
 * 713. Subarray Product Less Than K
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int numSubarray = 0;
        int product = 1;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            product *= nums[end];
            while (start < end && product >= k) {
                product /= nums[start];
                start++;
            }
            if (product < k) {
                numSubarray += end - start + 1;
            }
            end++;
        }
        return numSubarray;
    }

    public int numSubarrayProductLessThanKLog(int[] nums, int k) {
        double[] logsPrefixSum = new double[nums.length + 1];
        // Use log because of possible big numbers in results. Calculate prefix sum of logarithms of elements
        for (int i = 0; i < nums.length; i++) {
            logsPrefixSum[i + 1] = logsPrefixSum[i] + Math.log(nums[i]);
        }

        int numSubarray = 0;
        // Calculate subarray count with product less than k
        for (int i = 0; i < nums.length + 1; i++) {
            int start = i + 1;
            int end = nums.length + 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                //because product of subarray is a/b < k => a < b*k. 1e-9 is required because log doesn't calculate it properly
                if (logsPrefixSum[mid] <= logsPrefixSum[i] + Math.log(k) - 1e-9) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            numSubarray += start - i - 1;
        }

        return numSubarray;
    }

    public static long countSubarrays(List<Integer> numbers, int k) {
        long numSubarray = 0;
        long product = 1;
        int start = 0;
        int end = 0;
        while (end < numbers.size()) {
            product *= numbers.get(end);
            while (start < end && product > k) {
                product /= numbers.get(start);
                start++;
            }
            if (product <= k) {
                numSubarray += end - start + 1;
            }
            end++;
        }
        return numSubarray;
    }
}
