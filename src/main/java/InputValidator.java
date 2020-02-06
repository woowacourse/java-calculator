public class InputValidator {

	public boolean validate(String input) {
		if (!validateWithRegex(input)) {
			return true;
		}
		return false;
	}

	private boolean validateWithRegex(String input) {
		return input.matches("[0-9+-/*.\\s]+");
	}
}
