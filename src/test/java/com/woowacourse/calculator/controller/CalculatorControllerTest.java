package com.woowacourse.calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("CalculatorController Test")
class CalculatorControllerTest {

    @DisplayName("CalculatorController - calculator() Test")
    @Test
    void calculate() {
        final String inputExpression = "1 + 2 * 3";
        CalculatorController calculatorController = new CalculatorController();
        int actual = calculatorController.calculate(inputExpression);
        int expected = 9;
        assertThat(actual).isEqualTo(expected);
    }
}
