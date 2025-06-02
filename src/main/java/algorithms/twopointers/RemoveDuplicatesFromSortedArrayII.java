package algorithms.twopointers;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Time: O(n)
 * Space: O(1)
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int move = 0;
        int previous = nums[0];
        int i = 1;
        while (i < nums.length) {
            if (i + move > nums.length - 1) return i;
            nums[i] = nums[i + move];
            if (nums[i] == previous && count == 2) {
                move++;
                continue;
            } else if (nums[i] == previous) {
                count++;
            } else {
                count = 1;
            }
            previous = nums[i];
            i++;
        }
        return nums.length;
    }
}
