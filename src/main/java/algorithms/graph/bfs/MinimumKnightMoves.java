package algorithms.graph.bfs;

import java.util.*;

/**
 * 1197. Minimum Knight Moves
 */
public class MinimumKnightMoves {

    public int minKnightMoves(int x, int y) {
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[607][607];
        queue.add(new int[]{0, 0});
        visited[302][302] = true;
        int size = queue.size();
        int result = 0;
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (position[0] == x && position[1] == y) {
                return result;
            }
            //add next
            addToQueue(position[0] + 1, position[1] + 2, visited, queue);
            addToQueue(position[0] + 2, position[1] + 1, visited, queue);
            addToQueue(position[0] - 1, position[1] + 2, visited, queue);
            addToQueue(position[0] - 2, position[1] + 1, visited, queue);
            addToQueue(position[0] + 1, position[1] - 2, visited, queue);
            addToQueue(position[0] + 2, position[1] - 1, visited, queue);
            addToQueue(position[0] - 1, position[1] - 2, visited, queue);
            addToQueue(position[0] - 2, position[1] - 1, visited, queue);

            //check the step
            size--;
            if (size == 0) {
                result++;
                size = queue.size();
            }
        }
        return result;
    }

    private void addToQueue(int x, int y, boolean[][] visited, LinkedList<int[]> queue) {
        if (visited[x + 302][y + 302]) {
            return;
        }
        visited[x + 302][y + 302] = true;
        queue.add(new int[]{x, y});
    }


}
