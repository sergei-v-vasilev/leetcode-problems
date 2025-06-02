package algorithms.math;

/**
 * 342. Power of Four
 *
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        return Math.log(n) / Math.log(4) % 1 == 0;
    }
}
