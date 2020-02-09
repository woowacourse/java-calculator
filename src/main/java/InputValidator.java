import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private List<String> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public boolean validate(String input) {
        if (!validateWithRegex(input) || isZeroDivisionExists(input)) {
            askAgain();
            return true;
        }
        String[] splittedInput = input.split(" ");
        if (validateAfterSplit(splittedInput)) {
            askAgain();
            return true;
        }
        return false;
    }

    private void askAgain() {
        System.out.println("잘못된 형식을 입력하셨습니다. 다시 입력해주세요.");
    }

    private boolean validateWithRegex(String input) {
        return input.matches("[0-9+*/\\-.\\s]+[0-9]+$");
    }

    private boolean isZeroDivisionExists(String input) {
        return input.contains("/ 0");
    }

    private boolean validateAfterSplit(String[] input) {
        for (int i = 0; i < input.length; i++) {
            separateNumbersAndOperators(input[i], i);
        }
        List<Boolean> isNumberCheck = numbers.stream().map(this::numberCheck).collect(Collectors.toList());
        List<Boolean> isOperatorCheck = operators.stream().map(this::operatorCheck).collect(Collectors.toList());
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
        System.out.println(!operator.matches("^[0-9]"));
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
