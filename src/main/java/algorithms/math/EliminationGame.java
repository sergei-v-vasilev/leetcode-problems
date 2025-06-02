package algorithms.math;

/**
 * 390. Elimination Game
 */
public class EliminationGame {

    public int lastRemaining(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int lastEven = n % 2 == 0 ? n : n - 1;
        return remove(2, lastEven, 2, false);
    }

    private int remove(int start, int end, int step, boolean fromLeft) {
        if (start == end) {
            return start;
        }
        int size = (end - start) / step + 1;
        boolean isEvenSize = (size % 2 == 0);
        if (fromLeft) {
            if (isEvenSize) {
                return remove(start + step, end, 2 * step, false);
            } else {
                return remove(start + step, end - step, 2 * step, false);
            }
        } else {
            if (isEvenSize) {
                return remove(start, end - step, 2 * step, true);
            } else {
                return remove(start + step, end - step, 2 * step, true);
            }
        }
    }

}
