package algorithms.array;

/**
 * 41. First Missing Positive
 * Time: O(n)
 * Space: O(1)
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int last = nums.length;
        int i = 0;
        while (i < last) {
            if (nums[i] <= 0) {
                last--;
                swap(i, last, nums);
                continue;
            }
            i++;
        }
        i = 0;
        while (i < last) {
            if (nums[i] - 1 < last && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums[i] - 1, i, nums);
                continue;
            }
            i++;
        }
        i = 0;
        while (i < last && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
