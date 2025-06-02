package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Time: O(log(n))
 * Space: O(1)
 *
 */
public class FindFirstLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int first = findFirstPosition(0, index + 1, nums, target);
        int last = findLastPosition(index, nums.length, nums, target);
        return new int[]{first, last};
    }

    private int findFirstPosition(int start, int end, int[] nums, int target) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            }
            return findFirstPosition(start, mid, nums, target);
        } else {
            return findFirstPosition(mid, end, nums, target);
        }
    }

    private int findLastPosition(int start, int end, int[] nums, int target) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            }
            return findLastPosition(mid + 1, end, nums, target);
        } else {
            return findLastPosition(start, mid, nums, target);
        }
    }
}
