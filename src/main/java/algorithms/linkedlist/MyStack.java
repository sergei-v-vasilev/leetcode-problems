package algorithms.linkedlist;

import java.util.LinkedList;

/**
 * 225. Implement Stack using Queues
 */
public class MyStack {

    private LinkedList<Integer> toPop;
    private LinkedList<Integer> toPush;

    public MyStack() {
        toPop = new LinkedList<>();
        toPush = new LinkedList<>();
    }

    public void push(int x) {
        toPush.addLast(x);
    }

    public int pop() {
        while (toPush.size() > 1) {
            toPop.addLast(toPush.pollFirst());
        }
        int result = toPush.pollFirst();
        toPush = toPop;
        toPop = new LinkedList<>();
        return result;
    }

    public int top() {
        while (toPush.size() > 1) {
            toPop.addLast(toPush.pollFirst());
        }
        int result = toPush.pollFirst();
        toPop.addLast(result);
        toPush = toPop;
        toPop = new LinkedList<>();
        return result;
    }

    public boolean empty() {
        return toPush.isEmpty();
    }
}
