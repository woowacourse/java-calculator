package unit.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Expression {
	private static final int MIN_SIZE_OF_TOKENS = 3;
	private static final int INITIAL_STATUS = 0;
	private static final int NUMBER_PUSHED_STATUS = 1;

	private final Stack<Token> expression;

	public Expression(final List<Token> tokens) {
		checkValidation(tokens);
		expression = toExpression(tokens);
	}

	private void checkValidation(final List<Token> tokens) {
		if (isInvalidSize(tokens)) {
			throw new IllegalArgumentException("식은 최소 3자 이상이어야 합니다.");
		}
		if (isUnbalanced(tokens)) {
			throw new IllegalArgumentException("연산자 혹은 숫자의 개수가 너무 많습니다.");
		}
	}

	private boolean isInvalidSize(List<Token> tokens) {
		return tokens.size() < MIN_SIZE_OF_TOKENS;
	}

	private boolean isUnbalanced(List<Token> tokens) {
		boolean isUnbalanced = false;
		final List<Integer> balancedStatus = Arrays.asList(INITIAL_STATUS, NUMBER_PUSHED_STATUS);

		int tokensStatus = INITIAL_STATUS;
		for (Token token : tokens) {
			tokensStatus = updateBy(token, tokensStatus);
			if (isNotIn(balancedStatus, tokensStatus)) {
				isUnbalanced = true;
				break;
			}
		}
		return isUnbalanced;
	}

	private int updateBy(final Token token, int tokensStatus) {
		if (isNumber(token)) {
			tokensStatus++;
		}
		if (isOperator(token)) {
			tokensStatus--;
		}
		return tokensStatus;
	}

	private boolean isNumber(Token token) {
		return token.getClass() == Number.class;
	}

	private boolean isOperator(Token token) {
		return token.getClass() == Operator.class;
	}

	private boolean isNotIn(final List<Integer> balancedStatus, final int tokensStatus) {
		return !balancedStatus.contains(tokensStatus);
	}

	private Stack<Token> toExpression(List<Token> tokens) {
		Stack<Token> expression = new Stack<>();

		Collections.reverse(tokens);
		tokens.forEach(expression::push);
		return expression;
	}

	public int calculate() {
		int result = 0;
		Number number1;
		Operator operator;
		Number number2;

		while (expression.size() >= MIN_SIZE_OF_TOKENS) {
			number1 = (Number)expression.pop();
			operator = (Operator)expression.pop();
			number2 = (Number)expression.pop();

			result = operator.calculate(number1, number2);

			expression.push(new Number(Integer.toString(result)));
		}
		return result;
	}

	public Stack<Token> getExpression() {
		return expression;
	}
}
