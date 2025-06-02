package algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * Time: O(n)
 * Space: O(n)
 *
 */
public class UniqueMorseCodeWords {

    private String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-" +
            ".-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        for (String word : words) {
            transformations.add(transformTheWord(word));
        }
        return transformations.size();
    }

    private String transformTheWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(morse[word.charAt(i) - 'a']);
        }
        return builder.toString();
    }
}
