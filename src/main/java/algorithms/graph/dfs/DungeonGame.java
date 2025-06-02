package algorithms.graph.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 174. Dungeon Game
 *
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        Map<Integer, Map<Integer, Integer>> minDamageMap = new HashMap<>();
        int damage = calculateMinimumHP(0, 0, dungeon, minDamageMap);
        if (damage < 0) {
            return -damage + 1;
        } else {
            return 1;
        }
    }

    private int calculateMinimumHP(int i, int j, int[][] dungeon, Map<Integer, Map<Integer, Integer>> minDamageMap) {
        if (minDamageMap.containsKey(i) && minDamageMap.get(i).containsKey(j)) {
            return minDamageMap.get(i).get(j);
        }
        int result = dungeon[i][j];
        if (i < dungeon.length - 1 && j < dungeon[i].length - 1) {
            int rightward = calculateMinimumHP(i, j + 1, dungeon, minDamageMap);
            int downward = calculateMinimumHP(i + 1, j, dungeon, minDamageMap);
            result = Math.min(result, result + Math.max(rightward, downward));
        } else if (i < dungeon.length - 1) {
            int downward = calculateMinimumHP(i + 1, j, dungeon, minDamageMap);
            result = Math.min(result, result + downward);
        } else if (j < dungeon[i].length - 1) {
            int rightward = calculateMinimumHP(i, j + 1, dungeon, minDamageMap);
            result = Math.min(result, result + rightward);
        } else {
            return result;
        }
        Map<Integer, Integer> row = minDamageMap.getOrDefault(i, new HashMap<>(dungeon[i].length));
        row.put(j, result);
        minDamageMap.put(i, row);
        return result;
    }
}
