package algorithms.hashtable;

import java.util.*;

/**
 * 460. LFU Cache
 */
public class LFUCache {
    private final Map<Integer, Integer> cache = new LinkedHashMap<>(); //key - <value, counter>
    private final Map<Integer, Integer> keyCounterMap = new HashMap<>();  // key - counter
    private final Map<Integer, LinkedHashSet<Integer>> counterKeyMap = new LinkedHashMap<>(); // counter - keys
    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            increaseCounter(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() == capacity) {
                if (!invalidate()) {
                    return;
                }
            }
        }
        increaseCounter(key);
        cache.put(key, value);
    }

    private void increaseCounter(int key) {
        int counter = keyCounterMap.getOrDefault(key, 0);
        int newCounter = counter + 1;
        keyCounterMap.put(key, newCounter);
        LinkedHashSet<Integer> oldKeys = counterKeyMap.getOrDefault(counter, new LinkedHashSet<>());
        oldKeys.remove(key);
        if (oldKeys.isEmpty()) {
            counterKeyMap.remove(counter);
            while (queue.size() > 0 && counter == queue.peek()) {
                queue.poll();
            }
        } else {
            counterKeyMap.put(counter, oldKeys);
        }
        LinkedHashSet<Integer> keys = counterKeyMap.getOrDefault(newCounter, new LinkedHashSet<>(capacity));
        keys.add(key);
        counterKeyMap.put(newCounter, keys);
        queue.add(newCounter);
    }

    private boolean invalidate() {
        if (counterKeyMap.isEmpty()) {
            return false;
        }
        LinkedHashSet<Integer> keys = counterKeyMap.get(queue.peek());
        int key = keys.iterator().next();
        cache.remove(key);
        keyCounterMap.remove(key);
        keys.remove(key);
        counterKeyMap.put(queue.peek(), keys);
        return true;
    }
}
