package unit.util;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
	public static List<String> tokenize(final String inputExpression) {
		final String[] tokens = inputExpression.split(" ");
		return Arrays.asList(tokens);
	}
}
