package com.woowacourse.calculator.domain;

import java.util.List;
import java.util.Objects;

/**
 * 클래스 이름 : Operators.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public class Operators {
    private final List<OperatorType> operators;

    public Operators(final List<OperatorType> operators) {
        Objects.requireNonNull(operators);
        this.operators = operators;
    }

    public double calculate(Numbers numbers) {
        double answer = numbers.get(0);
        for (int index = 0; index < operators.size(); ++index) {
            answer = numbers.calculate(operators.get(index), answer, index + 1);
        }
        return answer;
    }
}

