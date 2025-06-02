package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 Game
 */
public class TwentyFourGames {

    private double epsilon = 0.001;

    public boolean judgePoint24(int[] cards) {
        List<Double> numbers = new ArrayList<>(4);
        for (int card : cards) {
            numbers.add((double) card);
        }
        return judge(numbers);
    }

    private boolean judge(List<Double> numbers) {
        if (numbers.isEmpty()) return false;
        if (numbers.size() == 1) {
            if (Math.abs(numbers.get(0) - 24) < epsilon) return true;
            else return false;
        }
        List<Double> newNumbers = new ArrayList<>(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i == j) continue;
                double a = numbers.get(i);
                double b = numbers.get(j);
                newNumbers.remove(a);
                newNumbers.remove(b);

                //+
                newNumbers.add(a + b);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(a + b);

                //-
                newNumbers.add(a - b);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(a - b);
                newNumbers.add(b - a);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(b - a);

                //*
                newNumbers.add(a * b);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(a * b);

                // /
                if (a != 0 && b != 0) {
                    newNumbers.add(a / b);
                    if (judge(newNumbers)) {
                        return true;
                    }
                    newNumbers.remove(a / b);

                    newNumbers.add(b / a);
                    if (judge(newNumbers)) {
                        return true;
                    }
                    newNumbers.remove(b / a);
                }

                newNumbers.add(a);
                newNumbers.add(b);
            }
        }
        return false;
    }

}
