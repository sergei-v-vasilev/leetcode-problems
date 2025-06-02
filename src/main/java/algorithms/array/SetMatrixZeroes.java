package algorithms.array;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * Time: O(n * m)
 * Space: O(1)
 * 
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        if (matrix[0][0] != 0) {
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    matrix[0][0] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
