package unit.domain;

import java.util.List;

public class ExpressionValidator {
	private static final int MIN_SIZE_OF_TOKENS = 3;
	private static final int STATUS_OF_NUMBER = 0;
	private static final int STATUS_OF_OPERATOR = 1;

	public static void checkValidation(final List<Token> tokens) {
		if (isInvalidSize(tokens)) {
			throw new IllegalArgumentException("식은 최소 3자 이상이어야 합니다.");
		}
		if (isUnbalanced(tokens)) {
			throw new IllegalArgumentException("연산자 혹은 숫자의 개수가 너무 많습니다.");
		}
	}

	private static boolean isInvalidSize(final List<Token> tokens) {
		return tokens.size() < MIN_SIZE_OF_TOKENS;
	}

	private static boolean isUnbalanced(final List<Token> tokens) {
		if (isEndWithOperator(tokens)) {
			return true;
		}
		for (int i = 0; i < tokens.size() - 1; i++) {
			if (isNumberTurn(i) && isNumber(tokens.get(i))) {
				continue;
			}
			if (isOperatorTurn(i) && isOperator(tokens.get(i))) {
				continue;
			}
			return true;
		}
		return false;
	}

	private static boolean isEndWithOperator(final List<Token> tokens) {
		final Token lastToken = tokens.get(tokens.size() - 1);
		return isOperator(lastToken);
	}

	private static boolean isOperator(final Token token) {
		return token.getClass() == Operator.class;
	}

	public static boolean isNumberTurn(final int indexOfTokens) {
		return indexOfTokens % 2 == STATUS_OF_NUMBER;
	}

	public static boolean isOperatorTurn(final int indexOfTokens) {
		return indexOfTokens % 2 == STATUS_OF_OPERATOR;
	}

	private static boolean isNumber(final Token token) {
		return token.getClass() == Number.class;
	}
}
