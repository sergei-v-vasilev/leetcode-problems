package algorithms.heap;

import java.util.*;

/**
 * 1338. Reduce Array Size to The Half
 * 
 */
public class ReduceArraySizeTheHalf {
    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        for (int n : countMap.keySet()) {
            queue.add(countMap.get(n));
        }
        int size = 0;
        int half = (arr.length + 1) / 2;
        int result = 0;
        while (size < half && !queue.isEmpty()) {
            size += queue.poll();
            result++;
        }
        return result;
    }
}
