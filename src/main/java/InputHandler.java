import java.util.Scanner;

public class InputHandler {
	private Scanner scanner = new Scanner(System.in);
	private InputValidator inputValidator = new InputValidator();

	public String getInput() {
		String input;
		do {
			input = scanner.nextLine();
		} while (inputValidator.validate(input));
		return input;
	}
}
