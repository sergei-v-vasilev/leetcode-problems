package algorithms.bit;

/**
 * 393. UTF-8 Validation
 * Time: O(n)
 * Space: O(1)
 *
 */
public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        int numbersOf10 = 0;
        for (int i = 0; i < data.length; i++) {
            int ones = ones(data[i]);
            if (numbersOf10 > 0 && ones == 1) {
                numbersOf10--;
            } else if (numbersOf10 > 0) {
                return false;
            } else if (numbersOf10 == 0) {
                if (ones == 0) {
                } else if (ones == 1) {
                    return false;
                } else if (ones == 2) {
                    numbersOf10 = 1;
                } else if (ones == 3) {
                    numbersOf10 = 2;
                } else if (ones == 4) {
                    numbersOf10 = 3;
                } else {
                    return false;
                }
            }
        }
        return numbersOf10 == 0;
    }

    private int ones(int number) {
        int moves = 7;
        int count = 0;
        while ((number & (1 << moves)) != 0) {
            count++;
            moves--;
        }
        return count;
    }

}
