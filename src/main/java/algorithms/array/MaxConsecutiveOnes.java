package algorithms.array;

/**
 * 485. Max Consecutive Ones
 * Time: O(n)
 * Space: O(1)
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = nums[0] == 1 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] && nums[i] == 1) {
                current++;
            } else if (nums[i] == 1) {
                current = 1;
            } else {
                current = 0;
            }
            max = Math.max(current, max);
        }
        return Math.max(current, max);
    }
}
