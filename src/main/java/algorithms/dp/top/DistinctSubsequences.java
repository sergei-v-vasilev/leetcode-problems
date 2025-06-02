package algorithms.dp.top;

import java.util.HashMap;
import java.util.Map;

/**
 * 115. Distinct Subsequences
 * Time: O(n)
 * Space: O(n)
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        return numDistinct(0, 0, s.toCharArray(), t.toCharArray(), new HashMap<>());
    }

    private int numDistinct(int i, int j, char[] s, char[] t, Map<Integer, Map<Integer, Integer>> memo) {
        if (i == s.length || j == t.length || t.length - j > s.length - i) {
            return 0;
        }
        if (t.length - j == s.length - i) {
            while (j < t.length && i < s.length) {
                if (s[i] != t[j]) break;
                i++;
                j++;
            }
            return j == t.length && i == s.length ? 1 : 0;
        }
        if (memo.containsKey(i) && memo.get(i).containsKey(j)) {
            return memo.get(i).get(j);
        }
        if (j == t.length - 1) {
            int count = 0;
            for (int k = i; k < s.length; k++) {
                if (s[k] == t[j]) count++;
            }
            Map<Integer, Integer> m = memo.getOrDefault(i, new HashMap<>());
            m.put(j, count);
            memo.put(i, m);
            return count;
        } else if (s[i] == t[j]) {
            int result = numDistinct(i + 1, j, s, t, memo) + numDistinct(i + 1, j + 1, s, t, memo);
            Map<Integer, Integer> m = memo.getOrDefault(i, new HashMap<>());
            m.put(j, result);
            memo.put(i, m);
            return result;
        } else {
            while (i < s.length && s[i] != t[j]) {
                i++;
            }
            return numDistinct(i, j, s, t, memo);
        }
    }
}
