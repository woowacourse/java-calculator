package unit.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Operator implements Token {
	private final String operator;

	public Operator(final String operator) {
		checkValidation(operator);
		this.operator = operator;
	}

	private void checkValidation(String operator) {
		final List<String> validOperators = Arrays.asList("+", "-", "*", "/");
		if (!validOperators.contains(operator)) {
			throw new IllegalArgumentException("유효한 연산자 형식이 아닙니다.");
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
