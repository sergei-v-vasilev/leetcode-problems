package algorithms.graph.dfs;

import java.util.*;

/**
 * 364. Nested List Weight Sum II
 */
public class NestedListWeightSumII {

    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

    private int sumIntegers = 0;
    private int sumDepthIntegers = 0;
    private int maxDepth = 0;

    //sum [(maxDepth - (the depth of the integer) + 1) * integer] = maxDepth * sum [integer] - sum [{(the depth of the integer)-1}* integer]
    public int depthSumInverse(List<NestedInteger> nestedList) {
        depthSumInverse(1, nestedList);
        return maxDepth * sumIntegers - sumDepthIntegers;
    }

    private void depthSumInverse(int depth, List<NestedInteger> nestedList) {
        maxDepth = Math.max(maxDepth, depth);
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                int value = nestedInteger.getInteger();
                sumIntegers += value;
                sumDepthIntegers += (depth - 1) * value;
            } else {
                depthSumInverse(depth + 1, nestedInteger.getList());
            }
        }
    }

}
