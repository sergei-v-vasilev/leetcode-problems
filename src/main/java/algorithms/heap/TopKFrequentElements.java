package algorithms.heap;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Time: O(n * log(k))
 * Space: O(n)
 * 
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> frequentElement = new PriorityQueue<>(k, Comparator.comparing(map::get));
        for (Integer n : map.keySet()) {
            frequentElement.add(n); //log(n)
            //keep only k frequent element
            if (frequentElement.size() > k) {
                frequentElement.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = frequentElement.poll();
        }
        return result;
    }
}
