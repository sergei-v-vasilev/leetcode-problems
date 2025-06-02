package algorithms.twopointers;

/**
 * 202. Happy Number
 * Time: O(log(n))
 * Space: O(1)
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int slowerRunner = n;
        int fasterRunner = calculateNextNumber(n);
        while (fasterRunner != 1 && fasterRunner != slowerRunner) {
            slowerRunner = calculateNextNumber(slowerRunner);
            fasterRunner = calculateNextNumber(calculateNextNumber(fasterRunner));
        }
        return fasterRunner == 1;
    }

    private int calculateNextNumber(int n) {
        int nextNumber = 0;
        while (n != 0) {
            nextNumber += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return nextNumber;
    }
}
