package algorithms.graph.dfs;

/**
 * 463. Island Perimeter
 * Time: O(n*n + k) where k is the square of island
 * Space: O(1)
 *
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return islandPerimeter(i, j, grid, 0);
                }
            }
        }
        return 0;
    }

    private int islandPerimeter(int i, int j, int[][] grid, int perimeter) {
        if (grid[i][j] != 1) return perimeter;
        grid[i][j] = 2;
        if (i == 0 || grid[i - 1][j] == 0) perimeter++;
        if (j == 0 || grid[i][j - 1] == 0) perimeter++;
        if (i == grid.length - 1 || grid[i + 1][j] == 0) perimeter++;
        if (j == grid[i].length - 1 || grid[i][j + 1] == 0) perimeter++;

        if (i > 0 && grid[i - 1][j] == 1) perimeter = islandPerimeter(i - 1, j, grid, perimeter);
        if (j > 0 && grid[i][j - 1] == 1) perimeter = islandPerimeter(i, j - 1, grid, perimeter);
        if (i < grid.length - 1 && grid[i + 1][j] == 1) perimeter = islandPerimeter(i + 1, j, grid, perimeter);
        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) perimeter = islandPerimeter(i, j + 1, grid, perimeter);

        return perimeter;
    }
}
