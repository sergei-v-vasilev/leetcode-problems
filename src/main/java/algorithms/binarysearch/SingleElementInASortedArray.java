package algorithms.binarysearch;

/**
 * 540. Single Element in a Sorted Array
 * Time: O(log(n))
 * Space: O(1)
 * 
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int mid;
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid == 0) return nums[mid];
            if (mid == nums.length - 1) return nums[mid];
            if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            }
            if (nums[mid - 1] == nums[mid]) {
                if ((end - mid - 1) % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                continue;
            }
            if (nums[mid] == nums[mid + 1]) {
                if ((end - mid - 2) % 2 == 0) {
                    end = mid;
                } else {
                    start = mid + 2;
                }
            }
        }
        return -1;
    }
}
