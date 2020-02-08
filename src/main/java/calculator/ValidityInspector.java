package calculator;

import java.util.ArrayList;
import java.util.List;

public class ValidityInspector {
    private List<String> operators;

    ValidityInspector() {
        operators = new ArrayList<>();
        operators.add(Operator.Plus.getValue());
        operators.add(Operator.Minus.getValue());
        operators.add(Operator.Multiplication.getValue());
        operators.add(Operator.Division.getValue());
    }

    public void isValidInput(String input) {
        if (isBlank(input) || isNullOrEmpty(input)) {
            throw new IllegalArgumentException("Null or Blank or Empty exception.");
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input.equals("");
    }

    private boolean isBlank(String input) {
        return input.equals(" ");
    }

    public void isValidSplitedInput(String[] splitedInput) {
        String firstClause = splitedInput[0];
        checkCorrectDoubleNumber(firstClause);
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            String operator = splitedInput[i];
            String secondClause = splitedInput[i + 1];
            if (Operator.Division.getValue().equals(operator) && "0".equals(secondClause)) {
                throw new IllegalArgumentException("Cannot divide zero.");
            }
            checkCorrectOperator(operator);
            checkCorrectDoubleNumber(secondClause);
        }
    }

    private void checkCorrectDoubleNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("Can not convert to double.");
        }
    }

    private void checkCorrectOperator(String s) {
        if (!operators.contains(s)) {
            throw new IllegalArgumentException("Operator check exception.");
        }
    }
}
