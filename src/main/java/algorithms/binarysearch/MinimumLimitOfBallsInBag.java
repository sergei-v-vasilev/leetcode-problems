package algorithms.binarysearch;

/**
 * 1760. Minimum Limit of Balls in a Bag
 */
public class MinimumLimitOfBallsInBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (equalDistributionIsPossible(mid, nums, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean equalDistributionIsPossible(int howManyPartsOfBiggest, int[] nums, int maxOperations) {
        int numberOfOperations = 0;
        for (int num : nums) {
            if (num > howManyPartsOfBiggest) {
                numberOfOperations += (int) Math.ceil((double) num / (howManyPartsOfBiggest)) - 1;
                if (numberOfOperations > maxOperations) {
                    return false;
                }
            }
        }
        return true;
    }
}
