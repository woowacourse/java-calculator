package calculator;

public class Expression {
    private String[] expression;

    public Expression(String inputString) {
        String[] inputStringArray = splitInput(inputString);

        if (!isCorrectStringArray(inputStringArray)) {
            throw new IllegalArgumentException("입력은 다음과 같은 규칙을 따라야 합니다.\n"
                + " * 1번째, 3번째, 5번째 등 홀수번 째 문자는 숫자여야합니다.\n"
                + " * 2번째, 4번째, 6번째 등 짝수번 째 문자는 연산자(+, -, *, /)여야 합니다.\n"
                + " * 마지막 문자는 숫자여야 합니다.\n"
                + " * 각 문자들 사이에는 한 칸의 공백이 존재해야 하며, "
                + "문장의 시작과 끝에는 공백이 없어야 합니다.\n");
        }

        this.expression = inputStringArray;
    }

    private String[] splitInput(String input) {
        return input.split(" ");
    }

    private boolean isCorrectStringArray(String[] input) {
        return isOperatorAtOddIndex(input) && isNumberAtEvenIndex(input) && isOddLength(input);
    }

    private boolean isOperatorAtOddIndex(String[] input) {
        boolean ret = true;

        for (int i = 1; i < input.length && ret == true; i += 2) {
            ret = isOperator(input[i]);
        }

        return ret;
    }

    private boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    private boolean isNumberAtEvenIndex(String[] input) {
        boolean ret = true;

        for (int i = 0; i < input.length && ret == true; i += 2) {
            ret = isNumber(input[i]);
        }

        return ret;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isOddLength(String[] input) {
        return input.length % 2 == 1;
    }

    public Operand getOperand(int position) {
        int indexByPosition = getOperandIndexByPosition(position);

        if (indexByPosition >= expression.length || indexByPosition < 0) {
            return null;
        }

        return new Operand(expression[indexByPosition]);
    }

    private int getOperandIndexByPosition(int position) {
        return (position - 1) * 2;
    }

    public Operator getOperator(int position) {
        int indexByPosition = getOperatorIndexByPosition(position);

        if (indexByPosition >= expression.length || indexByPosition <= 0) {
            return null;
        }

        return new Operator(expression[indexByPosition]);
    }

    private int getOperatorIndexByPosition(int position) {
        return (position - 1) * 2 + 1;
    }

}
