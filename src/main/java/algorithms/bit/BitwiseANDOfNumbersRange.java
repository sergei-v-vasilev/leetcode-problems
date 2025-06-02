package algorithms.bit;

/**
 * 201. Bitwise AND of Numbers Range
 * Time: O(n)
 * Space: O(1)
 */
public class BitwiseANDOfNumbersRange {
    public static int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || left == right) return 0;
        //first differences in numbers lead us to all zeros from this point in the number;
        int numberOfZeros = 0;
        while (left != right) {
            left >>= 1; // 1111 -> 0111 -> 0011
            right >>= 1; // 1101 -> 0110 -> 0011
            numberOfZeros++;
        }
        return left << numberOfZeros; // 0011 -> 1100
    }


}
