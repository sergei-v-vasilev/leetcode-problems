package algorithms.math;

/**
 * 2523. Closest Prime Numbers in Range
 */
public class ClosestPrimeNumbersInRange {

    public int[] closestPrimes(int left, int right) {
        boolean[] isNotPrime = new boolean[right + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i <= right; i++) {
            for (int j = i; i * j <= right; j++) {
                if (!isNotPrime[i * j]) {
                    isNotPrime[i * j] = true;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int l = -1, r = -1;
        int firstPrime = -1;
        int secondPrime = -1;
        for (int i = left; i <= right; i++) {
            if (!isNotPrime[i]) {
                if (firstPrime == -1) {
                    firstPrime = i;
                } else {
                    secondPrime = i;
                    if (secondPrime - firstPrime < min) {
                        min = secondPrime - firstPrime;
                        l = firstPrime;
                        r = secondPrime;
                    }
                    firstPrime = secondPrime;
                }
            }
        }
        if (l == -1 || r == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{l, r};
        }
    }

}
