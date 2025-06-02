package algorithms.array;

/**
 * 1752. Check if Array Is Sorted and Rotated
 */
public class CheckIfArrayIsSortedAndRotated {

    public boolean check(int[] nums) {
        boolean isPassedRotatedIndex = false;
        for (int i = 1; i < nums.length; i++) {
            if (isPassedRotatedIndex && nums[i] < nums[i - 1]) {
                return false;
            } else if (nums[i] < nums[i - 1]) {
                isPassedRotatedIndex = true;
            }
        }
        return !isPassedRotatedIndex || nums[nums.length - 1] <= nums[0];
    }

}
