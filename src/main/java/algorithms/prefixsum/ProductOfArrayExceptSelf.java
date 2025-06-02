package algorithms.prefixsum;

/**
 * 238. Product of Array Except Self
 * Time: O(n)
 * Space: O(n)
 *
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int lastNumber = nums[0];
        product[0] = 1;
        for (int i = 1; i < product.length; i++) {
            product[i] = lastNumber * product[i - 1];
            lastNumber = nums[i];
        }
        //product[i] = P_0^(i-1) nums[i]
        for (int i = product.length - 2; i >= 0; i--) {
            product[i] *= lastNumber;
            lastNumber *= nums[i];
        }
        return product;
    }
}
