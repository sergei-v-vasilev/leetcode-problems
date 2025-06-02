package algorithms.greedy;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Time: O(n)
 * Space: O(1)
 *
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        int localMaxProfit = 0;
        int buyPrice = prices[0];
        Integer sellPrice = null;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buyPrice - fee > localMaxProfit) {
                sellPrice = prices[i];
                localMaxProfit = sellPrice - buyPrice - fee;
            }
            if (sellPrice != null && sellPrice - prices[i] - fee > 0) {
                maxProfit += localMaxProfit;
                localMaxProfit = 0;
                buyPrice = prices[i];
                sellPrice = null;
            } else if (sellPrice == null && prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }
        maxProfit += localMaxProfit;
        return maxProfit;
    }
}
