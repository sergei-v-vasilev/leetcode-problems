package algorithms.dp.top;

/**
 * 322. Coin Change. Top down dynamic programming
 * Time: O(n)
 * Space: O(n)
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return topDownDP(coins, amount, new int[amount + 1]);
    }

    private int topDownDP(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = topDownDP(coins, amount - coin, memo);
            if (count != -1) {
                minCount = Math.min(minCount, count + 1);
            }
        }
        memo[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[amount];
    }

}
