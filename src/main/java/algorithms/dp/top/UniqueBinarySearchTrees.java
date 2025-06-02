package algorithms.dp.top;

/**
 * 96. Unique Binary Search Trees
 * Time: O(n)
 * Space: O(n)
 *
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] memo = new int[n + 2];
        memo[0] = 0;
        memo[1] = 1;
        return numTrees(0, n + 1, memo);
    }

    private int numTrees(int start, int end, int[] memo) {
        if (end == start) {
            return 0;
        }
        if (memo[end - start] != 0) {
            return memo[end - start];
        }
        int count = 0;
        for (int i = start + 1; i < end; i++) {
            count += numTrees(start, i, memo) * numTrees(i, end, memo);
        }
        memo[end - start] = count;
        return count;
    }
}
