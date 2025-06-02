package algorithms.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Time: O(n)
 * Space: O(n)
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> indices = new HashMap<>();
        indices.put(s.charAt(0), 0);
        int l = 0;
        int r = 1;
        int max = 1;
        char c;
        while (r < s.length()) {
            c = s.charAt(r);
            if (indices.containsKey(c) && l <= indices.get(c)) {
                l = indices.get(c) + 1;
                indices.remove(c);
            }
            indices.put(c, r);
            max = r > l ? Math.max(max, r - l + 1) : max;
            r++;
        }
        return max;
    }
}
