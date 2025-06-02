package algorithms.heap;

import java.util.*;

/**
 * 1094. Car Pooling
 *
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(l -> l[1]));
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l[2]));
        int tripPosition = 0;
        while (tripPosition < trips.length) {
            int[] trip = trips[tripPosition];
            while (!queue.isEmpty() && queue.peek()[2] <= trip[1]) {
                capacity += queue.poll()[0];
            }
            if (trip[0] > capacity) {
                return false;
            }
            capacity -= trip[0];
            queue.add(new Integer[]{trip[0], trip[1], trip[2]});
            tripPosition++;
        }
        return true;
    }
}
