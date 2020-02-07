package domain;

public class Calculator {
	private static final String REGEX_SPACE = " ";
	
	public int apply(String expression) {
		String[] expressionAsArray = expression.split(REGEX_SPACE);
		validateExpression(expressionAsArray);
		return getApplyResult(expressionAsArray);
	}

	private int getApplyResult(String[] expressionAsArray) {
		int result = 0;
		Operator operator = Operator.ADD;
		for (String expressionArg : expressionAsArray) {
			if (isOperator(expressionArg)) {
				operator = Operator.findBySymbol(expressionArg);
				continue;
			}
			int operand = Integer.parseInt(expressionArg);
			result = operator.calculate(result, operand);
		}
		return result;
	}

	private void validateExpression(String[] formulaArray) {
		validateNumericPosition(formulaArray);
		validateOperatorPosition(formulaArray);

	}

	private void validateNumericPosition(String[] expressionAsArray) {
		for (int i = 0; i < expressionAsArray.length; i+=2) {
			if (!isNumeric(expressionAsArray[i])) {
				throw new IllegalArgumentException("숫자가 있어야합니다.");
			}
		}
	}

	private void validateOperatorPosition(String[] expressionAsArray) {
		if (expressionAsArray.length == 1) {
			return;
		}

		for (int i = 1; i < expressionAsArray.length; i+=2) {
			if (!isOperator(expressionAsArray[i]) || expressionAsArray.length - 1 == i) {
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
		return Operator.isOperatorSymbol(expressionArg);
	}
}
