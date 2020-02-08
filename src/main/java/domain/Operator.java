package domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public enum Operator {
	ADD("+", (operand1, operand2) -> operand1 + operand2),
	SUBTRACT("-", (operand1, operand2) -> operand1 - operand2),
	MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
	DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

	private static final String NO_SUCH_OPERATOR_EXCEPTION_MESSAGE = "존재하지 않는 연산자입니다.";

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
			.orElseThrow(() -> new NoSuchElementException(NO_SUCH_OPERATOR_EXCEPTION_MESSAGE));
	}

	int calculate(int operand1, int operand2) {
		return operation.apply(operand1, operand2);
	}

	static boolean isOperator(String value) {
		return Arrays.stream(Operator.values())
			.anyMatch(operator -> value.equals(operator.symbol));
	}
}
