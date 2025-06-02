package algorithms.dp.bottom;

import java.util.List;

/**
 * 120. Triangle
 * Time: O(n^2)
 * Space: O(n)
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[] previousRow = new Integer[triangle.size()];
        Integer[] currentRow = new Integer[triangle.size()];
        currentRow[0] = triangle.get(0).get(0);
        previousRow[0] = triangle.get(0).get(0);
        if (triangle.size() == 1) return previousRow[0];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < triangle.size(); j++) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < triangle.get(j).size(); i++) {
                if (i == 0) {
                    currentRow[i] = triangle.get(j).get(i) + previousRow[i];
                } else if (previousRow[i] != null) {
                    currentRow[i] = Math.min(previousRow[i], previousRow[i - 1]) + triangle.get(j).get(i);
                } else {
                    currentRow[i] = previousRow[i - 1] + triangle.get(j).get(i);
                }
                min = Math.min(min, currentRow[i]);
            }
            for (int i = 0; i < triangle.get(j).size(); i++) {
                previousRow[i] = currentRow[i];
            }

        }
        return min;

    }
}
