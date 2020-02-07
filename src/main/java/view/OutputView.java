package view;

public class OutputView {
	private static final String RESULT = "계산 결과: ";
	private static final String RETRY = "에러: 다시 입력하세요!";

	public static void showResult(double result) {
		System.out.println(RESULT + result);
	}

	public static void showRetry() {
		System.out.println(RETRY);
	}
}
