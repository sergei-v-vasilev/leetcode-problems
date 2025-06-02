package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 2349. Design a Number Container System
 */
public class NumberContainers {

    private final Map<Integer, Integer> indexMap;
    private final Map<Integer, TreeSet<Integer>> numberMap;

    public NumberContainers() {
        this.indexMap = new HashMap<>();
        this.numberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            TreeSet<Integer> indexSet = numberMap.get(oldNumber);
            indexSet.remove(index);
            if (indexSet.isEmpty()) {
                numberMap.remove(oldNumber);
            } else {
                numberMap.put(oldNumber, indexSet);
            }
        }
        indexMap.put(index, number);
        TreeSet<Integer> indexSet = numberMap.getOrDefault(number, new TreeSet<>());
        indexSet.add(index);
        numberMap.put(number, indexSet);
    }

    public int find(int number) {
        if (numberMap.containsKey(number)) {
            return numberMap.get(number).first();
        } else {
            return -1;
        }
    }
}
