package study;

import domain.Calculator;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		String expression = InputView.inputExpression();
		String[] values = expression.split(" ");
		int result = Calculator.calculate(values);
		OutputView.printResult(result);
	}
}
