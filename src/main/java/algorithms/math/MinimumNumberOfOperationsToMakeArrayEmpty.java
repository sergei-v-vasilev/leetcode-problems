package algorithms.math;

import java.util.*;

/**
 * 2870. (M) Minimum Number of Operations to Make Array Empty
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {

    //[2,3,3,2,2,4,2,3,4]

    // val % 3 = 0
    // val % 3 = 1
    // val % 3 = 2

    // 3a + 1 = c => 3 (a-1) + 2*2
    // 3a + 2 = c => 3a + 2
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val == 1) {
                return -1;
            } else if (val == 2) {
                res += 1;
            } else if (val % 3 == 0) {
                res += val / 3;
            } else if (val % 3 == 1) {
                res += val / 3 - 1;
                res += 2;
            } else if (val % 3 == 2) {
                res += val / 3 + 1;
            } else if (val % 2 == 0) {
                res += val / 2;
            } else {
                return -1;
            }
        }
        return res;
    }

}
