package algorithms.stack;

/**
 * 1381. (M) Design a Stack With Increment Operation
 */
public class CustomStack {

    private final int[] array;
    private int index;

    public CustomStack(int maxSize) {
        array = new int[maxSize];
        index = 0;
    }

    public void push(int x) {
        if (index < array.length) {
            array[index] = x;
            index++;
        }
    }

    public int pop() {
        if (index == 0) {
            return -1;
        }
        return array[--index];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, array.length); i++) {
            array[i] += val;
        }
    }

}
