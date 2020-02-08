package calculator.util;

import java.util.Arrays;
import java.util.List;

public class RawEquationSplitter {
    private static final String BLANK = " ";
    private static final String NUMBER_FORMAT = "\\d+";
    private static final String INCORRECT_POSITION_MESSAGE = "식이 올바르지 않습니다. %s의 위치를 확인하세요.";
    private static final String INCORRECT_POSITION_NUMBER = "숫자";
    private static final String INCORRECT_POSITION_OPERATOR = "연산자";

    public static List<String> split(String inputString) {
        String[] result = inputString.split(BLANK);
        validate(result);
        return Arrays.asList(result);
    }

    private static void validate(String[] equation) {
        for (int i = 0; i < equation.length; i++) {
            checkPosition(equation, i);
        }
    }

    private static void checkPosition(String[] equation, int index) {
        if (isNotNumberPosition(index) && isNumber(equation[index])) {
            throw new IllegalArgumentException(String.format(INCORRECT_POSITION_MESSAGE, INCORRECT_POSITION_NUMBER));
        }
        if (isNumberPosition(index) && isNotNumber(equation[index])) {
            throw new IllegalArgumentException(String.format(INCORRECT_POSITION_MESSAGE, INCORRECT_POSITION_OPERATOR));
        }
    }

    private static boolean isNotNumberPosition(int index) {
        return index % 2 != 0;
    }

    private static boolean isNumberPosition(int index) {
        return !isNotNumberPosition(index);
    }

    private static boolean isNotNumber(String maybeNumber) {
        return !isNumber(maybeNumber);
    }

    private static boolean isNumber(String maybeNumber) {
        return maybeNumber.matches(NUMBER_FORMAT);
    }
}