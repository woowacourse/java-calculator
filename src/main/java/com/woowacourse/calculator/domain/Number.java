package com.woowacourse.calculator.domain;

import java.util.Objects;

public class Number implements Token {
	private final int number;

	public Number(final String number) {
		this.number = toInt(number);
	}

	private int toInt(final String token) {
		try {
			return Integer.parseInt(token);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("유효한 범위의 숫자를 입력해 주세요");
		}
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

	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
