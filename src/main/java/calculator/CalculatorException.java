package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CalculatorException {
    private static final String EXPRESSION_DELIMITER = " ";
    private static final int INDEX_START = 0;
    private static final int INDEX_ONE = 1;

    public static void checkValidInput(String input) {
        List<String> splittedInput = Arrays.asList(input.split(EXPRESSION_DELIMITER));
        checkClusteredElements(splittedInput);
        checkIfStartWithSymbol(splittedInput);
        checkIfEndWithSymbol(splittedInput);
    }

    private static void checkIfStartWithSymbol(List<String> input) {
        if (!isNumber(input.get(INDEX_START))) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다");
        }
    }

    private static void checkIfEndWithSymbol(List<String> input) {
        if (!isNumber(input.get(input.size() - INDEX_ONE))) {
            throw new IllegalArgumentException("숫자로 끝나야 합니다");
        }
    }

    public static Boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static void checkClusteredElements(List<String> input) {
        IntStream.range(0, input.size() - INDEX_ONE).forEach(i -> {
            checkIfClustered(input.get(i), input.get(i + INDEX_ONE));
        });
    }

    private static void checkIfClustered(String prev, String post) {
        checkIfBothAreNumbers(prev, post);
        checkIfBothAreSymbols(prev, post);
    }

    private static void checkIfBothAreNumbers(String prev, String post) {
        if (isNumber(prev) && isNumber(post)) {
            throw new IllegalArgumentException("숫자가 연속되면 안됩니다");
        }
    }

    private static void checkIfBothAreSymbols(String prev, String post) {
        if (!isNumber(prev) && !isNumber(post)) {
            throw new IllegalArgumentException("연산자가 연속되면 안됩니다");
        }
    }
}
