package algorithms.binarysearch;

/**
 * 240. Search a 2D Matrix II
 * Time: O(n * log(n))
 * Space: O(1)
 *
 */
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int columnIndex;
        for (int i = 0; i < matrix.length; i++) {
            columnIndex = binarySearch(0, matrix[i].length, matrix, target, null, i);
            if (matrix[0][columnIndex] == target) {
                return true;
            }
            int rowIndex = binarySearch(0, matrix.length, matrix, target, columnIndex, null);
            if (matrix[rowIndex][columnIndex] == target) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int start, int end, int[][] matrix, int target, Integer column, Integer row) {
        if (start + 1 == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (column != null) {
            if (matrix[mid][column] == target) {
                return mid;
            } else if (matrix[mid][column] > target) {
                return binarySearch(start, mid, matrix, target, column, null);
            } else {
                return binarySearch(mid, end, matrix, target, column, null);
            }
        } else {
            if (matrix[row][mid] == target) {
                return mid;
            } else if (matrix[row][mid] > target) {
                return binarySearch(start, mid, matrix, target, null, row);
            } else {
                return binarySearch(mid, end, matrix, target, null, row);
            }
        }
    }
}
