package algorithms.stack;

import java.util.LinkedList;

/**
 * 150. Evaluate Reverse Polish Notation
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> queue = new LinkedList<>();
        int left;
        int right;
        for (String token : tokens) {
            if ("+".equals(token)) {
                right = queue.pollLast();
                left = queue.pollLast();
                queue.addLast(left + right);
            } else if ("*".equals(token)) {
                right = queue.pollLast();
                left = queue.pollLast();
                queue.addLast(left * right);
            } else if ("/".equals(token)) {
                right = queue.pollLast();
                left = queue.pollLast();
                queue.addLast(left / right);
            } else if ("-".equals(token)) {
                right = queue.pollLast();
                left = queue.pollLast();
                queue.addLast(left - right);
            } else {
                if (token.startsWith("-")) {
                    queue.addLast(-Integer.parseInt(token.substring(1)));
                } else {
                    queue.addLast(Integer.parseInt(token));
                }
            }
        }
        return queue.pollLast();
    }
}
