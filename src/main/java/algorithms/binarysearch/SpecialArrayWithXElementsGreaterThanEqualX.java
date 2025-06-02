package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 1608. Special Array With X Elements Greater Than or Equal X
 */
public class SpecialArrayWithXElementsGreaterThanEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];
        for (int i = 0; i <= max; i++) {
            int a = findCeil(i, nums);
            if (len - a == i) {
                return i;
            }
        }
        return -1;
    }

    private int findCeil(int a, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= a) {
                right = mid;
            } else left = mid + 1;
        }
        return left;
    }
}
