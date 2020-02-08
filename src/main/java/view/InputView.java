package view;

import java.util.Scanner;

public class InputView {
	private static Scanner SCANNER = new Scanner(System.in);

	public static String inputExpression() {
		System.out.print("계산식을 입력해주세요 :");
		return SCANNER.nextLine();
	}
}
