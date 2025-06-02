package algorithms.dp.bottom;

/**
 * 72. Edit Distance
 * Time: O(n^2)
 * Space: O(n)
 * <p>
 * Bottom up dynamic programming
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word1.length() + 1];
        int previousDiagonalElement;
        int previousElement;
        for (int i = 0; i <= word2.length(); i++) {
            previousElement = i;
            previousDiagonalElement = i > 0 ? i - 1 : 0;
            for (int j = 0; j <= word1.length(); j++) {
                if (i == 0) dp[j] = j;
                else if (j == 0) dp[j] = previousElement;
                else {
                    if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                        previousElement = Math.min(previousDiagonalElement, Math.min(dp[j], previousElement) + 1);
                    } else {
                        previousElement = Math.min(previousDiagonalElement, Math.min(dp[j], previousElement)) + 1;
                    }
                    previousDiagonalElement = dp[j];
                    dp[j] = previousElement;
                }
            }
        }
        return dp[word1.length()];
    }

}
