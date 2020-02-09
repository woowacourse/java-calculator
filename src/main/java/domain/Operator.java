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

    public static Operator findOperator(String operator) {
        for (Operator compareOperator : Operator.values()) {
            if (compareOperator.operator.equals(operator)) {
                return compareOperator;
            }
        }
        throw new IllegalArgumentException("올바른 연산자를 입력하지 않으셨습니다. (입력한 연산자 : " + operator + ")");
    }

    public double calculate(double operand1, double operand2) {
        return this.expression.apply(operand1, operand2);
    }
}
