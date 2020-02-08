package domain;

public class Calculator {
	private static final String REGEX_SPACE = " ";
	private static final int EVEN_START_NUM = 0;
	private static final int ODD_START_NUM = 1;
	private static final int EVEN_INDEX = 2;
	
	public int run(String expression) {
		String[] expressionAsArray = expression.split(REGEX_SPACE);
		validateExpression(expressionAsArray);
		return calculateExpression(expressionAsArray);
	}

	private int calculateExpression(String[] expressionAsArray) {
		int result = 0;
		Operator operator = Operator.ADD;
		for (String expressionArg : expressionAsArray) {
			if (Operator.isOperatorSymbol(expressionArg)) {
				operator = Operator.of(expressionArg);
				continue;
			}
			int operand = Integer.parseInt(expressionArg);
			result = operator.calculate(result, operand);
		}
		return result;
	}

	private void validateExpression(String[] expressionAsArray) {
		validateNumericPosition(expressionAsArray);
		validateOperatorPosition(expressionAsArray);
	}

	private void validateNumericPosition(String[] expressionAsArray) {
		for (int i = EVEN_START_NUM; i < expressionAsArray.length; i += EVEN_INDEX) {
			validateNumeric(expressionAsArray[i]);
		}
	}

	private void validateNumeric(String expressionArg) {
		if (!isNumeric(expressionArg)) {
			throw new IllegalArgumentException("숫자가 있어야합니다.");
		}
	}

	private void validateOperatorPosition(String[] expressionAsArray) {
		if (expressionAsArray.length % EVEN_INDEX == EVEN_START_NUM) {
			throw new IllegalArgumentException("연산자로 끝나서는 안됩니다.");
		}
		for (int i = ODD_START_NUM; i < expressionAsArray.length; i += EVEN_INDEX) {
			validateOperator(expressionAsArray[i]);
		}
	}

	private void validateOperator(String expressionArg) {
		if (!Operator.isOperatorSymbol(expressionArg)) {
			throw new IllegalArgumentException("연산자 위치가 올바르지 않습니다.");
		}
	}

	private boolean isNumeric(String expressionArg) {
		try {
			Integer.parseInt(expressionArg);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
