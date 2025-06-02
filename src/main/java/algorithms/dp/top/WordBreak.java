package algorithms.dp.top;

import java.util.*;

/**
 * 139. Word Break
 * Time: O(n^2)
 * Space: O(n)
 */
public class WordBreak {
    public boolean wordBreak(String word, List<String> dictionaryList) {
        return wordBreak(word, new HashSet<>(dictionaryList), new HashSet<>());
    }

    private boolean wordBreak(String word, Set<String> dictionary, Set<String> memo) {
        if ("".equals(word) || dictionary.contains(word)) {
            return true;
        }
        if (memo.contains(word)) {
            return false;
        }
        boolean result = false;
        String temp;
        for (int i = 0; i < word.length(); i++) {
            temp = word.substring(0, i); // time O(n)
            if (dictionary.contains(temp)) {
                result = wordBreak(word.substring(i), dictionary, memo);
            }
            if (result) {
                return true;
            } else {
                memo.add(word);
            }
        }
        return false;
    }
}
