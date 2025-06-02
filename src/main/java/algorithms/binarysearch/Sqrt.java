package algorithms.binarysearch;

/**
 * 69. Sqrt(x)
 * Time: O(log(n))
 * Space: O(1)
 * 
 */
public class Sqrt {


    public int mySqrt(int x) {
        if (x == 0) return 0;
        long start = 0;
        long end = ((long) x) + 1;
        while (start < end) {
            long mid = start + (end - start) / 2;
            long value = mid * mid;
            long overValue = (mid + 1) * (mid + 1);
            if (value == x) return (int) mid;
            if (value < x && x < overValue) return (int) mid;
            if (value < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return 1;
    }


}
