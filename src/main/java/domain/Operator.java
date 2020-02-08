package domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
	ADD("+", (operand1, operand2) -> operand1 + operand2),
	SUBTRACT("-", (operand1, operand2) -> operand1 - operand2),
	MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
	DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

	private final String symbol;
	private final BinaryOperator<Integer> operation;

	Operator(String symbol, BinaryOperator<Integer> operation) {
		this.symbol = symbol;
		this.operation = operation;
	}

	static Operator getOperatorOf(String value) {
		return Arrays.stream(values())
			.filter(operator -> value.equals(operator.symbol))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	int calculate(int operand1, int operand2) {
		return operation.apply(operand1, operand2);
	}

	static boolean isOperator(String value) {
		return Arrays.stream(Operator.values())
			.anyMatch(operator -> value.equals(operator.symbol));
	}
}
