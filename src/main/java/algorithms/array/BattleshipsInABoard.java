package algorithms.array;

/**
 * 419. Battleships in a Board
 * Time: O(n * m)
 * Space: O(1)
 */
public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
