package algorithms.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 658. Find K Closest Elements
 * Time: O(n * log(k))
 * Space: O(k)
 *
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((l, r) -> {
            if (Math.abs(l - x) != Math.abs(r - x)) {
                return Integer.compare(Math.abs(r - x), Math.abs(l - x));
            } else {
                return Integer.compare(r, l);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        result.sort(Integer::compareTo);
        return result;
    }
}
