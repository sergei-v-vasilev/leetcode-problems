package algorithms.graph.trie;

import java.util.*;

/**
 * 1268. Search Suggestions System
 * Time: O(n * k), n = number of products words, k = maximum length of products words
 * Space: O(n * k)
 * 
 */
public class SearchSuggestionsSystem {

    class Trie {
        Trie[] dictionary;
        LinkedList<String> wordBySuchLetter;

        Trie() {
            dictionary = new Trie[27];
            wordBySuchLetter = new LinkedList<>();
        }

        void addWord(String word, int index) {
            if (index == word.length()) {
                return;
            }
            char letter = word.charAt(index);
            Trie trie;
            if (dictionary[letter - 'a'] != null) {
                trie = dictionary[letter - 'a'];
            } else {
                trie = new Trie();
            }
            trie.wordBySuchLetter.add(word);

            Collections.sort(trie.wordBySuchLetter);
            if (trie.wordBySuchLetter.size() > 3) {
                trie.wordBySuchLetter.pollLast();
            }

            trie.addWord(word, index + 1);
            dictionary[letter - 'a'] = trie;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Trie root = new Trie();
        for (String word : products) {
            root.addWord(word, 0);
        }
        Trie trie = root;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> rowResult = new ArrayList<>();
            char letter = searchWord.charAt(i);
            if (trie != null) {
                trie = trie.dictionary[letter - 'a'];
                if (trie != null) {
                    rowResult.addAll(trie.wordBySuchLetter);
                }
            }

            result.add(rowResult);
        }
        return result;
    }
}
