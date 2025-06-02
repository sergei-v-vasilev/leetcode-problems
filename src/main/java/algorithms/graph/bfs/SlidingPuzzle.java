package algorithms.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 773. Sliding Puzzle
 */
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(convert(board));
        int steps = 0;
        int size = 1;
        Set<String> actions = new HashSet<>();
        while (!queue.isEmpty()) {
            int nextSize = 0;
            while (size > 0 && !queue.isEmpty()) {
                String current = queue.pollFirst();
                if ("123450".equals(current)) {
                    return steps;
                }
                visited.add(current);
                Set<String> applicableActions = actions(current, actions, visited);
                nextSize += applicableActions.size();
                queue.addAll(applicableActions);
                size--;
            }
            steps++;
            size = nextSize;
        }
        return -1;
    }

    private Set<String> actions(String s, Set<String> actions, Set<String> visited) {
        actions.clear();
        if (s.indexOf('0') == 0) {
            actions.add("" + s.charAt(1) + "0" + s.charAt(2) + s.charAt(3) + s.charAt(4) + s.charAt(5));
            actions.add("" + s.charAt(3) + s.charAt(1) + s.charAt(2) + "0" + s.charAt(4) + s.charAt(5));
        } else if (s.indexOf('0') == 1) {
            actions.add("" + s.charAt(0) + s.charAt(4) + s.charAt(2) + s.charAt(3) + "0" + s.charAt(5));
            actions.add("" + "0" + s.charAt(0) + s.charAt(2) + s.charAt(3) + s.charAt(4) + s.charAt(5));
            actions.add("" + s.charAt(0) + s.charAt(2) + "0" + s.charAt(3) + s.charAt(4) + s.charAt(5));
        } else if (s.indexOf('0') == 2) {
            actions.add("" + s.charAt(0) + "0" + s.charAt(1) + s.charAt(3) + s.charAt(4) + s.charAt(5));
            actions.add("" + s.charAt(0) + s.charAt(1) + s.charAt(5) + s.charAt(3) + s.charAt(4) + "0");
        } else if (s.indexOf('0') == 3) {
            actions.add("" + "0" + s.charAt(1) + s.charAt(2) + s.charAt(0) + s.charAt(4) + s.charAt(5));
            actions.add("" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(4) + "0" + s.charAt(5));
        } else if (s.indexOf('0') == 4) {
            actions.add("" + s.charAt(0) + "0" + s.charAt(2) + s.charAt(3) + s.charAt(1) + s.charAt(5));
            actions.add("" + s.charAt(0) + s.charAt(1) + s.charAt(2) + "0" + s.charAt(3) + s.charAt(5));
            actions.add("" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3) + s.charAt(5) + "0");
        } else if (s.indexOf('0') == 5) {
            actions.add("" + s.charAt(0) + s.charAt(1) + "0" + s.charAt(3) + s.charAt(4) + s.charAt(2));
            actions.add("" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3) + "0" + s.charAt(4));
        }
        actions.removeAll(visited);
        return actions;
    }

    private String convert(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }
}
