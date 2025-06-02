package algorithms.greedy;

import java.util.TreeMap;

/**
 * 870. Advantage Shuffle
 *
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int num : nums1) {
            int count = tree.getOrDefault(num, 0) + 1;
            tree.put(num, count);
        }
        int[] result = new int[nums1.length];
        int i = 0;
        for (int num : nums2) {
            Integer key = tree.higherKey(num);
            if (key != null) {
                result[i] = key;
                int count = tree.get(key);
                if (count == 1) {
                    tree.remove(key);
                } else {
                    tree.put(key, count - 1);
                }
            } else {
                result[i] = -1;
            }
            i++;
        }

        for (int j = 0; j < result.length; j++) {
            if (result[j] == -1) {
                int key = tree.lastKey();
                result[j] = key;
                int count = tree.get(key);
                if (count == 1) {
                    tree.remove(key);
                } else {
                    tree.put(key, count - 1);
                }
            }
        }
        return result;
    }
}
