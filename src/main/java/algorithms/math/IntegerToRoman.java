package algorithms.math;

import java.util.Map;

/**
 * 12. Integer to Roman
 * Time: O(n)
 * Space: O(1)
 *
 */
public class IntegerToRoman {
    private Map<Integer, String> romanAlphabet = Map.of(
            1, "I",
            5, "V",
            10, "X",
            50, "L",
            100, "C",
            500, "D",
            1000, "M"
    );
    
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int mod = 1;
        int value;
        while (num != 0) {
            value = num % 10;
            if (3 >= value && value > 0) {
                for (int i = 0; i < value; i++) {
                    builder.append(romanAlphabet.get(mod));
                }
            } else if (5 >= value && value > 3) {
                builder.append(romanAlphabet.get(5 * mod));
                if (value == 4) {
                    builder.append(romanAlphabet.get(mod));
                }
            } else if (8 >= value && value > 5) {
                for (int i = 0; i < value - 5; i++) {
                    builder.append(romanAlphabet.get(mod));
                }
                builder.append(romanAlphabet.get(5 * mod));
            } else if (value == 9) {
                builder.append(romanAlphabet.get(10 * mod)).append(romanAlphabet.get(mod));
            }
            mod *= 10;
            num /= 10;
        }
        return builder.reverse().toString();
    }

}
