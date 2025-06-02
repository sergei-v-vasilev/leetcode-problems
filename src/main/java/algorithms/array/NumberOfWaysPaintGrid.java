package algorithms.array;

/**
 * 1411. NumberOfWaysPaintGrid
 */
public class NumberOfWaysPaintGrid {

    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;
        long mod = (long) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            long newAba = 3 * aba + 2 * abc;
            long newAbc = 2 * aba + 2 * abc;
            aba = newAba % mod;
            abc = newAbc % mod;
        }
        return (int) ((aba + abc) % mod);
    }
}
