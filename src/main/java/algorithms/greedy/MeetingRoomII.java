package algorithms.greedy;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 253. Meeting Rooms II
 */
public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        //<end of the meeting, number of meetings>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int rooms = 0;
        for (int[] interval : intervals) {
            Integer availableFinishTime = map.floorKey(interval[0]);
            if (availableFinishTime != null) {
                int count = map.get(availableFinishTime) - 1;
                if (count > 0) {
                    map.put(availableFinishTime, count);
                } else {
                    map.remove(availableFinishTime);
                }
                map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
            } else {
                map.put(interval[1], map.getOrDefault(interval[1], 0) + 1);
                rooms++;
            }
        }
        return rooms;
    }

}
