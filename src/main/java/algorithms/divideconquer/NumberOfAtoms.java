package algorithms.divideconquer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 726. Number of Atoms
 */
public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        countOfAtoms(1, formula, map);
        List<String> atoms = map.keySet().stream().sorted().toList();
        StringBuilder result = new StringBuilder();
        int numbers;
        for (String atom : atoms) {
            numbers = map.get(atom);
            result.append(atom);
            if (numbers > 1) {
                result.append(numbers);
            }
        }
        return result.toString();
    }

    private void countOfAtoms(int amount, String formula, Map<String, Integer> map) {
        int openBrackets = 0;
        int openParenthesis = 0;
        int closeParenthesis = 0;
        int i = 0;
        StringBuilder atomName = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        while (i < formula.length()) {
            //calculate inner formula
            if (formula.charAt(i) == '(') {
                //handle already calculated values if there is
                handleValues(amount, atomName, digits, map);
                atomName = new StringBuilder();
                digits = new StringBuilder();

                openBrackets++;
                i++;
                openParenthesis = i;
                while (i < formula.length() && openBrackets != 0) {
                    if (formula.charAt(i) == ')') {
                        openBrackets--;
                    }
                    if (formula.charAt(i) == '(') {
                        openBrackets++;
                    }
                    i++;
                }
                closeParenthesis = i;
                digits = new StringBuilder();
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    digits.append(formula.charAt(i));
                    i++;
                }
                int count = digits.isEmpty() ? 1 : Integer.parseInt(digits.toString());
                countOfAtoms(count * amount, formula.substring(openParenthesis, closeParenthesis), map);
            } else {
                if (Character.isLetter(formula.charAt(i))) {
                    //upper case means new atom
                    if (Character.isUpperCase(formula.charAt(i))) {
                        handleValues(amount, atomName, digits, map);
                        atomName = new StringBuilder();
                        digits = new StringBuilder();
                    }
                    atomName.append(formula.charAt(i));
                } else if (Character.isDigit(formula.charAt(i))) {
                    digits.append(formula.charAt(i));
                }
                i++;
            }
        }
        handleValues(amount, atomName, digits, map);
    }

    private void handleValues(int amount, StringBuilder atomName, StringBuilder digits, Map<String, Integer> map) {
        if (atomName.isEmpty()) return;
        int counter = digits.isEmpty() ? 1 : Integer.parseInt(digits.toString());
        map.put(atomName.toString(), map.getOrDefault(atomName.toString(), 0) + amount * counter);
    }
}
