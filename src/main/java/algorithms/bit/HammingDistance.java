package algorithms.bit;

/**
 * 461. Hamming Distance
 * Time: O(1) because number of bits are limited
 * Space: O(1)
 *
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        while (x != 0 && y != 0) {
            if ((x & 1) == 1 && (y & 1) == 0 || (x & 1) == 0 && (y & 1) == 1) {
                distance++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        while (x != 0) {
            if ((x & 1) == 1) {
                distance++;
            }
            x = x >>> 1;
        }
        while (y != 0) {
            if ((y & 1) == 1) {
                distance++;
            }
            y = y >>> 1;
        }
        return distance;
    }
}
