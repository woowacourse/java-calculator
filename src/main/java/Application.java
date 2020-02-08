import domain.Calculator;
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
			System.out.print("계산식을 입력해주세요 :");
			return calculator.calculate(InputView.inputExpression());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return getCalculateResult(calculator);
		}
	}
}
