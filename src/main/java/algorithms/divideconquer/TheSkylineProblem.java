package algorithms.divideconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 218. The Skyline Problem
 * 
 */
public class TheSkylineProblem {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        return divideAndMerge(0, buildings.length - 1, buildings);
    }

    private static List<List<Integer>> divideAndMerge(int start, int end, int[][] buildings) {
        if (start == end) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> startPoint = new ArrayList<>(2);
            List<Integer> endPoint = new ArrayList<>(2);
            startPoint.add(buildings[start][0]);
            startPoint.add(buildings[start][2]);
            endPoint.add(buildings[start][1]);
            endPoint.add(0);
            result.add(startPoint);
            result.add(endPoint);
            return result;
        } else {
            int mid = start + (end - start) / 2;
            List<List<Integer>> leftResult = divideAndMerge(start, mid, buildings);
            List<List<Integer>> rightResult = divideAndMerge(mid + 1, end, buildings);
            return merge(leftResult, rightResult);
        }
    }

    private static List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        int skyline = 0;
        int location = 0;
        int lastLeftHeight = 0;
        int lastRightHeight = 0;
        while (l < left.size() && r < right.size()) {
            int leftHeight = left.get(l).get(1);
            int rightHeight = right.get(r).get(1);
            int leftPoint = left.get(l).get(0);
            int rightPoint = right.get(r).get(0);
            if (leftPoint == rightPoint) {
                location = leftPoint;
                lastLeftHeight = leftHeight;
                lastRightHeight = rightHeight;
                l++;
                r++;
            } else if (leftPoint < rightPoint) {
                location = leftPoint;
                lastLeftHeight = leftHeight;
                l++;
            } else {
                location = rightPoint;
                lastRightHeight = rightHeight;
                r++;
            }

            if (skyline != Math.max(lastLeftHeight, lastRightHeight)) {
                skyline = Math.max(lastLeftHeight, lastRightHeight);
                List<Integer> point = new ArrayList<>(2);
                point.add(location);
                point.add(skyline);
                result.add(point);
            }
        }
        result = handleRest(left, skyline, l, result);
        result = handleRest(right, skyline, r, result);
        return result;
    }

    private static List<List<Integer>> handleRest(List<List<Integer>> list, int skyline, int index,
                                                  List<List<Integer>> result) {
        while (index < list.size()) {
            int location = list.get(index).get(0);
            int height = list.get(index).get(1);
            if (skyline != height) {
                skyline = height;
                List<Integer> point = new ArrayList<>(2);
                point.add(location);
                point.add(height);
                result.add(point);
            }
            index++;
        }
        return result;
    }
}
