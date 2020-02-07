package domain;

import util.InputView;

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
		validateNumeric(formulaArray);
		validateOperator(formulaArray);

	}

	void validateNumeric(String[] formulaArray) {
		for (int i = 0; i < formulaArray.length; i+=2) {
			if (!isNumeric(formulaArray[i])) {
				throw new IllegalArgumentException("숫자가 있어야합니다.");
			}
		}
	}

	void validateOperator(String[] formulaArray) {
		if (formulaArray.length == 1) {
			return;
		}

		for (int i = 1; i < formulaArray.length; i+=2) {
			if (!isNumeric(formulaArray[i])) {
				throw new IllegalArgumentException("숫자가 있어야합니다.");
			}
		}
	}

	private boolean isNumeric(String formulaArg) {
		for (int i = 0; i < formulaArg.length(); i++) {
			if (formulaArg.codePointAt(i) < '0'
				|| formulaArg.codePointAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	private boolean isOperator(String formulaArg) {
		return Operator.isOperatorSymbol(formulaArg);
	}
}
