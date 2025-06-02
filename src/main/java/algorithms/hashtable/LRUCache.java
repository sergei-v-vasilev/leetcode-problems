package algorithms.hashtable;

import java.util.LinkedHashMap;

/**
 * 146. LRU Cache
 * Space - O(n)
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    /**
     * Time - O(1)
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    /**
     * Time - O(1)
     */
    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            int eldestKey = map.keySet().iterator().next();
            map.remove(eldestKey);
        } else {
            map.remove(key);
        }
        map.put(key, value);
    }
}
