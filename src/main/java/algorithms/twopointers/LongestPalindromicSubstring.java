package algorithms.twopointers;

/**
 * 5. Longest Palindromic Substring
 * Time: O(n^2)
 * Space: O(1)
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int[] resultPoints = new int[]{0, 0}, points;
        for (int i = 0; i < s.length(); i++) {
            points = getLongestPalindromeLength(s, i, i);
            if (points[1] - points[0] > resultPoints[1] - resultPoints[0]) {
                resultPoints = points;
            }
            points = getLongestPalindromeLength(s, i, i + 1);
            if (points[1] - points[0] > resultPoints[1] - resultPoints[0]) {
                resultPoints = points;
            }
        }
        return s.substring(resultPoints[0], resultPoints[1]);
    }

    private int[] getLongestPalindromeLength(String s, int left, int right) {
        while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

}
