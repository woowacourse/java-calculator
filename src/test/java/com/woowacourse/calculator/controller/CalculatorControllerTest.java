package com.woowacourse.calculator.controller;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.Tokenizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("CalculatorController Test")
class CalculatorControllerTest {
    @DisplayName("CalculatorController - calculator() Test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - 3,0", "1 * 3 / 3,1", "3 - 2 * 5,5"})
    void testCalculate(final String inputExpression, final int expected) {
        Expression expression = new Expression(Tokenizer.tokenize(inputExpression));
        CalculatorController calculatorController = new CalculatorController(expression);

        int actual = calculatorController.calculate();

        assertThat(actual).isEqualTo(expected);
    }
}
