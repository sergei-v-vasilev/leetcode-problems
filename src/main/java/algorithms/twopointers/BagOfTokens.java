package algorithms.twopointers;

import java.util.Arrays;

/**
 * 948. Bag of Tokens
 * Time: O(n * log (n))
 * Space: O(1)
 *
 */
public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxScore = 0;
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (tokens[left] <= power) {
                score++;
                power -= tokens[left];
                maxScore = Math.max(score, maxScore);
                left++;
            } else if (score > 0) {
                score--;
                power += tokens[right];
                right--;
            } else {
                return maxScore;
            }
        }
        return maxScore;
    }
}
