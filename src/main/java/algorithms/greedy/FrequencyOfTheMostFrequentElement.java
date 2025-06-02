package algorithms.greedy;

import java.util.Arrays;

/**
 * 1838. Frequency of the Most Frequent Element
 */
public class FrequencyOfTheMostFrequentElement {


    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int end = 0;
        long availableMoves = k;
        int maxFrequency = Integer.MIN_VALUE;
        int currentArrayValue = nums[start];

        while (end < nums.length) {
            if (end > start && currentArrayValue != nums[end]) {
                availableMoves -= ((long) (nums[end] - currentArrayValue)) * (end - start);
                currentArrayValue = nums[end];
            }
            if (availableMoves >= 0) {
                maxFrequency = Math.max(maxFrequency, end - start + 1);
            }
            while (start < end && availableMoves < 0) {
                availableMoves += currentArrayValue - nums[start];
                start++;
            }
            if (availableMoves >= 0) {
                maxFrequency = Math.max(maxFrequency, end - start + 1);
            }
            end++;
        }

        return maxFrequency;
    }

}
