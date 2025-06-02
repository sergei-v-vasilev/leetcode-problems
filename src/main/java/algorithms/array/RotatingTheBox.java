package algorithms.array;

import java.util.LinkedList;

/**
 * 1861. Rotating the Box
 */
public class RotatingTheBox {

    public char[][] rotateTheBox(char[][] box) {
        LinkedList[] list = new LinkedList[box.length]; //rows which became columns
        for (int i = 0; i < box.length; i++) {
            //list of obstacles where int[0] - index of obstacle, int[1] number of stones before it
            LinkedList<int[]> column = new LinkedList<>();
            int stoneNumber = 0;
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == '#') {
                    stoneNumber++;
                } else if (box[i][j] == '*') {
                    column.addLast(new int[]{j, stoneNumber});
                    stoneNumber = 0;
                }
            }
            if (stoneNumber > 0) {
                column.addLast(new int[]{box[0].length, stoneNumber});
            }
            list[i] = column;
        }
        char[][] result = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                result[j][box.length - i - 1] = '.';
            }
        }
        for (int i = 0; i < box.length; i++) {
            LinkedList<int[]> column = list[i];
            while (column.peekFirst() != null) {
                int[] obstacle = column.pollFirst();
                if (obstacle[0] < box[0].length) {
                    result[obstacle[0]][box.length - i - 1] = '*';
                    for (int k = obstacle[1]; k > 0; k--) {
                        result[obstacle[0] - obstacle[1] + k - 1][box.length - i - 1] = '#';
                    }
                } else {
                    for (int k = 0; k < obstacle[1]; k++) {
                        result[box[0].length - 1 - k][box.length - i - 1] = '#';
                    }
                }
            }
        }
        return result;
    }
}
