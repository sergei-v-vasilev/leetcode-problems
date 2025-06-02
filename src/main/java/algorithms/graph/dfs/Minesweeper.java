package algorithms.graph.dfs;

/**
 * 529. Minesweeper
 * Time: O(n * m)
 * Space: O(n * m)
 * 
 */
public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else if (board[click[0]][click[1]] == 'E') {
            reveal(click[0], click[1], board);
            return board;
        } else {
            return board;
        }
    }

    private void reveal(int i, int j, char[][] board) {
        if (board[i][j] != 'E') {
            return;
        }
        board[i][j] = 'B';
        int mines = getMines(i, j, board);

        if (mines > 0) {
            board[i][j] = (char) (mines + '0');
        } else {
            if (i < board.length - 1 && board[i + 1][j] == 'E') reveal(i + 1, j, board);
            if (j < board[i].length - 1 && board[i][j + 1] == 'E') reveal(i, j + 1, board);
            if (i < board.length - 1 && j < board[i].length - 1 && board[i + 1][j + 1] == 'E')
                reveal(i + 1, j + 1, board);

            if (i > 0 && board[i - 1][j] == 'E') reveal(i - 1, j, board);
            if (j > 0 && board[i][j - 1] == 'E') reveal(i, j - 1, board);
            if (i > 0 && j > 0 && board[i - 1][j - 1] == 'E') reveal(i - 1, j - 1, board);

            if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] == 'E') reveal(i + 1, j - 1, board);
            if (j < board[i].length - 1 && i > 0 && board[i - 1][j + 1] == 'E') reveal(i - 1, j + 1, board);
        }

    }

    private static int getMines(int i, int j, char[][] board) {
        int mines = 0;
        if (i < board.length - 1 && board[i + 1][j] == 'M') mines++;
        if (j < board[i].length - 1 && board[i][j + 1] == 'M') mines++;
        if (i < board.length - 1 && j < board[i].length - 1 && board[i + 1][j + 1] == 'M') mines++;

        if (i > 0 && board[i - 1][j] == 'M') mines++;
        if (j > 0 && board[i][j - 1] == 'M') mines++;
        if (i > 0 && j > 0 && board[i - 1][j - 1] == 'M') mines++;

        if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] == 'M') mines++;
        if (j < board[i].length - 1 && i > 0 && board[i - 1][j + 1] == 'M') mines++;
        return mines;
    }
}
