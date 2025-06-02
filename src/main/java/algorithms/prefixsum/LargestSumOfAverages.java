package algorithms.prefixsum;

/**
 * 813. Largest Sum of Averages
 * 
 */
public class LargestSumOfAverages {

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length][k];
        return largestSumOfAverages(0, nums, k - 1, dp);
    }

    private double largestSumOfAverages(int i, int[] nums, int k, double[][] dp) {
        if (k < 0 || i == nums.length) {
            return 0d;
        }
        if (dp[i][k] != 0) {
            return dp[i][k];
        }
        double max = 0d;
        double sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            double size = (j - i + 1);
            double result = sum / size;
            if (k > 0 || j == nums.length - 1) {
                max = Math.max(max, result + largestSumOfAverages(j + 1, nums, k - 1, dp));
            }
        }
        dp[i][k] = max;
        return max;
    }
}
