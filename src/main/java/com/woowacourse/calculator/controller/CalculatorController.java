package com.woowacourse.calculator.controller;

import com.woowacourse.calculator.domain.Expression;

public class CalculatorController {
    private final Expression expression;

    public CalculatorController(Expression expression) {
        this.expression = expression;
    }

    public int calculate() {
        return expression.calculate();
    }
}
