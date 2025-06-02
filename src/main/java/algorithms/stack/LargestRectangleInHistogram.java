package algorithms.stack;

import java.util.LinkedList;

/**
 * 84. Largest Rectangle in Histogram
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                int height = heights[stack.pollLast()];
                int width = i - (stack.isEmpty() ? 0 : (stack.peekLast() + 1));
                maxArea = Math.max(maxArea, height * width);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pollLast()];
            int width = heights.length - (stack.isEmpty() ? 0 : (stack.peekLast() + 1));
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public int largestRectangleAreaOld(int[] heights) {
        int[] lessThanLeft = new int[heights.length];
        int[] lessThanRight = new int[heights.length];
        //int[0] = height of the bar, int[1] = index of the bar
        int max = Integer.MIN_VALUE;
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i]);
            if (i == 0) {
                lessThanLeft[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.getLast()[0] >= heights[i]) {
                    stack.pollLast();
                }
                int lessThenThat = stack.isEmpty() ? -1 : stack.getLast()[1];
                lessThanLeft[i] = lessThenThat;
            }
            stack.add(new int[]{heights[i], i});
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (i == heights.length - 1) {
                lessThanRight[i] = heights.length;
            } else {
                while (!stack.isEmpty() && stack.getLast()[0] >= heights[i]) {
                    stack.pollLast();
                }
                int lessThenThat = stack.isEmpty() ? heights.length : stack.getLast()[1];
                lessThanRight[i] = lessThenThat;
            }
            stack.add(new int[]{heights[i], i});
        }
        int result = max;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (lessThanRight[i] - lessThanLeft[i] - 1));
        }
        return result;
    }
}
