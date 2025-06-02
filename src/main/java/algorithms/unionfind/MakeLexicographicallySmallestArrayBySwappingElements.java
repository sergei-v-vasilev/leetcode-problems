package algorithms.unionfind;

import java.util.*;

/**
 * 2948. Make Lexicographically Smallest Array by Swapping Elements
 */
public class MakeLexicographicallySmallestArrayBySwappingElements {

    private static class UnionFind {
        Map<Integer, Integer> roots;
        Map<Integer, PriorityQueue<Integer>> weights;

        public UnionFind(int[] nums) {
            roots = new HashMap<>();
            weights = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                roots.put(nums[i], nums[i]);
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                heap.add(nums[i]);
                weights.put(nums[i], heap);
            }
        }

        public int getRoot(int i) {
            if (i == roots.get(i)) {
                return i;
            } else {
                return getRoot(roots.get(i));
            }
        }

        public void union(int i, int j) {
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            if (rootI == rootJ) {
                return;
            }
            if (weights.get(rootI).size() > weights.get(rootJ).size()) {
                roots.put(rootJ, rootI);
                weights.get(rootI).addAll(weights.get(rootJ));
            } else {
                roots.put(rootI, rootJ);
                weights.get(rootJ).addAll(weights.get(rootI));
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        UnionFind unionFind = new UnionFind(nums);
        int[] sortedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArray);
        for (int i = 0; i < sortedArray.length; i++) {
            if (i > 0 && sortedArray[i] - sortedArray[i - 1] <= limit) {
                unionFind.union(sortedArray[i], sortedArray[i - 1]);
            }
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < sortedArray.length; i++) {
            if (visited.contains(sortedArray[i])) {
                unionFind.weights.get(unionFind.getRoot(sortedArray[i])).add(sortedArray[i]);
            }
            visited.add(sortedArray[i]);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int root = unionFind.getRoot(nums[i]);
            int value = unionFind.weights.get(root).poll();
            result[i] = value;
        }
        return result;
    }
}
