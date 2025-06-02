package algorithms.hashtable;

/**
 * 706. Design HashMap
 */
public class MyHashMap {

    private int[] array;
    private int capacity = 16;

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public MyHashMap() {
        array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = -1;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public void put(int key, int value) {
        if (key >= capacity) {
            resize(Math.min(Integer.MAX_VALUE, 2 * key));
        }
        array[key] = value;
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public int get(int key) {
        if (key < capacity) {
            return array[key];
        } else {
            return -1;
        }
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public void remove(int key) {
        if (key < capacity) {
            array[key] = -1;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private void resize(int capacity) {
        int[] resizedArray = new int[capacity];
        for (int i = 0; i < resizedArray.length; i++) {
            if (i < array.length) {
                resizedArray[i] = array[i];
            } else {
                resizedArray[i] = -1;
            }
        }
        array = resizedArray;
    }
}
