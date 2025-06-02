package algorithms.bit;

/**
 * 67. Add Binary
 * Time: O(n)
 * Space: O(1)
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] l = a.toCharArray();
        char[] r = b.toCharArray();
        StringBuilder builder = new StringBuilder();
        int leftPointer = l.length - 1;
        int rightPointer = r.length - 1;
        char mod = '0';
        while (leftPointer >= 0 && rightPointer >= 0) {
            if (l[leftPointer] == '1' && r[rightPointer] == '1') {
                if (mod == '1') builder.append('1');
                else builder.append('0');
                mod = '1';
            } else if (l[leftPointer] == '1' && r[rightPointer] == '0' || l[leftPointer] == '0' && r[rightPointer] == '1') {
                if (mod == '1') {
                    builder.append('0');
                } else builder.append('1');
            } else {
                if (mod == '1') {
                    builder.append('1');
                } else builder.append('0');
                mod = '0';
            }
            leftPointer--;
            rightPointer--;
        }
        while (leftPointer >= 0) {
            if (l[leftPointer] == '1') {
                if (mod == '1') builder.append('0');
                else builder.append('1');
            } else {
                if (mod == '1') builder.append('1');
                else builder.append('0');
                mod = '0';
            }
            leftPointer--;
        }
        while (rightPointer >= 0) {
            if (r[rightPointer] == '1') {
                if (mod == '1') builder.append('0');
                else builder.append('1');
            } else {
                if (mod == '1') builder.append('1');
                else builder.append('0');
                mod = '0';
            }
            rightPointer--;
        }
        if (mod == '1') {
            builder.append('1');
        }
        return builder.reverse().toString();
    }
}
