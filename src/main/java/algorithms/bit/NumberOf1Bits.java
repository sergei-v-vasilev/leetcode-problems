package algorithms.bit;

/**
 * 191. Number of 1 Bits
 * Time: O(1)
 * Space: O(1)
 * <p>
 *
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
