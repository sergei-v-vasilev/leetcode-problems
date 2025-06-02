package algorithms.greedy;

/**
 * 334. Increasing Triplet Subsequence
 * Time: O(n)
 * Space: O(1)
 *
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        Integer numI = null;
        Integer numJ = null;
        for (int i = 0; i < nums.length; i++) {
            if (numI == null) {
                numI = nums[i];
            } else if (numJ == null) {
                if (nums[i] <= numI) {
                    numI = nums[i];
                } else {
                    numJ = nums[i];
                }
            } else {
                if (nums[i] <= numI) {
                    numI = nums[i];
                } else if (nums[i] <= numJ) {
                    numJ = nums[i];
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
