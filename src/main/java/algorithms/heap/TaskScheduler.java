package algorithms.heap;


import java.util.PriorityQueue;

/**
 * 621. Task Scheduler
 * Time: O(n)
 * Space: O(1)
 *
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char task : tasks) {
            frequency[task - 'A']++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(26, (l, r) -> {
            if (frequency[l - 'A'] == frequency[r - 'A']) return Character.compare(l, r);
            else return Integer.compare(frequency[r - 'A'], frequency[l - 'A']);
        });
        PriorityQueue<Character> latestProcessedTasks = new PriorityQueue<>(26, (l, r) -> {
            if (frequency[l - 'A'] == frequency[r - 'A']) return Character.compare(l, r);
            else return Integer.compare(frequency[r - 'A'], frequency[l - 'A']);
        });
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                queue.add((char) (i + 'A'));
            }
        }
        int step = 0;
        int size;
        while (!queue.isEmpty()) {
            size = n + 1;
            while (size > 0 && !queue.isEmpty()) {
                char task = queue.poll();
                frequency[task - 'A']--;
                step++;
                if (frequency[task - 'A'] > 0) {
                    latestProcessedTasks.add(task);
                }
                size--;
            }
            step += latestProcessedTasks.isEmpty() ? 0 : size;
            queue.addAll(latestProcessedTasks);
            latestProcessedTasks.clear();
        }
        return step;
    }
}
