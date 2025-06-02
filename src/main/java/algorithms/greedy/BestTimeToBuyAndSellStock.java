package algorithms.greedy;

/**
 * 121. Best Time to Buy and Sell Stock
 * Time: O(n)
 * Space: O(1)
 *
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int k = 1; k < prices.length; k++) {
            if (prices[k] < min) {
                min = prices[k];
            } else {
                max = Math.max(max, prices[k] - min);
            }
        }
        return max;
    }
}
