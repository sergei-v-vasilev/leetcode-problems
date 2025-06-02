package algorithms.slidingwindow;

/**
 * 1151. Minimum Swaps to Group All 1's Together
 */
public class MinimumSwapsToGroupAl1Together {

    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i = 0; i < data.length; i++) {
            ones += data[i];
        }

        //initial window
        int currentOnes = 0;
        for (int i = 0; i < ones; i++) {
            currentOnes += data[i];
        }
        int result = ones - currentOnes;
        int start = 0;
        int end = ones;
        while (end < data.length) {
            currentOnes -= data[start];
            currentOnes += data[end];
            result = Math.min(result, ones - currentOnes);
            start++;
            end++;
        }
        return result;
    }

}
