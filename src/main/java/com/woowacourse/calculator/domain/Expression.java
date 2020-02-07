package com.woowacourse.calculator.domain;

import java.util.List;
import java.util.Objects;

/**
 * 클래스 이름 : Expression.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.06 목요일
 */

public class Expression {
    private final List<Double> numbers;
    private final List<OperatorType> operators;

    public Expression(final List<Double> numbers, final List<OperatorType> operators) {
        this.numbers = Objects.requireNonNull(numbers);
        this.operators = Objects.requireNonNull(operators);
    }

    public double calculate() {
        double answer = numbers.get(0);
        for (int index = 0; index < operators.size(); ++index) {
            OperatorType operator = operators.get(index);
            answer = operator.calculate(answer, numbers.get(index + 1));
        }
        return answer;
    }
}
