import java.util.ArrayList;
import java.util.List;

public class InputValidator {

	public boolean validate(String input) {
		if (!validateWithRegex(input)) {
			return true;
		}
		String[] splittedInput = input.split(" ");
		if (validateAfterSplit(splittedInput)) {
			return true;
		}
		return false;
	}

	private boolean validateWithRegex(String input) {
		return input.matches("[0-9+*/\\-.\\s]+[0-9]+$");
	}

	private boolean validateAfterSplit(String[] input) {
		List<String> numbers = new ArrayList<>();
		List<String> operators = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (i % 2 == 0) {
				numbers.add(input[i]);
			} else {
				operators.add(input[i]);
			}
		}
		for (String number : numbers) {
			try {
				Double.parseDouble(number);
			} catch (Exception e) {
				return true;
			}
		}
		return false;
	}
}
