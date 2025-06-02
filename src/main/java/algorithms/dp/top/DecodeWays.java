package algorithms.dp.top;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. Decode Ways
 * Time: O(n)
 * Space: O(n)
 * <p>
 * Top down dynamic programming
 */
public class DecodeWays {

    public int numDecodings(String s) {
        return calculateDecodings(0, s, new HashMap<>());
    }

    private int calculateDecodings(int i, String s, Map<Integer, Integer> memo) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int result = 0;
        if (i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2') && s.charAt(i + 1) == '0') {
            result = calculateDecodings(i + 2, s, memo);
        } else if (i < s.length() - 1 && s.charAt(i + 1) != '0' && checkIsInBound(s.charAt(i), s.charAt(i + 1))) {
            result = calculateDecodings(i + 1, s, memo) + calculateDecodings(i + 2, s, memo);
        } else result = calculateDecodings(i + 1, s, memo);
        memo.put(i, result);
        return result;
    }

    private boolean checkIsInBound(char f, char s) {
        int k = Integer.parseInt(new String(new char[]{f, s}));
        return 0 < k && k < 27;
    }
}
