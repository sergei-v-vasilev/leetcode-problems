package algorithms.unionfind;

import java.util.*;

/**
 * 737. Sentence Similarity II
 */
public class SentenceSimilarityII {

    private class UnionFind {
        int[] roots;
        int[] sizes;
        Map<String, Integer> indexMap = new HashMap<>();

        public UnionFind(List<List<String>> sentences) {
            int n = 2 * sentences.size() + 1;
            roots = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                sizes[i] = 1;
            }
            int index = 0;
            for (List<String> sentence : sentences) {
                String word1 = sentence.get(0);
                String word2 = sentence.get(1);
                if (!indexMap.containsKey(word1)) {
                    this.indexMap.put(word1, index);
                    index++;
                }
                if (!indexMap.containsKey(word2)) {
                    this.indexMap.put(word2, index);
                    index++;
                }
            }
        }

        public int getRoot(int i) {
            if (i == roots[i]) {
                return i;
            }
            return getRoot(roots[i]);
        }

        public void union(String word1, String word2) {
            int i = this.indexMap.get(word1);
            int j = this.indexMap.get(word2);
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            if (rootI == rootJ) {
                return;
            }
            if (sizes[rootI] < sizes[rootJ]) {
                roots[rootI] = rootJ;
                sizes[rootJ] += sizes[rootI];
            } else {
                roots[rootJ] = rootI;
                sizes[rootI] += sizes[rootJ];
            }
        }

        public boolean isSimilar(String word1, String word2) {
            if (word1.equals(word2)) {
                return true;
            }
            Integer index1 = this.indexMap.get(word1);
            Integer index2 = this.indexMap.get(word2);
            if (index1 == null || index2 == null) {
                return false;
            }
            return getRoot(index1) == getRoot(index2);
        }
    }

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        UnionFind unionFind = new UnionFind(similarPairs);

        for (List<String> sentence : similarPairs) {
            String word1 = sentence.get(0);
            String word2 = sentence.get(1);
            unionFind.union(word1, word2);
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (!unionFind.isSimilar(sentence1[i], sentence2[i])) {
                return false;
            }
        }
        return true;
    }

}
