package algorithms.hashtable;

import java.util.*;

/**
 * 49. Group Anagrams
 * Time: O(n * m log(m))
 * Space: O(n)
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String sortedWord;
        char[] wordArray;
        for (String word : strs) {
            wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            sortedWord = new String(wordArray);
            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord, list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
