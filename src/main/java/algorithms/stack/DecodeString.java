package algorithms.stack;

/**
 * 394. Decode String
 * Time: O(n*k), n is length of the string, k is the maximum level of nesting
 * Space: O(n*k)
 *
 */
public class DecodeString {
    public String decodeString(String s) {
        return decodeString(0, s.length(), s);
    }

    private String decodeString(int start, int end, String s) {
        StringBuilder digitBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        int times = 0;
        char c;
        int index = start;
        int indexOfOpenParenthesis = 0;
        int count = 0;
        while (index < end) {
            c = s.charAt(index);
            if (count == 0) {
                if (Character.isDigit(c)) {
                    digitBuilder.append(c);
                } else if (c == '[') {
                    times = Integer.parseInt(digitBuilder.toString());
                    digitBuilder = new StringBuilder();
                    indexOfOpenParenthesis = index;
                    count++;
                } else if (Character.isLetter(c)) {
                    resultBuilder.append(c);
                }
            } else {
                if (c == '[') {
                    count++;
                } else if (c == ']') {
                    count--;
                }
                if (count == 0) {
                    String decodedString = decodeString(indexOfOpenParenthesis + 1, index, s);
                    for (int i = 0; i < times; i++) {
                        resultBuilder.append(decodedString);
                    }
                }
            }
            index++;
        }
        return resultBuilder.toString();
    }
}
