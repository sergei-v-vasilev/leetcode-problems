package algorithms.hashtable;

import java.util.*;

/**
 * 819. Most Common Word
 * Time: O(n + m)
 * Space: O(n + m)
 *
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replace(",", " ")
                .replace("!", " ")
                .replace("?", " ")
                .replace("'", " ")
                .replace(";", " ")
                .replace(".", " ");
        String[] words = paragraph.split(" ");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!"".equals(word.trim())) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        Set<String> bannedWords = new HashSet<>();
        for (String bannedWord : banned) {
            bannedWords.add(bannedWord);
        }
        int max = Integer.MIN_VALUE;
        String resultWord = null;
        int frequency;
        for (String word : frequencyMap.keySet()) {
            frequency = frequencyMap.get(word);
            if (!bannedWords.contains(word) && frequency > max) {
                resultWord = word;
                max = frequency;
            }
        }
        return resultWord;
    }
}
