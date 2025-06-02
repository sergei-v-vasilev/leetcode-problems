package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. Longest Consecutive Sequence
 * Time: O(n)
 * Space: O(n)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> numbers = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], 0);
        }
        for (int i = 0; i < nums.length; i++) { // this cycle actual has O(2n) time complexity
            max = Math.max(max, getConsecutiveLength(nums[i], numbers));
        }
        return max;
    }

    private int getConsecutiveLength(int number, Map<Integer, Integer> numbers) {
        if (numbers.containsKey(number)) {
            int value = numbers.get(number);
            if (value > 0) {
                return value;
            } else {
                value = numbers.containsKey(number + 1) ? getConsecutiveLength(number + 1, numbers) + 1 : 1;
                numbers.put(number, value);
                return value;
            }
        } else {
            return 0;
        }
    }
}
