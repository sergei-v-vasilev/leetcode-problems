package algorithms.greedy;

import java.util.Arrays;

/**
 * 1996. The Number of Weak Characters in the Game
 */
public class TheNumberOfWeakCharactersInGame {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (x, y) -> {
            if (x[0] == y[0]) {
                return Integer.compare(y[1], x[1]);
            } else {
                return Integer.compare(x[0], y[0]);
            }
        });
        int number = 0;
        int maxAttack = properties[properties.length - 1][0];
        int maxDefence = properties[properties.length - 1][1];
        for (int i = properties.length - 2; i >= 0; i--) {
            if (properties[i][0] < maxAttack && properties[i][1] < maxDefence) {
                number++;
            } else {
                maxAttack = Math.max(maxAttack, properties[i][0]);
                maxDefence = Math.max(maxDefence, properties[i][1]);
            }
        }
        return number;
    }
}
