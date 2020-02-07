package unit.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Expression {
	private static final int NUMBER_AMOUNT_OVER = 2;
	private static final int OPERATOR_AMOUNT_OVER = -1;

	private final Stack<Token> expression;

	public Expression(final List<Token> tokens) {
		checkValidation(tokens);
		expression = toExpression(tokens);
	}

	private void checkValidation(final List<Token> tokens) {
		int status = 0;
		for (Token token : tokens) {
			status = updateBy(token, status);
			checkStatus(status);
		}
	}

	private int updateBy(final Token token, int status) {
		if (isNumber(token)) {
			status++;
		}
		if (isOperator(token)) {
			status--;
		}
		return status;
	}

	private boolean isNumber(Token token) {
		return token.getClass() == Number.class;
	}

	private boolean isOperator(Token token) {
		return token.getClass() == Operator.class;
	}

	private void checkStatus(int statusNumber) {
		final List<Integer> invalidStatus = Arrays.asList(OPERATOR_AMOUNT_OVER, NUMBER_AMOUNT_OVER);
		if (invalidStatus.contains(statusNumber)) {
			throw new IllegalArgumentException("잘못된 식입니다.");
		}
	}

	private Stack<Token> toExpression(List<Token> tokens) {
		Stack<Token> expression = new Stack<>();

		Collections.reverse(tokens);
		tokens.forEach(expression::push);
		return expression;
	}

	public Stack<Token> getExpression() {
		return expression;
	}
}
