package algorithms.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 * Time: O(n)
 * Space: O(n)
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberOfOccurrences = new HashMap<>();
        Integer count;
        for (int i : arr) {
            count = numberOfOccurrences.get(i);
            numberOfOccurrences.put(i, count != null ? count + 1 : 1);
        }
        Set<Integer> occurrences = new HashSet<>();
        for (int occurrence : numberOfOccurrences.values()) {
            if (occurrences.contains(occurrence)) {
                return false;
            } else {
                occurrences.add(occurrence);
            }
        }
        return true;
    }
}
