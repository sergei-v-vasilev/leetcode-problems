package algorithms.binarysearch;

/**
 * 875. Koko Eating Bananas
 * Time: O(n*log(m))
 * Space: O(n)
 *
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return lowest(piles, h, 1, max + 1);
    }

    private int lowest(int[] piles, int h, int start, int end) {
        if (start >= end) return -1;
        int mid = start + (end - start) / 2;
        if (start == mid && checkSpeed(mid, piles, h)) return mid;
        boolean can = checkSpeed(mid - 1, piles, h);
        if (can && start == mid - 1) return mid - 1;
        if (can) return lowest(piles, h, start, mid);
        else return lowest(piles, h, mid, end);
    }

    private boolean checkSpeed(int k, int[] piles, int h) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] < k) time++;
            else {
                time += piles[i] / k;
                time += piles[i] % k != 0 ? 1 : 0;
            }
        }
        if (time <= h) return true;
        else return false;
    }
}
