package study;

import domain.Calculator;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		calculate();
	}

	private static void calculate() {
		try {
			String expression = InputView.inputExpression();
			String[] tokens = expression.split(" ");
			int result = Calculator.calculate(tokens);
			OutputView.printResult(result);
		} catch (Exception e) {
			System.out.println("잘못된 식입니다.");
			calculate();
		}
	}
}
