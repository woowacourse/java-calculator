package util;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static String getExpression() {
		return scanner.nextLine();
	}
}
