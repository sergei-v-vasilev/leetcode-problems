package algorithms.twopointers;

import java.util.LinkedList;
import java.util.List;

/**
 * 68. Text Justification
 */
public class TextJustification {

    //["This", "is", "an", "d", "of", "text", "d."]
    //7
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        int nextLinePosition = 0;
        int i = 0;

        while (nextLinePosition < words.length) {
            int wordsLength = 0;
            int wordCount = 0;
            boolean isNewLine = true;
            //move pointer to next possible line
            while (nextLinePosition < words.length) {
                int space = isNewLine ? 0 : 1;
                isNewLine = false;
                if (wordsLength + space + words[nextLinePosition].length() > maxWidth) {
                    break;
                }
                wordCount++;
                wordsLength += space + words[nextLinePosition].length();
                nextLinePosition++;
            }
            StringBuilder line = new StringBuilder();
            if (wordsLength == maxWidth || nextLinePosition == words.length) {
                while (i < nextLinePosition) {
                    line.append(words[i]);
                    if (i < nextLinePosition - 1) {
                        line.append(' ');
                    }
                    i++;
                }
                if (nextLinePosition == words.length && maxWidth > wordsLength) {
                    line.append(" ".repeat(maxWidth - wordsLength));
                }
            } else {
                int spaceCount = wordCount - 1;
                int uniformAdditionalSpaces = spaceCount > 0 ? (maxWidth - wordsLength) / spaceCount : 0;
                int leftSpaceCount = spaceCount > 0 ? (maxWidth - wordsLength) % spaceCount : maxWidth - wordsLength;
                while (i < nextLinePosition) {
                    line.append(words[i]);
                    if (i < nextLinePosition - 1) {
                        line.append(' ');
                        if (uniformAdditionalSpaces > 0) {
                            line.append(" ".repeat(uniformAdditionalSpaces));
                        }
                        if (leftSpaceCount > 0) {
                            line.append(' ');
                            leftSpaceCount--;
                        }
                    }
                    i++;
                }
                if (leftSpaceCount > 0) {
                    line.append(" ".repeat(leftSpaceCount));
                }
            }
            result.add(line.toString());
        }
        return result;
    }

}
