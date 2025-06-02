package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 32. Longest Valid Parentheses
 * Time: O(n)
 * Space: O(n)
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    count = 0;
                    prefixMap.put(count, i);
                } else if (prefixMap.containsKey(count)) {
                    max = Math.max(max, i - prefixMap.get(count));
                } else {
                    prefixMap.put(count, i);
                }
            } else {
                count++;
                prefixMap.put(count, i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
