package unit.domain;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	public static List<Token> tokenize(final String inputExpression) {
		List<Token> result = new ArrayList<>();
		String[] tokens = inputExpression.split(" ");

		for (int i = 0; i < tokens.length; i++) {
			if (ExpressionValidator.isNumberTurn(i)) {
				result.add(new Number(tokens[i]));
				continue;
			}
			if (ExpressionValidator.isOperatorTurn(i)) {
				result.add(new Operator(tokens[i]));
			}
		}
		return result;
	}
}
