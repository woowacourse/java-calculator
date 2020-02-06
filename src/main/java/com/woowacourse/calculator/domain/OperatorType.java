package com.woowacourse.calculator.domain;

import java.util.Arrays;

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
