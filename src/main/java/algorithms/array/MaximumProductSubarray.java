package algorithms.array;

/**
 * 152. Maximum Product Subarray
 * Time: O(n)
 * Space: O(1)
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                left *= nums[i];
                max = Math.max(max, left);
            } else {
                max = Math.max(max, 0);
                left = 1;
            }
            if (nums[nums.length - 1 - i] != 0) {
                right *= nums[nums.length - 1 - i];
                max = Math.max(max, right);
            } else {
                max = Math.max(max, 0);
                right = 1;
            }
        }
        return max;
    }
}
