package unit.domain;

import java.util.List;
import java.util.Stack;

import unit.util.TokensHandler;

public class Expression {
	private final Stack<Token> expression;

	public Expression(final List<Token> tokens) {
		ExpressionValidator.checkValidation(tokens);
		expression = TokensHandler.toExpression(tokens);
	}

	public Token pop() {
		return expression.pop();
	}

	public void push(final Token token) {
		expression.push(token);
	}

	public boolean isSizeGreaterThanOrEqualTo(final int size) {
		return expression.size() >= size;
	}
}
