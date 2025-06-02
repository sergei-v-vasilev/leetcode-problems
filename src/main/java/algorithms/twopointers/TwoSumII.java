package algorithms.twopointers;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * Time: O(n)
 * Space: O(1)
 *
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else break;
        }
        return new int[]{left + 1, right + 1};
    }
}
