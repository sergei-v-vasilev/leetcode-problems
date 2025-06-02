package algorithms.binarysearch;

/**
 * 367. Valid Perfect Square
 * Time: O(log(n))
 * Space: O(log(n))
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        return isSquareBS(num, 0, 46341);
    }

    private boolean isSquareBS(int num, int start, int end) {
        if (num == 1) return true;
        if (start >= end) {
            return false;
        }
        int current = start + (end - start) / 2;
        int value = current * current;
        if (value == num) return true;
        else if (value > num) {
            return isSquareBS(num, start, current);
        } else {
            return isSquareBS(num, current + 1, end);
        }
    }
}
