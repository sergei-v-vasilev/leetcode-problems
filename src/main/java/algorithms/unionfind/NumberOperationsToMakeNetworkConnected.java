package algorithms.unionfind;

/**
 * 1319. Number of Operations to Make Network Connected
 * Time: O(n * n * log (n))
 * Space: O(n)
 *
 */
public class NumberOperationsToMakeNetworkConnected {


    private class UnionFind {
        private int[] computers;
        private int[] sizes;

        UnionFind(int n) {
            computers = new int[n];
            sizes = new int[n];
            for (int i = 0; i < computers.length; i++) {
                computers[i] = i;
                sizes[i] = 1;
            }
        }

        int getRoot(int i) {
            if (computers[i] == i) return i;
            else return getRoot(computers[i]);
        }

        boolean union(int i, int j) {
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            if (rootI == rootJ) return true;
            if (sizes[rootI] > sizes[rootJ]) {
                computers[rootJ] = computers[rootI];
                sizes[rootI] += sizes[rootJ];
            } else {
                computers[rootI] = computers[rootJ];
                sizes[rootJ] += sizes[rootI];
            }
            return false;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        int numberOfExtraCable = 0;
        for (int i = 0; i < connections.length; i++) {
            int leftComputer = connections[i][0];
            int rightComputer = connections[i][1];
            if (unionFind.union(leftComputer, rightComputer)) {
                numberOfExtraCable++;
            }
        }
        int numberOfNetworks = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind.computers[i] == i) {
                numberOfNetworks++;
            }
        }
        if (numberOfNetworks - 1 > numberOfExtraCable) return -1;
        else return numberOfNetworks - 1;
    }
}
