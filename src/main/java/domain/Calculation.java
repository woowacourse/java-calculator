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

    private static final String CAN_NOT_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";
    private static final String NO_MATCHING_OPERATOR = "일치하는 연산자가 없습니다.";

    private String operator;
    private BiFunction<Double, Double, Double>  expression;

    Calculation(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private static void validDivideZero(double secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_ZERO);
        }
    }

    public static Calculation findByOperator(String operator) {
        return Arrays.stream(Calculation.values())
                .filter(calculation -> calculation.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_MATCHING_OPERATOR));
    }

    public double calculate(double num1, double num2) {
        return expression.apply(num1, num2);
    }
}
