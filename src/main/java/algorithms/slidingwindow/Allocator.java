package algorithms.slidingwindow;


/**
 * 2502. Design Memory Allocator
 */
public class Allocator {

    private final int[] memory;

    public Allocator(int n) {
        this.memory = new int[n];
    }

    public int allocate(int size, int mID) {
        int start = 0;
        int end = 0;
        int empty = 0;
        while (end < Math.min(memory.length, size)) {
            if (memory[end] == 0) {
                empty++;
            }
            end++;
        }
        while (end < memory.length && empty < size) {
            if (memory[start] == 0) {
                empty--;
            }
            start++;
            if (memory[end] == 0) {
                empty++;
            }
            end++;
        }
        if (empty == size) {
            int result = start;
            while (start < end) {
                memory[start] = mID;
                start++;
            }
            return result;
        } else {
            return -1;
        }
    }

    public int freeMemory(int mID) {
        int result = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == mID) {
                memory[i] = 0;
                result++;
            }
        }
        return result;
    }
}
