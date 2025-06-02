package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary
 * 
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            dictionary.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i], dictionary)) return false;
        }
        return true;
    }

    private boolean check(String left, String right, Map<Character, Integer> dictionary) {
        int l = 0;
        int r = 0;
        while (l < left.length() && r < right.length()) {
            if (dictionary.get(left.charAt(l)) > dictionary.get(right.charAt(r))) return false;
            if (dictionary.get(left.charAt(l)) < dictionary.get(right.charAt(r))) return true;
            l++;
            r++;
        }
        if (l < left.length() && r == right.length()) return false;
        return true;
    }
}
