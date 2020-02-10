package com.woowacourse.calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
	PLUS("+", Double::sum),
	MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
	DIVISION("/", (firstOperand, secondOperand) -> firstOperand / secondOperand),
	MULTIPLICATION("*", (firstOperand, secondOperand) -> firstOperand * secondOperand);

	private static final double ZERO = 0d;
	private static final String DIVISION_OPERATOR = "/";

	private String operator;
	private BinaryOperator<Double> expression;

	Operator(final String operator, final BinaryOperator<Double> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public static Operator of(final String operator) {
		return Arrays.stream(Operator.values())
			.filter(value -> value.operator.equals(operator))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("유효한 연산자 형식이 아닙니다."));
	}

	public Double calculate(final Double firstOperand, final Double secondOperand) {
		checkDivideByZero(secondOperand);
		return expression.apply(firstOperand, secondOperand);
	}

	private void checkDivideByZero(final Double secondOperand) {
		if (!DIVISION_OPERATOR.equals(operator)) {
			return;
		}
		if (secondOperand == ZERO) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
	}
}
