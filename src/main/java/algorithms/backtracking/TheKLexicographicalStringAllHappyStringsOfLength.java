package algorithms.backtracking;

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * can be solved with math also
 */
public class TheKLexicographicalStringAllHappyStringsOfLength {

    private int counter = 0;

    public String getHappyString(int n, int k) {
        counter = k;
        String result = getHappyString(n, new StringBuilder());
        if (result == null) return "";
        else return result;
    }

    private String getHappyString(int n, StringBuilder builder) {
        if (builder.length() == n && counter == 1) {
            return builder.toString();
        }
        if (builder.length() == n) {
            counter--;
            return null;
        }
        String happyString;
        for (int i = 0; i < 3; i++) {
            char ch = (char) ('a' + i);
            if (consistentWithLastChar(ch, builder)) {
                builder.append(ch);
                happyString = getHappyString(n, builder);
                if (happyString != null) {
                    return happyString;
                }
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return null;
    }

    private boolean consistentWithLastChar(char ch, StringBuilder builder) {
        if (!builder.isEmpty()) {
            char lastChar = builder.charAt(builder.length() - 1);
            return ch != lastChar;
        } else {
            return true;
        }
    }
}
