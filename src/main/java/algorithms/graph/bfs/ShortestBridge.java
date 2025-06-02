package algorithms.graph.bfs;


import java.util.LinkedList;

/**
 * 934. Shortest Bridge
 * Time: O(n * n)
 * Space: O(n * n)
 *
 */
public class ShortestBridge {


    public int shortestBridge(int[][] grid) {
        boolean findIsland = false;
        LinkedList<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            if (!findIsland) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 1) {
                        fillIsland(i, j, grid, queue);
                        findIsland = true;
                        break;
                    }
                }
            } else break;
        }
        while (!queue.isEmpty()) {
            Integer[] point = queue.pollFirst();
            int i = point[0];
            int j = point[1];
            if (i > 0 && grid[i - 1][j] == 0) {
                grid[i - 1][j] = grid[i][j] + 1;
                queue.addLast(new Integer[]{i - 1, j});
            } else if (i > 0 && grid[i - 1][j] == 1) {
                return grid[i][j] - 2;
            }
            if (j > 0 && grid[i][j - 1] == 0) {
                grid[i][j - 1] = grid[i][j] + 1;
                queue.addLast(new Integer[]{i, j - 1});
            } else if (j > 0 && grid[i][j - 1] == 1) {
                return grid[i][j] - 2;
            }
            if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                grid[i + 1][j] = grid[i][j] + 1;
                queue.addLast(new Integer[]{i + 1, j});
            } else if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                return grid[i][j] - 2;
            }
            if (j < grid.length - 1 && grid[i][j + 1] == 0) {
                grid[i][j + 1] = grid[i][j] + 1;
                queue.addLast(new Integer[]{i, j + 1});
            } else if (j < grid.length - 1 && grid[i][j + 1] == 1) {
                return grid[i][j] - 2;
            }
        }
        return -1;
    }

    private void fillIsland(int i, int j, int[][] grid, LinkedList<Integer[]> queue) {
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            queue.add(new Integer[]{i, j});
            if (i > 0 && grid[i - 1][j] == 1) fillIsland(i - 1, j, grid, queue);
            if (j > 0 && grid[i][j - 1] == 1) fillIsland(i, j - 1, grid, queue);
            if (i < grid.length - 1 && grid[i + 1][j] == 1) fillIsland(i + 1, j, grid, queue);
            if (j < grid.length - 1 && grid[i][j + 1] == 1) fillIsland(i, j + 1, grid, queue);
        }
    }

}
