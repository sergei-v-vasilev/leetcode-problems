package algorithms.twopointers;

/**
 * 88. Merge Sorted Array
 * Time: O(n)
 * Space: O(1)
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int index = m + n - 1;
        while (pointer1 >= 0 || pointer2 >= 0) {
            if (pointer1 >= 0 && pointer2 >= 0 && nums1[pointer1] > nums2[pointer2]) {
                nums1[index] = nums1[pointer1];
                pointer1--;
                index--;
            }
            if (pointer1 >= 0 && pointer2 >= 0 && nums2[pointer2] >= nums1[pointer1]) {
                nums1[index] = nums2[pointer2];
                pointer2--;
                index--;
            }
            if (pointer1 >= 0 && pointer2 < 0) {
                nums1[index] = nums1[pointer1];
                pointer1--;
                index--;
            }
            if (pointer2 >= 0 && pointer1 < 0) {
                nums1[index] = nums2[pointer2];
                pointer2--;
                index--;
            }
        }
    }
}
