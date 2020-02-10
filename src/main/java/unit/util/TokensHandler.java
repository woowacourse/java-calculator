package unit.util;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import unit.domain.Number;
import unit.domain.Numbers;
import unit.domain.Operators;

public class TokensHandler {
	private static final int FIRST_INDEX_OF_NUMBER = 0;
	private static final int FIRST_INDEX_OF_OPERATOR = 1;
	private static final int DISTANCE_OF_SAME_TOKEN = 2;

	public static Numbers toNumbers(final List<String> tokens) {
		final Stack<Number> numbers = new Stack<>();
		Collections.reverse(tokens);
		for (int i = FIRST_INDEX_OF_NUMBER; i < tokens.size(); i += DISTANCE_OF_SAME_TOKEN) {
			final String token = tokens.get(i);
			final double value = Double.parseDouble(token);
			numbers.push(new Number(value));
		}
		Collections.reverse(tokens);
		return new Numbers(numbers);
	}

	public static Operators toOperators(final List<String> tokens) {
		final Stack<String> operators = new Stack<>();
		Collections.reverse(tokens);
		for (int i = FIRST_INDEX_OF_OPERATOR; i < tokens.size() - 1; i += DISTANCE_OF_SAME_TOKEN) {
			final String token = tokens.get(i);
			operators.push(token);
		}
		Collections.reverse(tokens);
		return new Operators(operators);
	}
}
