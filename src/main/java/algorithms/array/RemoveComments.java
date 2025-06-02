package algorithms.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 722. Remove Comments
 */
public class RemoveComments {

    public List<String> removeComments(String[] source) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlockCommentStart = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (isBlockCommentStart && isBlockCommentEnd(i, s)) { // block comment has been started && here it's the end
                    isBlockCommentStart = false;
                    i++;
                } else if (isBlockCommentStart) {  // block comment has been started && here it's not the end
                    //do nothing
                } else if (isLineComment(i, s)) { //line comment so we can stop tracking the line
                    break;
                } else if (isBlockCommentStart(i, s)) {
                    isBlockCommentStart = true;
                    i++;//
                } else {
                    sb.append(s.charAt(i));
                }
            }
            if (!isBlockCommentStart && !sb.isEmpty()) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    private boolean isLineComment(int i, String line) {
        return i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '/';
    }

    private boolean isBlockCommentStart(int i, String line) {
        return i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '*';
    }

    private boolean isBlockCommentEnd(int i, String line) {
        return i < line.length() - 1 && line.charAt(i) == '*' && line.charAt(i + 1) == '/';
    }
}
