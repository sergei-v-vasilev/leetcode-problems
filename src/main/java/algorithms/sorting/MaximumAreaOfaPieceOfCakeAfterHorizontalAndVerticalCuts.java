package algorithms.sorting;

import java.util.Arrays;

/**
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * 
 */
public class MaximumAreaOfaPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = 0;
        for (int i = 0; i < horizontalCuts.length; i++) {
            if (i == 0) {
                maxH = Math.max(maxH, horizontalCuts[0]);
            } else {
                maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        int maxW = 0;
        for (int i = 0; i < verticalCuts.length; i++) {
            if (i == 0) {
                maxW = Math.max(maxW, verticalCuts[0]);
            } else {
                maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
            }
        }
        maxW = Math.max(maxW, w - verticalCuts[verticalCuts.length - 1]);
        long result = maxH * maxW % 1000000007;
        return (int) result;
    }
}
