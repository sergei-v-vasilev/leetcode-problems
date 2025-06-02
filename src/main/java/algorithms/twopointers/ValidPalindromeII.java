package algorithms.twopointers;

/**
 * 680. Valid Palindrome II
 * Time: O(n)
 * Space: O(1)
 *
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(left + 1, right, s) || isPalindrome(left, right - 1, s);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
