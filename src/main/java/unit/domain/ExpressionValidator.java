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

	private static boolean isInvalidSize(List<Token> tokens) {
		return tokens.size() < MIN_SIZE_OF_TOKENS;
	}

	private static boolean isUnbalanced(List<Token> tokens) {
		for (int i = 0; i < tokens.size(); i++) {
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

	public static boolean isNumberTurn(int indexOfTokens) {
		return indexOfTokens % 2 == STATUS_OF_NUMBER;
	}

	public static boolean isOperatorTurn(int indexOfTokens) {
		return indexOfTokens % 2 == STATUS_OF_OPERATOR;
	}

	private static boolean isNumber(Token token) {
		return token.getClass() == Number.class;
	}

	private static boolean isOperator(Token token) {
		return token.getClass() == Operator.class;
	}
}
