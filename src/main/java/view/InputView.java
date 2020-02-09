package view;

import java.util.Scanner;

public class InputView {
	public static Scanner scanner = new Scanner(System.in);

	public static String inputExpression() {
		System.out.println("공백으로 구분하여 식을 입력해주세요(ex. 1 + 2 - 4)");
		String input = scanner.nextLine();
		return input;
	}

}
