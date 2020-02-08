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
        if (isNull(input) || isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException("Null or Blank or Empty exception.");
        }
    }

    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isBlank(String input) {
        return input.equals(" ");
    }

    private boolean isEmpty(String input) {
        return input.equals("");
    }

    public void isValidSplitedInput(String[] splitedInput) {
        checkIsDoubleNumber(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            String operator = splitedInput[i];
            String number = splitedInput[i + 1];
            if (operator.equals("/") && number.equals("0")) {
                throw new IllegalArgumentException("Cannot divide zero.");
            }
            checkIsOperator(operator);
            checkIsDoubleNumber(number);
        }
    }

    private void checkIsDoubleNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("Can not convert to double.");
        }
    }

    private void checkIsOperator(String s) {
        if (!operators.contains(s)) {
            throw new IllegalArgumentException("Operator check exception.");
        }
    }
}
