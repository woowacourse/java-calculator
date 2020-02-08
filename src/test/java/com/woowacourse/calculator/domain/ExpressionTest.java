package com.woowacourse.calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Expression Test")
class ExpressionTest {
    @DisplayName("Expression - checkValidSize() Test")
    @Test
    void testCheckValidSize() {
        final String invalidInputExpression = "1";

        assertThatThrownBy(() -> new Expression(Tokenizer.tokenize(invalidInputExpression)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연산 식입니다.");
    }

    @DisplayName("Expression - checkValidExpression() Test")
    @Test
    void testCheckValidExpression() {
        final String invalidInputExpression = "1 + +";

        assertThatThrownBy(() -> new Expression(Tokenizer.tokenize(invalidInputExpression)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연산 식입니다.");
    }

    @DisplayName("Expression - GetExpression() Test")
    @Test
    void testGetExpression() {
        final String inputExpression = "1 + 2";
        Expression expression = new Expression(Tokenizer.tokenize(inputExpression));

        Stack<Token> actual = expression.getExpression();

        Stack<Token> expected = new Stack<>();
        expected.push(new Number("2"));
        expected.push(new Operator("+"));
        expected.push(new Number("1"));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Expression - calculate() Test")
    @Test
    void testCalculate() {
        final String inputExpression = "1 + 2 * 4 - 3";
        Expression expression = new Expression(Tokenizer.tokenize(inputExpression));

        int actual = expression.calculate();

        int expected = 9;

        assertThat(actual).isEqualTo(expected);

    }
}
