package domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
	ADD("+", (operand1, operand2) -> operand1 + operand2),
	SUBTRACT("-", (operand1, operand2) -> operand1 - operand2),
	MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
	DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

	private final String symbol;
	private final BinaryOperator<Integer> binaryOperator;

	Operator(String symbol, BinaryOperator<Integer> binaryOperator) {
		this.symbol = symbol;
		this.binaryOperator = binaryOperator;
	}

	public static Operator findBySymbol(String value) {
		return Arrays.stream(values())
			.filter(operator -> value.equals(operator.symbol))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	public int apply(int operand1, int operand2) {
		return binaryOperator.apply(operand1, operand2);
	}

	public static boolean isOperatorSymbol(String symbol) {
		return Arrays.stream(Operator.values())
			.anyMatch(operator -> symbol.equals(operator.symbol));
	}
}
