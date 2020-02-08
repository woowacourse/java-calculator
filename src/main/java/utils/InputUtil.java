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
	private static final String PATTERN = "[0-9]+(((\\s)[+\\-*](\\s)[0-9]+)|((\\s)[/](\\s)[1-9]+))*";

	public BufferedReader input() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

	public static List<String> inputMathematicalExpression(BufferedReader reader) throws IOException {
		return checkException(reader.readLine(), reader);
	}

	private static List<String> checkException(String input, BufferedReader reader) throws IOException {
		if (isRightPattern(input)) {
			return split(input);
		}

		OutputView.showRetry();
		return inputMathematicalExpression(reader);
	}

	public static List<String> split(String input) {
		return Stream.of(input.split(SPACE)).collect(Collectors.toList());
	}

	public static boolean isRightPattern(String input) {
		return input.matches(PATTERN);
	}
}
