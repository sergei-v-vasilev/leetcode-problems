package algorithms.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 */
public class NestedIterator implements Iterator<Integer> {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    private LinkedList<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>();
        iterateOverNestedList(nestedList, list);
    }

    private void iterateOverNestedList(List<NestedInteger> nestedList, LinkedList<Integer> list) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                list.addLast(n.getInteger());
            } else {
                iterateOverNestedList(n.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return list.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}