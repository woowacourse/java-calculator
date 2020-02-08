package com.woowacourse.calculator.controller;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.Tokenizer;

public class Calculator {
	public int calculate(final String inputExpression) {
		Expression expression = new Expression(Tokenizer.tokenize(inputExpression));
		return expression.calculate();
    }
}
