package algorithms.stack;

import java.util.LinkedList;


/**
 * 155. (M) Min Stack
 */
public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> mins;

    public MinStack() {
       this.mins = new LinkedList<>();
       this.stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.add(val);
        if(mins.isEmpty()) {
            mins.add(val);
        } else {
            mins.add(Math.min(mins.getLast(), val));
        }
    }

    public void pop() {
        stack.removeLast();
        mins.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return mins.getLast();
    }

}
