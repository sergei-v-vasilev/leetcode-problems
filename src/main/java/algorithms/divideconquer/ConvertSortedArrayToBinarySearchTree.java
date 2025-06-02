package algorithms.divideconquer;

import algorithms.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Time: O(n)
 * Space: O(log(n))
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(0, nums.length, nums);
    }

    private TreeNode sortedArrayToBST(int start, int end, int[] nums) {
        if (start >= end) {
            return null;
        }
        if (start == end - 1) {
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start) / 2;
        return new TreeNode(nums[mid], sortedArrayToBST(start, mid, nums), sortedArrayToBST(mid + 1, end, nums));
    }
}
