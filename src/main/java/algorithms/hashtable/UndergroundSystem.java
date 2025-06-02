package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. Design Underground System
 */
public class UndergroundSystem {

    //<startStation, <endStation, {all_time, counts}>>
    private Map<String, Map<String, int[]>> timingMap;
    //<id, time>
    private Map<Integer, Integer> currentTripMap;
    //<id, startStation>
    private Map<Integer, String> startStationMap;

    public UndergroundSystem() {
        this.timingMap = new HashMap<>();
        this.currentTripMap = new HashMap<>();
        this.startStationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        currentTripMap.put(id, t);
        startStationMap.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = startStationMap.remove(id);
        int startTime = currentTripMap.remove(id);
        Map<String, int[]> map = timingMap.getOrDefault(startStation, new HashMap<>());
        int[] timings = map.getOrDefault(stationName, new int[]{0, 0});
        timings[0] += t - startTime;
        timings[1]++;
        map.put(stationName, timings);
        timingMap.put(startStation, map);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<String, int[]> map = timingMap.getOrDefault(startStation, new HashMap<>());
        int[] timings = map.getOrDefault(endStation, new int[]{0, 0});
        if (timings[1] == 0) return 0;
        return ((double) timings[0]) / timings[1];
    }
}
