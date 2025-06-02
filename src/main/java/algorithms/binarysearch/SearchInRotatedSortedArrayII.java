package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 81. Search in Rotated Sorted Array II
 * Time: O(log(n))
 * Space: O(log(n))
 *
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length > 1 && nums[0] < nums[nums.length - 1]) {
            return Arrays.binarySearch(nums, target) >= 0;
        } else if (nums.length == 1) {
            return nums[0] == target;
        }
        int pivot = search(0, nums.length, nums);
        if (pivot == -1) {
            return Arrays.binarySearch(nums, target) >= 0;
        }
        if (nums[0] == target || nums[nums.length - 1] == target || nums[pivot] == target) {
            return true;
        }
        if (nums[pivot] < target && target < nums[nums.length - 1]) {
            return Arrays.binarySearch(nums, pivot, nums.length, target) >= 0;
        } else {
            return Arrays.binarySearch(nums, 0, pivot, target) >= 0;
        }
    }

    private int search(int start, int end, int[] nums) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return mid;
        }
        if (nums[mid] < nums[end - 1]) {
            return search(start, mid + 1, nums);
        } else if (nums[mid] > nums[end - 1]) {
            return search(mid, end, nums);
        } else if (nums[start] < nums[mid]) {
            return search(mid, end, nums);
        } else if (nums[start] > nums[mid]) {
            return search(start, mid + 1, nums);
        } else {
            int result = search(start, mid, nums);
            if (result == -1) {
                return search(mid + 1, end, nums);
            } else {
                return result;
            }
        }
    }
}
