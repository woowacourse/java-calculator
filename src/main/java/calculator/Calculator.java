package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
	static public void calculate(String expression) {
		List<String> tokens = Arrays.asList(expression.split(" "));
		System.out.println(tokens);

		if (!isValidSize(tokens)) {
			System.err.println("유효한 식이 아닙니다.");
			return;
		}

		if (!isNumber(tokens.get(0))) {
			System.err.println("유효한 식이 아닙니다.");
			return;
		}
		double condense = Integer.parseInt(tokens.get(0));
		for (int i = 1; i < tokens.size(); i += 2) {
			if (!isNumber(tokens.get(i+1))) {
				System.err.println("유효한 식이 아닙니다.");
				return;
			}
			condense = operate(condense, tokens.get(i), Integer.parseInt(tokens.get(i+1)));
		}

		System.out.println(condense);
		return;
	}

	private static double operate(double condense, String term, double next) {
		if (term.equals("+")) {
			return condense + next;
		}
		if (term.equals("-")) {
			return condense - next;
		}
		if (term.equals("*")) {
			return condense * next;
		}
		if (term.equals("/")) {
			return condense / next;
		}
		return -1;
	}

	private static boolean isValidSize(List<String> tokens) {
		if ((tokens.size() & 1) == 1) {
			return true;
		}
		return false;
	}

	private static boolean isNumber(String term) {
		int firstIndex = 0;

		if (isFirstNumberMinus(term)) {
			firstIndex = 1;
		}

		for (int i = firstIndex; i < term.length(); i++) {
			if (Character.isDigit(term.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	private static boolean isFirstNumberMinus(String term) {
		if (term.startsWith("-") && term.length() > 1) {
			return true;
		}
		return false;
	}
}
