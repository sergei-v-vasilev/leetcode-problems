package algorithms.dp.bottom;

import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Time: O(n^2)
 * Space: O(n)
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        Integer[] previousRow = new Integer[rowIndex + 1];
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        previousRow[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (previousRow[j] == null) {
                    result[j] = 1;
                } else {
                    result[j] = previousRow[j] + previousRow[j - 1];
                }
            }
            previousRow = result.clone();
        }
        return Arrays.asList(result);
    }
}
