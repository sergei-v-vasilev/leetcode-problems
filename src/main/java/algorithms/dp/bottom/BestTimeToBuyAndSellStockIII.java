package algorithms.dp.bottom;

/**
 * 123. Best Time to Buy and Sell Stock III
 * Time: O(n)
 * Space: O(n)
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int[] profitFromDay = new int[prices.length];
        int max = prices[prices.length - 1];
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (max <= prices[i]) {
                profitFromDay[i] = profit;
                max = prices[i];
                min = Integer.MAX_VALUE;
            } else {
                min = Math.min(min, prices[i]);
                profitFromDay[i] = Math.max(profit, max - min);
                profit = Math.max(profit, profitFromDay[i]);
            }
        }
        min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min < prices[i]) {
                result = Math.max(result, prices[i] - min + (i + 1 < profitFromDay.length ? profitFromDay[i + 1] : 0));
            } else {
                min = prices[i];
            }
        }

        return result;
    }
}
