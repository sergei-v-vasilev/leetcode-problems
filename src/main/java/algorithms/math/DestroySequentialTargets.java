package algorithms.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 2453. (M) Destroy Sequential Targets
 */
public class DestroySequentialTargets {

    public int destroyTargets(int[] nums, int space) {
        //<mod, value of seed>
        Map<Integer, Integer> seedValue = new HashMap<>();
        //<mod, number of targets>
        Map<Integer, Integer> seedOutcome = new HashMap<>();
        for (int num : nums) {
            int key = num % space;
            seedValue.put(key, Math.min(seedValue.getOrDefault(key, Integer.MAX_VALUE), num));
            seedOutcome.put(key, seedOutcome.getOrDefault(key, 0) + 1);
        }
        int targets = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for(int key : seedOutcome.keySet()) {
            if(targets < seedOutcome.get(key)) {
                targets = seedOutcome.get(key);
                result = seedValue.get(key);
            } else if(targets == seedOutcome.get(key)) {
                result = Math.min(result, seedValue.get(key));
            }
        }
        return result;
    }

}
