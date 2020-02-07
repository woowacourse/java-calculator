package study;

import domain.Calculator;
import view.InputView;

public class Application {
	public static void main(String[] args) {
		String expression = InputView.inputExpression();
		String[] values = expression.split(" ");
		System.out.println(Calculator.calculate(values));
	}
}
