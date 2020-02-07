package domain;

public class Calculator {
	private static final String REGEX_SPACE = " ";
	
	public int apply(String formula) {
		String[] formulaArray = formula.split(REGEX_SPACE);
		validateFormula(formulaArray);
		return getApplyResult(formulaArray);
	}

	private int getApplyResult(String[] formulaArray) {
		int result = 0;
		Operator operator = Operator.ADD;
		for (String formulaArg : formulaArray) {
			if (isOperator(formulaArg)) {
				operator = Operator.findBySymbol(formulaArg);
				continue;
			}
			int operand = Integer.parseInt(formulaArg);
			result = operator.calculate(result, operand);
		}
		return result;
	}

	private void validateFormula(String[] formulaArray) {
		validateNumericPosition(formulaArray);
		validateOperatorPosition(formulaArray);

	}

	private void validateNumericPosition(String[] formulaArray) {
		for (int i = 0; i < formulaArray.length; i+=2) {
			if (!isNumeric(formulaArray[i])) {
				throw new IllegalArgumentException("숫자가 있어야합니다.");
			}
		}
	}

	private void validateOperatorPosition(String[] formulaArray) {
		if (formulaArray.length == 1) {
			return;
		}

		for (int i = 1; i < formulaArray.length; i+=2) {
			if (!isOperator(formulaArray[i]) || formulaArray.length - 1 == i) {
				throw new IllegalArgumentException("연산자 위치가 올바르지 않습니다.");
			}
		}
	}

	private boolean isNumeric(String formulaArg) {
		try {
			Integer.parseInt(formulaArg);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean isOperator(String formulaArg) {
		return Operator.isOperatorSymbol(formulaArg);
	}
}
