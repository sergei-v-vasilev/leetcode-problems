package algorithms.graph.dfs;

/**
 * 695. Max Area of Island
 * Time: O(n * m)
 * Space: O(1)
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, obtainArea(i, j, grid));
            }
        }
        return max;
    }

    private int obtainArea(int i, int j, int[][] grid) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[i].length) {
            if (grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            return 1 + obtainArea(i - 1, j, grid) + obtainArea(i, j - 1, grid) + obtainArea(i + 1, j, grid) + obtainArea(i, j + 1, grid);
        } else {
            return 0;
        }
    }
}
