package unit.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {
	public static List<Token> tokenize(final String inputExpression) {
		return Arrays.stream(inputExpression.split(" "))
			.map(token -> {
				try {
					return new Number(token);
				} catch (NumberFormatException e) {
					return new Operator(token);
				}
			})
			.collect(Collectors.toList());
	}
}
