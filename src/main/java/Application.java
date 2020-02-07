import domain.Calculator;
import util.InputView;
import util.OutputView;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int result = getApplyResult(calculator);
		OutputView.printResult(result);
	}

	private static int getApplyResult(Calculator calculator) {
		try {
			System.out.print("계산식을 입력해주세요 :");
			return calculator.apply(InputView.getExpression());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return getApplyResult(calculator);
		}
	}
}
