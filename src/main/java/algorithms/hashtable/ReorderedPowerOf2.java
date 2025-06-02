package algorithms.hashtable;

import java.util.Arrays;

/**
 * 869. Reordered Power of 2
 * Time: O(log^2 (n))
 * Space: O(log (n))
 * 
 */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        //digits numbers in current n
        int[] digits = digits(n);
        //31 because of int
        for (int i = 0; i < 31; i++) {
            //1 << 0 = 1, 1 << 1 = 2, 1 << 2 = 4, 1 << 3 = 8, ...
            // power of 2 always has binary representation as 100....
            if (Arrays.equals(digits, digits(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] digits(int n) {
        int step = 10;
        int[] result = new int[10];
        while (n > 0) {
            int digit = n % step;
            result[digit]++;
            n /= step;
        }
        return result;
    }
}
