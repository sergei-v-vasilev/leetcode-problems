package algorithms.array;

/**
 * 376. Wiggle Subsequence
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int lengthIsUp = 1;
        int lengthIsDown = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                lengthIsDown = lengthIsUp + 1;
            }
            if (nums[i] > nums[i - 1]) {
                lengthIsUp = lengthIsDown + 1;
            }
        }
        return Math.max(lengthIsDown, lengthIsUp);
    }
}
