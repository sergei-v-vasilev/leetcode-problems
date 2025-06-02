package algorithms.array;

/**
 * 566. Reshape the Matrix
 * Time: O(n)
 * Space: O(1)
 *
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        int row = 0;
        int column = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (row == r) {
                    return mat;
                }
                result[row][column] = mat[i][j];
                if (column < c - 1) {
                    column++;
                } else {
                    row++;
                    column = 0;
                }
            }
        }
        return column == 0 && row == r ? result : mat;
    }
}
