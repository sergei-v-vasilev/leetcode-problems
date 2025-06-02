package algorithms.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 284. Peeking Iterator
 */
public class PeekingIterator implements Iterator<Integer> {

    private LinkedList<Integer> list;

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public PeekingIterator(Iterator<Integer> iterator) {
        list = new LinkedList<>();
        while (iterator.hasNext()) {
            list.addLast(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public Integer peek() {
        return list.peekFirst();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.

    /**
     * Time: O(1)
     * Space: O(1)
     */
    @Override
    public Integer next() {
        return list.pollFirst();
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}