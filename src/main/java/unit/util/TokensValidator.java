package unit.util;

import java.util.List;

import unit.domain.Operator;

public class TokensValidator {
	private static final int MIN_SIZE_OF_TOKENS = 3;
	private static final int STATUS_OF_NUMBER = 0;
	private static final int STATUS_OF_OPERATOR = 1;

	public static void checkValidation(final List<String> tokens) {
		if (isInvalidSize(tokens)) {
			throw new IllegalArgumentException("식은 최소 3자 이상이어야 합니다.");
		}
		if (isEndWithOperator(tokens)) {
			throw new IllegalArgumentException("식의 마지막은 연산자가 될수 없습니다.");
		}
		if (isUnbalanced(tokens)) {
			throw new IllegalArgumentException("연산자 혹은 숫자의 개수가 너무 많습니다.");
		}
	}

	private static boolean isInvalidSize(final List<String> tokens) {
		return tokens.size() < MIN_SIZE_OF_TOKENS;
	}

	private static boolean isEndWithOperator(final List<String> tokens) {
		final int lastIndexOfTokens = tokens.size() - 1;
		final String lastToken = tokens.get(lastIndexOfTokens);
		return Operator.isIn(lastToken);
	}

	private static boolean isUnbalanced(final List<String> tokens) {
		for (int i = 0; i < tokens.size() - 1; i++) {
			final String token = tokens.get(i);
			if (isNumberTurn(i) && isNumber(token)) {
				continue;
			}
			if (isOperatorTurn(i) && Operator.isIn(token)) {
				continue;
			}
			return true;
		}
		return false;
	}

	private static boolean isNumberTurn(final int indexOfTokens) {
		return indexOfTokens % 2 == STATUS_OF_NUMBER;
	}

	private static boolean isOperatorTurn(final int indexOfTokens) {
		return indexOfTokens % 2 == STATUS_OF_OPERATOR;
	}

	public static boolean isNumber(final String token) {
		char singleFigures;
		for (int i = 0; i < token.length(); i++) {
			singleFigures = token.charAt(i);
			if (!Character.isDigit(singleFigures)) {
				return false;
			}
		}
		return true;
	}
}
