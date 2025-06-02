package algorithms.dp.top;

import java.util.*;

/**
 * 140. Word Break II
 * Time: O(n*k)
 * Space: O(1)
 *
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(0, s, new HashSet<>(wordDict), new LinkedList<>());
    }

    private List<String> wordBreak(int start, String s, Set<String> dictionary, List<String> result) {
        if (start >= s.length() - 1) {
            result.add(s.trim());
            return result;
        }
        String previous = s.substring(0, start);
        String temp;
        for (int i = start; i < s.length(); i++) {
            temp = s.substring(start, i + 1);
            if (dictionary.contains(temp)) {
                temp = previous + temp + " " + s.substring(i);
                result = wordBreak(i + 2, temp, dictionary, result);
            }
        }
        return result;
    }


}
