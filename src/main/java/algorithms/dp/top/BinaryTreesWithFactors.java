package algorithms.dp.top;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 823. Binary Trees With Factors
 * Time: O(n^2)
 * Space: O(n)
 *
 */
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        long totalCount = 0;
        Set<Integer> values = new HashSet<>(arr.length);
        Map<Integer, Long> memo = new HashMap<>(arr.length);
        for (int i : arr) {
            values.add(i);
        }
        for (int v : values) {
            totalCount++;
            totalCount += top(v, values, memo);
        }
        return (int) (totalCount % 1000000007);
    }

    private long top(int value, Set<Integer> values, Map<Integer, Long> memo) {
        long count = 0;
        if (memo.containsKey(value)) {
            return memo.get(value);
        }
        for (int left : values) {
            if (value % left == 0 && values.contains(value / left)) {
                count++;
                long leftCount = top(left, values, memo);
                long rightCount = top(value / left, values, memo);
                count += leftCount + rightCount;
                count += leftCount * rightCount;
            }
        }
        memo.put(value, count);
        return count;
    }
}
