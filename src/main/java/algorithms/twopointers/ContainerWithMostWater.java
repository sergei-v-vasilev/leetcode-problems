package algorithms.twopointers;

/**
 * 11. Container With Most Water
 * Time: O(n)
 * Space: O(1)
 * <p>
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            if (height[right] < height[left]) {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            } else {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }
        }
        return max;
    }
}
