package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculation {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLICATION("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> {
        validDivideZero(num2);
        return num1 / num2;
    });

    private String operator;
    private BiFunction<Double, Double, Double>  expression;

    Calculation(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private static void validDivideZero(double num) {
        if (num == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static Calculation findByOperator(String operator) {
        return Arrays.stream(Calculation.values())
                .filter(calculation -> calculation.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 연산자가 없습니다."));
    }

    public double calculate(double num1, double num2) {
        return expression.apply(num1, num2);
    }
}
