package algorithms.graph.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3342. Find Minimum Time to Reach Last Room II
 */
public class FindMinimumTimeToReachLastRoomII {

    private class Room {
        int i;
        int j;
        int moveTime;

        public Room(int i, int j, int moveTime) {
            this.i = i;
            this.j = j;
            this.moveTime = moveTime;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] times = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                times[i][j] = Integer.MAX_VALUE;
            }
        }
        times[0][0] = 0;
        PriorityQueue<Room> queue = new PriorityQueue<>(Comparator.comparingInt(a -> times[a.i][a.j]));
        queue.add(new Room(0, 0, 1));
        while (!queue.isEmpty()) {
            Room room = queue.poll();
            int i = room.i;
            int j = room.j;
            int nextMoveTime = room.moveTime == 1 ? 2 : 1;
            //up
            if (i > 0 && times[i - 1][j] > Math.max(times[i][j], moveTime[i - 1][j]) + room.moveTime) {
                times[i - 1][j] = Math.max(times[i][j], moveTime[i - 1][j]) + room.moveTime;
                queue.add(new Room(i - 1, j, nextMoveTime));
            }
            //right
            if (j < m - 1 && times[i][j + 1] > Math.max(times[i][j], moveTime[i][j + 1]) + room.moveTime) {
                times[i][j + 1] = Math.max(times[i][j], moveTime[i][j + 1]) + room.moveTime;
                queue.add(new Room(i, j + 1, nextMoveTime));
            }
            //down
            if (i < n - 1 && times[i + 1][j] > Math.max(times[i][j], moveTime[i + 1][j]) + room.moveTime) {
                times[i + 1][j] = Math.max(times[i][j], moveTime[i + 1][j]) + room.moveTime;
                queue.add(new Room(i + 1, j, nextMoveTime));
            }
            //left
            if (j > 0 && times[i][j - 1] > Math.max(times[i][j], moveTime[i][j - 1]) + room.moveTime) {
                times[i][j - 1] = Math.max(times[i][j], moveTime[i][j - 1]) + room.moveTime;
                queue.add(new Room(i, j - 1, nextMoveTime));
            }
        }
        return times[n - 1][m - 1];
    }

}
