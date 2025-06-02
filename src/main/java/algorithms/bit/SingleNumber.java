package algorithms.bit;

/**
 * 136. Single Number
 * Time: O(n)
 * Space: O(1)
 */
public class SingleNumber {

    public int singleNumber(int[] array) throws RuntimeException {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }
}
