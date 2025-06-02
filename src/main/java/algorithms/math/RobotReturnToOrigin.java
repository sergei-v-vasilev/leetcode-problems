package algorithms.math;

/**
 * 657. Robot Return to Origin
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if ('U' == moves.charAt(i)) x++;
            if ('D' == moves.charAt(i)) x--;
            if ('R' == moves.charAt(i)) y++;
            if ('L' == moves.charAt(i)) y--;
        }
        return x == 0 && y == 0;
    }
}
