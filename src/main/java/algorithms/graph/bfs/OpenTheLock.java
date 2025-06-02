package algorithms.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 752. Open the Lock
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class OpenTheLock {

    public static int openLock(String[] deadEnds, String target) {
        String lock = "0000";
        Set<String> stuck = new HashSet<>(deadEnds.length);
        Set<String> visited = new HashSet<>();
        for (String d : deadEnds) {
            stuck.add(d);
            if (d.equals(lock)) return -1;
        }
        LinkedList<String> queue = new LinkedList<>();
        int size;
        int turns = 0;
        queue.add(lock);
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                String curLock = queue.poll();
                size--;
                if (curLock.equals(target)) {
                    return turns;
                }
                for (int i = 0; i < 4; i++) {
                    char curDigit = curLock.charAt(i);
                    int nextDigit = curDigit - '0';
                    String downLock = curLock.substring(0, i) + (nextDigit != 9 ? (nextDigit + 1) : 0) + curLock.substring(i + 1);
                    String upLock = curLock.substring(0, i) + (nextDigit != 0 ? (nextDigit - 1) : 9) + curLock.substring(i + 1);
                    if (!stuck.contains(downLock) && !visited.contains(downLock)) {
                        queue.offer(downLock);
                        visited.add(downLock);
                    }
                    if (!stuck.contains(upLock) && !visited.contains(upLock)) {
                        queue.offer(upLock);
                        visited.add(upLock);
                    }
                }

            }
            turns++;

        }
        return -1;
    }
}

