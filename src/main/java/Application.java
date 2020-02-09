import domain.Calculator;
import utils.Validator;
import view.InputView;
import view.OutputView;

public class Application {

	public static void main(String[] args) {
		runCalculator();
	}

	private static void runCalculator() {
		try {
			String input = InputView.inputExpression();
			Validator.checkIsBlank(input);
			String result = Calculator.calculate(input);
			OutputView.printResult(result);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			runCalculator();
		}
	}

}
