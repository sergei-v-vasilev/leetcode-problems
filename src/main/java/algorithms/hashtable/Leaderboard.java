package algorithms.hashtable;

import java.util.*;

/**
 * 1244. Design A Leaderboard
 */
public class Leaderboard {

    //<playerId, score>
    private final Map<Integer, Integer> playerScores;
    //<playerId>
    private final TreeSet<Integer> leaderboard;

    public Leaderboard() {
        this.playerScores = new HashMap<>();
        this.leaderboard = new TreeSet<>((a, b) -> {
            if (playerScores.getOrDefault(b, 0).equals(playerScores.getOrDefault(a, 0))) {
                return a.compareTo(b);
            } else {
                return playerScores.getOrDefault(b, 0) - playerScores.getOrDefault(a, 0);
            }
        });
    }

    public void addScore(int playerId, int score) {
        leaderboard.remove(playerId);
        playerScores.put(playerId, playerScores.getOrDefault(playerId, 0) + score);
        leaderboard.add(playerId);
    }

    public int top(int k) {
        int size = 0;
        int sum = 0;
        for (Integer playerId : leaderboard) {
            sum += playerScores.get(playerId);
            size++;
            if (size == k) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        leaderboard.remove(playerId);
        playerScores.put(playerId, 0);
        leaderboard.add(playerId);
    }
}
