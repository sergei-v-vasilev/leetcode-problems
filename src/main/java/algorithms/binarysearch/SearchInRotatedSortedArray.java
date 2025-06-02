package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 33. Search in Rotated Sorted Array
 * Time: O(log(n))
 * Space: O(1)
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = -1;
        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        if (nums[0] > nums[nums.length - 1]) {
            pivot = findPivot(0, nums.length, nums);
        }
        int index;
        if (pivot < 0) {
            index = Arrays.binarySearch(nums, target);
            return index < 0 ? -1 : index;
        } else {
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target && target < nums[nums.length - 1]) {
                index = Arrays.binarySearch(nums, pivot, nums.length, target);
                return index < 0 ? -1 : index;
            } else if (nums[0] < target && target <= nums[pivot - 1]) {
                index = Arrays.binarySearch(nums, 0, pivot, target);
                return index < 0 ? -1 : index;
            } else {
                return -1;
            }
        }
    }

    private int findPivot(int start, int end, int[] nums) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (mid > 0 && nums[mid - 1] > nums[mid]) {
            return mid;
        } else if (nums[mid] > nums[nums.length - 1]) {
            return findPivot(mid + 1, end, nums);
        } else {
            return findPivot(start, mid, nums);
        }
    }

}
