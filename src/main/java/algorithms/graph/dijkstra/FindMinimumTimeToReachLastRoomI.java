package algorithms.graph.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3341. Find Minimum Time to Reach Last Room I
 */
public class FindMinimumTimeToReachLastRoomI {

    private class Room {
        int i;
        int j;

        Room(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] timing = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                timing[i][j] = Integer.MAX_VALUE;
            }
        }
        timing[0][0] = 0;
        PriorityQueue<Room> queue = new PriorityQueue<>(m * n, Comparator.comparingInt(a -> timing[a.i][a.j]));
        queue.add(new Room(0, 0));
        while (!queue.isEmpty()) {
            Room room = queue.poll();
            int i = room.i;
            int j = room.j;
            //up
            if (i > 0 && timing[i - 1][j] > Math.max(moveTime[i - 1][j] + 1, timing[i][j] + 1)) {
                timing[i - 1][j] = Math.max(moveTime[i - 1][j] + 1, timing[i][j] + 1);
                queue.add(new Room(i - 1, j));
            }
            //right
            if (j < m - 1 && timing[i][j + 1] > Math.max(moveTime[i][j + 1] + 1, timing[i][j] + 1)) {
                timing[i][j + 1] = Math.max(moveTime[i][j + 1] + 1, timing[i][j] + 1);
                queue.add(new Room(i, j + 1));
            }
            //down
            if (i < n - 1 && timing[i + 1][j] > Math.max(moveTime[i + 1][j] + 1, timing[i][j] + 1)) {
                timing[i + 1][j] = Math.max(moveTime[i + 1][j] + 1, timing[i][j] + 1);
                queue.add(new Room(i + 1, j));
            }
            //left
            if (j > 0 && timing[i][j - 1] > Math.max(moveTime[i][j - 1] + 1, timing[i][j] + 1)) {
                timing[i][j - 1] = Math.max(moveTime[i][j - 1] + 1, timing[i][j] + 1);
                queue.add(new Room(i, j - 1));
            }
        }
        return timing[n - 1][m - 1];
    }

}
