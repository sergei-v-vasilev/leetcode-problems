package algorithms.randomized.reservoir.sampling;

import java.util.*;

/**
 * 398. Random Pick Index
 *
 */
public class RandomPickIndex {

    private int[] nums;
    private Random random;
    private Map<Integer, List<Integer>> indexMap;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
        indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = indexMap.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            indexMap.put(nums[i], indices);
        }
    }

    /**
     * Time: O(1)
     */
    public int pick(int target) {
        List<Integer> indices = indexMap.getOrDefault(target, new ArrayList<>());
        int index = random.nextInt(indices.size());
        return indices.get(index);
    }

    /**
     * Time: O(n)
     */
    public int pickWithReservoirSampling(int target) {
        int k = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (random.nextInt(k + 1) == 0) {
                    index = i;
                }
                k++;
            }
        }
        return index;
    }
}
