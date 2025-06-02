package algorithms.math;

/**
 * 357. Count Numbers with Unique Digits
 * Time: O(n)
 * Space: O(n)
 *
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int prod = 9;
        for (int i = 0; i < n - 1; i++) {
            prod *= 9 - i;
        }
        return prod + countNumbersWithUniqueDigits(n - 1);
    }
}
