package algorithms.math;

/**
 * 204. Count Primes
 * Time: O(n*log(log(n)))
 * Space: O(n)
 * <p>
 * Sieve of Eratosthenes
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = n - 2;
        boolean[] wasThere = new boolean[n];
        for (int k = 2; k * k < n; k++) {
            if (!wasThere[k]) {
                for (int m = k; m * k < n; m++) {
                    if (!wasThere[m * k]) {
                        count--;
                        wasThere[m * k] = true;
                    }
                }
            }
        }
        return count;
    }
}
