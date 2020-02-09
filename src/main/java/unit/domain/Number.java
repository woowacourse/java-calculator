package unit.domain;

import java.util.Objects;

public class Number implements Token {
	private final double number;

	public Number(final String number) {
		this.number = toDouble(number);
	}

	private double toDouble(final String number) {
		try {
			return Double.parseDouble(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("유효한 범위의 숫자를 입력해 주세요");
		}
	}

	public double getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return number == number1.number;
	}


	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
