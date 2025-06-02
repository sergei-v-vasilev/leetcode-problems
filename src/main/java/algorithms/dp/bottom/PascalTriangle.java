package algorithms.dp.bottom;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Time: O(n^2)
 * Space: O(1)
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i > 0) row.add(1);
            result.add(row);
        }
        return result;
    }
}
