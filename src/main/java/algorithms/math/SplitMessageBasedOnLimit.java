package algorithms.math;

/**
 * 2468. Split Message Based on Limit
 */
public class SplitMessageBasedOnLimit {

    public String[] splitMessage(String message, int limit) {
        int tagSize = 5;
        if (limit < tagSize) {
            return new String[]{};
        }
        long multiplier = 1;
        int numberOfDigits = 1;
        long condition = 9L * (limit - tagSize);
        while (condition < message.length()) {
            numberOfDigits++;

            tagSize += 2;
            multiplier *= 10;
            int partialTagSize = tagSize;
            long partialMultiplier = multiplier;
            condition = 0;
            while (partialMultiplier > 0) {
                condition += 9L * partialMultiplier * (limit - partialTagSize);
                partialMultiplier /= 10;
                partialTagSize--;
            }
            if (condition < 0) {
                return new String[]{};
            }
        }
        int start = (int) Math.pow(10, numberOfDigits - 1);
        int end = (int) Math.pow(10, numberOfDigits);
        int k = 0;
        int digits = 1;
        condition = 0;
        long initialTagSize = tagSize - numberOfDigits + 1;
        multiplier = 1;
        long number = 0;
        while (digits < numberOfDigits) {
            number += 9L * multiplier;
            condition += 9L * multiplier * (limit - initialTagSize);
            multiplier *= 10;
            initialTagSize++;
            digits++;
        }

        for (int i = start; i <= end; i++) {
            if (condition + (i - number) * (limit - tagSize) >= message.length()) {
                k = i;
                break;
            }
        }
        return splitMessage(k, limit, message);
    }

    private String[] splitMessage(int k, int limit, String message) {
        String[] result = new String[k];
        int start = 0;
        for (int i = 0; i < k; i++) {
            String tag = "<" + (i + 1) + "/" + k + ">";
            result[i] = message.substring(start, Math.min(start + limit - tag.length(), message.length())) + tag;
            start += limit - tag.length();
        }
        return result;
    }
}
