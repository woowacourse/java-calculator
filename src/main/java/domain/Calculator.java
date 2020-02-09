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

	private void calculate(double operand, String symbol) {
		for (Operator operator : Operator.values()) {
			findAndExecute(operand, symbol, operator);
		}
	}

	private void findAndExecute(double operand, String symbol, Operator operator) {
		if (operator.getSymbol().equals(symbol)) {
			result = operator.getFunction().applyAsDouble(result, operand);
		}
	}
}
