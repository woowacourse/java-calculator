package unit.util;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import unit.domain.Token;

public class TokensHandler {
	public static Stack<Token> toExpression(List<Token> tokens) {
		Stack<Token> expression = new Stack<>();

		Collections.reverse(tokens);
		tokens.forEach(expression::push);
		return expression;
	}
}
