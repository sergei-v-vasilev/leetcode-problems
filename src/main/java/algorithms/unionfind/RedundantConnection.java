package algorithms.unionfind;

/**
 * 684. Redundant Connection
 */
public class RedundantConnection {

    private class UnionFind {
        private int[] roots;
        private int[] sizes;

        public UnionFind(int n) {
            roots = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                sizes[i] = 1;
            }
        }

        public int getRoot(int x) {
            if (x == roots[x]) {
                return x;
            }
            return getRoot(roots[x]);
        }

        public boolean isConnected(int x, int y) {
            return getRoot(x) == getRoot(y);
        }

        public void union(int a, int b) {
            int rootA = getRoot(a);
            int rootB = getRoot(b);
            if (rootA == rootB) {
                return;
            }
            if (sizes[rootA] < sizes[rootB]) {
                roots[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
            } else {
                roots[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            if (uf.isConnected(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                uf.union(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

}
