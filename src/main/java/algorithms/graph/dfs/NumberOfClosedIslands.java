package algorithms.graph.dfs;

/**
 * 1254. Number of Closed Islands
 * Time: O(n*m)
 * Space: O(1)
 *
 */
public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            sinkTheIsland(i, 0, grid);
            sinkTheIsland(i, grid[i].length - 1, grid);
        }
        for (int j = 0; j < grid[0].length; j++) {
            sinkTheIsland(0, j, grid);
            sinkTheIsland(grid.length - 1, j, grid);
        }
        int numberOfClosedIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    numberOfClosedIsland++;
                    sinkTheIsland(i, j, grid);
                }
            }
        }
        return numberOfClosedIsland;
    }

    private void sinkTheIsland(int i, int j, int[][] grid) {
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            if (j > 0) {
                sinkTheIsland(i, j - 1, grid);
            }
            if (i > 0) {
                sinkTheIsland(i - 1, j, grid);
            }
            if (j < grid[i].length - 1) {
                sinkTheIsland(i, j + 1, grid);
            }
            if (i < grid.length - 1) {
                sinkTheIsland(i + 1, j, grid);
            }
        }
    }
}
