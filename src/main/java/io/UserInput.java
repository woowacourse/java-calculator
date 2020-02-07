package io;

import calculator.Operator;

import java.util.Scanner;

public class UserInput {
    private static final String BLANK = " ";
    private static final Scanner sc = new Scanner(System.in);
    private static String userInput;

    public String[] getNumbersAndOperator() {
        userInput = sc.nextLine();
        if (checkAllInputError()) {
            return userInput.split(BLANK);
        }
        OutputView.inputError();
        return getNumbersAndOperator();
    }

    private boolean checkAllInputError() {
        String[] inputArray = userInput.split(BLANK);
        if (!((inputArray.length % 2) == 1) || !isNumber(inputArray[0]))
            return false;
        for (int i = 1; i < inputArray.length; i += 2) {
            if (!isOperator(inputArray[i]) || !isNumber(inputArray[i + 1]))
                return false;
        }
        return true;
    }

    private boolean isNumber(String target) {
        try {
            Double.parseDouble(target);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String target) {
//        return target.equals(Operator.PLUS) || target.equals(Operator.SUBTRACT) || target.equals(Operator) || target.equals("/");
        try {
            Operator.of(target);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
