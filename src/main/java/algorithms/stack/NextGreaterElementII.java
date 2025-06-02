package algorithms.stack;

import java.util.LinkedList;

/**
 * 503. Next Greater Element II
 * Time: O(n)
 * Space: O(n)
 *
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        int current;
        for (int i = nums.length - 1; i >= 0; i--) {
            current = nums[i];
            if (list.isEmpty()) result[i] = -1;
            else {
                while (!list.isEmpty() && list.getLast() <= current) {
                    list.pollLast();
                }
                if (list.isEmpty()) result[i] = -1;
                else result[i] = list.getLast();
            }
            list.addLast(current);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            current = nums[i];
            if (!list.isEmpty()) {
                while (!list.isEmpty() && list.getLast() <= current) {
                    list.pollLast();
                }
                if (!list.isEmpty()) result[i] = list.getLast();
            }
            list.addLast(current);
        }
        return result;
    }
}
