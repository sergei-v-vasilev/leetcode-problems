package algorithms.dp.top;

/**
 * 97. Interleaving String
 * Time: O(n*m)
 * Space: O(n*m)
 *
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(0, s1, 0, s2, 0, s3, new int[s1.length()][s2.length()]);
    }

    private boolean isInterleave(int i, String s1, int j, String s2, int k, String s3, int[][] memo) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        if (s1.charAt(i) == s3.charAt(k) && isInterleave(i + 1, s1, j, s2, k + 1, s3, memo)) {
            memo[i][j] = 1;
            return true;
        } else if (s2.charAt(j) == s3.charAt(k) && isInterleave(i, s1, j + 1, s2, k + 1, s3, memo)) {
            memo[i][j] = 1;
            return true;
        }
        memo[i][j] = -1;
        return false;
    }
}
