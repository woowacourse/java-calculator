package domain;

import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", (firstOperand, secondOperand) -> firstOperand + secondOperand),
	MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
	MULTIPLICATION("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
	DIVISION("/", (firstOperand, secondOperand) -> firstOperand / secondOperand);

	private String operator;
	private BiFunction<Double, Double, Double> function;

	Operator(String operator, BiFunction<Double, Double, Double> expression) {
		this.operator = operator;
		this.function = expression;
	}

	public String getOperator() {
		return operator;
	}

	public BiFunction<Double, Double, Double> getExpression() {
		return function;
	}
}
