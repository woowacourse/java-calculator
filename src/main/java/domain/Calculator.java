package domain;

public class Calculator {
	public static double calculate(String[] values) {
		double result = Double.parseDouble(values[0]);
		for (int i = 1; i < values.length; i += 2) {
			String operator = values[i];
			double rightOperand = Double.parseDouble(values[i + 1]);
			result = Operator.of(operator)
					.calculate(result, rightOperand);
		}
		return result;
	}
}
