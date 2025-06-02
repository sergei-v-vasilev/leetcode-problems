package algorithms.dp.bottom;

/**
 * 221. Maximal Square
 * Time: O(n * n)
 * Space: O(n * n)
 *
 */
public class MaximalSquare {
    public int maximalSquare(char[][] charMatrix) {
        int[][] matrix = new int[charMatrix.length][charMatrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = charMatrix[i][j] == '1' ? 1 : 0;
            }
        }
        int value;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0 && j > 0 && matrix[i][j] > 0) {
                    value = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                    matrix[i][j] = Math.max(matrix[i][j], value + 1);
                }
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max * max;
    }
}
