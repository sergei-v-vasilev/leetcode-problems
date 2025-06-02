package algorithms.twopointers;

/**
 * 42. Trapping Rain Water
 * Time: O(n)
 * Space: O(1)
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0;
        int tempLeft = 0;
        int tempRight = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        for (int i = 0; i < height.length; i++) {
            //from left to right
            if (maxLeft > height[i]) {
                tempLeft += maxLeft - height[i];
            } else {
                water += tempLeft;
                tempLeft = 0;
                maxLeft = height[i];
            }
            //from right to left
            if (maxRight > height[height.length - 1 - i]) {
                tempRight += maxRight - height[height.length - 1 - i];
            } else if (maxRight < height[height.length - 1 - i]) {
                water += tempRight;
                tempRight = 0;
                maxRight = height[height.length - 1 - i];
            }
        }
        return water;
    }
}
