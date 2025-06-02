package algorithms.math;

/**
 * 640. Solve the Equation
 */
public class SolveTheEquation {

    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = calculate(parts[0]);
        int[] right = calculate(parts[1]);
        if (left[1] == right[1] && left[0] == right[0]) {
            return "Infinite solutions";
        } else if (left[0] == right[0]) {
            return "No solution";
        } else if (left[1] == right[1]) {
            return "x=0";
        } else {
            int value = (right[1] - left[1]) / (left[0] - right[0]);
            return "x=" + value;
        }
    }

    private int[] calculate(String equation) {
        int x = 0;
        int N = 0;
        char sigh = '+';
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '+' || c == '-') {
                if (!number.isEmpty()) {
                    N = sigh == '+' ? N + Integer.parseInt(number.toString()) : N - Integer.parseInt(number.toString());
                    number = new StringBuilder();
                }
                sigh = c;
            } else if (Character.isDigit(c)) {
                number.append(c);
            } else if (c == 'x') {
                int multiplier = 1;
                if (!number.isEmpty()) {
                    multiplier = Integer.parseInt(number.toString());
                    number = new StringBuilder();
                }
                x = sigh == '+' ? x + multiplier : x - multiplier;
            } else {
                throw new RuntimeException("Unrecognized character: " + c);
            }
        }
        if (!number.isEmpty()) {
            N = sigh == '+' ? N + Integer.parseInt(number.toString()) : N - Integer.parseInt(number.toString());
        }
        return new int[]{x, N};
    }
}
