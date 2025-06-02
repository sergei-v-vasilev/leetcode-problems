package algorithms.backtracking;

import java.util.*;

/**
 * 47. Permutations II
 * 
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> keys = new HashSet<>();
        for (int num : nums) {
            keys.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        permute(keys, map, new LinkedList<>(), result);
        return result;
    }

    private void permute(Set<Integer> keys, Map<Integer, Integer> map, LinkedList<Integer> array,
                         List<List<Integer>> result) {
        if (map.isEmpty()) {
            result.add(new ArrayList<>(array));
            return;
        }
        for (int i : keys) {
            if (map.containsKey(i)) {
                array.addLast(i);
                if (map.get(i) == 1) {
                    map.remove(i);
                } else map.put(i, map.get(i) - 1);
                permute(keys, map, array, result);
                array.removeLast();
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
    }

}
