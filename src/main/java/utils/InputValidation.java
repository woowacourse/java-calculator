package utils;

import java.util.Arrays;

public class InputValidation {
    public static boolean checkNullOrSpace(String input) {
        if ("".equals(input))
            Exit.sendErrorMessage("공백을 입력하셨습니다.");
        return false;
    }

    public static boolean isNumber(String stringNumber) {
        try {
            Double.parseDouble(stringNumber);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static boolean isOperator(String stringOperator) {
        return "+".equals(stringOperator)
                || "-".equals(stringOperator)
                || "*".equals(stringOperator)
                || "/".equals(stringOperator);
    }

    public static String[] removeSpaceElement(String[] formulas) {
        return Arrays.stream(formulas)
                .filter(x -> !"".equals(x))
                .toArray(String[]::new);
    }
}
