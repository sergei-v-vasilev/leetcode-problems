package algorithms.dp.top;

/**
 * 329. Longest Increasing Path in a Matrix
 */
public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
            }
        }
        return maxLength;
    }

    //the length of the longest path start from (row,col)
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int maxLength = 1;
        if (row < matrix.length - 1 && matrix[row][col] < matrix[row + 1][col]) {
            maxLength = Math.max(maxLength, 1 + dfs(matrix, row + 1, col, memo));
        }
        if (row > 0 && matrix[row][col] < matrix[row - 1][col]) {
            maxLength = Math.max(maxLength, 1 + dfs(matrix, row - 1, col, memo));
        }
        if (col < matrix[0].length - 1 && matrix[row][col] < matrix[row][col + 1]) {
            maxLength = Math.max(maxLength, 1 + dfs(matrix, row, col + 1, memo));
        }
        if (col > 0 && matrix[row][col] < matrix[row][col - 1]) {
            maxLength = Math.max(maxLength, 1 + dfs(matrix, row, col - 1, memo));
        }
        memo[row][col] = maxLength;
        return memo[row][col];
    }

}
