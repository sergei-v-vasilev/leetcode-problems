package algorithms.unionfind;

/**
 * 990. Satisfiability of Equality Equations
 * 23.33
 */
public class SatisfiabilityOfEqualityEquations {

    private class UnionFind {
        int[] values;
        int[] sizes;

        public UnionFind(int n) {
            values = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = i;
                sizes[i] = 1;
            }
        }

        public int root(int i) {
            if (values[i] == i) {
                return i;
            }
            return root(values[i]);
        }

        public void union(int i, int j) {
            int rootI = root(i);
            int rootJ = root(j);
            if (rootI == rootJ) return;
            if (sizes[rootI] < sizes[rootJ]) {
                values[rootI] = rootJ;
                sizes[rootJ] += rootI;
            } else {
                values[rootJ] = rootI;
                sizes[rootI] += rootJ;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=' && equation.charAt(2) == '=') {
                int l = equation.charAt(0) - 'a';
                int r = equation.charAt(3) - 'a';
                unionFind.union(l, r);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && equation.charAt(2) == '=') {
                int l = equation.charAt(0) - 'a';
                int r = equation.charAt(3) - 'a';
                if (unionFind.root(l) == unionFind.root(r)) {
                    return false;
                }
            }
        }
        return true;
    }
}
