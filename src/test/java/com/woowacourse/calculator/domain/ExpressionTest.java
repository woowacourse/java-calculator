package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Expression Test")
class ExpressionTest {
    @DisplayName("Expression - checkValidation() Test")
    @Test
    void testCheckValidation() {
        List<Number> numbers = Arrays.asList(new Number("1"));
        List<Operator> operators = Arrays.asList();
        assertThatThrownBy(() -> new Expression(numbers, operators))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산을 진행하기 위해서는 적어도 2개 이상의 숫자를 입력하셔야 합니다.");
    }

    @DisplayName("Expression - calculate() Test")
    @Test
    void testCalculate() {
        final String inputExpression = "1 + 2 * 4 - 3";
        Expression expression = ExpressionFactory.generate(inputExpression);

        final Double actual = expression.calculate();

        final Double expected = 9d;

        assertThat(actual).isEqualTo(expected);

    }
}
