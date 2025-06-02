package algorithms.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 636. Exclusive Time of Functions
 */
public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        LinkedList<int[]> stack = new LinkedList<>();
        Integer lastExecutedFunctionTime = null;
        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            boolean isStart = "start".equals(parts[1]);
            int time = Integer.parseInt(parts[2]);
            if (isStart) {
                if (!stack.isEmpty()) {
                    int[] previous = stack.peekLast();
                    int previousFunctionId = previous[0];
                    int previousTime = previous[1];
                    if (lastExecutedFunctionTime != null) {
                        result[previousFunctionId] += time - lastExecutedFunctionTime - 1;
                        lastExecutedFunctionTime = null;
                    } else {
                        result[previousFunctionId] += time - previousTime;
                    }
                }
                stack.addLast(new int[]{functionId, time});
            } else {
                int[] previous = stack.pollLast();
                int previousFunctionId = previous[0];
                int previousTime = previous[1];
                if (lastExecutedFunctionTime != null) {
                    result[previousFunctionId] += time - lastExecutedFunctionTime;
                } else {
                    result[previousFunctionId] += time - previousTime + 1;
                }
                lastExecutedFunctionTime = time;
            }
        }
        return result;
    }

}
