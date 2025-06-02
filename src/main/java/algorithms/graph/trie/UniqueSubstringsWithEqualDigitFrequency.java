package algorithms.graph.trie;

import java.util.*;

/**
 * 2168. Unique Substrings With Equal Digit Frequency
 */
public class UniqueSubstringsWithEqualDigitFrequency {

    private class TrieNode {
        Map<Integer, TrieNode> nextDigits;

        public TrieNode() {
            nextDigits = new HashMap<>();
        }
    }

    public int equalDigitFrequency(String s) {
        int counter = 0;
        Map<Integer, TrieNode> graph = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>(10);
        int maxFrequency = 0;
        int countWithMaxFrequency = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - '0';
            TrieNode previous = graph.getOrDefault(value, new TrieNode());
            if (!graph.containsKey(value)) {
                counter++;
            }
            graph.put(value, previous);

            frequency.clear();
            frequency.put(value, 1);
            maxFrequency = 1;
            countWithMaxFrequency = 1;

            for (int j = i + 1; j < s.length(); j++) {
                value = s.charAt(j) - '0';
                int frequencyValue = frequency.getOrDefault(value, 0) + 1;
                frequency.put(value, frequencyValue);
                if (maxFrequency < frequencyValue) {
                    maxFrequency = frequencyValue;
                    countWithMaxFrequency = 1;
                } else if (maxFrequency == frequencyValue) {
                    countWithMaxFrequency++;
                }

                if (previous.nextDigits.containsKey(value)) {
                    previous = previous.nextDigits.get(value);
                } else {
                    TrieNode next = new TrieNode();
                    previous.nextDigits.put(value, next);
                    previous = next;
                    if (countWithMaxFrequency == frequency.size()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

}
