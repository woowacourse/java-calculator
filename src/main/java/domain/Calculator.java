package domain;

public class Calculator {
	public static int calculate(String[] tokens) {
		int result = Integer.parseInt(tokens[0]);
		for (int i = 1; i < tokens.length; i += 2) {
			String operator = tokens[i];
			int rightOperand = Integer.parseInt(tokens[i + 1]);
			result = Operator.of(operator)
					.calculate(result, rightOperand);
		}
		return result;
	}
}
