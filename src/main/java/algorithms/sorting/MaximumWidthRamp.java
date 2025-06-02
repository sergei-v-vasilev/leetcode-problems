package algorithms.sorting;

import java.util.*;

/**
 * 962. Maximum Width Ramp
 */
public class MaximumWidthRamp {

    private class Pair {
        int value;
        int index;
    }

    public int maxWidthRamp(int[] nums) {
        Pair[] numsWithIndex = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Pair pair = new Pair();
            pair.value = nums[i];
            pair.index = i;
            numsWithIndex[i] = pair;
        }
        int width = 0;
        Arrays.sort(numsWithIndex, Comparator.comparingInt(o -> o.value));
        int minIndex = numsWithIndex.length - 1;
        for (int i = 0; i < numsWithIndex.length; i++) {
            width = Math.max(width, numsWithIndex[i].index - minIndex);
            minIndex = Math.min(numsWithIndex[i].index, minIndex);
        }
        return width;
    }
}
