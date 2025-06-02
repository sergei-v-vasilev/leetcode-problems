package algorithms.heap;

import java.util.*;

/**
 * 1642. Furthest Building You Can Reach
 * Time: O(n * log(ladders))
 * Space: O(ladders)
 */
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(heights.length);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < heights[i - 1]) continue;
            int diff = heights[i] - heights[i - 1];
            if (queue.size() < ladders) {
                queue.add(diff);
            } else {
                int bricksThatNeed;
                if (!queue.isEmpty() && queue.peek() < diff) {
                    bricksThatNeed = queue.poll();
                    queue.add(diff);
                } else {
                    bricksThatNeed = diff;
                }
                if (bricks >= bricksThatNeed) {
                    bricks -= bricksThatNeed;
                } else {
                    return i - 1;
                }
            }
        }
        return heights.length - 1;
    }

}
