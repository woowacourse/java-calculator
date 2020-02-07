package calculator;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }

    public static double calculate(String operator, double input1, double input2) {
        checkIfOperator(operator);
        double output = 0.0;
        if (operator.equals(PLUS.symbol)) {
            output = input1 + input2;
        } else if (operator.equals(MINUS.symbol)) {
            output = input1 - input2;
        } else if (operator.equals(MULTIPLY.symbol)) {
            output = input1 * input2;
        } else if (operator.equals(DIVIDE.symbol)) {
            checkZero(input2);
            output = input1 / input2;
        }
        return output;
    }

    private static void checkZero(double input) {
        if (input == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static void checkIfOperator(String symbol) {
        Operator[] operators = Operator.values();
        for (Operator operator : operators) {
            if (operator.toString().equals(symbol)) {
                return;
            }
        }
        throw new IllegalArgumentException("사칙연산 연산자만 계산 가능합니다");
    }
}