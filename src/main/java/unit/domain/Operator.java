package unit.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Operator implements Token {
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String DIVIDE = "/";
	private static final String MULTIPLY = "*";

	private final String operator;

	public Operator(final String operator) {
		checkValidation(operator);
		this.operator = operator;
	}

	private void checkValidation(String operator) {
		final List<String> validOperators = Arrays.asList(PLUS, MINUS, DIVIDE, MULTIPLY);
		if (!validOperators.contains(operator)) {
			throw new IllegalArgumentException("유효한 연산자 형식이 아닙니다.");
		}
	}

	public double calculate(Number number1, Number number2) {
		if (PLUS.equals(operator)) {
			return number1.getNumber() + number2.getNumber();
		}
		if (MINUS.equals(operator)) {
			return number1.getNumber() - number2.getNumber();
		}
		if (DIVIDE.equals(operator)) {
			checkDivider(number2);
			return number1.getNumber() / number2.getNumber();
		}
		if (MULTIPLY.equals(operator)) {
			return number1.getNumber() * number2.getNumber();
		}
		throw new IllegalStateException("정의 되지 않은 연산입니다.");
	}

	private void checkDivider(Number number2) {
		if (number2.getNumber() == 0) {
			throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Operator operator1 = (Operator)o;
		return Objects.equals(operator, operator1.operator);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operator);
	}
}
