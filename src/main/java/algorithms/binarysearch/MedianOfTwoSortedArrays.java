package algorithms.binarysearch;

/**
 * 4. Median of Two Sorted Arrays
 * Time: O(log(n+m))
 * Space: O(1)
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        return findMedianSortedArrays(a, b, 0, a.length);
    }

    private double findMedianSortedArrays(int[] a, int[] b, int start, int end) {
        int m = a.length;
        int n = b.length;
        int partitionA = (start + end) / 2;
        int partitionB = (m + n + 1) / 2 - partitionA;
        int maxLeftA = partitionA > 0 ? a[partitionA - 1] : Integer.MIN_VALUE;
        int maxLeftB = partitionB > 0 ? b[partitionB - 1] : Integer.MIN_VALUE;
        int minRightA = partitionA < m ? a[partitionA] : Integer.MAX_VALUE;
        int minRightB = partitionB < n ? b[partitionB] : Integer.MAX_VALUE;
        if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
            if ((m + n) % 2 == 0) {
                return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
            } else {
                return Math.max(maxLeftA, maxLeftB);
            }
        } else if (maxLeftA > minRightB) {
            return findMedianSortedArrays(a, b, start, partitionA + 1);
        } else {
            return findMedianSortedArrays(a, b, partitionA + 1, end);
        }

    }
}
