package algorithms.backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        int openToRemove = 0;
        int closeToRemove = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                closeToRemove++;
                count = 0;
            }
        }
        openToRemove = count;
        Set<String> set = new HashSet<>();
        set = removeInvalidParentheses(0, s, openToRemove, closeToRemove, new StringBuilder(), set);
        return new ArrayList<>(set);
    }

    private Set<String> removeInvalidParentheses(int i, String s, int openToRemove, int closeToRemove, StringBuilder builder, Set<String> set) {
        if (openToRemove == 0 && closeToRemove == 0) {
            builder.append(s, i, s.length());
            if (isValid(builder.toString())) {
                set.add(builder.toString());
            }
            return set;
        }
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == '(' && openToRemove > 0) {
                StringBuilder newBuilder = new StringBuilder(builder);
                newBuilder.append(s, i, j);
                set = removeInvalidParentheses(j + 1, s, openToRemove - 1, closeToRemove, newBuilder, set);
            } else if (c == ')' && closeToRemove > 0) {
                StringBuilder newBuilder = new StringBuilder(builder);
                newBuilder.append(s, i, j);
                set = removeInvalidParentheses(j + 1, s, openToRemove, closeToRemove - 1, newBuilder, set);
            }
        }
        return set;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}
