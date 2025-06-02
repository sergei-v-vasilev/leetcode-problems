package algorithms.greedy;

import java.util.Arrays;

/**
 * 670. Maximum Swap
 * Time: O(n * log (n))
 * Space: O(n)
 *
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        String number = String.valueOf(num);
        char[] digits = number.toCharArray();
        Arrays.sort(digits);
        int i = 0;
        while (i < digits.length && digits[digits.length - 1 - i] == number.charAt(i)) {
            i++;
        }
        if (i == digits.length) {
            return num;
        } else {
            char next = digits[digits.length - 1 - i];
            int k = number.length() - 1;
            while (k >= 0) {
                if (number.charAt(k) == next) {
                    break;
                }
                k--;
            }
            char[] array = number.toCharArray();
            char temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            return Integer.parseInt(new String(array));
        }
    }
}
