package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            Exit.sendErrorMessage("잘못된 식을 입력하셨습니다.");
        }
        return -1;
    }

    public static char checkIsOperator(String stringOperator) {
        char operator = stringOperator.charAt(0);
        List<Character> operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        if (!operators.contains(operator)
                || stringOperator.length() != 1) {
            Exit.sendErrorMessage("잘못된 식을 입력하셨습니다.");
        }
        return operator;
    }

    public static String[] trimSpace(String[] formulas) {
        return Arrays.stream(formulas)
                .filter((x) -> {
                    if (x.equals("")) return false;
                    return true;
                }).toArray(String[]::new);

    }

}
