package util;

public class ExpressionParser {
	public static String removeBlank(String expression) {
		String result = expression.replaceAll("\\s", "");
		return result;
	}
}
