package algorithms.heap;

import java.util.PriorityQueue;

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 */
public class MinimumOperationsExceedThresholdValueII {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }
        int operations = 0;
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            minHeap.offer(Math.max(first, second) + 2 * Math.min(first, second));
            operations++;
        }
        return operations;
    }

}
