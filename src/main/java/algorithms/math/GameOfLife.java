package algorithms.math;

/**
 * 289. Game of Life
 * Time: O(n * k)
 * Space: O(1)
 *
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j, board);
                if (board[i][j] == 1 && (aliveNeighbors < 2 || 3 < aliveNeighbors)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && aliveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAliveNeighbors(int i, int j, int[][] board) {
        int count = 0;

        if (i > 0 && Math.abs(board[i - 1][j]) == 1) count++;
        if (j > 0 && Math.abs(board[i][j - 1]) == 1) count++;
        if (i < board.length - 1 && Math.abs(board[i + 1][j]) == 1) count++;
        if (j < board[i].length - 1 && Math.abs(board[i][j + 1]) == 1) count++;

        if (i > 0 && j > 0 && Math.abs(board[i - 1][j - 1]) == 1) count++;
        if (i > 0 && j < board[i].length - 1 && Math.abs(board[i - 1][j + 1]) == 1) count++;
        if (i < board.length - 1 && j > 0 && Math.abs(board[i + 1][j - 1]) == 1) count++;
        if (i < board.length - 1 && j < board[i].length - 1 && Math.abs(board[i + 1][j + 1]) == 1) count++;

        return count;
    }

}
