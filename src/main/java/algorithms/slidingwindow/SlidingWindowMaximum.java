package algorithms.slidingwindow;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int pointer = 0;
        TreeSet<Integer> set = new TreeSet<>((l, r) -> {
            int compareResult = Integer.compare(nums[r], nums[l]);
            if (compareResult == 0) {
                compareResult = Integer.compare(l, r);
            }
            return compareResult;
        });
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        int start = 0;
        int end = k - 1;
        while (pointer < result.length) {
            result[pointer] = nums[set.first()];
            pointer++;
            set.remove(start);
            start++;
            end++;
            if (end < nums.length) {
                set.add(end);
            }
        }
        return result;
    }


    public int[] maxSlidingWindowWithQueue(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] result = new int[nums.length - k + 1];
        int max = map.lastKey();
        result[0] = max;
        for (int i = k; i < nums.length; i++) {
            //remove previous start
            int oldest = queue.removeFirst();
            if (map.get(oldest) > 1) {
                map.put(oldest, map.get(oldest) - 1);
            } else {
                map.remove(oldest);
            }
            //add new end
            queue.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = map.lastKey();
            result[i - k + 1] = max;
        }
        return result;
    }
}
