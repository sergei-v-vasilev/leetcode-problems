package algorithms.graph.dfs;

/**
 * 785. Is Graph Bipartite?
 *
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0 && dfs(i, graph, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int[][] graph, int[] colors, int color) {
        if (colors[i] != 0 && colors[i] != color) {
            return true;
        } else if (colors[i] != 0 && colors[i] == color) {
            return false;
        }
        colors[i] = color;
        int nextColor = color == 1 ? -1 : 1;
        for (int adjacent : graph[i]) {
            if (dfs(adjacent, graph, colors, nextColor)) {
                return true;
            }
        }
        return false;
    }
}
