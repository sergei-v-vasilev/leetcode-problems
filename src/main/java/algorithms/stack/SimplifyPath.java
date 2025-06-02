package algorithms.stack;

import java.util.LinkedList;

/**
 * 71. Simplify Path
 * Time: O(n)
 * Space: O(n)
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] dirtyDirectories = path.split("/");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < dirtyDirectories.length; i++) {
            if ("..".equals(dirtyDirectories[i])) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else if (!".".equals(dirtyDirectories[i]) && !dirtyDirectories[i].isEmpty()) {
                queue.addLast(dirtyDirectories[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        String directory = queue.pollFirst();
        while (directory != null) {
            builder.append("/").append(directory);
            directory = queue.pollFirst();
        }
        return builder.length() != 0 ? builder.toString() : "/";
    }
}
