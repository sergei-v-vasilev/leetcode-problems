package algorithms.twopointers;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * Time: O(n)
 * Space: O(1)
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
            if (nums[nums.length - 1 - i] > nums[nums.length - i]) {
                max = Math.max(max, nums[nums.length - 1 - i]);
            }
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length && nums[left] > min) {
            left++;
        }
        while (right >= 0 && nums[right] < max) {
            right--;
        }

        return right > left ? right - left + 1 : 0;
    }
}
