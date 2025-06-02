package algorithms.greedy;

/**
 * 122. Best Time to Buy and Sell Stock II
 * Time: O(n)
 * Space: O(1)
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
