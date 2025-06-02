package algorithms.graph.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 *
 */
public class Trie {

    private final Map<Character, Trie> children;
    private boolean isWord = false;

    /**
     * Initialize your data structure here.
     * Time: O(1)
     * Space: O(n)
     */
    public Trie() {
        children = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     * Time: O(n)
     * Space: O(n)
     */
    public void insert(String word) {
        char letter = word.charAt(0);
        Trie child = children.getOrDefault(letter, new Trie());
        child.isWord = child.isWord || word.length() == 1;
        if (word.length() > 1) {
            child.insert(word.substring(1));
        }
        children.put(letter, child);
    }

    /**
     * Returns if the word is in the trie.
     * Time: O(n)
     * Space: O(n)
     */
    public boolean search(String word) {
        char letter = word.charAt(0);
        if (children.containsKey(letter)) {
            Trie child = children.get(letter);
            if (word.length() == 1) {
                return child.isWord;
            } else {
                return child.search(word.substring(1));
            }
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * Time: O(n)
     * Space: O(n)
     */
    public boolean startsWith(String prefix) {
        char letter = prefix.charAt(0);
        if (children.containsKey(letter)) {
            Trie child = children.get(letter);
            if (prefix.length() == 1) {
                return true;
            } else {
                return child.startsWith(prefix.substring(1));
            }
        } else {
            return false;
        }
    }
}
