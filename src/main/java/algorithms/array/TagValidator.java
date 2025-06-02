package algorithms.array;

import java.util.LinkedList;

/**
 * 591. Tag Validator
 */
public class TagValidator {
    public boolean isValid(String code) {
        if (code.charAt(0) != '<') {
            return false;
        }
        LinkedList<String> tags = new LinkedList<>();
        String tag = getOpenTag(0, code);
        if (tag == null) {
            return false;
        }
        tags.add(tag);
        for (int i = tag.length() + 2; i < code.length(); i++) {
            if (tags.isEmpty()) {
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                while (j < code.length()) {
                    if (code.startsWith("]]>", j)) {
                        break;
                    }
                    j++;
                }
                if (!code.startsWith("]]>", j)) {
                    return false;
                }
                i = j + 2;
            } else if (code.startsWith("</", i)) {
                tag = getCloseTag(i, code);
                if (tag == null) return false;
                if (tags.getLast().equals(tag)) {
                    tags.removeLast();
                } else {
                    return false;
                }
                i += tag.length() + 2;
            } else if (code.startsWith("<", i)) {
                tag = getOpenTag(i, code);
                if (tag == null) return false;
                tags.add(tag);
                i += tag.length() + 1;
            }
        }
        return tags.isEmpty();
    }

    private String getOpenTag(int i, String code) {
        if (code.charAt(i) != '<') {
            return null;
        }
        int j = i + 1;
        while (j < code.length() && Character.isUpperCase(code.charAt(j)) && Character.isLetter(code.charAt(j)) && j - i < 10) {
            j++;
        }
        if (j - i < 2 || j == code.length() || j - i > 10 || code.charAt(j) != '>') {
            return null;
        }
        return code.substring(i + 1, j);
    }

    private String getCloseTag(int i, String code) {
        if (code.charAt(i) != '<' || i == code.length() - 1 || code.charAt(i + 1) != '/') {
            return null;
        }
        int j = i + 2;
        while (j < code.length() && Character.isUpperCase(code.charAt(j)) && Character.isLetter(code.charAt(j)) && j - i < 11) {
            j++;
        }
        if (j - i < 3 || j == code.length() || j - i > 11 || code.charAt(j) != '>') {
            return null;
        }
        return code.substring(i + 2, j);
    }

}
