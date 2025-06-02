package algorithms.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * Time: O(n)
 * Space: O(1)
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int index;
        //O(2*n)
        for (int i = 0; i < nums.length; i++) {
            index = nums[i];
            while (nums[index - 1] != index) {
                swap(i, index - 1, nums);
                index = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
