package algorithms.dp.bottom;

/**
 * 1524. Number of Sub-arrays With Odd Sum
 */
public class NumberOfSubArraysWithOddSum {

    //sub arrays including the num[i]
    // oddSum  1(current)   1(current)             1(last event+current)+1(current)
    // evenSum 0(current)   1(last odd+current)    1(last odd+current)


    public int numOfSubarrays(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int[] oddSum = new int[arr.length];
        int[] evenSum = new int[arr.length];
        if (arr[0] % 2 == 0) {
            oddSum[0] = 0;
            evenSum[0] = 1;
        } else {
            oddSum[0] = 1;
            evenSum[0] = 0;
        }
        int result = oddSum[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                oddSum[i] = oddSum[i - 1] % MOD;
                evenSum[i] = (evenSum[i - 1] + 1) % MOD;
            } else {
                oddSum[i] = (evenSum[i - 1] + 1) % MOD;
                evenSum[i] = (oddSum[i - 1]) % MOD;
            }
            result += oddSum[i];
            result %= MOD;
        }
        return result;
    }

}
