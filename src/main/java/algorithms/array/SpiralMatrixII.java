package algorithms.array;

/**
 * 59. Spiral Matrix II
 * Time: O(n^2)
 * Space: O(1)
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        int value = 1;
        while (value <= n * n) {
            while (0 <= j && j < n && matrix[i][j] == 0) {
                matrix[i][j] = value;
                value++;
                j++;
            }
            j--;
            i++;
            while (0 <= i && i < n && matrix[i][j] == 0) {
                matrix[i][j] = value;
                value++;
                i++;
            }
            i--;
            j--;
            while (n > j && j >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = value;
                value++;
                j--;
            }
            j++;
            i--;
            while (n > i && i >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = value;
                value++;
                i--;
            }
            i++;
            j++;
        }
        return matrix;
    }
}
