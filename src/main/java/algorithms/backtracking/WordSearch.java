package algorithms.backtracking;

/**
 * 79. Word Search
 * Time: O(n^2*m)
 * Space: O(m)
 * <p>
 *
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int i, int j, char[][] board, int start, String word) {
        if (start == word.length()) {
            return true;
        }
        boolean result = false;
        if (board[i][j] == word.charAt(start)) {
            if (start == word.length() - 1) {
                return true;
            }
            char temp = board[i][j];
            board[i][j] = '!';
            if (i > 0) {
                result = exist(i - 1, j, board, start + 1, word);
            }
            if (!result && i < board.length - 1) {
                result = exist(i + 1, j, board, start + 1, word);
            }
            if (!result && j > 0) {
                result = exist(i, j - 1, board, start + 1, word);
            }
            if (!result && j < board[i].length - 1) {
                result = exist(i, j + 1, board, start + 1, word);
            }
            board[i][j] = temp;
        }
        return result;
    }
}
