package algorithms.stack;


/**
 * 3174. Clear Digits
 */
public class ClearDigits {

    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                result.append(s.charAt(i));
                pointer++;
            } else {
                if (!result.isEmpty() && !Character.isDigit(result.charAt(pointer - 1))) {
                    result.deleteCharAt(pointer - 1);
                    pointer--;
                }
            }
        }
        return result.toString();
    }
}
