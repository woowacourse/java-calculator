package unit;

import java.util.List;

import unit.domain.Calculator;
import unit.domain.Numbers;
import unit.domain.Operators;
import unit.util.Tokenizer;
import unit.util.TokensValidator;
import unit.util.DoubleHandler;
import unit.util.TokensHandler;
import unit.view.InputView;
import unit.view.OutputView;

public class Application {
	public static void main(String[] args) {
		String inputLine = InputView.inputExpression();
		List<String> tokens = Tokenizer.tokenize(inputLine);

		TokensValidator.checkValidation(tokens);

		Numbers numbers = TokensHandler.toNumbers(tokens);
		Operators operators = TokensHandler.toOperators(tokens);

		double result = Calculator.calculate(numbers, operators);
		OutputView.printResult(DoubleHandler.round(result));
	}
}
