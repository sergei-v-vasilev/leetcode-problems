package algorithms.unionfind;

/**
 * 547. Number of Provinces
 *
 * Time: O(n * n * log (n))
 * Space: O(n)
 */
public class NumberOfProvinces {

    private class UnionFind {
        private int[] cities;
        private int[] sizes;

        UnionFind(int n) {
            cities = new int[n];
            sizes = new int[n];
            for (int i = 0; i < cities.length; i++) {
                cities[i] = i;
                sizes[i] = 1;
            }
        }

        int getRootCity(int i) {
            if (cities[i] == i) return i;
            else return getRootCity(cities[i]);
        }

        void union(int i, int j) {
            int rootCityI = getRootCity(i);
            int rootCityJ = getRootCity(j);
            if (rootCityI == rootCityJ) return;
            if (sizes[rootCityI] > sizes[rootCityJ]) {
                cities[rootCityJ] = cities[rootCityI];
                sizes[rootCityI] += sizes[rootCityJ];
            } else {
                cities[rootCityI] = cities[rootCityJ];
                sizes[rootCityJ] += sizes[rootCityI];
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (unionFind.cities[i] == i) count++;
        }
        return count;
    }
}
