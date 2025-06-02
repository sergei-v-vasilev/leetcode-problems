package algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3161. Block Placement Queries
 */
public class BlockPlacementQueries {

    public List<Boolean> getResults(int[][] queries) {
        //<end interval, max available interval>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) { // add obstacle
                Map.Entry<Integer, Integer> previousInterval = map.lowerEntry(query[1]);
                Integer nextIndex = map.higherKey(query[1]);
                if (previousInterval == null) {
                    map.put(query[1], query[1]);
                } else {
                    map.put(query[1], Math.max(query[1] - previousInterval.getKey(), previousInterval.getValue()));
                }
                Integer previousIndex = query[1];
                while (nextIndex != null && map.get(nextIndex) > map.get(previousIndex)) {
                    map.put(nextIndex, Math.max(nextIndex - previousIndex, map.get(previousIndex)));
                    previousIndex = nextIndex;
                    nextIndex = map.higherKey(nextIndex);
                }
            } else { // check, if it's possible
                if (map.containsKey(query[1])) {
                    list.add(map.get(query[1]) >= query[2]);
                } else {
                    Map.Entry<Integer, Integer> previousInterval = map.lowerEntry(query[1]);
                    if (previousInterval == null) {
                        list.add(query[1] >= query[2]);
                    } else {
                        int maxAvailableInterval = Math.max(previousInterval.getValue(), query[1] - previousInterval.getKey());
                        list.add(maxAvailableInterval>= query[2]);
                    }
                }
            }
        }
        return list;
    }


}
