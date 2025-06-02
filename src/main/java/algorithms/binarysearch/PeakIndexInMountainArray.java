package algorithms.binarysearch;

/**
 * 852. Peak Index in a Mountain Array
 * Time: O(log(n))
 * Space: O(1)
 *
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (0 < mid && mid < arr.length - 1) {
                if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                } else if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    end = mid;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    end = mid;
                }
            } else if (mid == 0) {
                if (arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
