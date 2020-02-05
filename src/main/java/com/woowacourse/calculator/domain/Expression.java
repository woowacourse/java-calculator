package com.woowacourse.calculator.domain;

import java.util.Objects;

public class Expression {
    private final Numbers numbers;
    private final Operators operators;

    public Expression(final Numbers numbers, final Operators operators) {
        this.numbers = Objects.requireNonNull(numbers);
        this.operators = Objects.requireNonNull(operators);
    }

}
