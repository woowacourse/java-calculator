package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (firstElement, secondElement) -> firstElement + secondElement),
    MINUS("-", (firstElement, secondElement) -> firstElement - secondElement),
    MULTIPLY("*", (firstElement, secondElement) -> firstElement * secondElement),
    DIVIDE("/", (firstElement, secondElement) -> {
        isDividedByZero(secondElement);
        return firstElement / secondElement;
    });

    private static final Double ZERO = 0.0;
    private final String symbol;
    private final BiFunction<Double, Double, Double> operate;

    Operator(String symbol, BiFunction<Double, Double, Double> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public static Operator createOperatorByString(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.toString().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산만 가능합니다");
    }

    public double calculate(double firstElement, double secondElement) {
        return this.operate.apply(firstElement, secondElement);
    }

    private static void isDividedByZero(double element) {
        if (element == ZERO) {
            throw new IllegalArgumentException("0이 아닌 숫자로 나눠주세요");
        }
    }

}
