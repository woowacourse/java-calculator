package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Operator Test")
class OperatorTest {
    @DisplayName("Operator - Of() Test")
    @ParameterizedTest
    @CsvSource(value = {"%", "$", "A", "@"})
    void testOperator(final String invalidOperator) {
        assertThatThrownBy(() -> Operator.Of(invalidOperator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 연산자 형식이 아닙니다.");
    }

    @DisplayName("Operator - calculate() Test")
    @ParameterizedTest
    @CsvSource(value = {"+, 1,2,3", "-, 1,2,-1", "/, 2,1,2", "*, 2,3,6"})
    void testCalculate(final String inputOperator, final String firstOperand, final String secondOperand, final Double expected) {
        Operator operator = Operator.Of(inputOperator);

        final Double firstOperandNumber = new Number(firstOperand).getNumber();
        final Double secondOperandNumber = new Number(secondOperand).getNumber();
        final Double actual = operator.calculate(firstOperandNumber, secondOperandNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Operator - checkDivision() Test")
    @Test
    void testCheckDivideByZero() {
        final String division = "/";
        Operator operator = Operator.Of(division);

        assertThatThrownBy(() -> {
            final Double firstOperand = new Number("1").getNumber();
            final Double zero = new Number("0").getNumber();
            operator.calculate(firstOperand, zero);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
