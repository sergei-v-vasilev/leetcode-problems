package algorithms.dp.bottom;


/**
 * 1277. Count Square Submatrices with All Ones
 * Time: O(n*m)
 * Space: O(n*m)
 */
public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    sum += dp[i][j];
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = 1;
                    sum += dp[i][j];
                }
            }
        }
        return sum;
    }
}
