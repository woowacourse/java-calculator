package calculator.spliter;

import java.util.Arrays;
import java.util.List;

public class RawEquationSplitter {
    private static final String BLANK = " ";
    private static final String NUMBER_FORMAT = "\\d+";

    public static List<String> split(String inputString) {
        String[] result = inputString.split(BLANK);
        validate(result);
        return Arrays.asList(inputString.split(BLANK));
    }

    private static void validate(String[] equation) {
        for (int i = 0; i < equation.length; i++) {
            checkPosition(equation, i);
        }
    }

    private static void checkPosition(String[] equation, int i) {
        if (i % 2 != 0 && isNumber(equation[i])) {
            throw new IllegalArgumentException("숫자의 위치가 잘못되었습니다.");
        }
        if (i % 2 == 0 && isNotNumber(equation[i])) {
            throw new IllegalArgumentException("연산자의 위치가 잘못되었습니다.");
        }
    }

    private static boolean isNotNumber(String maybeNumber) {
        return !isNumber(maybeNumber);
    }

    private static boolean isNumber(String maybeNumber) {
        return maybeNumber.matches(NUMBER_FORMAT);
    }
}