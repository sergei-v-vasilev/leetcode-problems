package algorithms.graph.bfs;

import java.util.*;

/**
 * 433. Minimum Genetic Mutation
 *
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankMap = new HashSet<>(bank.length);
        for (String gene : bank) {
            bankMap.add(gene);
        }
        if (!bankMap.contains(end)) return -1;
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        int size;
        int path = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (!queue.isEmpty() && size > 0) {
                String n = queue.pollFirst();
                size--;
                for (String m : mutations(n)) {
                    if (bankMap.contains(m)) {
                        if (end.equals(m)) {
                            return path + 1;
                        } else {
                            queue.addLast(m);
                        }
                    }
                }
            }
            path++;
        }
        return -1;
    }

    private Set<String> mutations(String n) {
        Set<String> result = new HashSet<>();
        char[] ch = n.toCharArray();
        for (int i = 0; i < n.length(); i++) {
            if (ch[i] == 'A') {
                ch[i] = 'C';
                result.add(new String(ch));
                ch[i] = 'G';
                result.add(new String(ch));
                ch[i] = 'T';
                result.add(new String(ch));
                ch[i] = 'A';
            }
            if (ch[i] == 'C') {
                ch[i] = 'A';
                result.add(new String(ch));
                ch[i] = 'G';
                result.add(new String(ch));
                ch[i] = 'T';
                result.add(new String(ch));
                ch[i] = 'C';
            }
            if (ch[i] == 'G') {
                ch[i] = 'A';
                result.add(new String(ch));
                ch[i] = 'C';
                result.add(new String(ch));
                ch[i] = 'T';
                result.add(new String(ch));
                ch[i] = 'G';
            }
            if (ch[i] == 'T') {
                ch[i] = 'A';
                result.add(new String(ch));
                ch[i] = 'G';
                result.add(new String(ch));
                ch[i] = 'C';
                result.add(new String(ch));
                ch[i] = 'T';
            }
        }
        return result;
    }
}
