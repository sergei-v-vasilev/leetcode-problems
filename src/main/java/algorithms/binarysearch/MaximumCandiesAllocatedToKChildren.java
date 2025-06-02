package algorithms.binarysearch;

/**
 * 2226. Maximum Candies Allocated to K Children
 */
public class MaximumCandiesAllocatedToKChildren {

    // 5 8 6 = 19
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        if (sum < k) {
            return 0;
        }
        return findMaxCandies(0, (int) (sum / k) + 1, candies, k); 
    }

    private int findMaxCandies(int start, int end, int[] candies, long k) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (isPossibleToAllocate(mid, k, candies)) {
            return Math.max(mid, findMaxCandies(mid + 1, end, candies, k));
        } else {
            return findMaxCandies(start, mid, candies, k);
        }
    }

    private boolean isPossibleToAllocate(int pileSize, long k, int[] candies) {
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > pileSize) {
                k -= candies[i] / pileSize;
                if (k <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
