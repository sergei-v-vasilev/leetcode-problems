package algorithms.graph.bfs;

import java.util.LinkedList;

/**
 * 1765. Map of Highest Peak
 * 19.25
 */
public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] isWater) {
        LinkedList<int[]> peaks = new LinkedList<>();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    visited[i][j] = true;
                    isWater[i][j] = 0;
                    addToQueue(i, j, 0, visited, isWater, peaks);
                }
            }
        }
        while (!peaks.isEmpty()) {
            int[] peak = peaks.poll();
            int i = peak[0];
            int j = peak[1];
            int height = peak[2] + 1;
            isWater[i][j] = height;
            addToQueue(i, j, height, visited, isWater, peaks);
        }
        return isWater;
    }

    private void addToQueue(int i, int j, int height, boolean[][] visited, int[][] isWater, LinkedList<int[]> peaks) {
        if (i > 0 && isWater[i - 1][j] == 0 && !visited[i - 1][j]) {
            peaks.add(new int[]{i - 1, j, height});
            visited[i - 1][j] = true;
        }
        if (j > 0 && isWater[i][j - 1] == 0 && !visited[i][j - 1]) {
            peaks.add(new int[]{i, j - 1, height});
            visited[i][j - 1] = true;
        }
        if (i < isWater.length - 1 && isWater[i + 1][j] == 0 && !visited[i + 1][j]) {
            peaks.add(new int[]{i + 1, j, height});
            visited[i + 1][j] = true;
        }
        if (j < isWater[i].length - 1 && isWater[i][j + 1] == 0 && !visited[i][j + 1]) {
            peaks.add(new int[]{i, j + 1, height});
            visited[i][j + 1] = true;
        }
    }
}
