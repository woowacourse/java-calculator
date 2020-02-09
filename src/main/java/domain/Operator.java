package domain;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> {
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    });

    private final String operator;
    private final BinaryOperator<Double> expression;

    Operator(String operator, BinaryOperator<Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double calculate(double operand1, double operand2) {
        return this.expression.apply(operand1, operand2);
    }

    public boolean isSameOperator(String operator) {
        if (this.operator.equals(operator)) {
            return true;
        }
        return false;
    }
}
