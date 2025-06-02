package algorithms.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 1061. Lexicographically Smallest Equivalent String
 *
 */
public class LexicographicallySmallestEquivalentString {

    private class LexicalUnionFind {
        int[] chars;

        int[] sizes;

        Map<Integer, Character> smallestChar;

        public LexicalUnionFind() {
            chars = new int[27];
            sizes = new int[27];
            smallestChar = new HashMap<>(27);
            for (int i = 0; i < 27; i++) {
                chars[i] = i;
                sizes[i] = 1;
                smallestChar.put(i, (char) (i + 'a'));
            }
        }

        public int root(int i) {
            if (chars[i] == i) {
                return i;
            } else {
                return root(chars[i]);
            }
        }

        public void union(int i, int j) {
            int rootI = root(i);
            int rootJ = root(j);
            if (rootI != rootJ) {
                if (sizes[i] < sizes[j]) {
                    chars[rootI] = rootJ;
                    sizes[j] += sizes[i];
                    handleSmallestChar(rootJ, rootI);
                } else {
                    chars[rootJ] = rootI;
                    sizes[i] += sizes[j];
                    handleSmallestChar(rootI, rootJ);
                }
            }
        }

        public void handleSmallestChar(int root, int rootToConnect) {
            char rootChar = smallestChar.get(root);
            char rootToConnectChar = smallestChar.get(rootToConnect);
            if (rootToConnectChar < rootChar) {
                smallestChar.put(root, rootToConnectChar);
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        LexicalUnionFind unionFind = new LexicalUnionFind();
        for (int i = 0; i < s1.length(); i++) {
            unionFind.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int root = unionFind.root(baseStr.charAt(i) - 'a');
            char smallestLetter = unionFind.smallestChar.get(root);
            if (smallestLetter < baseStr.charAt(i)) {
                builder.append(smallestLetter);
            } else {
                builder.append(baseStr.charAt(i));
            }
        }
        return builder.toString();
    }
}
