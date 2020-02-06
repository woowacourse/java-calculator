package com.woowacourse.calculator.domain;

import java.util.List;
import java.util.Objects;

/**
 * 클래스 이름 : Numbers.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

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
