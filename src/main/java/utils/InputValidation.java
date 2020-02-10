package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    public static boolean checkNullOrSpace(String input) {
        if ("".equals(input))
            Exit.sendErrorMessage("공백을 입력하셨습니다.");
        return false;
    }

    public static double isNumber(String stringNumber) {
        try {
            return Double.parseDouble(stringNumber);
        } catch (Exception e) {
            Exit.sendErrorMessage("잘못된 식을 입력하셨습니다.");
        }
        return -1;
    }

    public static char isOperator(String stringOperator) {
        char operator = stringOperator.charAt(ZERO);
        List<Character> operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        if (!operators.contains(operator)
                || stringOperator.length() != ONE) {
            Exit.sendErrorMessage("잘못된 식을 입력하셨습니다.");
        }
        return operator;
    }

    public static String[] removeSpaceElement(String[] formulas) {
        return Arrays.stream(formulas)
                .filter(x -> !"".equals(x))
                .toArray(String[]::new);
    }
}
