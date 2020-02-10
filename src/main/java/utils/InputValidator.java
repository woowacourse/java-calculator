package utils;

import domain.Operator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class InputValidator {
    private static final String DIVIDE_BY_ZERO = "/0";

    public static String checkInputHandler(String input) {
        if (checkString(input.split(" ")) && isUndefinedValue(input)) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isUndefinedValue(String str) {
        if (str.replace(" ", "").contains(DIVIDE_BY_ZERO)) {
            return false;
        }
        return true;
    }

    private static boolean checkString(String[] inputStrings) {
        if (EvenChecker.isEven(inputStrings.length)) {
            return false;
        }
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputStrings)
                .allMatch(x -> checkIndividual(index.getAndIncrement(), x));
    }

    private static boolean checkIndividual(int i, String inputString) {
        if (EvenChecker.isEven(i)) {
            return checkNumber(inputString);
        }
        return checkSign(inputString);
    }

    private static boolean checkNumber(String inputString) {
        return inputString.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean checkSign(String inputString) {
        return Arrays.stream(Operator.values())
                .anyMatch(x-> (x.isExistOperator(inputString)));
    }
}
