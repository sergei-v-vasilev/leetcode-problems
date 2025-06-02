package algorithms.dp.bottom;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * Time: O(n * k)
 * Space: O(n)
 */
public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] sell = new int[k + 1]; //количество денег, если продали на k-й раз
        int[] buy = new int[k + 1]; //количество денег, если купили на k-й раз
        for (int i = 0; i < k + 1; i++) {
            sell[i] = 0;
            buy[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(sell[j], prices[i] + buy[j]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
        }
        return sell[k];
    }
}
