package calculator;

import java.util.function.BiFunction;

public enum Operator{
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> {
        checkZero(right);
        return left / right;
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> operate;

    Operator(String symbol, BiFunction<Double, Double, Double> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public String toString() {
        return this.symbol;
    }

    public double calculate(double left, double right) {
        return this.operate.apply(left, right);
    }

    public static Operator getOperatorByString(String input) {
        for (Operator operator : Operator.values()) {
            if (operator.toString().equals(input)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산 연산자만 계산 가능합니다");
    }

    private static void checkZero(double input) {
        if (input == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}