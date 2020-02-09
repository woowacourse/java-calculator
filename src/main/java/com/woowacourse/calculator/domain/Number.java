package com.woowacourse.calculator.domain;

import java.util.Objects;

public class Number {
    private final Double number;

    public Number(final String number) {
        this.number = toDouble(number);
    }

    private Double toDouble(final String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("유효한 숫자 형식이 아닙니다.");
        }
    }

    public Double getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(this.number, number.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
