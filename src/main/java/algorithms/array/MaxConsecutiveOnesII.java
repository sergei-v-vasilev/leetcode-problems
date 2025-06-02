package algorithms.array;

/**
 * 487. Max Consecutive Ones II
 */
public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int startWindow = -1;
        int nextZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && nextZeroIndex == -1) {
                nextZeroIndex = i;
            } else if (nums[i] == 0) {
                startWindow = nextZeroIndex;
                nextZeroIndex = i;
            }
            max = Math.max(max, i - startWindow);
        }
        return max;
    }

}
