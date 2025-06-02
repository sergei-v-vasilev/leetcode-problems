package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. Length of Longest Fibonacci Subsequence
 */
public class LengthOfLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        //<last number, size> in subseq that ends with arr[i]
        Map<Integer, Integer>[] maps = new HashMap[arr.length];
        for (int i = 0; i < arr.length; i++) {
            maps[i] = new HashMap<>(i + 1);
            for (int j = i - 1; j >= 0; j--) {
                int size = maps[j].getOrDefault(arr[i] - arr[j], 1) + 1;
                maps[i].put(arr[j], size);
                if(size > 2) {
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

}
