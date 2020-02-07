package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
	MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
	MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
	DIVIDE("/", (leftOperand, rightOperand) -> {
		if (rightOperand.intValue() == 0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		return leftOperand / rightOperand;
	});

	private final String operator;
	private final BiFunction<Double, Double, Double> expression;

	Operator(String operator, BiFunction<Double, Double, Double> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public static Operator of(String operator) {
		return Arrays.stream(values())
				.filter(op -> op.operator.equals(operator))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
	}

	public double calculate(double leftOperand, double rightOperand) {
		return expression.apply(leftOperand, rightOperand);
	}
}
