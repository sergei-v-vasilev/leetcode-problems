package algorithms.graph.trie;


import java.util.Arrays;

/**
 * 820. Short Encoding of Words
 *
 */
public class ShortEncodingOfWords {

    class Trie {
        Trie[] dictionary;

        Trie() {
            dictionary = new Trie[27];
        }

        boolean getOrAddWordFromEnd(String word, int index) {
            char letter = word.charAt(index);
            Trie trie;
            if (dictionary[letter - 'a'] != null) {
                trie = dictionary[letter - 'a'];
                if (index == 0) {
                    dictionary[letter - 'a'] = trie;
                    return false;
                }
            } else {
                trie = new Trie();
                if (index == 0) {
                    dictionary[letter - 'a'] = trie;
                    return true;
                }
            }
            boolean result = trie.getOrAddWordFromEnd(word, index - 1);
            dictionary[letter - 'a'] = trie;
            return result;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
        StringBuilder builder = new StringBuilder(words.length);
        Trie root = new Trie();
        boolean wasCreated;
        for (String word : words) {
            wasCreated = root.getOrAddWordFromEnd(word, word.length() - 1);
            if (wasCreated) {
                builder.append(word).append("#");
            }
        }
        return builder.length();
    }
}
