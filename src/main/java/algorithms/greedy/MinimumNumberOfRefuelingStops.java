package algorithms.greedy;

import java.util.PriorityQueue;

/**
 * 871. Minimum Number of Refueling Stops
 * Time: O(n log (n))
 * Space: O(n)
 *
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        int count = 0;
        int fuel = startFuel;
        int position = 0;
        PriorityQueue<Integer> stationQueue = new PriorityQueue<>((l, r) -> Integer.compare(r, l));
        for (int i = 0; i < stations.length; i++) {
            //try to keep rolling
            fuel = fuel - (stations[i][0] - position);
            position = stations[i][0];
            //if fuel is absent try to fill it in the biggest gasoline station
            while (fuel < 0 && !stationQueue.isEmpty()) {
                fuel += stationQueue.poll();
                count++;
            }
            if (fuel < 0) {
                return -1;
            }
            if (fuel >= target) {
                return count;
            }
            stationQueue.add(stations[i][1]);
        }
        while (fuel < target - position && !stationQueue.isEmpty()) {
            fuel += stationQueue.poll();
            count++;
        }
        if (fuel < target - position) {
            return -1;
        }
        return count;
    }
}
