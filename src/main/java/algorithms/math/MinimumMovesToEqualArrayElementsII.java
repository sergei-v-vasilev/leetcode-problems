package algorithms.math;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int value = nums[mid];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(nums[i] - value);
        }
        return moves;
    }
}
