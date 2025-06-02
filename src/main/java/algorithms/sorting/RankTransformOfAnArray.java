package algorithms.sorting;


import java.util.*;

/**
 * 1331. Rank Transform of an Array
 * Time: O(n * log (n))
 * Space: O(n)
 *
 */
public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        int rank = 1;
        for (int n : sortedArray) {
            if (!map.containsKey(n)) {
                map.put(n, rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}
