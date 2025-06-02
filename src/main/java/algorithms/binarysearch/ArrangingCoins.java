package algorithms.binarysearch;

/**
 * 441. Arranging Coins
 * Time: O(log(n))
 * Space: O(1)
 *
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int) arrangeCoins(0, n, n);
    }

    private long arrangeCoins(long start, long end, long n) {
        long mid = start + (end - start) / 2;
        long numberOfCoins = mid * (mid + 1) / 2;
        if (n > numberOfCoins && n - numberOfCoins <= mid + 1) {
            return (long) (n - numberOfCoins) == (long) (mid + 1) ? (long) (mid + 1) : (long) mid;
        } else if (n > numberOfCoins) {
            return arrangeCoins(mid, end, n);
        } else {
            return arrangeCoins(start, mid, n);
        }
    }

    public int arrangeCoinsMath(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}
