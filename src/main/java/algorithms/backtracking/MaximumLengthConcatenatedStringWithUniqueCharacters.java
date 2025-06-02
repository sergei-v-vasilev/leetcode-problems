package algorithms.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 *
 */
public class MaximumLengthConcatenatedStringWithUniqueCharacters {

    public static int maxLength(List<String> arr) {
        return maxLength(0, "", arr, new HashMap<>());
    }

    private static int maxLength(int i, String s, List<String> arr, Map<String, Integer> memo) {
        int max = s.length();
        if (i == arr.size()) {
            return max;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        String r = arr.get(i);
        if (isConcatenationUnique(s, r)) {
            max = Math.max(max, maxLength(i + 1, s + r, arr, memo));
        }
        max = Math.max(max, maxLength(i + 1, s, arr, memo));
        memo.put(s, max);
        return max;
    }

    private static boolean isConcatenationUnique(String s, String r) {
        boolean[] array = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a']) {
                return false;
            }
            array[s.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < r.length(); i++) {
            if (array[r.charAt(i) - 'a']) {
                return false;
            }
            array[r.charAt(i) - 'a'] = true;
        }
        return true;
    }

}
