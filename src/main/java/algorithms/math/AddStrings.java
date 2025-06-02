package algorithms.math;

/**
 * 415. Add Strings
 * Time: O(n)
 * Space: O(1)
 *
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder(Math.max(num1.length(), num2.length()) + 1);
        int rest = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int value;
        while (l1 >= 0 && l2 >= 0) {
            value = (num1.charAt(l1) - '0') + (num2.charAt(l2) - '0') + rest;
            rest = value / 10;
            builder.insert(0, value > 9 ? value % 10 : value);
            l1--;
            l2--;
        }
        while (l1 >= 0) {
            value = (num1.charAt(l1) - '0') + rest;
            rest = value / 10;
            builder.insert(0, value > 9 ? value % 10 : value);
            l1--;
        }
        while (l2 >= 0) {
            value = (num2.charAt(l2) - '0') + rest;
            rest = value / 10;
            builder.insert(0, value > 9 ? value % 10 : value);
            l2--;
        }
        if (rest > 0) {
            builder.insert(0, rest);
        }
        return builder.toString();
    }

}
