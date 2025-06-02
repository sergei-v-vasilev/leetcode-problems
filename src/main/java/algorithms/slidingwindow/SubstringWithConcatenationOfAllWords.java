package algorithms.slidingwindow;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * Time: O(a + n * b), a - number of words, b - word length
 * Space: O(n + a)
 *
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int count;
        Map<String, Integer> dictionary = new HashMap<>();
        for (String word : words) {
            dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
        }
        LinkedList<Integer> indicesOfWords = new LinkedList<>();
        String currentWord;
        for (int i = 0; i <= s.length() - wordLength; i++) {
            currentWord = s.substring(i, i + wordLength);
            if (dictionary.containsKey(currentWord)) {
                indicesOfWords.add(i);
            }
        }
        int start;
        int end;
        while (!indicesOfWords.isEmpty()) {
            count = 0;
            start = indicesOfWords.pollFirst();
            end = start + wordLength * words.length;
            Map<String, Integer> window = new HashMap<>();
            int i = start + wordLength;
            while (i <= end && end <= s.length()) {
                currentWord = s.substring(i - wordLength, i);
                if (dictionary.containsKey(currentWord)) {
                    window.put(currentWord, window.getOrDefault(currentWord, 0) + 1);
                    if (Objects.equals(window.get(currentWord), dictionary.get(currentWord))) {
                        count++;
                    }
                    i += wordLength;
                } else {
                    i++;
                }
            }
            if (count == dictionary.size()) {
                result.add(start);
            }
        }

        return result;
    }
}
