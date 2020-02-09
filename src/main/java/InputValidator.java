import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private List<String> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public boolean validate(String input) {
        String[] splittedInput = input.split(" ");
        if (!validateWithRegex(input)) {
            askAgainBeforeSplit();
            return true;
        }
        if (isZeroDivisionExists(input)) {
            askAgainWithZeroDivision();
            return true;
        }
        if (validateAfterSplit(splittedInput)) {
            askAgainAfterSplit();
            return true;
        }
        return false;
    }

    private void askAgainAfterSplit() {
        System.out.println("숫자 또는 연산자가 연속으로 오거나, 숫자와 연산자를 공백을 두지 않고 입력하셨습니다.");
        System.out.println("다시 입력해주세요.");
    }

    private void askAgainWithZeroDivision() {
        System.out.println("또는 0으로 나누는 경우가 존재합니다.");
        System.out.println("다시 입력해주세요.");
    }

    private void askAgainBeforeSplit() {
        System.out.println("숫자(0-9) 또는 연산자(+, -, *, /)를 제외한 다른 문자가 들어있습니다.");
        System.out.println("다시 입력해주세요.");
    }

    private boolean validateWithRegex(String input) {
        return input.matches("[0-9+*/\\-.\\s]+[0-9]+$");
    }

    private boolean isZeroDivisionExists(String input) {
        return input.contains("/ 0");
    }

    private boolean validateAfterSplit(String[] input) {
        List<Boolean> isNumberCheck = new ArrayList<>();
        List<Boolean> isOperatorCheck = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            separateNumbersAndOperators(input[i], i);
        }
        for (String number : numbers) {
            isNumberCheck.add(numberCheck(number));
        }
        for (String operator : operators) {
            isOperatorCheck.add(operatorCheck(operator));
        }
        return isNumberCheck.contains(false) || isOperatorCheck.contains(false);
    }

    private void separateNumbersAndOperators(String input, int index) {
        if (index % 2 == 0) {
            numbers.add(input);
            return;
        }
        operators.add(input);
    }

    private boolean operatorCheck(String operator) {
        return !operator.matches("^[0-9]");
    }

    private boolean numberCheck(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
