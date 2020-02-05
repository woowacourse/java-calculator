package com.woowacourse.calculator.domain;

import java.util.List;
import java.util.Objects;

public class Operators {
    private final List<OperatorType> operators;

    public Operators(final List<OperatorType> operators) {
        Objects.requireNonNull(operators);
        this.operators = operators;
    }
}

