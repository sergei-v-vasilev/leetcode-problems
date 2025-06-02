package algorithms.math;


/**
 * 169. Majority Element
 * Time: O(n)
 * Space: O(1)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int value = nums[0];
        int numberOfElements = 1;
        int i = 1;
        while (i < nums.length) {
            if (numberOfElements == 0) {
                value = nums[i];
            }
            if (nums[i] == value) {
                numberOfElements++;
            } else {
                numberOfElements--;
            }
            i++;
        }
        return value;
    }
}
