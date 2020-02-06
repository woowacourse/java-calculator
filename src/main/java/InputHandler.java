import java.util.Scanner;

public class InputHandler {
	private Scanner scanner = new Scanner(System.in);

	public String getInput() {
		String input = scanner.nextLine();
		return input;
	}

	private boolean validateWithRegex(String input) {
		return input.matches("[0-9+\\-*/]");
	}
}
