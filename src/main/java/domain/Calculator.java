package domain;

public class Calculator {
	public static double calculate(String[] tokens) {
		if (isEmpty(tokens)) {
			return 0;
		}
		double result = Double.parseDouble(tokens[0]);
		for (int i = 1; i < tokens.length; i += 2) {
			Operator operator = Operator.of(tokens[i]);
			double rightOperand = Double.parseDouble(tokens[i + 1]);
			result = operator.calculate(result, rightOperand);
		}
		return result;
	}

	private static boolean isEmpty(String[] tokens) {
		return tokens == null || tokens.length == 0;
	}
}
