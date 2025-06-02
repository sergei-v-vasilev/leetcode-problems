package algorithms.dp.bottom;

/**
 * 583. Delete Operation for Two Strings
 * Time: O(n^2)
 * Space: O(n)
 *
 * Bottom up dynamic programming
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int[] d = new int[word1.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            d[i] = i;
        }
        int previousElement;
        int previousDiagonal;
        for (int i = 1; i < word2.length() + 1; i++) {
            previousElement = i;
            previousDiagonal = d[0];
            for (int j = 1; j < word1.length() + 1; j++) {
                if (word1.charAt(j - 1) != word2.charAt(i - 1)) previousElement = Math.min(previousElement, d[j]) + 1;
                else previousElement = previousDiagonal;

                previousDiagonal = d[j];
                d[j] = previousElement;
            }
            d[0]++;
        }
        return d[word1.length()];
    }

    public int minDistanceFullDP(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
