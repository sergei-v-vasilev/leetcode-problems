package algorithms.math.gcd;

/**
 * 365. Water and Jug Problem
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int a, int b, int c) {
        if (a + b < c) {
            return false;
        }
        return c % gcd(a, b) == 0;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
