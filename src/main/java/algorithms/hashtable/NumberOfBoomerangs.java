package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * Time: O(n^2)
 * Space: O(n)
 *
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int temp;
            for (int j = 0; j < points.length; j++) {
                temp = getDistance(points[i], points[j]);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            for (Integer key : map.keySet()) {
                temp = map.get(key);
                count += temp * (temp - 1);
            }
        }

        return count;
    }

    private int getDistance(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
