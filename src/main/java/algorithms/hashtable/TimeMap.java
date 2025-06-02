package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 */
class TimeMap {

    private final Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> map = this.map.getOrDefault(key, new TreeMap<>());
        map.put(timestamp, value);
        this.map.put(key, map);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> map = this.map.get(key);
        NavigableMap<Integer, String> headMap = map.headMap(timestamp, true);
        if (headMap.isEmpty()) {
            return "";
        }
        return headMap.lastEntry().getValue();
    }
}