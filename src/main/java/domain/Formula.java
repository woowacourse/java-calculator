package domain;

import java.util.Arrays;
import java.util.List;

public class Formula {
    private static final String BLANK = " ";

    private final String formula;

    public Formula(String formula) {
        checkFormula(formula.split(BLANK));
        this.formula = formula;
    }

    private void checkFormula(String[] formulas) {
        validNumbers(formulas[0]);
        for (int index = 1; index < formulas.length; index += 2) {
            validOperator(formulas[index]);
            validNumbers(formulas[index + 1]);
        }
    }

    private void validNumbers(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자가 숫자가 아닙니다. " + number);
        }
    }

    private void validOperator(String operator) {
        char first = operator.charAt(0);
        if (!(first == '*' || first == '/' || first == '+' || first == '-') || operator.length() != 1) {
            throw new IllegalArgumentException("연산자가 잘못되었습니다. " + operator);
        }
    }

    public List<String> toList() {
        return Arrays.asList(formula.split(BLANK));
    }

}
