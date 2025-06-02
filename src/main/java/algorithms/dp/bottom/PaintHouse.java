package algorithms.dp.bottom;

/**
 * 256. Paint House
 */
public class PaintHouse {

    //[[17,2,17],[16,16,5],[14,3,19]]
    // [17,2,17],[18,33,7],[21,10,37]
    public int minCost(int[][] costs) {
        // [i][color for the i-th house]
        int[][] dp = new int[costs.length][3];
        dp[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            //0 color
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            //1 color
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            //2 color
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }

}
