package algorithms.array;

/**
 * 498. Diagonal Traverse
 * Time: O(n*m)
 * Space: O(1)
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];
        boolean isUp = true;
        int i = 0;
        int j = 0;
        int pointer = 0;
        while (pointer < n * m) {
            result[pointer] = mat[i][j];
            pointer++;
            if (isUp) {
                if (i > 0 && j < m - 1) {
                    i--;
                    j++;
                } else {
                    if (j < m - 1) {
                        j++;
                    } else if (i < n - 1) {
                        i++;
                    }
                    isUp = false;
                }
            } else {
                if (i < n - 1 && j > 0) {
                    i++;
                    j--;
                } else {
                    if (i < n - 1) {
                        i++;
                    } else if (j < m - 1) {
                        j++;
                    }
                    isUp = true;
                }
            }
        }
        return result;
    }
}
