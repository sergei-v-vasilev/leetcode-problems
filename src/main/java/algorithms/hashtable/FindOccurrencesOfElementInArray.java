package algorithms.hashtable;

import java.util.*;

/**
 * 3159. (E) Find Occurrences of an Element in an Array
 */
public class FindOccurrencesOfElementInArray {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int occurrences = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                occurrences++;
                map.put(occurrences, i);
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i], -1);
        }
        return result;
    }

}
