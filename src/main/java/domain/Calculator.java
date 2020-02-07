package domain;

public class Calculator {
	private double result;

	public double calculate(String[] input) {
		result = Double.parseDouble(input[0]);
		for (int i = 1; i < input.length; i += 2) {
			calculate2(Double.parseDouble(input[i + 1]), input[i]);
		}
		return result;
	}

	private void plus(double operand) {
		result += operand;
	}

	private void calculate2(double operand, String operator) {
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

	private void minus(double operand) {
		result -= operand;
	}

	private boolean divide(double operand) {
		if (operand == 0) {
			return false;
		}
		result /= operand;
		return true;
	}

	private void multiply(double operand) {
		result *= operand;
	}
}
