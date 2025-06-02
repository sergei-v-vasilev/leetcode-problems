package algorithms.graph.trie;

import java.util.*;

/**
 * 2261. K Divisible Elements Subarrays
 */
public class KDivisibleElementsSubarrays {

    private class TrieNode {
        private Map<Integer, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public int countDistinct(int[] nums, int k, int p) {
        Map<Integer, TrieNode> trieForest = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            TrieNode node;
            if (trieForest.containsKey(nums[i])) {
                node = trieForest.get(nums[i]);
            } else {
                node = new TrieNode();
                trieForest.put(nums[i], node);
            }
            int count = nums[i] % p == 0 ? 1 : 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count <= k) {
                    if (node.children.containsKey(nums[j])) {
                        node = node.children.get(nums[j]);
                    } else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(nums[j], newNode);
                        node = newNode;
                    }
                } else {
                    break;
                }
            }
        }
        int result = 0;
        for (TrieNode node : trieForest.values()) {
            result += countTrie(node);
        }
        return result;
    }

    private int countTrie(TrieNode root) {
        int count = 1;
        for (TrieNode node : root.children.values()) {
            count += countTrie(node);
        }
        return count;
    }

}
