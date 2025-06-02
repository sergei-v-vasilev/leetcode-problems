package algorithms.linkedlist;

import java.util.LinkedList;

/**
 * 1823. Find the Winner of the Circular Game
 * Time: O(n)
 * Space: O(n)
 *
 */
public class FindWinnerOfCircularGame {

    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int count = 1;
        int i = 0;
        while (list.size() > 1) {
            if (count < k) {
                if (i < list.size() - 1) {
                    i++;
                } else if (i == list.size() - 1) {
                    i = 0;
                }
                count++;
            } else {
                list.remove(i);
                if (i == list.size() - 1) {
                    i = 0;
                }
                count = 1;
            }
        }
        return list.getLast();
    }
}
