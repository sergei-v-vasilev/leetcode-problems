package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 3160. Find the Number of Distinct Colors Among the Balls
 */
public class FindNumberOfDistinctColorsAmongTheBalls {

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> balls = new HashMap<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer color = balls.get(queries[i][0]);
            if (color != null && color == queries[i][1]) {
                result[i] = colorMap.size();
                continue;
            } else if (color != null && color != queries[i][1]) {
                int count = colorMap.get(color);
                if (count == 1) {
                    colorMap.remove(color);
                } else {
                    colorMap.put(color, count - 1);
                }
            }
            balls.put(queries[i][0], queries[i][1]);
            colorMap.put(queries[i][1], colorMap.getOrDefault(queries[i][1], 0) + 1);
            result[i] = colorMap.size();
        }
        return result;
    }

}
