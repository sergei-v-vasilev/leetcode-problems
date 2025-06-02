package algorithms.array;

import java.util.TreeSet;

/**
 * 1878. Get Biggest Three Rhombus Sums in a Grid
 */
public class GetBiggestThreeRhombusSumsInGrid {

    //m*n*min(m,n)
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> pq = new TreeSet<>();
        int sum = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int rhombusSide = 1; 2 * rhombusSide - 1 <= Math.min(m, n); rhombusSide++) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    sum = calculateSum(rhombusSide, i, j, m, n, grid);
                    if (sum > 0) {
                        pq.add(sum);
                        if (pq.size() > 3) {
                            pq.pollFirst();
                        }
                    }
                }
            }
        }
        int[] result = new int[pq.size()];
        int i = result.length - 1;
        while (!pq.isEmpty()) {
            result[i] = pq.pollFirst();
            i--;
        }
        return result;
    }

    private int calculateSum(int rhombusSide, int row, int col, int m, int n, int[][] grid) {
        //check column size
        if (col + 1 < rhombusSide || n - rhombusSide < col) {
            return 0;
        }
        //check rows size
        if (m - 2 * rhombusSide + 1 < row) {
            return 0;
        }
        int sum = 0;
        int i = 0;
        //calculate the upper part of the rhombus
        while (i < rhombusSide) {
            if (i == 0) {
                sum += grid[row][col];
            } else {
                sum += grid[row + i][col - i] + grid[row + i][col + i];
            }
            i++;
        }
        //calculate the lower part of the rhombus
        int j = i - 2;
        while (j >= 0) {
            if (j == 0) {
                sum += grid[row + i][col];
            } else {
                sum += grid[row + i][col - j] + grid[row + i][col + j];
            }
            i++;
            j--;
        }
        return sum;
    }

}
