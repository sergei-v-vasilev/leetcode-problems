package algorithms.heap;

import java.util.*;

/**
 * 973. K Closest Points to Origin
 * Time: O(n * log(n))
 * Space: O(n)
 *
 */
public class KClosestPointsToOrigin {

    private class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Integer getDistance() {
            return x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Comparator<Point> comparator = (o1, o2) -> {
            if (o1.getDistance() > o2.getDistance()) {
                return -1;
            } else if (o1.getDistance() < o2.getDistance()) {
                return 1;
            } else {
                return 0;
            }

        };
        PriorityQueue<Point> heap = new PriorityQueue<>(k, comparator);
        for (int[] coordinate : points) {
            heap.add(new Point(coordinate[0], coordinate[1]));
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[][] result = new int[heap.size()][2];
        Point point;
        for (int i = 0; i < k; i++) {
            point = heap.poll();
            if (point == null) {
                break;
            }
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }
}
