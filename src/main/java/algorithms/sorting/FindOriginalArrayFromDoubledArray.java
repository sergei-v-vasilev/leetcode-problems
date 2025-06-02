package algorithms.sorting;

import java.util.*;

/**
 * 2007. Find Original Array From Doubled Array
 *
 */
public class FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        Map<Integer, Integer> values = new HashMap<>();
        for (int value : changed) {
            int count = values.getOrDefault(value, 0) + 1;
            values.put(value, count);
        }
        Arrays.sort(changed);
        int[] doubledValues = new int[changed.length / 2];
        int step = 0;
        for (int value : changed) {
            if (value != 0 && values.containsKey(value) && values.containsKey(2 * value)) {
                doubledValues[step] = value;
                step++;
                handle(value, values);
                handle(2 * value, values);
            } else if (value == 0 && values.getOrDefault(value, 0) >= 2) {
                doubledValues[step] = value;
                step++;
                handle(value, values);
                handle(0, values);
            }
        }
        if (step < changed.length / 2) {
            return new int[0];
        } else {
            return doubledValues;
        }
    }

    private void handle(int value, Map<Integer, Integer> values) {
        int count = values.getOrDefault(value, 0) - 1;
        if (count > 0) {
            values.put(value, count);
        } else {
            values.remove(value);
        }
    }
}
