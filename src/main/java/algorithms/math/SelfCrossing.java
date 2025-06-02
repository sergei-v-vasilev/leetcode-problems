package algorithms.math;

/**
 * 335. Self Crossing
 * Time: O(n)
 * Space: O(1)
 * 1h
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        if (distance.length < 4) {
            return false;
        }
        //outward circling
        int i = 2;
        while (i < distance.length && distance[i - 2] < distance[i]) {
            i++;
        }
        if (i == distance.length) {
            return false; // contains only outward circle
        }
        //check if there are some intersections between inward and outward circle
        if (i > 2 && distance[i - 1] <= distance[i - 3]) {
            return true;
        }
        if (i < distance.length - 1 && i > 2 && distance[i] == distance[i - 2] && distance[i + 1] + distance[i - 3] >= distance[i - 1]) {
            return true;
        }
        if (i < distance.length - 1 && i > 3 && distance[i + 1] + distance[i - 3] >= distance[i - 1] && distance[i] + distance[i - 4] >= distance[i - 2]) {
            return true;
        }
        //inward circling
        while (i < distance.length && distance[i - 2] > distance[i]) {
            i++;
        }
        return i < distance.length;
    }
}
