package algorithms.binarysearch;

/**
 * 1539. Kth Missing Positive Number
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] - mid < k + 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start + k;
    }
}

