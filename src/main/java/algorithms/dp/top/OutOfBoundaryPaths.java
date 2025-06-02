package algorithms.dp.top;

import java.util.Arrays;

/**
 * 576. Out of Boundary Paths
 * Time: O(n * m * k)
 * Space: O(n * m * k)
 */
public class OutOfBoundaryPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //dp[i][j][k] is the number of possible paths to the border from (i, j) position with k moves available
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] array : dp) {
            for (int[] d : array) {
                Arrays.fill(d, -1);
            }
        }
        return findPaths(m, n, maxMove, startRow, startColumn, dp);
    }

    private int findPaths(int m, int n, int k, int i, int j, int[][][] dp) {
        if (i < 0 || m <= i) {
            return 1;
        }
        if (j < 0 || n <= j) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[i][j][k] >= 0) return dp[i][j][k];
        int numberOfPaths = 0;
        numberOfPaths += (findPaths(m, n, k - 1, i - 1, j, dp) + findPaths(m, n, k - 1, i + 1, j, dp)) % 1000000007;
        numberOfPaths += (findPaths(m, n, k - 1, i, j - 1, dp) + findPaths(m, n, k - 1, i, j + 1, dp)) % 1000000007;
        dp[i][j][k] = numberOfPaths % 1000000007;
        return dp[i][j][k];
    }
}
