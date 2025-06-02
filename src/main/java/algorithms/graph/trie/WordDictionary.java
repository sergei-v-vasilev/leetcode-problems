package algorithms.graph.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 211. Design Add and Search Words Data Structure
 *
 */
public class WordDictionary {

    private class TrieNode {
        char letter;
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }

        TrieNode(char letter) {
            this.letter = letter;
            children = new HashMap<>();
            this.isWord = false;
        }
    }

    private final TrieNode root;
    private final Set<String> dictionary;

    public WordDictionary() {
        root = new TrieNode();
        dictionary = new HashSet<>();
    }

    public void addWord(String word) {
        addWord(0, root, word);
        dictionary.add(word);
    }

    private void addWord(int i, TrieNode root, String word) {
        char letter = word.charAt(i);
        TrieNode node = root.children.getOrDefault(letter, new TrieNode(letter));
        node.isWord = node.isWord || i == word.length() - 1;
        root.children.put(letter, node);
        if (i < word.length() - 1) {
            addWord(i + 1, node, word);
        }
    }

    public boolean search(String word) {
        boolean hasDot = false;
        for (char c : word.toCharArray()) {
            if (c == '.') {
                hasDot = true;
                break;
            }
        }
        if (hasDot) return search(0, root, word);
        else return dictionary.contains(word);
    }

    private boolean search(int i, TrieNode root, String word) {
        char letter = word.charAt(i);
        if (letter == '.') {
            if (i == word.length() - 1) {
                return root.children.values().stream().anyMatch(c -> c.isWord);
            }
            for (TrieNode child : root.children.values()) {
                if (search(i + 1, child, word)) {
                    return true;
                }
            }
            return false;
        } else {
            if (i == word.length() - 1) {
                return root.children.containsKey(letter) && root.children.get(letter).isWord;
            }
            if (root.children.containsKey(letter)) {
                return search(i + 1, root.children.get(letter), word);
            } else {
                return false;
            }
        }
    }
}
