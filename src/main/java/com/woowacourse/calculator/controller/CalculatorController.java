package com.woowacourse.calculator.controller;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.ExpressionFactory;
import com.woowacourse.calculator.view.InputView;
import com.woowacourse.calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final OutputView outputView;
	private final Expression expression;

	public CalculatorController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
		expression = generateExpression();
	}

	private Expression generateExpression() {
		try {
			final String inputExpression = inputView.inputExpression();
			return ExpressionFactory.generate(inputExpression);
		} catch (IllegalArgumentException e) {
			outputView.printExceptionMessage(e.getMessage());
			return generateExpression();
		}
	}

	public void calculateExpression() {
		try {
			final Double calculateResult = expression.calculate();
			outputView.printCalculateResult(calculateResult);
		} catch (IllegalArgumentException e) {
			outputView.printExceptionMessage(e.getMessage());
		}
	}
}
