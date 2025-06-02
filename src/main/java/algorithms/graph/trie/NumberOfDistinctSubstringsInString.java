package algorithms.graph.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 1698. Number of Distinct Substrings in a String
 */
public class NumberOfDistinctSubstringsInString {

    private class TrieNode {
        Character value;
        Map<Character, TrieNode> children;

        public TrieNode(Character value) {
            this.value = value;
            children = new HashMap<>();
        }
    }

    public int countDistinct(String s) {
        TrieNode root = new TrieNode(null);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            TrieNode node = root;
            for (int j = i; j < s.length(); j++) {
                if (!node.children.containsKey(s.charAt(j))) {
                    count++;
                    TrieNode newNode = new TrieNode(s.charAt(j));
                    node.children.put(s.charAt(j), newNode);
                }
                node = node.children.get(s.charAt(j));
            }
        }
        return count;
    }

}
