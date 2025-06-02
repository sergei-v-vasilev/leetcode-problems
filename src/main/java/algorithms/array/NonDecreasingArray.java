package algorithms.array;

/**
 * 665. Non-decreasing Array
 * Time - O(n)
 * Space - O(1)
 *
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean wasModified = false;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] > nums[i] || nums[i] > nums[i + 1]) {
                if (wasModified) {
                    return false;
                }
                if (nums[i - 1] > nums[i] && nums[i] > nums[i + 1]) {
                    return false;
                }
                if (nums[i - 1] > nums[i]) {
                    if (nums[i - 1] > nums[i + 1] && i > 1 && nums[i - 2] > nums[i]) {
                        return false;
                    } else if (nums[i - 1] > nums[i + 1]) {
                        nums[i - 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                    wasModified = true;
                } else if (nums[i] > nums[i + 1]) {
                    if (nums[i - 1] > nums[i + 1] && i < nums.length - 2 && nums[i + 2] < nums[i]) {
                        return false;
                    } else if (nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                    wasModified = true;
                }
            }
        }
        return true;
    }
}
