package algorithms.array;

/**
 * 2202. Maximize the Topmost Element After K Moves
 */
public class MaximizeTheTopmostElementAfterKMoves {

    public int maximumTop(int[] nums, int k) {
        int maxElement = -1;
        if (nums.length == 1 && k % 2 != 0) {
            return maxElement;
        }
        //we remove all k-1 elements and track the biggest one
        for (int i = 0; i < Math.min(k - 1, nums.length); i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }
        //we still have one move. we can remove the element and leave k+1 as the biggest or add the existing
        if (k < nums.length && nums[k] > maxElement) {
            maxElement = nums[k];
        }
        return maxElement;
    }
}
