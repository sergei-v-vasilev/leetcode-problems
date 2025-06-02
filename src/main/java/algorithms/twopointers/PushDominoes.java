package algorithms.twopointers;

/**
 * 838. Push Dominoes
 *
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] array = dominoes.toCharArray();
        int first = 0;
        while (first < array.length && array[first] == '.') {
            first++;
        }
        if (first < array.length && array[first] == 'L') {
            makeLeft(0, first, array);
        }
        while (first < array.length) {
            int second = first + 1;
            while (second < array.length && array[second] == '.') {
                second++;
            }
            if (second < array.length) {
                if (array[first] == 'L' && array[second] == 'L') {
                    makeLeft(first, second, array);
                } else if (array[first] == 'R' && array[second] == 'L') {
                    makeInternal(first, second, array);
                } else if (array[first] == 'R' && array[second] == 'R') {
                    makeRight(first, second, array);
                } else if (array[first] == 'L' && array[second] == 'R') {
                    //do nothing
                }
                first = second;
            } else {
                break;
            }
        }
        if (first < array.length && array[first] == 'R') {
            makeRight(first, array.length, array);
        }
        return new String(array);
    }

    private void makeLeft(int start, int end, char[] array) {
        for (int i = start; i < end; i++) {
            array[i] = 'L';
        }
    }

    private void makeRight(int start, int end, char[] array) {
        for (int i = start; i < end; i++) {
            array[i] = 'R';
        }
    }

    private void makeInternal(int start, int end, char[] array) {
        int left = start + 1;
        int right = end - 1;
        while (left < right) {
            array[left] = 'R';
            array[right] = 'L';
            left++;
            right--;
        }
    }
}