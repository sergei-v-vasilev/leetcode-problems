package algorithms.graph.dfs;

/**
 * 200. Number of Islands
 * Time: O(n*m)
 * Space: O(1)
 * <p>
 *
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sinkTheIsland(i, j, grid);
                }
            }
        }
        return count;
    }

    private void sinkTheIsland(int i, int j, char[][] grid) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i > 0) {
                sinkTheIsland(i - 1, j, grid);
            }
            if (i < grid.length - 1) {
                sinkTheIsland(i + 1, j, grid);
            }
            if (j > 0) {
                sinkTheIsland(i, j - 1, grid);
            }
            if (j < grid[i].length - 1) {
                sinkTheIsland(i, j + 1, grid);
            }
        }
    }
}
