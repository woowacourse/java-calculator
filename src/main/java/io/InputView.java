package io;

import calculator.Operator;

import java.util.Scanner;

public class InputView {
    public static final int OPERATOR_DELIMITER = 2;
    private static final String BLANK = " ";
    public static final String NUMBER_FORMAT = "^[0-9\\+\\-]?[0-9]+$";
    public static final int FIRST_OPERATOR = 1;

    private static final Scanner sc = new Scanner(System.in);

    public String requestInput() {
        String userInput = sc.nextLine().trim();
        if (hasNoError(userInput)) {
            return userInput;
        }
        throw new RuntimeException();
    }

    private boolean hasNoError(String userInput) {
        String[] inputArray = userInput.split(BLANK);
        checkFirstNumberAndLength(inputArray);
        checkPositionIsCorrect(inputArray);
        checkNullAndBlank(userInput);
        return true;
    }

    private void checkNullAndBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new NullPointerException("값을 입력 해 주세요.");
        }
    }

    private void checkPositionIsCorrect(String[] inputArray) throws IllegalArgumentException {
        for (int i = FIRST_OPERATOR; i < inputArray.length; i += OPERATOR_DELIMITER) {
            if (!Operator.isOperator(inputArray[i]) || !isNumber(inputArray[i + 1]))
                throw new IllegalArgumentException();
        }
    }

    private void checkFirstNumberAndLength(String[] inputArray) {
        if (!isCorrectLength(inputArray.length) || !isNumber(inputArray[0])) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 정상적인 입력의 경우 1 + 3 + 5  와 같이 식의 길이가 홀수여야 합니다.
     * 이를 검증하는 메서드입니다.
     *
     * @param length
     */
    private boolean isCorrectLength(int length) {
        return length % 2 == 1;
    }

    private boolean isNumber(String target) {
        if (!target.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException("수를 입력 할 자리에 다른 값을 입력하였습니다.");
        }
        return true;
    }
}
