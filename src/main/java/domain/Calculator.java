package domain;

import java.util.Arrays;
import java.util.List;

import utils.Validator;

public class Calculator {
	private static final String BLANK = " ";
	private static final int ZERO = 0;

	static public String calculate(String expression) {
		List<String> tokens = Arrays.asList(expression.split(BLANK));
		Validator.checkIsValidExpression(tokens);

		double accumulatedNumber = Integer.parseInt(tokens.get(ZERO));
		for (int i = 1; i < tokens.size(); i += 2) {
			String operator = tokens.get(i);
			String nextNumber = tokens.get(i + 1);

			Validator.checkIsNumber(nextNumber);
			Validator.checkDivideByZero(operator, Double.parseDouble(nextNumber));
			accumulatedNumber = Operator.isEqual(operator).operate(accumulatedNumber, Double.parseDouble(nextNumber));
		}
		return Double.toString(accumulatedNumber);
	}

}
