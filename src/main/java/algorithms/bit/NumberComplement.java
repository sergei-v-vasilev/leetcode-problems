package algorithms.bit;

/**
 * 476. Number Complement
 * 
 */
public class NumberComplement {
    public int findComplement(int num) {
        int result = 0;
        while (num != 0) {
            result = result << 1;
            if ((num & 1) == 0) {
                result = result | 1;
            }
            num = num >>> 1;
        }
        return result;
    }
}
