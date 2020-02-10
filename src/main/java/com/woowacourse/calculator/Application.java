package com.woowacourse.calculator;

import com.woowacourse.calculator.controller.CalculatorController;
import com.woowacourse.calculator.view.InputView;
import com.woowacourse.calculator.view.OutputView;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		CalculatorController calculatorController = new CalculatorController(inputView, outputView);
		calculatorController.calculateExpression();
	}
}
