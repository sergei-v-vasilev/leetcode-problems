package algorithms.twopointers;

import java.util.*;

/**
 * Two characters
 * https://www.hackerrank.com/challenges/two-characters/problem?isFullScreen=true
 *
 */
public class TwoCharacters {

    public static int alternate(String s) {
        Map<Character, List<Integer>> lettersMap = new HashMap<>(26);
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            List<Integer> indicies = lettersMap.getOrDefault(c, new LinkedList<>());
            indicies.add(i);
            lettersMap.put(c, indicies);
        }
        int max = 0;
        for (char ch : lettersMap.keySet()) {
            for (char innerCh : lettersMap.keySet()) {
                if (innerCh != ch) {
                    List<Integer> indiciesCh = lettersMap.get(ch);
                    List<Integer> indiciesInnerCh = lettersMap.get(innerCh);
                    if (Math.abs(indiciesCh.size() - indiciesInnerCh.size()) < 2) {
                        if (isAlternate(indiciesCh, indiciesInnerCh)) {
                            max = Math.max(max, indiciesCh.size() + indiciesInnerCh.size());
                        }
                    }
                }
            }
        }
        return max;
    }

    private static boolean isAlternate(List<Integer> left, List<Integer> right) {
        Iterator<Integer> leftIterator = left.iterator();
        Iterator<Integer> rightIterator = right.iterator();
        boolean leftTurn = left.get(0) < right.get(0);
        int leftValue;
        int rightValue;
        int previous = Integer.MIN_VALUE;
        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            leftValue = leftTurn ? leftIterator.next() : rightIterator.next();
            rightValue = leftTurn ? rightIterator.next() : leftIterator.next();
            if (leftValue >= rightValue || previous > leftValue) {
                return false;
            }
            previous = rightValue;
        }
        if (leftIterator.hasNext()) {
            if (!leftTurn) {
                return false;
            }
            leftValue = leftIterator.next();
            if (leftValue <= previous) {
                return false;
            }
        }
        if (rightIterator.hasNext()) {
            if (leftTurn) {
                return false;
            }
            leftValue = rightIterator.next();
            if (leftValue <= previous) {
                return false;
            }
        }
        return true;
    }
}
