import domain.Calculator;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int result = getApplyResult(calculator);
		OutputView.printResult(result);
	}

	private static int getApplyResult(Calculator calculator) {
		try {
			System.out.print("계산식을 입력해주세요 :");
			return calculator.run(InputView.getExpression());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getApplyResult(calculator);
		}
	}
}
