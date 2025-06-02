package algorithms.unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. Number of Islands II
 */
public class NumberOfIslandsII {

    private static class UnionFind {
        private final int[] root;
        private final int[] size;
        private final boolean[] isLand;

        public UnionFind(int n) {
            this.root = new int[n];
            this.size = new int[n];
            this.isLand = new boolean[n];
            for (int i = 0; i < n; i++) {
                this.root[i] = i;
                this.size[i] = 1;
            }
        }

        public int getRoot(int i) {
            if (i == root[i]) return i;
            else return getRoot(root[i]);
        }

        public boolean union(int i, int j) {
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            if (rootI == rootJ) return false;

            if (size[rootI] < size[rootJ]) {
                root[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                root[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
            return true;
        }

        public boolean isLand(int i) {
            return isLand[i];
        }

        public void setLand(int i) {
            isLand[i] = true;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m * n);
        int landCount = 0;
        List<Integer> islands = new ArrayList<>(positions.length);
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            int index = n * position[0] + position[1];
            if (unionFind.isLand(index)) {
                islands.add(landCount);
                continue;
            }
            unionFind.setLand(index);
            landCount++;
            //up
            if (position[0] > 0 && unionFind.isLand(n * (position[0] - 1) + position[1])) {
                boolean wasNotConnected = unionFind.union(n * (position[0] - 1) + position[1], index);
                if (wasNotConnected) {
                    landCount--;
                }
            }
            //right
            if (position[1] < n - 1 && unionFind.isLand(n * position[0] + position[1] + 1)) {
                boolean wasNotConnected = unionFind.union(n * position[0] + position[1] + 1, index);
                if (wasNotConnected) {
                    landCount--;
                }
            }
            //bottom
            if (position[0] < m - 1 && unionFind.isLand(n * (position[0] + 1) + position[1])) {
                boolean wasNotConnected = unionFind.union(n * (position[0] + 1) + position[1], index);
                if (wasNotConnected) {
                    landCount--;
                }
            }
            //left
            if (position[1] > 0 && unionFind.isLand(n * position[0] + position[1] - 1)) {
                boolean wasNotConnected = unionFind.union(n * position[0] + position[1] - 1, index);
                if (wasNotConnected) {
                    landCount--;
                }
            }
            islands.add(landCount);
        }
        return islands;
    }

}
