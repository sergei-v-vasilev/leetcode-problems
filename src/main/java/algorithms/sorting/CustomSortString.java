package algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 791. Custom Sort String
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> orderMap = new HashMap<>(order.length());
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        Character[] result = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        Arrays.sort(result, (a, b) -> {
            int aI = orderMap.getOrDefault(a, 0);
            int bI = orderMap.getOrDefault(b, 0);
            if (aI == bI) {
                return a - b;
            } else {
                return aI - bI;
            }
        });
        // Return the result
        StringBuilder resultString = new StringBuilder();
        for (Character c: result) {
            resultString.append(c);
        }
        return resultString.toString();
    }
}
