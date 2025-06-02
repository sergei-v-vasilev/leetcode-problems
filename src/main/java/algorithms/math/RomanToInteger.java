package algorithms.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Time: O(n)
 * Space: O(1)
 *
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int previous = 0;
        int result = 0;
        int current;
        for (int i = 0; i < s.length(); i++) {
            current = map.get(s.charAt(i));
            if (previous == 0 || previous >= current) {
                result += previous;
                previous = current;
            } else {
                result += current - previous;
                previous = 0;
            }
        }
        result += previous;
        return result;
    }
}
