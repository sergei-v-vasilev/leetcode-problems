package algorithms.twopointers;

/**
 * 31. Next Permutation
 * Time: O(n)
 * Space: O(1)
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int low = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                low = i;
                break;
            }
        }
        if (low != -1) {
            for (int i = nums.length - 1; i > low; i--) {
                if (nums[low] < nums[i]) {
                    swap(low, i, nums);
                    break;
                }
            }
        }
        int leftPointer = low + 1;
        int rightPointer = nums.length - 1;
        while (leftPointer < rightPointer) {
            swap(leftPointer, rightPointer, nums);
            leftPointer++;
            rightPointer--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
