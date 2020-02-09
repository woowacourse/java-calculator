package unit;

import unit.domain.Calculator;
import unit.domain.Expression;
import unit.domain.Tokenizer;
import unit.util.DoubleHandler;
import unit.view.InputView;
import unit.view.OutputView;

public class Application {
	public static void main(String[] args) {
		String inputLine = InputView.inputExpression();
		double result = Calculator.calculate(new Expression(Tokenizer.tokenize(inputLine)));
		OutputView.printResult(DoubleHandler.round(result));
	}
}
