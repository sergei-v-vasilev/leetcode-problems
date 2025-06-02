package algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 2375. Construct Smallest Number From DI String
 */
public class ConstructSmallestNumberFromDIString {

    public String smallestNumber(String pattern) {
        Set<Integer> usedNumbers = new HashSet<>(9);
        for (int i = 1; i < 10; i++) {
            usedNumbers.add(i);
            String result = smallestNumber(1, pattern, new StringBuilder(String.valueOf(i)), usedNumbers);
            if (result != null) {
                return result;
            }
            usedNumbers.remove(i);
        }
        return null;
    }

    private String smallestNumber(int i, String pattern, StringBuilder numberBuilder, Set<Integer> usedNumbers) {
        if (i == pattern.length() + 1) {
            return numberBuilder.toString();
        }
        if (usedNumbers.size() == 9) {
            return null;
        }
        char change = pattern.charAt(i - 1);
        int previousNumber = numberBuilder.charAt(numberBuilder.length() - 1) - '0';
        String result;
        if (change == 'I') {
            for (int j = previousNumber + 1; j < 10; j++) {
                result = tryInsert(i, pattern, numberBuilder, usedNumbers, j);
                if (result != null) return result;
            }
        } else {
            for (int j = 1; j < previousNumber; j++) {
                result = tryInsert(i, pattern, numberBuilder, usedNumbers, j);
                if (result != null) return result;
            }
        }
        return null;
    }

    private String tryInsert(int i, String pattern, StringBuilder numberBuilder, Set<Integer> usedNumbers, int j) {
        String result;
        if (!usedNumbers.contains(j)) {
            usedNumbers.add(j);
            numberBuilder.append(j);
            result = smallestNumber(i + 1, pattern, numberBuilder, usedNumbers);
            if (result != null) return result;
            usedNumbers.remove(j);
            numberBuilder.deleteCharAt(numberBuilder.length() - 1);
        }
        return null;
    }

}
