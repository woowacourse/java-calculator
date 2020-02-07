package domain;

public class Calculator {
	public static int calculate(String[] values) {
		int result = Integer.parseInt(values[0]);
		for (int i = 1; i < values.length; i += 2) {
			String operator = values[i];
			int rightOperand = Integer.parseInt(values[i + 1]);
			result = Operator.of(operator)
					.calculate(result, rightOperand);
		}
		return result;
	}
}
