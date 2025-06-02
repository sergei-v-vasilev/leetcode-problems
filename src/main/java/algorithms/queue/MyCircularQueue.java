package algorithms.queue;

/**
 * 622. Design Circular Queue
 */
public class MyCircularQueue {

    private final int[] buffer;
    private int start = 0;
    private int end = 0;//next possible position

    public MyCircularQueue(int k) {
        buffer = new int[k];
        for (int i = 0; i < k; i++) {
            buffer[i] = -1;
        }
    }

    public boolean enQueue(int value) {
        if (buffer[end] != -1) {
            return false;
        } else {
            buffer[end] = value;
            end++;
            if (end == buffer.length) {
                end = 0;
            }
            return true;
        }
    }

    public boolean deQueue() {
        if (buffer[start] == -1) {
            return false;
        } else {
            buffer[start] = -1;
            start++;
            if (start == buffer.length) {
                start = 0;
            }
            return true;
        }
    }

    public int Front() {
        return buffer[start];
    }

    public int Rear() {
        if (end > 0) {
            return buffer[end - 1];
        } else {
            return buffer[buffer.length - 1];
        }
    }

    public boolean isEmpty() {
        return start == end && buffer[start] == -1;
    }

    public boolean isFull() {
        if (end > 0) {
            return start == end && buffer[start] != -1 && buffer[end - 1] != -1;
        } else {
            return start == end && buffer[start] != -1 && buffer[buffer.length - 1] != -1;
        }
    }
}
