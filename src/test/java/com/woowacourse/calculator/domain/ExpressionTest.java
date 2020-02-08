package com.woowacourse.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Expression Test")
class ExpressionTest {
    @DisplayName("Expression - Expression() Test")
    @Test
    void testExpression() {
        List<Token> invalidTokens = new ArrayList<>(Arrays.asList(
                new Number("1"),
                new Operator("+"),
                new Operator("+")));
        assertThatThrownBy(() -> new Expression(invalidTokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연산 식입니다.");
    }

    @DisplayName("Expression - GetExpression() Test")
    @Test
    void testGetExpression() {
        List<Token> value = new ArrayList<>(Arrays.asList(
                new Number("1"),
                new Operator("+"),
                new Number("2")));
        Expression expression = new Expression(value);
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
        List<Token> value = new ArrayList<>(Arrays.asList(
                new Number("1"),
                new Operator("+"),
                new Number("2"),
                new Operator("*"),
                new Number("4"),
                new Operator("-"),
                new Number("3")));
        Expression expression = new Expression(value);
        int actual = expression.calculate();
        int expected = 9;
        assertThat(actual).isEqualTo(expected);

    }
}
