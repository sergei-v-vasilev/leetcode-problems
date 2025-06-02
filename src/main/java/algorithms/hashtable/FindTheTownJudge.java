package algorithms.hashtable;

/**
 * 997. Find the Town Judge
 * Time: O(n)
 * Space: O(n)
 *
 */
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] numberOfPeopleWhoTrust = new int[n];
        for (int[] t : trust) {
            numberOfPeopleWhoTrust[t[1] - 1]++;
            numberOfPeopleWhoTrust[t[0] - 1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < numberOfPeopleWhoTrust.length; i++) {
            if (numberOfPeopleWhoTrust[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
