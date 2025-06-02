package algorithms.math;

import java.util.LinkedList;

/**
 * 224. Basic Calculator
 */
public class BasicCalculator {

    private class SignedNumber {
        char sign;
        int number;

        public SignedNumber(char sign, int number) {
            this.sign = sign;
            this.number = number;
        }
    }

    public int calculate(String s) {
        LinkedList<SignedNumber> numbers = new LinkedList<>();
        int value = 0;
        char sign = '+';
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == '(') {
                numbers.add(new SignedNumber(sign, value));
                value = 0;
                sign = '+';
            } else if (s.charAt(i) == ')') {
                if(!currentNumber.isEmpty()) value = addLastNumber(value, sign, Integer.parseInt(currentNumber.toString()));
                currentNumber = new StringBuilder();
                SignedNumber lastSignedNumber = numbers.pollLast();
                value = addLastNumber(lastSignedNumber.number, lastSignedNumber.sign, value);
                sign = '+';
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if(!currentNumber.isEmpty()) value = addLastNumber(value, sign, Integer.parseInt(currentNumber.toString()));
                currentNumber = new StringBuilder();
                sign = s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                currentNumber.append(s.charAt(i));
            }
        }
        if(!currentNumber.isEmpty()) {
            if (sign == '+') {
                value = value + Integer.parseInt(currentNumber.toString());
            } else {
                value = value - Integer.parseInt(currentNumber.toString());
            }
        }
        return value;
    }

    private int addLastNumber(int value, char sign, int newValue) {
        if (sign == '+') {
            value = value + newValue;
        } else {
            value = value - newValue;
        }
        return value;
    }
}
