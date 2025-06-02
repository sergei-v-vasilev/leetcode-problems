package algorithms.bit;

/**
 * 338. Counting Bits
 * Time: O(n*log(n))
 * Space: O(1)
 *
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n];
        int count;
        int k;
        for (int i = 0; i < n; i++) {
            count = 0;
            k = i;
            while (k > 0) {
                count += ((k >>> 1) & 1) == 1 ? 1 : 0;
                k = k >>> 1;
            }
            result[i] = count;
        }
        return result;
    }
}
