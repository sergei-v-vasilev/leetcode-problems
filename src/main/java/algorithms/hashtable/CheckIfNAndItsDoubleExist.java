package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1346. Check If N and Its Double Exist
 */
public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(2 * arr[i]) && map.get(2 * arr[i]) != i) {
                return true;
            }
        }
        return false;
    }
}
