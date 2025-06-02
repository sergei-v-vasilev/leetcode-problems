package algorithms.binarysearch;

/**
 * 74. Search a 2D Matrix
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target, 0, matrix.length);
        if (row != -1) {
            return findColumn(matrix[row], target, 0, matrix[row].length) != -1;
        } else {
            return false;
        }
    }

    private int findRow(int[][] nums, int target, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid][0] == target) {
            return mid;
        } else if (mid < end - 1 && nums[mid][0] < target && target < nums[mid + 1][0]) {
            return mid;
        } else if (mid == end - 1 && nums[mid][0] < target) {
            return mid;
        } else if (nums[mid][0] < target) {
            return findRow(nums, target, mid + 1, end);
        } else {
            return findRow(nums, target, start, mid);
        }
    }

    private int findColumn(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return findColumn(nums, target, mid + 1, end);
        } else {
            return findColumn(nums, target, start, mid);
        }
    }
}
