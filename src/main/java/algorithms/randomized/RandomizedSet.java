package algorithms.randomized;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 */
public class RandomizedSet {

    private final Map<Integer, Integer> indices;
    private final ArrayList<Integer> numbers;
    private final Random random;
    private int counter = 0;

    public RandomizedSet() {
        indices = new HashMap<>();
        numbers = new ArrayList<>(1000);
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        indices.put(val, counter);
        numbers.add(counter, val);
        counter++;
        return true;
    }

    public boolean remove(int val) {
        if (indices.containsKey(val)) {
            int oldIndex = indices.get(val);
            indices.remove(val);
            if (oldIndex != counter - 1) {
                int valueForSwapping = numbers.get(counter - 1);
                numbers.set(oldIndex, valueForSwapping);
                numbers.set(counter - 1, val);
                indices.put(valueForSwapping, oldIndex);
            }
            counter--;
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int index = random.nextInt(counter);
        return numbers.get(index);
    }
}
