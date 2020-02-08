package com.woowacourse.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpressionTest {
	@Test
	void testTokens() {
		List<Token> invalidTokens = Arrays.asList(new Number("1"), new Operator("+"), new Operator("+"));
		assertThatThrownBy(() -> {
			new Expression(invalidTokens);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("잘못된 식입니다.");
	}

	@Test
	void testGetExpression() {
		List<Token> value = Arrays.asList(new Number("1"), new Operator("+"), new Number("2"));
		Expression expression = new Expression(value);
		Stack<Token> actual = expression.getExpression();
		Stack<Token> expected = new Stack<>();
		expected.push(new Number("2"));
		expected.push(new Operator("+"));
		expected.push(new Number("1"));
		Assertions.assertThat(actual).isEqualTo(expected);
	}
}
