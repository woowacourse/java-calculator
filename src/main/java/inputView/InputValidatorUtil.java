package inputView;

import java.util.ArrayList;
import java.util.List;

public class InputValidatorUtil {

	private static List<String> numbers = new ArrayList<>();
	private static List<String> operators = new ArrayList<>();

	public static boolean isNotValidWithinRegex(String input) {
		return !input.matches("[0-9+*/\\-.\\s]+[0-9]+$");
	}

	public static boolean zeroDivisionExists(String input) {
		return input.contains("/ 0");
	}

	public static boolean validateAfterSplit(String input) {
		String[] inputSplit = input.split(" ");
		for (int i = 0; i < inputSplit.length; i++) {
			separateNumbersAndOperators(inputSplit[i], i);
		}
		List<Boolean> invalidDoubleValidations = new ArrayList<>();
		for (String number : numbers) {
			invalidDoubleValidations.add(isNotDouble(number));
		}
		clearAll();
		return invalidDoubleValidations.contains(true);
	}

	private static void separateNumbersAndOperators(String input, int index) {
		if (index % 2 == 0) {
			numbers.add(input);
			return;
		}
		operators.add(input);
	}

	private static void clearAll() {
		numbers.clear();
		operators.clear();
	}

	private static boolean isNotDouble(String number) {
		try {
			Double.parseDouble(number);
		} catch (Exception e) {
			return true;
		}
		return false;
	}
}
