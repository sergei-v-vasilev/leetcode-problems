package algorithms.twopointers;

/**
 * 2109. Adding Spaces to a String
 */
public class AddingSpacesToString {
    public String addSpaces(String s, int[] spaces) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length + spaces.length];
        int stringPoint = 0;
        int resultPoint = 0;
        int spacePoint = 0;
        while (stringPoint < chars.length) {
            if (spacePoint == spaces.length || stringPoint < spaces[spacePoint]) {
                result[resultPoint] = chars[stringPoint];
            } else if (stringPoint == spaces[spacePoint]) {
                result[resultPoint] = ' ';
                spacePoint++;
                resultPoint++;
                result[resultPoint] = chars[stringPoint];
            }
            stringPoint++;
            resultPoint++;
        }
        return new String(result);
    }
}
