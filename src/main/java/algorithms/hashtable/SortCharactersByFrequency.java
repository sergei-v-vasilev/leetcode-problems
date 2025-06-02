package algorithms.hashtable;

import java.util.*;

/**
 * 451. Sort Characters By Frequency
 * Time: O(n * log(n))
 * Space: O(n)
 *
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> dictionary = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            dictionary.put(s.charAt(i), dictionary.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> chars = new ArrayList<>(dictionary.keySet());
        chars.sort(Comparator.comparing(dictionary::get));
        StringBuilder builder = new StringBuilder();
        int i;
        for (Character c : chars) {
            i = dictionary.get(c);
            while (i > 0) {
                builder.insert(0, c);
                i--;
            }
        }
        return builder.toString();
    }
}
