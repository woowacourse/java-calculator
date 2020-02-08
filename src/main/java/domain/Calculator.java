package domain;

public class Calculator {
	private static final String REGEX_SPACE = " ";
	private static final int SINGLE_EXPRESSION_SIZE = 1;
	private static final int NUMERIC_START_IDX = 0;
	private static final int OPERATOR_START_IDX = 1;
	private static final int VALID_CHECK_IDX_UNIT = 2;

	public int calculate(String expression) {
		String[] splitExpression = expression.split(REGEX_SPACE);
		validateExpression(splitExpression);
		return getApplyResult(splitExpression);
	}

	private int getApplyResult(String[] expression) {
		int result = 0;
		Operator operator = Operator.ADD;
		for (String expressionArg : expression) {
			if (isOperator(expressionArg)) {
				operator = Operator.getOperatorOf(expressionArg);
				continue;
			}
			int operand = Integer.parseInt(expressionArg);
			result = operator.calculate(result, operand);
		}
		return result;
	}

	private void validateExpression(String[] expression) {
		validateNumericPosition(expression);
		validateOperatorPosition(expression);
	}

	private void validateNumericPosition(String[] expression) {
		for (int i = NUMERIC_START_IDX; i < expression.length; i += VALID_CHECK_IDX_UNIT) {
			if (!isNumeric(expression[i])) {
				throw new IllegalArgumentException("숫자가 있어야합니다.");
			}
		}
	}

	private void validateOperatorPosition(String[] expression) {
		if (expression.length == SINGLE_EXPRESSION_SIZE) {
			return;
		}

		for (int i = OPERATOR_START_IDX; i < expression.length; i += VALID_CHECK_IDX_UNIT) {
			if (!isOperator(expression[i]) || i == expression.length - 1) {
				throw new IllegalArgumentException("연산자 위치가 올바르지 않습니다.");
			}
		}
	}

	private boolean isNumeric(String expressionArg) {
		try {
			Integer.parseInt(expressionArg);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean isOperator(String expressionArg) {
		return Operator.isOperator(expressionArg);
	}
}
