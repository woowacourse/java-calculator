package view;

import java.util.Scanner;

public class InputView {
	private static Scanner SCANNER = new Scanner(System.in);

	public static String inputExpression() {
		return SCANNER.nextLine();
	}
}
