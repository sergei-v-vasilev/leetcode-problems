package algorithms.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2021. Brightest Position on Street
 */
public class BrightestPositionOnStreet {
    public int brightestPosition(int[][] lights) {
        PriorityQueue<Integer> lastRanges = new PriorityQueue<>();
        Arrays.sort(lights, (a, b) -> {
            if (a[0] - a[1] == b[0] - b[1]) {
                return a[0] + a[1] - (b[0] + b[1]);
            } else {
                return a[0] - a[1] - (b[0] - b[1]);
            }
        });
        int brightestPoint = 0;
        int brightestLight = 0;
        for (int[] light : lights) {
            int start = light[0] - light[1];
            int end = light[0] + light[1];
            while (!lastRanges.isEmpty() && lastRanges.peek() < start) {
                lastRanges.poll();
            }
            if (brightestLight < lastRanges.size() + 1) {
                brightestLight = lastRanges.size() + 1;
                brightestPoint = start;
            }
            lastRanges.add(end);
        }
        return brightestPoint;
    }
}
