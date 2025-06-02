package algorithms.slidingwindow;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 * Time: O(n)
 * Space: O(1)
 *
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int max;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;
        int n = cardPoints.length;
        if (k == n) {
            return max;
        }
        for (int i = 1; i <= k; i++) {
            sum -= cardPoints[k - i];
            sum += cardPoints[n - i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
