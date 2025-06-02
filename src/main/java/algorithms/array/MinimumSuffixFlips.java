package algorithms.array;

/**
 * 1529. Minimum Suffix Flips
 * Time: O(n)
 * Space: O(1)
 */
public class MinimumSuffixFlips {
    public int minFlips(String target) {
        char lastSymbol = '0';
        int numberOfFlips = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != lastSymbol) {
                numberOfFlips++;
                lastSymbol = lastSymbol == '0' ? '1' : '0';
            }
        }
        return numberOfFlips;
    }
}
