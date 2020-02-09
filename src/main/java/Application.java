import domain.Calculator;
import domain.ExpressionFactory;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int result = getCalculateResult(calculator);
		OutputView.printResult(result);
	}

	private static int getCalculateResult(Calculator calculator) {
		try {
			return calculator.calculate(ExpressionFactory.parse(InputView.inputExpression()));
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
			return getCalculateResult(calculator);
		}
	}
}
