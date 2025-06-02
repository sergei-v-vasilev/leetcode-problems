package algorithms.sorting;

import java.util.TreeSet;

/**
 * 1099. Two Sum Less Than K
 * Time: O(n * log(n))
 * Space: O(n)
 *
 */
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> map = new TreeSet<>();
        for (int number : nums) {
            map.add(number);
        }
        int max = Integer.MIN_VALUE;
        Integer key;
        for (int number : nums) {
            map.remove(number);
            key = map.lower(k - number);
            if (key != null) {
                max = Math.max(max, key + number);
            }
            map.add(number);
        }
        return max;
    }

}
