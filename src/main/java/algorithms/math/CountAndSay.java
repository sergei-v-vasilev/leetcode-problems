package algorithms.math;

/**
 * 38. Count and Say
 * Time: O(n)
 * Space: O(1)
 *
 */
public class CountAndSay {
    public String countAndSay(int n) {
        int k = 1;
        String s = "1";
        int counter;
        char previous;
        while (k < n) {
            StringBuilder builder = new StringBuilder();
            previous = s.charAt(0);
            counter = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == previous) counter++;
                else {
                    builder.append(counter).append(previous);
                    counter = 1;
                    previous = s.charAt(i);
                }
            }
            builder.append(counter).append(previous);
            s = builder.toString();
            k++;
        }
        return s;
    }
}
