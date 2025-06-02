package algorithms.hashtable;


import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Time: O(n+m)
 * Space: O(n+m)
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int k : nums2) {
            if (set.contains(k)) {
                resultSet.add(k);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int k : resultSet) {
            result[i] = k;
            i++;
        }
        return result;
    }
}
