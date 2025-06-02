package algorithms.binarysearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Time: O(log(n))
 * Space: O(1)
 * <p>
 * binary search
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length;
        int mid = 0;
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
