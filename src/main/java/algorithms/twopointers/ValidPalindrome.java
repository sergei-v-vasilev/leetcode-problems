package algorithms.twopointers;

/**
 * 125. Valid Palindrome
 * Time: O(n)
 * Space: O(1)
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.toLowerCase().trim().length() - 1;
        char[] array = s.toLowerCase().trim().toCharArray();
        while (left < right) {
            if (!Character.isLetterOrDigit(array[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(array[right])) {
                right--;
                continue;
            }
            if (array[left] != array[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
