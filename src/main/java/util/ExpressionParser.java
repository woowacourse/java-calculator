package util;

public class ExpressionParser {
	public static String[] splitWithBlank(String expression) {
		return expression.split(" ");
	}

	public static int stringToInt(String term) {
		return Integer.parseInt(term);
	}

	public static boolean isNumber(String term) {
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
