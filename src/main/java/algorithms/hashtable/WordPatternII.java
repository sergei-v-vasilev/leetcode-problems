package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 291. Word Pattern II
 */
public class WordPatternII {

    public boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() > s.length()) return false;
        return wordPatternMatch(0, pattern, 0, s, new HashMap<>(), new HashMap<>());
    }

    private boolean wordPatternMatch(int patternIndex, String pattern, int sIndex, String s, Map<Character, String> map, Map<String, Character> inverseMap) {
        if (patternIndex == pattern.length()) {
            return sIndex == s.length();
        }
        char c = pattern.charAt(patternIndex);
        if (map.containsKey(c)) {
            String mapped = map.get(c);
            if (!s.startsWith(mapped, sIndex)) {
                return false;
            }
            return wordPatternMatch(patternIndex + 1, pattern, sIndex + mapped.length(), s, map, inverseMap);
        } else {
            int patternLeft = pattern.length() - patternIndex;
            for (int i = sIndex; i < s.length() - patternLeft + 1; i++) {
                String mapped = s.substring(sIndex, i + 1);
                if (inverseMap.getOrDefault(mapped, c) != c) {
                    continue;
                }
                inverseMap.put(mapped, c);
                map.put(c, mapped);
                if (wordPatternMatch(patternIndex + 1, pattern, i + 1, s, map, inverseMap)) {
                    return true;
                }
                map.remove(c);
                inverseMap.remove(mapped);
            }
            return false;
        }
    }

}
