package algorithms.array;

/**
 * 1749. Maximum Absolute Sum of Any Subarray
 */
public class MaximumAbsoluteSumAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int positiveSum = 0;
        int negativeSum = 0;
        int max = 0;
        for (int num : nums) {
            if (positiveSum + num < 0 || positiveSum < 0) {
                positiveSum = num;
            } else {
                positiveSum += num;
            }
            if (negativeSum + num > 0 || negativeSum > 0) {
                negativeSum = num;
            } else {
                negativeSum += num;
            }
            max = Math.max(max, positiveSum);
            max = Math.max(max, -negativeSum);
        }
        return max;
    }

}
