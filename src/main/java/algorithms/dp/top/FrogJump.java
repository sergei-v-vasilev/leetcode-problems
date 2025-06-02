package algorithms.dp.top;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 403. Frog Jump
 * Time: O(n)
 * Space: O(n * n)
 * 
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>(stones.length);
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (stones[1] != 1) {
            return false;
        }
        return canCross(1, 1, stones, map, new HashMap<>());
    }

    private boolean canCross(int i, int k, int[] stones, Map<Integer, Integer> map, Map<Integer, Set<Integer>> visited) {
        if (i == stones.length - 1) {
            return true;
        }
        Set<Integer> kth = visited.getOrDefault(stones[i], new HashSet<>());
        kth.add(k);
        visited.put(stones[i], kth);
        for (int s = -1; s < 2; s++) {
            if (map.containsKey(stones[i] + k + s) &&
                    !(visited.containsKey(stones[i] + k + s) && visited.get(stones[i] + k + s).contains(k + s))) {
                if (canCross(map.get(stones[i] + k + s), k + s, stones, map, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
