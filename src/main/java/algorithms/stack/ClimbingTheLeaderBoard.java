package algorithms.stack;

import java.util.*;

/**
 * Climbing the leaderboard (https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true)
 */
public class ClimbingTheLeaderBoard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        LinkedList<Integer> scores = new LinkedList<>();
        for (int i = 0; i < ranked.size(); i++) {
            int rank = ranked.get(i);
            if (scores.isEmpty() || !scores.getLast().equals(rank)) {
                scores.addLast(rank);
            }
        }
        List<Integer> result = new ArrayList<>(player.size());
        for (int i = 0; i < player.size(); i++) {
            int p = player.get(i);
            while (scores.size() > 0 && p > scores.getLast()) {
                scores.pollLast();
            }
            result.add(scores.size() + (scores.size() > 0 && scores.getLast().equals(p) ? 0 : 1));
        }
        return result;
    }
}
