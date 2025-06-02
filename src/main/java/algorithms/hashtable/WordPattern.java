package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Time: O(n)
 * Space: O(n)
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> bijection = new HashMap<>();
        Map<String, Character> bijectionWords = new HashMap<>();
        String[] words = s.split(" ");
        int i = 0;
        char key;
        while (i < pattern.length() && i < words.length) {
            key = pattern.charAt(i);
            if (bijection.containsKey(key) && !bijection.get(key).equals(words[i])) {
                return false;
            } else if (bijectionWords.containsKey(words[i]) && bijectionWords.get(words[i]) != key) {
                return false;
            } else if (!bijection.containsKey(key) && !bijectionWords.containsKey(words[i])) {
                bijection.put(key, words[i]);
                bijectionWords.put(words[i], key);
            }
            i++;
        }
        return i == pattern.length() && i == words.length;
    }
}
