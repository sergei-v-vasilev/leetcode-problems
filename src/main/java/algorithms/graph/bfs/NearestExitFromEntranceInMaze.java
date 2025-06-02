package algorithms.graph.bfs;

import java.util.LinkedList;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * Time: O(n * n)
 * Space: O(n * n)
 */
public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] stepMatrix = new int[maze.length][maze[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        stepMatrix[entrance[0]][entrance[1]] = -1;
        queue.addLast(entrance);
        while (!queue.isEmpty()) {
            int[] position = queue.pollFirst();
            int i = position[0];
            int j = position[1];
            int steps = (stepMatrix[i][j] == -1) ? 0 : stepMatrix[i][j];
            if (steps > 0 && (i == 0 || j == 0 || i == maze.length - 1 || j == maze[i].length - 1)) {
                return steps;
            }

            if (0 < i && maze[i - 1][j] == '.') {
                stepMatrix[i - 1][j] = steps + 1;
                queue.addLast(new int[]{i - 1, j});
            }

            if (0 < j && maze[i][j - 1] == '.') {
                stepMatrix[i][j - 1] = steps + 1;
                maze[i][j - 1] = '+';
                queue.addLast(new int[]{i, j - 1});
            }

            if (i < maze.length - 1 && maze[i + 1][j] == '.') {
                stepMatrix[i + 1][j] = steps + 1;
                maze[i + 1][j] = '+';
                queue.addLast(new int[]{i + 1, j});
            }

            if (j < maze[i].length - 1 && maze[i][j + 1] == '.') {
                stepMatrix[i][j + 1] = steps + 1;
                maze[i][j + 1] = '+';
                queue.addLast(new int[]{i, j + 1});
            }
        }
        return -1;
    }
}
