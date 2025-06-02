package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Time: O(n*m)
 * Space: O(1)
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int size = n * m;
        List<Integer> result = new ArrayList<>(size);
        int i = 0;
        int j = 0;
        while (result.size() < size) {
            while (0 <= j && j < m && matrix[i][j] != -101) {
                result.add(matrix[i][j]);
                matrix[i][j] = -101;
                j++;
            }
            j--;
            i++;
            while (0 <= i && i < n && matrix[i][j] != -101) {
                result.add(matrix[i][j]);
                matrix[i][j] = -101;
                i++;
            }
            i--;
            j--;
            while (m > j && j >= 0 && matrix[i][j] != -101) {
                result.add(matrix[i][j]);
                matrix[i][j] = -101;
                j--;
            }
            j++;
            i--;
            while (n > i && i >= 0 && matrix[i][j] != -101) {
                result.add(matrix[i][j]);
                matrix[i][j] = -101;
                i--;
            }
            i++;
            j++;
        }
        return result;
    }
}
