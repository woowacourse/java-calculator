package calculator.util;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static calculator.domain.Calculator.isEven;
import static calculator.domain.Calculator.isOdd;

public class ExceptionHandler {
    private static final int EVEN = 0;
    private static final String DELIMITER = " ";
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";
    private static final String NUMBER_FORMAT = "-?\\d+(\\.\\d+)?";
    private static final String DIVIDE_ZERO_STRING = "/0";
    private static List<String> operatorList = Arrays.asList("+", "-", "*", "/");

    public static String checkInputHandler(String input) {
        if (checkString(input.split(DELIMITER)) == true && checkUndefinedValue(input) == true) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public static boolean checkUndefinedValue(String str) {
        if (str.replace(BLANK, EMPTY_STRING).contains(DIVIDE_ZERO_STRING)) {
            return false;
        }
        return true;
    }

    public static boolean checkString(String[] inputStrings) {
        if (inputStrings.length % 2 == EVEN) {
            return false;
        }

        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputStrings)
                .allMatch(str -> checkIndividual(index.getAndIncrement(), str));
    }

    public static boolean checkIndividual(int i, String inputString) {
        if (isEven(i)) {
            return checkNumber(inputString);
        }
        if (isOdd(i)) {
            return checkSign(inputString);
        }
        return false;
    }

    public static boolean checkNumber(String inputString) {
        return inputString.matches(NUMBER_FORMAT);
    }

    public static boolean checkSign(String inputString) {
        if (operatorList.contains(inputString)) {
            return true;
        }
        return false;
    }

}