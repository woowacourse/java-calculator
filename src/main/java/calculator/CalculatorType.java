package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

enum CalculatorType {
    PLUS((operand1, operand2) -> operand1 + operand2, "+"),
    MINUS((operand1, operand2) -> operand1 - operand2, "-"),
    MULTIPLY((operand1, operand2) -> operand1 * operand2, "*"),
    DIVIDE((operand1, operand2) -> operand1 / operand2, "/");

    private BiFunction<Double, Double, Double> expression;
    private String operator;

    CalculatorType(BiFunction<Double, Double, Double> expression, String operator) {
        this.expression = expression;
        this.operator = operator;
    }

    public static double calculate(double operand1, CalculatorType operator, double operand2) {
        return operator.expression.apply(operand1, operand2);
    }

    public static CalculatorType validateOperator(String input) {
        return Arrays.stream(CalculatorType.values())
                .filter(c -> c.operator.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(input + " is not valid operator"));
    }
}
