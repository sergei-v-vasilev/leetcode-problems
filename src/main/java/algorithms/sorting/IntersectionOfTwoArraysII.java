package algorithms.sorting;


import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 */
public class IntersectionOfTwoArraysII {

    /**
     * * Time: O(n*log(n))
     * * Space: O(1)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                resultList.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for (int k : resultList) {
            result[i] = k;
            i++;
        }
        return result;
    }

    /**
     * * Time: O(n+m)
     * * Space: O(n+m)
     */
    public int[] intersectMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int k : nums2) {
            if (map.containsKey(k) && map.get(k) > 0) {
                list.add(k);
                map.put(k, map.get(k) - 1);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int k : list) {
            result[i] = k;
            i++;
        }
        return result;
    }
}
