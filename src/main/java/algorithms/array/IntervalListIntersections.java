package algorithms.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 986. Interval List Intersections
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int first = 0;
        int second = 0;
        List<int[]> result = new LinkedList<>();
        while (first < firstList.length && second < secondList.length) {
            // [a---b]
            //    x
            if (firstList[first][0] <= secondList[second][0] && secondList[second][0] <= firstList[first][1]) {
                // [a-------b]
                //    [x-y]
                if (secondList[second][1] <= firstList[first][1]) {
                    result.add(new int[]{secondList[second][0], secondList[second][1]});
                    second++;
                } else {
                    // [a-------b]
                    //    [x-------y]
                    result.add(new int[]{secondList[second][0], firstList[first][1]});
                    first++;
                }
            } else
                //    a
                // [x---y]
                if (secondList[second][0] <= firstList[first][0] && firstList[first][0] <= secondList[second][1]) {
                    //      [a--b]
                    //    [x------y]
                    if (firstList[first][1] <= secondList[second][1]) {
                        result.add(new int[]{firstList[first][0], firstList[first][1]});
                        first++;
                    } else {
                        //     [a-------b]
                        // [x-------y]
                        result.add(new int[]{firstList[first][0], secondList[second][1]});
                        second++;
                    }
                } else
                    // [a---b]
                    //         x
                    if (firstList[first][1] < secondList[second][0]) {
                        first++;
                    } else
                        //          a
                        // [x---y]
                        if (secondList[second][1] < firstList[first][0]) {
                            second++;
                        }

        }
        return result.toArray(new int[result.size()][]);
    }

}
