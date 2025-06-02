package algorithms.binarysearch;

/**
 * 633. Sum of Square Numbers
 * Time: O(Math.sqrt(c) * log(c))
 * Space: O(log(c))
 *
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            int b = c - (int) (i * i);
            if (isSquareBS(b, 0, b)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquareBS(int num, long start, long end) {
        if (start > end) {
            return false;
        }
        long current = start + (end - start) / 2;
        long value = current * current;
        if (value == num) return true;
        else if (value > num) {
            return isSquareBS(num, start, current - 1);
        } else {
            return isSquareBS(num, current + 1, end);
        }
    }
}
