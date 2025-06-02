package algorithms.binarysearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1428. Leftmost Column with at Least a One
 */
public class LeftmostColumnwithAtLeastOne {

    interface BinaryMatrix {
        int get(int row, int col);

        List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0);
        int m = dimensions.get(1);
        int leftMostColumn = m;
        for (int i = 0; i < n; i++) {
            if (leftMostColumn > 0 && binaryMatrix.get(i, leftMostColumn - 1) == 1) {
                int firstOne = binarySearch(i, binaryMatrix, leftMostColumn);
                leftMostColumn = Math.min(leftMostColumn, firstOne);
                if (leftMostColumn == 0) {
                    return 0;
                }
            }
        }
        if (leftMostColumn == m) {
            return -1;
        }
        return leftMostColumn;
    }

    private int binarySearch(int row, BinaryMatrix binaryMatrix, int m) {
        int start = 0; //inclusive
        int end = m; //exclusive
        //<index, value> in the row
        Map<Integer, Integer> map = new HashMap<>();
        while (start < end) {
            int mid = start + (end - start) / 2;
            int value = binaryMatrix.get(row, mid);
            if (mid == 0 && value == 1) {
                return 0;
            }
            if (mid == m - 1 && value == 0) {
                return -1;
            }
            if (map.containsKey(mid - 1) && map.get(mid - 1) + 1 == value) {
                return mid;
            }
            if (map.containsKey(mid + 1) && value + 1 == map.get(mid + 1)) {
                return mid + 1;
            }
            map.put(mid, value);
            if (value == 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
