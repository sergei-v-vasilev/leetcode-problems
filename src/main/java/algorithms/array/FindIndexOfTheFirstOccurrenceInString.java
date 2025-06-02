package algorithms.array;

/**
 * 28. Find the Index of the First Occurrence in a String
 */
public class FindIndexOfTheFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
        int needleIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(needleIndex) == haystack.charAt(i)) {
                needleIndex++;
            } else {
                i = i - needleIndex;
                needleIndex = 0;
            }
            if (needleIndex == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

}
