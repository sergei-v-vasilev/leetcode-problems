package algorithms.array;

/**
 * 48. Rotate Image
 * Time: O(n*m)
 * Space: O(1)
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int i = 0;
        while (i < matrix.length / 2) {
            rotateEdge(i, matrix);
            i++;
        }
    }

    private void rotateEdge(int i, int[][] matrix) {
        int j = i;
        int n = matrix.length;
        int temp;
        while (j < n - 1 - i) {
            temp = matrix[i][j];
            matrix[i][j] = matrix[n - 1 - j][i];
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
            matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
            matrix[j][n - 1 - i] = temp;
            j++;
        }
    }
}
