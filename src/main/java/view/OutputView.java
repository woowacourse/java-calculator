package view;

public class OutputView {
	private static final String RESULT = "계산 결과: ";
	private static final String RETRY = "에러: 스페이스로 구분해서 다시 입력하세요! \n";
	private static final String EXAMPLE = "ex) 1 + 2 * 3";

	public static void showResult(double result) {
		System.out.println(RESULT + result);
	}

	public static void showRetry() {
		System.out.println(RETRY);
		System.out.println(EXAMPLE);
	}
}
