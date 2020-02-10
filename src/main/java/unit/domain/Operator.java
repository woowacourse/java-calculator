package unit.domain;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Operator {
	PLUS("+", Double::sum),
	MINUS("-", (number1, number2) -> number1 - number2),
	DIVIDE("/", (number1, number2) -> number1 / number2),
	MULTIPLY("*", (number1, number2) -> number1 * number2);

	private final String letter;
	private final BinaryOperator<Double> operator;

	Operator(final String letter, final BinaryOperator<Double> operator) {
		this.letter = letter;
		this.operator = operator;
	}

	public double operate(final Number number1, final Number number2) {
		final double firstNumber = number1.getNumber();
		final double secondNumber = number2.getNumber();
		return operator.apply(firstNumber, secondNumber);
	}

	public static boolean isIn(final String token) {
		return Stream.of(Operator.values())
			.anyMatch(isOperatorEquals(token));
	}

	private static Predicate<Operator> isOperatorEquals(final String token) {
		return value -> value.letter.equals(token);
	}

	public static Operator of(final String token) {
		return Stream.of(Operator.values())
			.filter(isOperatorEquals(token))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("정의되지 않은 연산자 입니다."));
	}
}
