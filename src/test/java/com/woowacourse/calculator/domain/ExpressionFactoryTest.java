package com.woowacourse.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("ExpressionFactory Test")
class ExpressionFactoryTest {
    @DisplayName("Tokenize - Tokenize() Test")
    @Test
    void testTokenize() {
        final String inputExpression = "1 + 2";

        final List<Token> actual = ExpressionFactory.generate(inputExpression);

        final List<Token> expected = Arrays.asList(new Number("1"), new Operator("+"), new Number("2"));

        assertThat(actual).isEqualTo(expected);
    }
}
