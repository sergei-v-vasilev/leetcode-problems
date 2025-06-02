package algorithms.heap;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Time: O(n * log (n))
 * Space: O(n)
 *
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(words.length, (l, r) -> {
            Integer frequencyL = frequencyMap.getOrDefault(l, 0);
            Integer frequencyR = frequencyMap.getOrDefault(r, 0);
            if (!Objects.equals(frequencyL, frequencyR)) return frequencyR.compareTo(frequencyL);
            else return l.compareTo(r);
        });
        for (String word : frequencyMap.keySet()) {
            queue.add(word);
        }
        List<String> result = new LinkedList<>();
        while (result.size() < k) {
            result.add(queue.poll());
        }
        return result;

    }
}
