import java.util.Scanner;

public class InputHandler {
	private Scanner scanner = new Scanner(System.in);
	private InputValidator inputValidator = new InputValidator();

	public String getInput() {
		String input;
		System.out.println("=========계산기==========");
		System.out.println("숫자(0-9)와 연산자를 공백 기준으로 입력해주세요.");
		do {
			input = scanner.nextLine();
		} while (inputValidator.validate(input));
		return input;
	}
}
