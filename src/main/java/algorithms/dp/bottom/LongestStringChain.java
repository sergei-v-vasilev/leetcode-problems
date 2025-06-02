package algorithms.dp.bottom;


import java.util.HashMap;
import java.util.Map;

/**
 * 1048. Longest String Chain
 * Time: O(n * k), n - number of lengths of words, k - max number of words of the certain length
 * Space: O(n)
 *
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Map<String, Integer>[] set = new HashMap[17];
        for (String word : words) {
            if (set[word.length()] == null) set[word.length()] = new HashMap<>();
            set[word.length()].put(word, 1);
        }
        int max = 1;
        for (int i = 15; i > 0; i--) {
            if (set[i] == null || set[i + 1] == null || set[i + 1].isEmpty()) continue;
            for (String word : set[i].keySet()) {
                for (String nextWord : set[i + 1].keySet()) {
                    if (isChain(word, nextWord)) {
                        int value = set[i + 1].get(nextWord) + 1;
                        if (set[i].get(word) < value) {
                            set[i].put(word, value);
                            max = Math.max(value, max);
                        }
                    }
                }
            }
        }
        return max;
    }

    private boolean isChain(String left, String right) {
        if (left.length() != right.length() - 1) return false;
        int l = 0;
        int r = 0;
        boolean found = false;
        while (l < left.length() && r < right.length()) {
            if (left.charAt(l) == right.charAt(r)) {
                l++;
                r++;
            } else if (found) return false;
            else {
                found = true;
                r++;
            }
        }
        return true;
    }


}
