package com.woowacourse.calculator.domain;

import java.util.List;
import java.util.Objects;

public class Expression {
    private static final int MIN_EXPRESSION_NUMBERS_SIZE = 2;
    private static final int ADDITIONAL_SIZE_OF_OPERAND = 1;
    private static final int FIRST_INDEX = 0;

    private final List<Number> numbers;
    private final List<Operator> operators;

    public Expression(List<Number> numbers, List<Operator> operators) {
        checkValidation(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    private void checkValidation(List<Number> numbers, List<Operator> operators) {
        if (numbers.size() < MIN_EXPRESSION_NUMBERS_SIZE) {
            throw new IllegalArgumentException("연산을 진행하기 위해서는 적어도 2개 이상의 숫자를 입력하셔야 합니다.");
        }
        if (numbers.size() != operators.size() + ADDITIONAL_SIZE_OF_OPERAND) {
            throw new IllegalArgumentException("피연산자의 개수는 연산자의 개수보다 1개 더 많아야 합니다.");
        }
    }

    public Double calculate() {
        int operandIndex = FIRST_INDEX;
        Double calculateResult = numbers.get(operandIndex++).getNumber();

        for (Operator operator : operators) {
            final Double nextOperand = numbers.get(operandIndex++).getNumber();
            calculateResult = operator.calculate(calculateResult, nextOperand);
        }
        return calculateResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }
}
