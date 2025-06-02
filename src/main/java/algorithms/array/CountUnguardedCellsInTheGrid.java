package algorithms.array;

/**
 * 2257. Count Unguarded Cells in the Grid
 *
 */
public class CountUnguardedCellsInTheGrid {

    //1 - guard
    //2 - wall
    //3 - guarded
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    up(i - 1, j, grid);
                    down(i + 1, j, grid);
                    left(i, j - 1, grid);
                    right(i, j + 1, grid);
                }
            }
        }
        int unoccupied = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unoccupied++;
                }
            }
        }
        return unoccupied;
    }

    private void up(int i, int j, int[][] grid) {
        if (i >= 0 && grid[i][j] != 1 && grid[i][j] != 2) {
            grid[i][j] = 3;
            up(i - 1, j, grid);
        }
    }

    private void down(int i, int j, int[][] grid) {
        if (i < grid.length && grid[i][j] != 1 && grid[i][j] != 2) {
            grid[i][j] = 3;
            down(i + 1, j, grid);
        }
    }

    private void left(int i, int j, int[][] grid) {
        if (j >= 0 && grid[i][j] != 1 && grid[i][j] != 2) {
            grid[i][j] = 3;
            left(i, j - 1, grid);
        }
    }

    private void right(int i, int j, int[][] grid) {
        if (j < grid[i].length && grid[i][j] != 1 && grid[i][j] != 2) {
            grid[i][j] = 3;
            right(i, j + 1, grid);
        }
    }
}
