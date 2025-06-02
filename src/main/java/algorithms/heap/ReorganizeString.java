package algorithms.heap;


import java.util.*;

/**
 * 767. Reorganize String
 * Time: O(n * log (n))
 * Space: O(n)
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> dictionary = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            dictionary.put(c, dictionary.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((l, r) -> dictionary.get(r).compareTo(dictionary.get(l)));
        queue.addAll(dictionary.keySet());
        StringBuilder builder = new StringBuilder();
        while (queue.size() > 1) {
            Character current = queue.poll();
            Character next = queue.poll();
            builder.append(current).append(next);
            dictionary.put(current, dictionary.get(current) - 1);
            dictionary.put(next, dictionary.get(next) - 1);
            if (dictionary.get(current) > 0) {
                queue.add(current);
            }
            if (dictionary.get(next) > 0) {
                queue.add(next);
            }
        }
        if (!queue.isEmpty()) {
            Character c = queue.poll();
            if (dictionary.get(c) > 1) return "";
            builder.append(c);
        }
        return builder.toString();
    }
}
