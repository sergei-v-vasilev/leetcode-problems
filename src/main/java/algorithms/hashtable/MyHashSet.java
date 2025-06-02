package algorithms.hashtable;

/**
 * 705. Design HashSet
 * 
 */
public class MyHashSet {

    private boolean[] array;

    public MyHashSet() {
        array = new boolean[16];
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public void add(int key) {
        if (key >= array.length) {
            resize(Math.min(Integer.MAX_VALUE, 2 * key));
        }
        array[key] = true;
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public void remove(int key) {
        if (key < array.length) {
            array[key] = false;
        }
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public boolean contains(int key) {
        if (key < array.length) {
            return array[key];
        }
        return false;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private void resize(int capacity) {
        boolean[] resizedArray = new boolean[capacity];
        for (int i = 0; i < array.length; i++) {
            resizedArray[i] = array[i];
        }
        array = resizedArray;
    }
}
