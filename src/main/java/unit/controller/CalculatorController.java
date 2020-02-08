package unit.controller;

import unit.domain.Calculator;
import unit.domain.Expression;
import unit.domain.Tokenizer;
import unit.view.InputView;
import unit.view.OutputView;

public class CalculatorController {
	public static Expression inputExpression() {
		return new Expression(Tokenizer.tokenize(InputView.inputExpression()));
	}

	public static void printResult(Calculator calculator) {
		OutputView.printResult(calculator.getResult());
	}
}
