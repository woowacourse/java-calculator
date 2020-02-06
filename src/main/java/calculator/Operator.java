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

    public double calculate(double input1, double input2) {
        if (this == PLUS) {
            return input1 + input2;
        } else if (this == MINUS) {
            return input1 - input2;
        } else if (this == MULTIPLY) {
            return input1 * input2;
        } else if (this == DIVIDE) {
            checkZeroDivide(input2);
            return input1 / input2;
        }
    }

    private void checkZeroDivide(double input) {
        if (this == DIVIDE && input == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
