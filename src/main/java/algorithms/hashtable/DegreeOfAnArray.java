package algorithms.hashtable;

import java.util.*;

/**
 * 697. Degree of an Array
 * Time: O(n)
 * Space: O(n)
 *
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        int n;
        int value;
        for (int i = 0; i < nums.length; i++) {
            n = nums[i];
            value = degreeMap.getOrDefault(n, 0) + 1;
            degreeMap.put(n, value);
            max = Math.max(value, max);
            if (!firstIndexMap.containsKey(n)) {
                firstIndexMap.put(n, i);
            }
            lastIndexMap.put(n, i);
        }
        int minLength = nums.length;
        for (Integer number : degreeMap.keySet()) {
            if (max == degreeMap.get(number)) {
                minLength = Math.min(minLength, lastIndexMap.get(number) - firstIndexMap.get(number) + 1);
            }
        }
        return minLength;
    }
}
