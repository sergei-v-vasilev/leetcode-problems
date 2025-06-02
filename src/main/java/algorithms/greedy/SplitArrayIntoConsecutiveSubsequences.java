package algorithms.greedy;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 659. Split Array into Consecutive Subsequences
 *
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        //<last value, sizes queue>
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> queue;
            if (map.containsKey(num - 1)) {
                queue = map.get(num - 1);
                int currentSize = queue.poll();
                if (queue.isEmpty()) {
                    map.remove(num - 1);
                }
                PriorityQueue<Integer> newQueue = map.getOrDefault(num, new PriorityQueue<>());
                newQueue.add(currentSize + 1);
                map.put(num, newQueue);
            } else {
                queue = map.getOrDefault(num, new PriorityQueue<>());
                queue.add(1);
                map.put(num, queue);
            }
        }
        for (int key : map.keySet()) {
            for (int size : map.get(key)) {
                if (size < 3) return false;
            }
        }
        return true;
    }
}
