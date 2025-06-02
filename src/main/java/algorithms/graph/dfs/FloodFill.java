package algorithms.graph.dfs;

/**
 * 733. Flood Fill
 * Time: O(n*m)
 * Space: O(n*m)
 * 
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        return floodFill(image, sr, sc, image[sr][sc], newColor);
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        if (sr > 0) {
            if (image[sr - 1][sc] == oldColor) {
                image = floodFill(image, sr - 1, sc, oldColor, newColor);
            }
        }
        if (sc > 0) {
            if (image[sr][sc - 1] == oldColor) {
                image = floodFill(image, sr, sc - 1, oldColor, newColor);
            }
        }
        if (sr < image.length - 1) {
            if (image[sr + 1][sc] == oldColor) {
                image = floodFill(image, sr + 1, sc, oldColor, newColor);
            }
        }
        if (sc < image[sr].length - 1) {
            if (image[sr][sc + 1] == oldColor) {
                image = floodFill(image, sr, sc + 1, oldColor, newColor);
            }
        }
        return image;
    }
}
