package com.woowacourse.calculator.domain;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private String operator;

    OperatorType(final String operator) {
        this.operator = operator;
    }

    public static OperatorType of(final String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자에 포함되지 않습니다."));
    }
}
