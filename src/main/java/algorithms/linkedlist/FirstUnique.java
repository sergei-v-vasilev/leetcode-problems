package algorithms.linkedlist;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1429. First Unique Number
 */
public class FirstUnique {

    private LinkedHashSet<Integer> uniqueNumbers;
    private Set<Integer> numbers;

    public FirstUnique(int[] nums) {
        this.uniqueNumbers = new LinkedHashSet<>();
        this.numbers = new HashSet<>();
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (uniqueNumbers.isEmpty()) {
            return -1;
        }
        return this.uniqueNumbers.iterator().next();
    }

    public void add(int value) {
        //we don't need to do anything if it's not unique
        if (numbers.contains(value)) {
            return;
        }
        if (uniqueNumbers.contains(value)) {
            uniqueNumbers.remove(value);
            numbers.add(value);
        } else {
            uniqueNumbers.add(value);
        }
    }
}
