package algorithms.heap;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Time: O(n * log(K))
 * Space: O(K)
 *
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
        return queue.poll();
    }
}
