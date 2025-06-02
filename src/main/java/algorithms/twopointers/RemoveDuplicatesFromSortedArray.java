package algorithms.twopointers;

/**
 * 26. Remove Duplicates from Sorted Array
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int pointer = 0;
        int currentValue = nums[pointer];
        for (int i = 1; i < nums.length; i++) {
            if (currentValue != nums[i]) {
                nums[pointer] = currentValue;
                pointer++;
                currentValue = nums[i];
            }
        }
        nums[pointer] = currentValue;
        pointer++;
        return pointer;
    }
}
