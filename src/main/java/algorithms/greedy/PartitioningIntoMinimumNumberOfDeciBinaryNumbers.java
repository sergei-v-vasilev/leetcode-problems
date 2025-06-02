package algorithms.greedy;

/**
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int maxDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
        }
        return maxDigit;
    }
}
