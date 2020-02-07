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

    private final List<Double> numbers;

    public Numbers(final List<Double> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(final List<Double> numbers) {
        Objects.requireNonNull(numbers);
        if (numbers.size() == ZERO) {
            throw new IllegalArgumentException("하나 이상의 숫자를 입력해주세요.");
        }
    }

    public Double get(final int index) {
        return numbers.get(index);
    }

    public double calculate(OperatorType operatorType, double operand, int nextIndex) {
        return operatorType.calculate(operand, numbers.get(nextIndex));
    }
}
