package algorithms.dp.top;


/**
 * 787. Cheapest Flights Within K Stops
 * Time: O(n * n)
 * Space: O(n * n * k)
 * 
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        int result = findCheapestPrice(graph, src, dst, k + 1, new int[n][n][k + 2]);
        return result == 100000 ? -1 : result;
    }

    private int findCheapestPrice(int[][] graph, int src, int dst, int leftStops, int[][][] memo) {
        if (src == dst) {
            return 0;
        }
        if (leftStops == 0) {
            return 100000;
        }
        if (memo[src][dst][leftStops] != 0) {
            return memo[src][dst][leftStops];
        }
        int min = 100000;
        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] != 0) {
                min = Math.min(min, findCheapestPrice(graph, i, dst, leftStops - 1, memo) + graph[src][i]);
            }
        }
        memo[src][dst][leftStops] = min;
        return min;
    }
}
