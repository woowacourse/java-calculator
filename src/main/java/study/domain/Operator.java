/**
 * Operator.java
 * 사칙 연산을 담당하는 enum
 * 우아한테크코스 1주차 미션 온보딩 - 문자열 계산기
 * 히로-핀
 * https://github.com/hotheadfactory/java-calculator
 */
package study.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

    public double calculate(double leftOperand, double rightOperand) {
        return expression.apply(leftOperand, rightOperand);
    }
}
