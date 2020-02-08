package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String EXPRESSION_INPUT_MESSAGE = "계산식을 입력해주세요: ";

	public static String inputExpression() {
		System.out.print(EXPRESSION_INPUT_MESSAGE);
		return SCANNER.nextLine();
	}
}
