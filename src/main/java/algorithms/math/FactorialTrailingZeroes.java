package algorithms.math;

/**
 * 172. Factorial Trailing Zeroes
 * Time: O(log_5(n))
 * Space: O(1)
 *
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 5) {
            n /= 5;
            result += n;
        }
        return result + n / 5;
    }
}
