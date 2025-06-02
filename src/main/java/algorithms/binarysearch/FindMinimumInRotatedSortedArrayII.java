package algorithms.binarysearch;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * Time: O(log(n) + k), where k is the number of maximum element
 * Space: O(1)
 * 
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length;
        int mid = 0;
        while (nums[end - 1] == nums[start] && start < end - 1) {
            end--;
        }
        if (start == end - 1) {
            return nums[0];
        }
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[0] > nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[mid];
    }
}
