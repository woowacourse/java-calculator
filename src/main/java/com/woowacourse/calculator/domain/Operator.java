package com.woowacourse.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Operator implements Token {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVISION = "/";
    private static final String MULTIPLICATION = "*";

    private final String operator;

    public Operator(final String operator) {
        checkValidation(operator);
        this.operator = operator;
    }

    private void checkValidation(String operator) {
        final List<String> validOperators = Arrays.asList(PLUS, MINUS, DIVISION, MULTIPLICATION);

        if (!validOperators.contains(operator)) {
            throw new IllegalArgumentException("유효한 연산자 형식이 아닙니다.");
        }
    }

    public int calculate(Number number1, Number number2) {
        if (operator.equals(PLUS)) {
            return number1.getNumber() + number2.getNumber();
        }
        if (operator.equals(MINUS)) {
            return number1.getNumber() - number2.getNumber();
        }
        if (operator.equals(DIVISION)) {
            checkDivision(number2);
            return number1.getNumber() / number2.getNumber();
        }
        return number1.getNumber() * number2.getNumber();
    }

    private void checkDivision(Number number2) {
        if (number2.getNumber() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
