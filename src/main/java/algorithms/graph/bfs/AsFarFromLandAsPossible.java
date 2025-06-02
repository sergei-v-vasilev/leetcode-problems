package algorithms.graph.bfs;

import java.util.LinkedList;

/**
 * 1162. As Far from Land as Possible
 * Time: O(n^2)
 * Space: O(n^2)
 *
 */
public class AsFarFromLandAsPossible {

    public int maxDistance(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] indices = queue.pollFirst();
            int i = indices[0];
            int j = indices[1];
            int distance = grid[i][j] == 1 ? -1 : grid[i][j] - 1;
            if (0 < i && (grid[i - 1][j] == 0 || grid[i - 1][j] < distance)) {
                grid[i - 1][j] = distance;
                queue.addLast(new int[]{i - 1, j});
            }
            if (0 < j && (grid[i][j - 1] == 0 || grid[i][j - 1] < distance)) {
                grid[i][j - 1] = distance;
                queue.addLast(new int[]{i, j - 1});
            }
            if (i < grid.length - 1 && (grid[i + 1][j] == 0 || grid[i + 1][j] < distance)) {
                grid[i + 1][j] = distance;
                queue.addLast(new int[]{i + 1, j});
            }
            if (j < grid.length - 1 && (grid[i][j + 1] == 0 || grid[i][j + 1] < distance)) {
                grid[i][j + 1] = distance;
                queue.addLast(new int[]{i, j + 1});
            }
        }

        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] < 0) {
                    max = Math.max(max, -grid[i][j]);
                }
            }
        }
        return max;
    }

}
