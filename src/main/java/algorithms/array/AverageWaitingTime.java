package algorithms.array;

/**
 * 1701. Average Waiting Time
 */
public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int whenChefIsFree = 0;
        long waitingTime = 0;
        for (int[] customer : customers) {
            if (whenChefIsFree <= customer[0]) {
                waitingTime += customer[1];
                whenChefIsFree = customer[0] + customer[1];
            } else {
                waitingTime += whenChefIsFree + customer[1] - customer[0];
                whenChefIsFree = whenChefIsFree + customer[1];
            }
        }
        return (double) waitingTime / customers.length;
    }
}
