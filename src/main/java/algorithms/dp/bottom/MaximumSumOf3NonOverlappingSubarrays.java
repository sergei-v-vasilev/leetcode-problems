package algorithms.dp.bottom;


/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 */
public class MaximumSumOf3NonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        long[] subarraySums = new long[nums.length - k + 1];
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        subarraySums[0] = currentSum;
        int index = k;
        for (int i = 1; i < subarraySums.length; i++) {
            currentSum -= nums[index - k];
            currentSum += nums[index];
            subarraySums[i] = currentSum;
            index++;
        }
        //[last max after k][index of last max after k]
        long[][] lastMax1 = new long[subarraySums.length][2];
        long lastMax = -1;
        long lastMaxIndex = -1;
        for (int i = subarraySums.length - 1; i >= 0; i--) {
            if (i + k < subarraySums.length && subarraySums[i + k] >= lastMax) {
                lastMaxIndex = i + k;
                lastMax = subarraySums[i + k];
            }
            lastMax1[i][0] = lastMax;
            lastMax1[i][1] = lastMaxIndex;
        }

        //[current sum + last max sum]
        long[] sums2 = new long[subarraySums.length];
        for (int i = subarraySums.length - 1; i >= 0; i--) {
            sums2[i] = subarraySums[i] + lastMax1[i][0];
        }

        //[last max sum of 2 after k][index of 2 elements creates last max sum of 2 after key]
        long[][] lastMax2 = new long[subarraySums.length][3];
        lastMax = -1;
        lastMaxIndex = -1;
        for (int i = subarraySums.length - 1; i >= 0; i--) {
            if (i + k < subarraySums.length && sums2[i + k] >= lastMax) {
                lastMaxIndex = i + k;
                lastMax = sums2[i + k];
            }
            lastMax2[i][0] = lastMax;
            lastMax2[i][1] = lastMaxIndex;
            if (0 <= lastMaxIndex && lastMaxIndex < subarraySums.length) {
                lastMax2[i][2] = lastMax1[(int) lastMaxIndex][1];
            }
        }

        lastMax = -1;
        int[] result = new int[3];
        for (int i = 0; i < subarraySums.length; i++) {
            if (lastMax < subarraySums[i] + lastMax2[i][0]) {
                lastMax = subarraySums[i] + lastMax2[i][0];
                result[0] = i;
                result[1] = (int) lastMax2[i][1];
                result[2] = (int) lastMax2[i][2];
            }
        }
        return result;
    }
}
