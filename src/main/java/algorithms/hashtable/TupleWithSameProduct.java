package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726. Tuple with Same Product
 */
public class TupleWithSameProduct {

    public int tupleSameProduct(int[] nums) {
        Map<Long, Integer> map = new HashMap<>(nums.length * nums.length);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long product = (long) nums[i] * nums[j];
                result += 8 * map.getOrDefault(product, 0);
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return result;
    }
}
