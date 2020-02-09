package com.woowacourse.calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * 클래스 이름 : OperatorType.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public enum OperatorType {
    PLUS("+", Double::sum),
    MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        if (secondOperand == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }),
    MULTIPLY("*", (firstOperand, secondOperand) -> firstOperand * secondOperand);

    private String operator;
    private BinaryOperator<Double> expression;

    OperatorType(final String operator, final BinaryOperator<Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static OperatorType of(final String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자에 포함되지 않습니다."));
    }

    public double calculate(final Double firstOperand, final Double secondOperand) {
        return expression.apply(firstOperand, secondOperand);
    }
}
