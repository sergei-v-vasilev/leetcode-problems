package algorithms.stack;

import java.util.LinkedList;

/**
 * 739. Daily Temperatures
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<int[]> stack = new LinkedList<>();
        stack.add(new int[]{temperatures[temperatures.length - 1], temperatures.length - 1});
        temperatures[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int size = 1;
            while (!stack.isEmpty() && temperatures[i] >= stack.getLast()[0]) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                size = stack.getLast()[1] - i;
            }
            stack.addLast(new int[]{temperatures[i], i});
            temperatures[i] = stack.size() == 1 ? 0 : size;
        }
        return temperatures;
    }
}
