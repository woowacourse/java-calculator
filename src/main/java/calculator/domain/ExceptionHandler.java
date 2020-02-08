package calculator.domain;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ExceptionHandler {
    private static final int EVEN = 0;
    private static final int ODD = 1;
    private static final int INDEX_INIT = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static String inputHandler() {
        try {
            return checkInputHandler(scanner.nextLine());
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("입력값을 확인해주세요.");
            scanner = new Scanner(System.in);
            return inputHandler();
        }
    }

    private static String checkInputHandler(String input) {
        if (checkString(input.split(" ")) == true && isUndefinedValue(input) == true) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isUndefinedValue(String str) {
        if (str.replace(" ", "").contains("/0")) {
            return false;
        }
        return true;
    }

    private static boolean checkString(String[] inputStrings) {
        if (inputStrings.length % 2 == EVEN) {
            return false;
        }
/*        for (int i = INDEX_INIT; i < inputStrings.length; i++) {
            if (checkIndividual(i, inputStrings[i]) == false) {
                return false;
            }
        }*/
        // depth 1으로 대신하는 코드
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputStrings)
                .allMatch(x -> checkIndividual(index.getAndIncrement(), x));
    }

    private static boolean checkIndividual(int i, String inputString) {
        if (i % 2 == EVEN) {
            return checkNumber(inputString);
        }
        if (i % 2 == ODD) {
            return checkSign(inputString);
        }
        return false;
    }

    private static boolean checkNumber(String inputString) {
        return inputString.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean checkSign(String inputString) {
        if (inputString.equals("+")) {
            return true;
        }
        if (inputString.equals("-")) {
            return true;
        }
        if (inputString.equals("*")) {
            return true;
        }
        if (inputString.equals("/")) {
            return true;
        }
        return false;
    }
}