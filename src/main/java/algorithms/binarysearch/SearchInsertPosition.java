package algorithms.binarysearch;

/**
 * 35. Search Insert Position
 * Time: O(log(n))
 * Space: O(1)
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        if (start + 1 == end) {
            if (nums[start] == target) return start;
            else if (nums[start] < target) return end;
            else if (nums[start] > target) return start;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return searchInsert(nums, target, start, mid);
        else return searchInsert(nums, target, mid, end);
    }
}
