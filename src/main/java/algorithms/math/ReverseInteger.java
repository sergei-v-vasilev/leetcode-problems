package algorithms.math;

/**
 * 7. Reverse Integer
 * Time: O(n)
 * Space: O(1)
 *
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        if (Math.abs(x) < 10) {
            return x;
        }
        int result = 0;
        boolean isNegativeNumber = x < 0;
        x = Math.abs(x);
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10;
            if (x % 10 > Integer.MAX_VALUE - result) {
                return 0;
            }
            result += x % 10;
            x /= 10;
        }
        return isNegativeNumber ? -1 * result : result;
    }
}
