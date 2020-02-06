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
        if (operator == PLUS.symbol) {
            return input1 + input2;
        } else if (operator == MINUS.symbol) {
            return input1 - input2;
        } else if (operator == MULTIPLY.symbol) {
            return input1 * input2;
        } else if (operator == DIVIDE.symbol) {
            checkZero(input2);
            return input1 / input2;
        }
    }

    private static void checkZero(double input) {
        if (input == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static void checkIfOperator(String symbol) {
        Operator[] operators = Operator.values();
        for (Operator operator : operators) {
            if (operator.toString() != symbol) {
                throw new IllegalArgumentException("사칙연산 연산자만 계산 가능합니다");
            }
        }
    }
}
