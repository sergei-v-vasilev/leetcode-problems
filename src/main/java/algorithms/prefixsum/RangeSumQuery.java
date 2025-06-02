package algorithms.prefixsum;

/**
 * 303. Range Sum Query
 *
 */
public class RangeSumQuery {

    private final int[] array;

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public RangeSumQuery(int[] nums) {
        array = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            array[i] = sum;
        }
    }

    /**
     * Time: O(1)
     */
    public int sumRange(int left, int right) {
        if (left > 0) {
            return array[right] - array[left - 1];
        } else {
            return array[right];
        }
    }
}
