package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";
	private static final String SPACE = " ";
	private static final int ONE = 1;
	private static final int ZERO = 0;

	static public void calculate(String expression) {
		List<String> tokens = Arrays.asList(expression.split(SPACE));

		if (!isValidSize(tokens) || !isNumber(tokens.get(ZERO))) {
			System.err.println("유효한 식이 아닙니다.");
			return;
		}

		double condense = Integer.parseInt(tokens.get(ZERO));
		for (int i = 1; i < tokens.size(); i += 2) {
			if (!isValidOperator(tokens.get(i))) {
				System.err.println("올바른 연산자가 아닙니다.");
			}
			if (!isNumber(tokens.get(i + 1))) {
				System.err.println("유효한 식이 아닙니다.");
				return;
			}
			condense = operate(condense, tokens.get(i), Integer.parseInt(tokens.get(i + 1)));
		}

		System.out.println(condense);
		return;
	}

	private static boolean isValidOperator(String operator) {
		String[] validOperator = {PLUS, MINUS, MULTIPLY, DIVIDE};
		return Arrays.asList(validOperator).contains(operator);
	}

	private static double operate(double condense, String operator, double next) {
		if (operator.equals(PLUS)) {
			return condense + next;
		}
		if (operator.equals(MINUS)) {
			return condense - next;
		}
		if (operator.equals(MULTIPLY)) {
			return condense * next;
		}
		if (operator.equals(DIVIDE)) {
			if (next == ZERO) {
				System.err.println("0으로 나눌 수는 없습니다.");
				return ZERO;
			}
			return condense / next;
		}
		return ZERO;
	}

	private static boolean isValidSize(List<String> tokens) {
		if ((tokens.size() & ONE) == ONE) {
			return true;
		}
		return false;
	}

	private static boolean isNumber(String term) {
		int firstIndex = ZERO;

		if (isFirstNumberMinus(term)) {
			firstIndex = ONE;
		}

		for (int i = firstIndex; i < term.length(); i++) {
			if (Character.isDigit(term.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	private static boolean isFirstNumberMinus(String term) {
		if (term.startsWith(MINUS) && term.length() > ONE) {
			return true;
		}
		return false;
	}
}
