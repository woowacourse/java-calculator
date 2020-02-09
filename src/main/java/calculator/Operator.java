package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

enum Operator {
    PLUS((operand1, operand2) -> operand1 + operand2, "+"),
    MINUS((operand1, operand2) -> operand1 - operand2, "-"),
    MULTIPLY((operand1, operand2) -> operand1 * operand2, "*"),
    DIVIDE((operand1, operand2) -> operand1 / operand2, "/");

    private BiFunction<Double, Double, Double> expression;
    private String operator;

    Operator(BiFunction<Double, Double, Double> expression, String operator) {
        this.expression = expression;
        this.operator = operator;
    }

    public static double calculate(double operand1, Operator operator, double operand2) {
        return operator.expression.apply(operand1, operand2);
    }

    public static Operator validateOperator(String input) throws IllegalArgumentException {
        return Arrays.stream(Operator.values())
                .filter(c -> c.operator.equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
