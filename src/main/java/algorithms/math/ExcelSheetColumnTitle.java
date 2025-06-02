package algorithms.math;

/**
 * 168. Excel Sheet Column Title
 * Time: O(n)
 * Space: O(1)
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            builder.append((char) ((int) 'A' + (columnNumber - 1) % 26));
            columnNumber = (columnNumber - 1) / 26;
        }
        return builder.reverse().toString();
    }

}
