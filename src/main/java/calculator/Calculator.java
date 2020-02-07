package calculator;

import java.util.Arrays;
import java.util.List;

import utils.Validator;

public class Calculator {
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";
	private static final String BLANK = " ";
	private static final int ZERO = 0;

	static public String calculate(String expression) {
		List<String> tokens = Arrays.asList(expression.split(BLANK));
		Validator.checkIsValidExpression(tokens);

		double accumulatedNumber = Integer.parseInt(tokens.get(ZERO));
		for (int i = 1; i < tokens.size(); i += 2) {
			Validator.checkIsNumber(tokens.get(i + 1));
			accumulatedNumber = operate(accumulatedNumber, tokens.get(i), Integer.parseInt(tokens.get(i + 1)));
		}
		return Double.toString(accumulatedNumber);
	}

	private static double operate(double previousNumber, String operator, double nextNumber) {
		if (operator.equals(PLUS)) {
			return previousNumber + nextNumber;
		}
		if (operator.equals(MINUS)) {
			return previousNumber - nextNumber;
		}
		if (operator.equals(MULTIPLY)) {
			return previousNumber * nextNumber;
		}
		if (operator.equals(DIVIDE)) {
			Validator.checkDivideByZero(nextNumber);
			return previousNumber / nextNumber;
		}
		throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
	}

}
