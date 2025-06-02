package algorithms.binarysearch;

/**
 * 278. First Bad Version
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int start, int end) {
        int mid = start + (end - start) / 2;
        boolean bad = isBadVersion(mid);
        if (start == mid && bad) return mid;
        return bad ? binarySearch(start, mid) : binarySearch(mid + 1, end);
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
