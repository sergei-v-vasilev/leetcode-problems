package algorithms.math;

/**
 * 66. Plus One
 * Time: O(n)
 * Space: O(1)
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int pointer = digits.length - 1;
        int residual = 1;
        for (int i = pointer; i >= 0 && residual > 0; i--) {
            if (digits[i] + residual < 10) {
                digits[i] += residual;
                residual = 0;
            } else {
                int value = digits[i] + residual;
                digits[i] = value % 10;
                residual = value / 10;
            }
        }
        if (residual > 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = residual;
            return result;
        } else {
            return digits;
        }
    }

}
