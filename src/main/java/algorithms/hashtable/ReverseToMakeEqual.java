package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. Make Two Arrays Equal by Reversing Sub-arrays
 * Time: O(n)
 * Space: O(n)
 *
 * <p>
 * https://leetcode.com/discuss/interview-question/586284/facebook-interview-question-reverse-to-make-equal
 */
public class ReverseToMakeEqual {

    boolean areTheyEqual(int[] left, int[] right) {
        Map<Integer, Integer> map = new HashMap<>(left.length);
        for (int num : left) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : right) {
            if (!map.containsKey(num)) {
                return false;
            }
            int frequency = map.get(num);
            if (frequency == 1) {
                map.remove(num);
            } else {
                map.put(num, frequency - 1);
            }
        }
        return map.isEmpty();
    }
}
