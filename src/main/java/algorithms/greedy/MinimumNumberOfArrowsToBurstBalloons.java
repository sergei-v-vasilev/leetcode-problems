package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(l -> l[0]));
        int shoots = 1;
        int start = points[0][0];
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (end < point[0]) {
                shoots++;
                start = point[0];
                end = point[1];
            } else {
                start = Math.max(start, point[0]);
                end = Math.min(end, point[1]);
            }
        }
        return shoots;
    }
}
