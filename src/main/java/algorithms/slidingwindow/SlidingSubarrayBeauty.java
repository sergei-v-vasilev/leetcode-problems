package algorithms.slidingwindow;

import java.util.*;

/**
 * 2653. (M) Sliding Subarray Beauty
 */
public class SlidingSubarrayBeauty {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] frequencies = new int[51];
        int[] result = new int[nums.length - k + 1];
        int negativeSize = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                frequencies[-nums[i]]++;
                negativeSize++;
            }
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (negativeSize < x) {
                result[i] = 0;
            } else {
                result[i] = getKthSmallest(frequencies, x);
            }
            if (nums[i] < 0) {
                frequencies[-nums[i]]--;
                negativeSize--;
            }
            if (i + k < nums.length && nums[i + k] < 0) {
                frequencies[-nums[i + k]]++;
                negativeSize++;
            }
        }
        return result;
    }

    private int getKthSmallest(int[] frequencies, int k) {
        int count = 0;
        for (int i = frequencies.length - 1; i > 0; i--) {
            int frequency = frequencies[i];
            count += frequency;
            if (count >= k) {
                return -i;
            }
        }
        return 0;
    }


    // TreeMap implementation, non-optimal
    public int[] getSubarrayBeautyTreeMap(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[nums.length - k + 1];
        int negativeSize = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                negativeSize++;
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (negativeSize < x) {
                result[i] = 0;
            } else {
                result[i] = getKthSmallest(map, x);
            }
            if (nums[i] < 0) {
                remove(nums[i], map);
                negativeSize--;
            }
            if (i + k < nums.length && nums[i + k] < 0) {
                map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1);
                negativeSize++;
            }
        }
        return result;
    }

    private int getKthSmallest(TreeMap<Integer, Integer> map, int k) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count >= k) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private void remove(int n, TreeMap<Integer, Integer> map) {
        map.put(n, map.get(n) - 1);
        if (map.get(n) == 0) {
            map.remove(n);
        }
    }

}
