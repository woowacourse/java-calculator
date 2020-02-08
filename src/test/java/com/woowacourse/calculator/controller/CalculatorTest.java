package com.woowacourse.calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Calculator Test")
class CalculatorTest {

    @DisplayName("Calculator - calculator() Test")
    @Test
    void calculate() {
        final String inputExpression = "1 + 2 * 3";
        Calculator calculator = new Calculator();
        int actual = calculator.calculate(inputExpression);
        int expected = 9;
        assertThat(actual).isEqualTo(expected);
    }
}
