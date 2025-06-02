package algorithms.dp.bottom;

/**
 * 55. Jump Game
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int currentAbilityToJump = nums[0];
        int i = 1;
        while (i < nums.length && currentAbilityToJump > 0) {
            currentAbilityToJump--;
            currentAbilityToJump = Math.max(currentAbilityToJump, nums[i]);
            if (currentAbilityToJump + i >= nums.length - 1) {
                return true;
            }
            i++;
        }
        return i == nums.length;
    }
}
