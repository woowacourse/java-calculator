package calculator;

import java.util.ArrayList;

public class Validator {
    private static final ArrayList<String> operators = new ArrayList<>();

    public Validator() {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public void isValidInput(String input) {
        if (isNull(input) || isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException("Handled Exception : Null or Blank or Empty exception.");
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
                throw new IllegalArgumentException("Handled Exception : Cannot divide zero.");
            }
            checkIsOperator(operator);
            checkIsDoubleNumber(number);
        }
    }

    private void checkIsDoubleNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("Handled Exception : Cannot convert to double.");
        }
    }

    private void checkIsOperator(String s) {
        if (!operators.contains(s)) {
            throw new IllegalArgumentException("Handled Exception : Operator check exception.");
        }
    }
}
