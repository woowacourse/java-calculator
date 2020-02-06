package calculator.util;

import java.util.Arrays;
import java.util.List;

public class RawEquationSplitter {
    private static final String BLANK = " ";
    private static final String NUMBER_FORMAT = "\\d+";

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
        if (index % 2 != 0 && isNumber(equation[index])) {
            throw new IllegalArgumentException("식이 올바르지 않습니다. 숫자의 위치를 확인하세요.");
        }
        if (index % 2 == 0 && isNotNumber(equation[index])) {
            throw new IllegalArgumentException("식이 올바르지 않습니다. 연산자의 위치를 확인하세요.");
        }
    }

    private static boolean isNotNumber(String maybeNumber) {
        return !isNumber(maybeNumber);
    }

    private static boolean isNumber(String maybeNumber) {
        return maybeNumber.matches(NUMBER_FORMAT);
    }
}