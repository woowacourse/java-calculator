package unit.domain;

import java.util.Objects;

public class Number {
	private final double number;

	public Number(final double number) {
		this.number = number;
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
