package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import view.OutputView;

public class InputUtil {
	private static final String SPACE = " ";
	private static final String PATTERN = "[0-9]+(((\\s)[+\\-*](\\s)[0-9]+)|((\\s)[/](\\s)[1-9]+[0-9]*))*";

	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static List<String> inputMathematicalExpression() throws IOException {
		return checkException(bufferedReader.readLine());
	}

	private static List<String> checkException(String input) throws IOException {
		if (isRightPattern(input)) {
			return split(input);
		}

		OutputView.showRetry();
		return inputMathematicalExpression();
	}

	public static List<String> split(String input) {
		return Stream.of(input.split(SPACE)).collect(Collectors.toList());
	}

	public static boolean isRightPattern(String input) {
		return input.matches(PATTERN);
	}
}
