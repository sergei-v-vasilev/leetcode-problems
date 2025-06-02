package algorithms.binarysearch;

/**
 * 1855. Maximum Distance Between a Pair of Values
 * 
 */
public class MaximumDistanceBetweenPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (max > nums2.length - 1 - i) {
                return max;
            }
            if (i < nums2.length && nums1[i] > nums2[i]) {
                continue;
            }
            int index = binarySearch(nums2, i, nums2.length - 1, nums1[i]);
            if (index > 0 && max < index - i) {
                max = index - i;
            }
        }
        return max;
    }

    public int binarySearch(int[] nums, int start, int end, int key) {
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= key) {
                index = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
}
