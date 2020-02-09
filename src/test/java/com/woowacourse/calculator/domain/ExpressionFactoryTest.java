package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("ExpressionFactory Test")
class ExpressionFactoryTest {
    @DisplayName("ExpressionFactory - generate() Test")
    @Test
    void testGenerate() {
        final String inputExpression = "1 + 2";

        final Expression actual = ExpressionFactory.generate(inputExpression);

        final List<Number> numbers = Arrays.asList(new Number("1"), new Number("2"));
        final List<Operator> operators = Arrays.asList(Operator.Of("+"));
        final Expression expected = new Expression(numbers, operators);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("ExpressionFactory - makeExpression() Test")
    @ParameterizedTest
    @CsvSource(value = {"1","1 +", "+ 1","1 1"})
    void testMakeExpression(final String invalidInputExpression) {
        assertThatThrownBy(() -> ExpressionFactory.generate(invalidInputExpression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
