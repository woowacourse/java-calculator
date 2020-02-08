package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Operator Test")
class OperatorTest {
    @DisplayName("Operator - Operator() Test")
    @ParameterizedTest
    @CsvSource(value = {"%", "$", "A", "@"})
    void testOperator(final String invalidOperator) {
        assertThatThrownBy(() -> new Operator(invalidOperator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 연산자 형식이 아닙니다.");
    }

    @DisplayName("Operator - calculate() Test")
    @ParameterizedTest
    @CsvSource(value = {"+, 1,2,3", "-, 1,2,-1", "/, 2,1,2", "*, 2,3,6"})
    void testCalculate(final String inputOperator, final String inputNumber1, final String inputNumber2, final int expected) {
        Operator operator = new Operator(inputOperator);

        int actual = operator.calculate(new Number(inputNumber1), new Number(inputNumber2));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Operator - checkDivision() Test")
    @Test
    void testCheckDivision() {
        final String division = "/";
        Operator operator = new Operator(division);

        assertThatThrownBy(() -> {
            final String number = "1";
            final String Zero = "0";
            operator.calculate(new Number(number), new Number(Zero));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
