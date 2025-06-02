package algorithms.queue;

import java.util.LinkedList;

/**
 * 232. Implement Queue using Stacks
 */
public class ImplementQueueUsingStacks {

    class MyQueue {

        private LinkedList<Integer> toPop;
        private LinkedList<Integer> toPush;

        public MyQueue() {
            toPop = new LinkedList<>();
            toPush = new LinkedList<>();
        }

        public void push(int x) {
            while (!toPop.isEmpty()) {
                toPush.push(toPop.pop());
            }
            toPush.push(x);
        }

        public int pop() {
            while (!toPush.isEmpty()) {
                toPop.push(toPush.pop());
            }
            return toPop.pop();
        }

        public int peek() {
            while (!toPush.isEmpty()) {
                toPop.push(toPush.pop());
            }
            return toPop.peek();
        }

        public boolean empty() {
            while (!toPush.isEmpty()) {
                toPop.push(toPush.pop());
            }
            return toPop.isEmpty();
        }
    }
}
