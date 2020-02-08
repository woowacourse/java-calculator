package unit.view;

public class OutputView {
	public static void printResult(final double result) {
		if (result == (long)result) {
			System.out.println(String.format("계산 결과 : %d", (long)result));
			return;
		}
		System.out.println(String.format("계산 결과 : %s", result));
	}
}
