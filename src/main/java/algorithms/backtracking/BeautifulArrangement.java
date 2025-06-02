package algorithms.backtracking;

/**
 * 526. Beautiful Arrangement
 * Time: O(k), k - number of permutation
 * Space: O(n)
 *
 */
public class BeautifulArrangement {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return countArrangement(1, n, visited);
    }

    private int countArrangement(int i, int n, boolean[] visited) {
        if (i > n) {
            return 1;
        }
        int result = 0;
        for (int j = 1; j < n + 1; j++) {
            if (!visited[j] && (j % i == 0 || i % j == 0)) {
                visited[j] = true;
                result += countArrangement(i + 1, n, visited);
                visited[j] = false;
            }
        }
        return result;
    }
}
