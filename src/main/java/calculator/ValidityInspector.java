package calculator;

import java.util.ArrayList;
import java.util.List;

public class ValidityInspector {
    private List<String> operators;

    ValidityInspector() {
        operators = new ArrayList<>();
        operators.add(Operator.Plus.getValue());
        operators.add(Operator.Minus.getValue());
        operators.add(Operator.Multiplication.getValue());
        operators.add(Operator.Division.getValue());
    }

    public void checkUserInputIsBlankOrEmpty(String input) {
        if (isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException("공백 또는 빈 문자열을 입력하셨습니다.");
        }
    }

    private boolean isEmpty(String input) {
        return input.equals("");
    }

    private boolean isBlank(String input) {
        return input.equals(" ");
    }

    public void checkCanConvertUserInputToNumberAndOperator(String[] splitedInput) {
        checkSplitedInputEmpty(splitedInput);
        String firstClause = splitedInput[0];
        checkCorrectDoubleNumber(firstClause);
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            String operator = splitedInput[i];
            String secondClause = splitedInput[i + 1];
            if (Operator.Division.getValue().equals(operator) && "0".equals(secondClause)) {
                throw new IllegalArgumentException("0으로 나누는 식을 입력하셨습니다.");
            }
            checkCorrectOperator(operator);
            checkCorrectDoubleNumber(secondClause);
        }
    }

    private void checkCorrectDoubleNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 수를 입력하였습니다.");
        }
    }

    private void checkCorrectOperator(String s) {
        if (!operators.contains(s)) {
            throw new IllegalArgumentException("잘못된 연산자를 입력하였습니다.");
        }
    }

    private void checkSplitedInputEmpty(String[] splitedInput) {
        if (splitedInput.length == 0) {
            throw new IllegalArgumentException("공백을 입력하였습니다.");
        }
    }
}
