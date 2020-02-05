package com.woowacourse.calculator.domain;

import java.util.List;
import java.util.Objects;

public class Numbers {
    private static final int ZERO = 0;

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(final List<Number> numbers) {
        Objects.requireNonNull(numbers);
        if (numbers.size() == ZERO) {
            throw new IllegalArgumentException("하나 이상의 숫자를 입력해주세요.");
        }
    }
}
