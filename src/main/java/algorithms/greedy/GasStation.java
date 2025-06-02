package algorithms.greedy;

/**
 * 134. Gas Station
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int result = -1;
        int currentCost;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            currentCost = gas[i] - cost[i];
            totalCost += currentCost;
            tank += currentCost;
            if (tank < 0) {
                result = -1;
                tank = 0;
            } else if (result == -1) {
                result = i;
            }
        }
        return totalCost < 0 ? -1 : result;
    }
}
