package algorithms.prefixsum;

import java.util.Arrays;

/**
 * 1652. Defuse the Bomb
 */
public class DefuseBomb {
    //2 4 9 3
    //2 6 15 18
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int[] prefixSum = new int[code.length];
        int sum = 0;
        for (int i = 0; i < code.length; i++) {
            sum += code[i];
            prefixSum[i] = sum;
        }
        int[] result = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            if (k < 0) {
                if (i + k >= 0) {
                    result[i] = prefixSum[i] - prefixSum[i + k] - code[i] + code[i + k];
                } else {
                    result[i] = prefixSum[i] - code[i] + prefixSum[code.length - 1] - prefixSum[code.length - 1 + i + k];
                }
            } else {
                if (i + k < code.length) {
                    result[i] = prefixSum[i + k] - prefixSum[i];
                } else {
                    result[i] = prefixSum[code.length - 1] - prefixSum[i] + prefixSum[i + k - code.length + 1] - code[i + k - code.length + 1];
                }
            }
        }
        return result;
    }
}
