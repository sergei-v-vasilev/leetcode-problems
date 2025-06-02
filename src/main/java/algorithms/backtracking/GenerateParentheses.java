package algorithms.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Time: O(4^n/sqrt(n))
 * Space: O(4^n/sqrt(n))
 * 
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(0, n, 0, new StringBuilder(), new LinkedList<>());
    }

    private List<String> generateParenthesis(int open, int n, int numberOfPairs, StringBuilder current, List<String> result) {
        if (numberOfPairs == n && open == 0) {
            result.add(current.toString());
            return result;
        } else if (numberOfPairs == n && open > 0) {
            return generateParenthesis(open - 1, n, numberOfPairs, new StringBuilder(current).append(")"), result);
        } else {
            result = generateParenthesis(open + 1, n, numberOfPairs + 1, new StringBuilder(current).append("("), result);
            if (open > 0) {
                result = generateParenthesis(open - 1, n, numberOfPairs, new StringBuilder(current).append(")"), result);
            }
            return result;
        }
    }
}

