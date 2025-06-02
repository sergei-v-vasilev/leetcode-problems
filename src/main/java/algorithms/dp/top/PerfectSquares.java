package algorithms.dp.top;

/**
 * 279. Perfect Squares
 * Time: O(n)
 * Space: O(n)
 */
public class PerfectSquares {
    public int numSquares(int n) {
        return minNumberOfSquares(n, new Integer[n + 1]);
    }

    private int minNumberOfSquares(int n, Integer[] memo) {
        if (n == 0) return 0;
        if (memo[n] != null) return memo[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, minNumberOfSquares(n - i * i, memo) + 1);
        }
        memo[n] = min;
        return memo[n];
    }
}
