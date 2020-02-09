package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTIPLY("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> a / b);

	private final String operator;
	private final BiFunction<Double, Double, Double> expression;

	Operator(String operator, BiFunction<Double, Double, Double> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public static Operator isEqual(String operator) {
		return Arrays.stream(values())
			.filter(op -> op.operator.equals(operator))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
	}

	public double operate(double firstOperand, double secondOperand) {
		return expression.apply(firstOperand, secondOperand);
	}

	public String getOperator() {
		return operator;
	}

}
