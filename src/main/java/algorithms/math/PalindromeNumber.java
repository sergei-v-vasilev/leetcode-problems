package algorithms.math;

/**
 * 9. Palindrome Number
 * Time: O(n)
 * Space: O(1)
 *
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int xL = x;
        int xR = x;
        int left = 1;
        while (left * 10 <= x && left <= Integer.MAX_VALUE / 10) {
            left *= 10;
        }
        while (left >= 10) {
            if (xL / left != xR % 10) {
                return false;
            }
            xL -= xL / left * left;
            xR /= 10;
            left /= 10;
        }
        return true;
    }
}
