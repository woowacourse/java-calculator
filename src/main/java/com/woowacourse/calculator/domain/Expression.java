package com.woowacourse.calculator.domain;

import java.util.Objects;

/**
 * 클래스 이름 : Expression.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public class Expression {
    private final Numbers numbers;
    private final Operators operators;

    public Expression(final Numbers numbers, final Operators operators) {
        this.numbers = Objects.requireNonNull(numbers);
        this.operators = Objects.requireNonNull(operators);
    }

    public double calculate() {
        return operators.calculate(numbers);
    }
}
