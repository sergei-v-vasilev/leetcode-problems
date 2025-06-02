package algorithms.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */
public class MedianFinder {

    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        //from the beginning till median
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        //from median till the end
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num <= minHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            if (minHeap.size() < maxHeap.size()) return maxHeap.peek();
            else return minHeap.peek();
        }
    }

    private void balance() {
        if (minHeap.size() < maxHeap.size()) {
            balance(minHeap, maxHeap);
        } else if (minHeap.size() > maxHeap.size()) {
            balance(maxHeap, minHeap);
        }
    }

    private void balance(PriorityQueue<Integer> smaller, PriorityQueue<Integer> bigger) {
        if ((smaller.size() + bigger.size()) % 2 == 0) {
            while (smaller.size() != bigger.size()) {
                smaller.add(bigger.poll());
            }
        } else {
            while (smaller.size() + 1 != bigger.size()) {
                smaller.add(bigger.poll());
            }
        }
    }
}
