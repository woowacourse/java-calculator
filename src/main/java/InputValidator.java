import java.util.ArrayList;
import java.util.List;

public class InputValidator {

	public boolean validate(String input) {
		if (!validateWithRegex(input)) {
			askAgain();
			return true;
		}
		String[] splittedInput = input.split(" ");
		if (validateAfterSplit(splittedInput)) {
			askAgain();
			return true;
		}
		return false;
	}

	private void askAgain() {
		System.out.println("잘못된 형식을 입력하셨습니다. 다시 입력해주세요.");
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
