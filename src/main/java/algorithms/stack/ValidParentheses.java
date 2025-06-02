package algorithms.stack;

import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 * Time: O(n)
 * Space: O(n)
 *
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                queue.addLast(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (queue.isEmpty() || queue.pollLast() != '(') {
                        return false;
                    }
                }
                if (s.charAt(i) == ']') {
                    if (queue.isEmpty() || queue.pollLast() != '[') {
                        return false;
                    }
                }
                if (s.charAt(i) == '}') {
                    if (queue.isEmpty() || queue.pollLast() != '{') {
                        return false;
                    }
                }
            }
        }
        return queue.isEmpty();
    }
}
