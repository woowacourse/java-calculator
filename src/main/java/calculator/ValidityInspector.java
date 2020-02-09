package calculator;

public class ValidityInspector {
    public void checkUserInputIsBlankOrEmpty(String input) {
        if (isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException("공백 또는 빈 문자열을 입력하셨습니다.");
        }
    }

    private boolean isEmpty(String input) {
        return input.equals(Constant.EMPTY_STRING);
    }

    private boolean isBlank(String input) {
        return input.equals(Constant.BLANK);
    }

    public void checkCanConvertUserInputToNumberAndOperator(String[] splitedInput) {
        checkSplitedInputEmpty(splitedInput);
        String firstClause = splitedInput[0];
        checkCorrectDoubleNumber(firstClause);
        try {
            for (int i = 1; i < splitedInput.length; i = i + 2) {
                String operator = splitedInput[i];
                String secondClause = splitedInput[i + 1];
                checkDivideByZero(operator, secondClause);
                checkCorrectOperator(operator);
                checkCorrectDoubleNumber(secondClause);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("잘못된 계산식을 입력하였습니다.");
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
        if (!Operator.isRightOperator(s)) {
            throw new IllegalArgumentException("잘못된 연산자를 입력하였습니다.");
        }
    }

    private void checkSplitedInputEmpty(String[] splitedInput) {
        if (splitedInput.length == 0) {
            throw new IllegalArgumentException("공백을 입력하였습니다.");
        }
    }

    private void checkDivideByZero(String operator, String secondClause) {
        if (Operator.isDivisionOperator(operator) && Integer.toString(Constant.ZERO).equals(secondClause)) {
            throw new IllegalArgumentException("0으로 나누는 식을 입력하셨습니다.");
        }
    }
}
