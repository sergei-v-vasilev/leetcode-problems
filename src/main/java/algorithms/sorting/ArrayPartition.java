package algorithms.sorting;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * Time: O(n log(n))
 * Space: O(1)
 * 
 */
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
