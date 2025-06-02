package algorithms.math;

/**
 * §268. Missing Number
 * Time: O(n)
 * Space: O(1)
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n + 1) * n / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return sum - actualSum;
    }

}
