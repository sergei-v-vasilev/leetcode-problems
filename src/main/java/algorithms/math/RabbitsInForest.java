package algorithms.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. Rabbits in Forest
 */
public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>(answers.length);
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int rabbitsWithTheSameColor = entry.getKey() + 1;
            int howManyRabbits = entry.getValue();
            answer += rabbitsWithTheSameColor * (
                    howManyRabbits / rabbitsWithTheSameColor + (howManyRabbits % rabbitsWithTheSameColor != 0 ? 1 : 0)
            );
        }
        return answer;
    }

}
