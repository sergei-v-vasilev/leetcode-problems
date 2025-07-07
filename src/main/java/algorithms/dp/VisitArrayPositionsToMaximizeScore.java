package algorithms.dp;

/**
 * 2786. (M) Visit Array Positions to Maximize Score
 */
public class VisitArrayPositionsToMaximizeScore {

    //[2,3,6,1,9,2]
    //[13,13,11,10,9,2]
    public long maxScore(int[] nums, int x) {
        long even = 0L;
        long odd = 0L;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                even = Math.max(nums[i] + even, nums[i] + odd - x);
            } else {
                odd = Math.max(nums[i] + odd, nums[i] + even - x);
            }
        }
        if (nums[0] % 2 == 0) {
            return even;
        } else {
            return odd;
        }
    }

}
