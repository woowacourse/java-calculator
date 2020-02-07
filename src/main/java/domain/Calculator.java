package domain;

public class Calculator {
	private double result;

	public double run(String[] input) {
		result = Double.parseDouble(input[0]);
		for (int i = 1; i < input.length; i += 2) {
			calculate(Double.parseDouble(input[i + 1]), input[i]);
		}
		return result;
	}

	private void calculate(double operand, String operator) {
		if (operator.equals("+")) {
			plus(operand);
			return;
		}
		if (operator.equals("-")) {
			minus(operand);
			return;
		}
		if (operator.equals("*")) {
			multiply(operand);
			return;
		}
		if (operator.equals("/")) {
			divide(operand);
		}
	}

	private void plus(double operand) {
		result += operand;
	}

	private void minus(double operand) {
		result -= operand;
	}

	private void divide(double operand) {
		result /= operand;
	}

	private void multiply(double operand) {
		result *= operand;
	}
}
