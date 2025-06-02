package algorithms.binarysearch;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * 
 */
public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int firstNegativeRow = findNegativeInColumn(0, grid.length, 0, grid);
        int count = 0;
        if (firstNegativeRow >= 0) {
            count += (grid.length - firstNegativeRow) * grid[0].length;
        } else {
            firstNegativeRow = grid.length;
        }
        for (int i = 0; i < firstNegativeRow; i++) {
            int firstNegativeColumn = findNegativeInRow(0, grid[0].length, i, grid);
            if (firstNegativeColumn >= 0) {
                count += grid[0].length - firstNegativeColumn;
            }
        }
        return count;
    }

    private int findNegativeInRow(int start, int end, int row, int[][] grid) {
        if (start >= end) {
            return -1;
        }
        if (start + 1 == end) {
            if (grid[row][start] >= 0) {
                return -1;
            } else {
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        if (mid == 0 && grid[row][mid] < 0) {
            return mid;
        } else if (mid == 0) {
            return -1;
        } else if (grid[row][mid - 1] < 0) {
            return findNegativeInRow(start, mid, row, grid);
        } else if (grid[row][mid - 1] >= 0 && grid[row][mid] < 0) {
            return mid;
        } else {
            return findNegativeInRow(mid, end, row, grid);
        }
    }

    private int findNegativeInColumn(int start, int end, int column, int[][] grid) {
        if (start >= end) {
            return -1;
        }
        if (start + 1 == end) {
            if (grid[start][column] >= 0) {
                return -1;
            } else {
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        if (mid == 0 && grid[mid][column] < 0) {
            return mid;
        } else if (mid == 0) {
            return -1;
        } else if (grid[mid - 1][column] < 0) {
            return findNegativeInColumn(start, mid, column, grid);
        } else if (grid[mid - 1][column] >= 0 && grid[mid][column] < 0) {
            return mid;
        } else {
            return findNegativeInColumn(mid, end, column, grid);
        }
    }
}
