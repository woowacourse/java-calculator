package utils;

import static utils.Constant.*;

import java.util.Arrays;

public class InputValidation {

    public static boolean checkNullOroSpace(String input) {
        if (input.equals(null) || input.equals(" ")) {
            Exit.sendErrorMessage("공백을 입력하셨습니다.");
        }
        return false;
    }

    public static double checkIsNumber(String stringNumber) {
        try {
            return Double.parseDouble(stringNumber);
        } catch (Exception e) {
            Exit.sendErrorMessage("잘못된 피연산자를 입력하셨습니다.");
        }
        return -1;
    }

    public static char checkIsOperator(String stringOperator) {
        char operator = stringOperator.charAt(0);

        if (!operatorFunction.containsKey(operator)
                || stringOperator.length() != 1) {
            Exit.sendErrorMessage("잘못된 연산자를 입력하셨습니다.");
        }
        return operator;
    }

    public static String[] trimSpace(String[] formulas) {
        return Arrays.stream(formulas)
                .filter(formula -> !formula.isEmpty())
                .toArray(String[]::new);
    }

}
