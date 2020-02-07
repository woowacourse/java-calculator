import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Application {

	public static void main(String[] args) {
		while (true) {
			try {
				String input = InputView.inputExpression();
				String result = Calculator.calculate(input);
				OutputView.printResult(result);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
