package algorithms.graph.dfs;


/**
 * 827. Making A Large Island
 * 16.34
 */
public class MakingALargeIsland {

    public int largestIsland(int[][] grid) {
        boolean hasWater = false;
        boolean hasLand = false;
        int[][] nearbyArea = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    hasLand = true;
                    int area = getArea(grid, i, j, 0);
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    markIsland(grid, i, j, area, nearbyArea, visited);
                }
                if (grid[i][j] == 0) {
                    hasWater = true;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, grid[i][j] + (hasWater ? 1 : 0));
                }
                if (nearbyArea[i][j] != 0) {
                    max = Math.max(max, nearbyArea[i][j] + 1);
                }
            }
        }
        if (!hasLand) {
            return 1;
        }
        return max;
    }

    private int getArea(int[][] grid, int x, int y, int area) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return area;
        }
        if (grid[x][y] != 1) {
            return area;
        }
        grid[x][y] = -1;
        area++;
        area = getArea(grid, x + 1, y, area);
        area = getArea(grid, x - 1, y, area);
        area = getArea(grid, x, y + 1, area);
        area = getArea(grid, x, y - 1, area);
        return area;
    }

    private void markIsland(int[][] grid, int x, int y, int area, int[][] nearbyArea, boolean[][] visited) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return;
        }
        if (grid[x][y] == 0 && !visited[x][y]) {
            nearbyArea[x][y] += area;
            visited[x][y] = true;
            return;
        }
        if (grid[x][y] != -1) {
            return;
        }
        grid[x][y] = area;
        markIsland(grid, x + 1, y, area, nearbyArea, visited);
        markIsland(grid, x - 1, y, area, nearbyArea, visited);
        markIsland(grid, x, y + 1, area, nearbyArea, visited);
        markIsland(grid, x, y - 1, area, nearbyArea, visited);
    }
}
