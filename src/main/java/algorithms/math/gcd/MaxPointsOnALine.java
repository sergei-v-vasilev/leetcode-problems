package algorithms.math.gcd;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * Time: O(n^2)
 * Space: O(n)
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int max = 1;
        int pointX, pointY, x, y, gcd, size;
        Map<Integer, Map<Integer, Integer>> xMap;
        for (int i = 0; i < points.length; i++) {
            pointX = points[i][0];
            pointY = points[i][1];
            xMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                x = points[j][0] - pointX;
                y = points[j][1] - pointY;
                gcd = findGCD(x, y);
                x /= gcd;
                y /= gcd;
                if (x < 0) {
                    x *= -1;
                    y *= -1;
                }
                if (xMap.containsKey(x) && xMap.get(x).containsKey(y)) {
                    size = xMap.get(x).get(y) + 1;
                    xMap.get(x).put(y, size);
                } else if (xMap.containsKey(x)) {
                    size = 2;
                    xMap.get(x).put(y, size);
                } else {
                    size = 2;
                    Map<Integer, Integer> yMap = new HashMap<>();
                    yMap.put(y, size);
                    xMap.put(x, yMap);
                }
                max = Math.max(max, size);
            }
        }
        return max;
    }

    private int findGCD(int x, int y) {
        return y == 0 ? x : findGCD(y, x % y);
    }

}
