package algorithms.dp.bottom;

/**
 * 1143. Longest Common Subsequence
 * Time: O(n^2)
 * Space: O(n)
 * <p>
 * Bottom up dynamic programming
 */
public class LongCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] d = new int[text1.length()];
        int previousDiagonalElement;
        int previousElement;
        for (int i = 0; i < text2.length(); i++) {
            previousElement = 0;
            previousDiagonalElement = 0;
            for (int j = 0; j < text1.length(); j++) {
                if (text1.charAt(j) == text2.charAt(i)) previousElement = previousDiagonalElement + 1;
                else previousElement = Math.max(d[j], previousElement);

                previousDiagonalElement = d[j];
                d[j] = previousElement;
            }
        }

        return d[text1.length() - 1];
    }
}
