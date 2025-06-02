package algorithms.greedy;

/**
 * 1753. Maximum Score From Removing Stones
 * Time: O(n)
 * Space: O(1)
 * <p>
 * 
 */
public class MaximumScoreFromRemovingStones {

    public int maximumScore(int a, int b, int c) {
        int score = 0;
        while (a > 0 && b > 0 || b > 0 && c > 0 || a > 0 && c > 0) {
            if (a >= b && a >= c) {
                if (b > c) {
                    a--;
                    b--;
                    score++;
                } else {
                    a--;
                    c--;
                    score++;
                }
            } else if (b >= a && b >= c) {
                if (a > c) {
                    b--;
                    a--;
                    score++;
                } else {
                    b--;
                    c--;
                    score++;
                }
            } else {
                if (a > b) {
                    c--;
                    a--;
                    score++;
                } else {
                    c--;
                    b--;
                    score++;
                }
            }
        }
        return score;
    }
}
