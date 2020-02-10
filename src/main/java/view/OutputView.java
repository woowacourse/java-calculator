package view;

public class OutputView {
	private static final String PRINT_RESULT_FORMAT = "계산결과 : %d\n";

	public static void printResult(int result) {
		System.out.printf(PRINT_RESULT_FORMAT, result);
	}
}
