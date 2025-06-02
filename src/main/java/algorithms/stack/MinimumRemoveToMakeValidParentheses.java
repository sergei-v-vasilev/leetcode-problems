package algorithms.stack;

import java.util.LinkedList;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * Time: O(n)
 * Space: O(n)
 *
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> positionsOfOpenParenthesis = new LinkedList<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                builder.append(c);
                positionsOfOpenParenthesis.addLast(builder.length() - 1);
            } else if (c == ')' && !positionsOfOpenParenthesis.isEmpty()) {
                builder.append(c);
                positionsOfOpenParenthesis.removeLast();
            } else if (Character.isLetter(c)) {
                builder.append(c);
            }
        }
        int count = 0;
        for (int i : positionsOfOpenParenthesis) {
            builder.delete(i - count, i - count + 1);
            count++;
        }
        return builder.toString();
    }
}
