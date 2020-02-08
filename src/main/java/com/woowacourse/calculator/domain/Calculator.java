package com.woowacourse.calculator.domain;

public class Calculator {
    private final Expression expression;

    public Calculator(Expression expression) {
        this.expression = expression;
    }

    public int getResult() {
        return expression.calculate();
    }
}
