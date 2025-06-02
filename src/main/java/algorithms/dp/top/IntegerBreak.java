package algorithms.dp.top;

/**
 * 343. Integer Break
 * Time: O(n)
 * Space: O(n)
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        return maxProduct(n, new Integer[n + 1], false);
    }

    private int maxProduct(int n, Integer[] memo, boolean flag) {
        if (n == 1) return 1;
        if (memo[n] != null) return memo[n];
        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            maxProduct = Math.max(maxProduct, i * maxProduct(n - i, memo, true));
        }
        if (flag) memo[n] = Math.max(maxProduct, n);
        else memo[n] = maxProduct;
        return memo[n];
    }


}
