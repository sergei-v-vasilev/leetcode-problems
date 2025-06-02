package algorithms.binarysearch;

/**
 * 374. Guess Number Higher or Lower
 * Time: O(log(n))
 * Space: O(1)
 *
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        return guessNumber(1, n + 1);
    }

    private int guessNumber(int start, int end) {
        int mid = start + (end - start) / 2;
        int result = guess(mid);
        if (result < 0) {
            return guessNumber(1, mid);
        } else if (result > 0) {
            return guessNumber(mid, end);
        } else {
            return mid;
        }
    }

    private int guess(int num) {
        return 0;
    }
}
