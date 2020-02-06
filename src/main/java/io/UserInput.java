package io;

import java.util.Scanner;

public class UserInput {
    private static final Scanner sc = new Scanner(System.in);
    private static String userInput;

    public String[] getNumbersAndOperator() {
        userInput = sc.nextLine();
        if(checkAllInputError())
            return userInput.split(" ");
        OutputView.inputError();
        return getNumbersAndOperator();
    }

    private boolean checkAllInputError() {
        String[] inputArray = userInput.split(" ");
        if(!((inputArray.length % 2) == 1) || !checkNumberOrNot(inputArray[0]))
            return false;
        for ( int i =1; i<inputArray.length; i+= 2) {
            if (!checkOperatorOrNot(inputArray[i]) || !checkNumberOrNot(inputArray[i+1]))
                return false;
        }
        return true;
    }

    private boolean checkNumberOrNot(String target) {
        try {
            Double.parseDouble(target);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean checkOperatorOrNot(String target) {
        return target.equals("+") || target.equals("-") || target.equals("*") || target.equals("/");
    }
}
