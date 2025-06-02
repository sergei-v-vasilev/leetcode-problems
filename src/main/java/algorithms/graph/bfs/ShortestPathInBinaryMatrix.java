package algorithms.graph.bfs;

import java.util.LinkedList;

/**
 * 1091. Shortest Path in Binary Matrix
 * Time: O(n^2)
 * Space: O(n^2)
 * 
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        grid[0][0] = -1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] indices = queue.pollFirst();
            int i = indices[0];
            int j = indices[1];
            int path = grid[i][j] - 1;
            if (0 < i && (grid[i - 1][j] == 0 || grid[i - 1][j] < path)) {
                grid[i - 1][j] = path;
                queue.addLast(new int[]{i - 1, j});
            }
            if (0 < i && 0 < j && (grid[i - 1][j - 1] == 0 || grid[i - 1][j - 1] < path)) {
                grid[i - 1][j - 1] = path;
                queue.addLast(new int[]{i - 1, j - 1});
            }
            if (0 < i && j < grid.length - 1 && (grid[i - 1][j + 1] == 0 || grid[i - 1][j + 1] < path)) {
                grid[i - 1][j + 1] = path;
                queue.addLast(new int[]{i - 1, j + 1});
            }
            if (0 < j && (grid[i][j - 1] == 0 || grid[i][j - 1] < path)) {
                grid[i][j - 1] = path;
                queue.addLast(new int[]{i, j - 1});
            }
            if (0 < j && i < grid.length - 1 && (grid[i + 1][j - 1] == 0 || grid[i + 1][j - 1] < path)) {
                grid[i + 1][j - 1] = path;
                queue.addLast(new int[]{i + 1, j - 1});
            }
            if (i < grid.length - 1 && (grid[i + 1][j] == 0 || grid[i + 1][j] < path)) {
                grid[i + 1][j] = path;
                queue.addLast(new int[]{i + 1, j});
            }
            if (i < grid.length - 1 && j < grid.length - 1 && (grid[i + 1][j + 1] == 0 || grid[i + 1][j + 1] < path)) {
                grid[i + 1][j + 1] = path;
                queue.addLast(new int[]{i + 1, j + 1});
            }
            if (j < grid.length - 1 && (grid[i][j + 1] == 0 || grid[i][j + 1] < path)) {
                grid[i][j + 1] = path;
                queue.addLast(new int[]{i, j + 1});
            }
        }
        return grid[grid.length - 1][grid.length - 1] == 0 ? -1 : -grid[grid.length - 1][grid.length - 1];
    }
}
