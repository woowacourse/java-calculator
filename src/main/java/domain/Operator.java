package domain;

import java.util.function.DoubleBinaryOperator;

public enum Operator {
	PLUS("+", (x, y) -> (x + y)),
	MINUS("-", (x, y) -> (x - y)),
	MULTIPLY("*", (x, y) -> (x * y)),
	DIVIDE("/", (x, y) -> (x / y));

	private String symbol;
	private DoubleBinaryOperator function;

	Operator(String symbol, DoubleBinaryOperator function) {
		this.symbol = symbol;
		this.function = function;
	}

	public String getSymbol() {
		return symbol;
	}

	public DoubleBinaryOperator getFunction() {
		return function;
	}

	public double findAndExecute(double result, double operand, String symbol) {
		if (getSymbol().equals(symbol)) {
			return getFunction().applyAsDouble(result, operand);
		}
		return result;
	}
}

