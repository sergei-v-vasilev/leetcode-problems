package algorithms.dp.top;

/**
 * 10. Regular Expression Matching
 * Time: O(n * m)
 * Space: O(n * m)
 *
 */
public class RegularExpressionMatching {

    public boolean isMatch(String text, String pattern) {
        int[][] memo = new int[text.length() + 1][pattern.length() + 1];
        return isMatch(0, 0, text, pattern, memo);
    }

    public boolean isMatch(int i, int j, String text, String pattern, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        boolean result;
        if (j == pattern.length()) {
            result = i == text.length();
        } else {
            boolean first_match = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                result = isMatch(i, j + 2, text, pattern, memo) || first_match && isMatch(i + 1, j, text, pattern, memo);
            } else {
                result = first_match && isMatch(i + 1, j + 1, text, pattern, memo);
            }
        }
        memo[i][j] = result ? 1 : -1;
        return result;
    }
}
