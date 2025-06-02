package algorithms.math;

/**
 * 50. Pow(x, n)
 * Time: O(log(n))
 * Space: O(log(n))
 * 
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, Math.abs(n));
        } else {
            return pow(x, Math.abs(n));
        }
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = pow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}
