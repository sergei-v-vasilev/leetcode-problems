package algorithms.math;

/**
 * 326. Power of Three
 * 
 */
public class PowerOfThree {
    public boolean isPowerOfFour(int n) {
        double epsilon = 0.0000000001;
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}
