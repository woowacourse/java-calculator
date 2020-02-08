package com.woowacourse.calculator.controller;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.Tokenizer;

public class Calculator {
	private Expression expression;

    public int calculate(final String inputExpression) {
		expression = new Expression(Tokenizer.tokenize(inputExpression));
		return expression.calculate();
    }
}
