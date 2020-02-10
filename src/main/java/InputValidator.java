public class InputValidator {
    private final String ERROR_AFTER_SPLIT_MESSAGE = "숫자 또는 연산자가 연속으로 오거나, 숫자와 연산자를 공백을 두지 않고 입력하셨습니다.";
    private final String ERROR_ZERO_DIVISION_MESSAGE = " 0으로 나누는 경우가 존재합니다.";
    private final String ERROR_BEFORE_SPLIT_MESSAGE = "숫자(0-9) 또는 연산자(+, -, *, /)를 제외한 다른 문자가 들어있습니다.";

    public boolean isReenterWithInvalidValue(String input) {
        String[] splittedInput = input.split(" ");
        if (!validateWithRegex(input)) {
            askAgain(ERROR_BEFORE_SPLIT_MESSAGE);
            return true;
        }
        return validateAfterSplit(splittedInput);
    }

    private void askAgain(String ErrorMessage) {
        System.out.println(ErrorMessage);
        System.out.println("다시 입력해주세요.");
    }

    private boolean validateWithRegex(String input) {
        return input.matches("[0-9+*/\\-.\\s]+[0-9]+$");
    }

    private boolean validateAfterSplit(String[] input) {
        for (int i = 0; i < input.length; i++) {
            try {
                separateNumbersAndOperatorsCheck(input[i], i);
            } catch (IllegalArgumentException e) {
                askAgain(e.getMessage());
                return true;
            }
        }
        return false;
    }

    private void separateNumbersAndOperatorsCheck(String input, int index) throws IllegalArgumentException {
        if (index % 2 == 0) {
            numberCheck(input);
            return;
        }
        operatorCheck(input);
    }

    private void operatorCheck(String operator) {
        if (!operator.matches("[^0-9]")) {
            throw new IllegalArgumentException(ERROR_AFTER_SPLIT_MESSAGE);
        }
    }

    private void numberCheck(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_AFTER_SPLIT_MESSAGE);
        }
    }
}