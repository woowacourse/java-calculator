package domain;

import java.util.Arrays;
import java.util.List;

public class Formula {
    private static final String BLANK = " ";
    private static final List<String> OPERATORS = Arrays.asList(new String[]{"+", "-", "*", "/"});
    private static final String NOT_NUMBER = "피연산자가 숫자가 아닙니다. %s";
    private static final String WRONG_OPERATOR = "연산자가 잘못되었습니다. %s";

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
            throw new IllegalArgumentException(String.format(NOT_NUMBER ,number));
        }
    }

    private void validOperator(String operator) {
       if (!OPERATORS.contains(operator)) {
           throw new IllegalArgumentException(String.format(WRONG_OPERATOR ,operator));
       }
    }

    public List<String> toList() {
        return Arrays.asList(formula.split(BLANK));
    }

}
