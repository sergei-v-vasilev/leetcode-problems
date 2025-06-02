package algorithms.math;

/**
 * 1762. Buildings With an Ocean View
 */
public class BuildingsWithAnOceanView {

    public int[] findBuildings(int[] heights) {
        int max = heights[heights.length - 1];
        heights[heights.length - 1] = -heights[heights.length - 1];
        int size = 1;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > max) {
                size++;
                max = heights[i];
                heights[i] = -heights[i];
            }
        }
        int[] result = new int[size];
        int index = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < 0) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }
}
