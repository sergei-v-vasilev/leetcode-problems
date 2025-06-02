package algorithms.math;

/**
 * 223. Rectangle Area
 * Time: O(1)
 * Space: O(1)
 *
 */
public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return calculateArea(ax1, ay1, ax2, ay2) + calculateArea(bx1, by1, bx2, by2) -
                Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1)) *
                        Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
    }

    private int calculateArea(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }
}
