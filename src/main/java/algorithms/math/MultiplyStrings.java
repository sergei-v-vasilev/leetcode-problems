package algorithms.math;

/**
 * 43. Multiply Strings
 * Time: O(N*M)
 * Space: O(N)
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        AddStrings addStrings = new AddStrings();
        StringBuilder mod = new StringBuilder();
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            result = addStrings.addStrings(result, multiply(num2, num1.charAt(i)) + mod);
            mod.append("0");
        }
        return result;
    }

    private String multiply(String num, char digit) {
        StringBuilder builder = new StringBuilder(num.length());
        int rest = 0;
        int i = num.length() - 1;
        int value;
        while (i >= 0) {
            value = (num.charAt(i) - '0') * (digit - '0') + rest;
            rest = value / 10;
            builder.insert(0, value > 9 ? value % 10 : value);
            i--;
        }
        if (rest > 0) {
            builder.insert(0, rest);
        }
        return builder.toString();
    }


}
