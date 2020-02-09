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
 * 날짜 : 2020/02/06
 */
public class Expression {
    private static final int START_INDEX = 0;

    private final List<Double> numbers;
    private final List<OperatorType> operators;

    public Expression(final List<Double> numbers, final List<OperatorType> operators) {
        validateExpression(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    public void validateExpression(final List<Double> numbers, final List<OperatorType> operators) {
        Objects.requireNonNull(numbers);
        Objects.requireNonNull(operators);
        validateExpressionLength(numbers, operators);
    }

    public void validateExpressionLength(final List<Double> numbers, final List<OperatorType> operators) {
        if (numbers.size() == 0) {
            throw new IllegalArgumentException("수식은 최소한 하나의 숫자를 가져야 합니다.");
        }
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("피연산자의 개수는 연산자의 개수보다 반드시 하나 더 있어야 합니다.");
        }
    }

    public double calculate() {
        double answer = numbers.get(START_INDEX);
        for (int index = START_INDEX, end = operators.size(); index < end; ++index) {
            OperatorType operator = operators.get(index);
            answer = operator.calculate(answer, numbers.get(index + 1));
        }
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Expression that = (Expression)o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }
}
