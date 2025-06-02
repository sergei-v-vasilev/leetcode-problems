package algorithms.stack;


/**
 * 85. Maximal Rectangle
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, lr.largestRectangleArea(heights));
        }
        return maxArea;
    }

}
